from urllib import request
from urllib import parse
import datetime
import json
import math

"""  관광지 입장객 정보 획득을 위한 파라메터 설정하여 결과를 얻어오는 함수
       - 년도, 시도, 구군, 페이지번호, 한페이지결과수를 지정 """


def getTourPointVistor(yyyymm, sido, gungu, nPagenum, nItems):
    # -----------------------------------------------------------
    # 여기에 코드
    access_key = 'r6j5ATGdXxiy57RCSG4gD5DWdM51YxkvX05Wb2mWdlNzh9ev8EdNL6x11u4hmqErPC4xDtDJpYDK6bIi8UGHww%3D%3D'  # 진경님 키
    url = 'http://openapi.tour.go.kr/openapi/service/TourismResourceStatsService/getPchrgTrrsrtVisitorList'
    queryParams = '?_type=json'
    queryParams += '&serviceKey=' + access_key
    queryParams += '&YM=' + yyyymm
    queryParams += '&SIDO=' + parse.quote(sido)
    queryParams += '&GUNGU=' + parse.quote(gungu)
    queryParams += '&RES_NM='
    queryParams += '&pageNo=' + str(nPagenum)
    queryParams += '&numOfRows=' + str(nItems)

    req = request.Request(url + queryParams)
    res = request.urlopen(req)
    returnData = res.read().decode('utf-8')
    if returnData == None:
        return None
    else:
        jsonData = json.loads(returnData)
        return jsonData


''' 각 항목을 JSON 구조로 변경하고 추가하는 함수'''


def getTourPointData(item, yyyymm, jsonResult):
    addrCd = 0 if 'addrCd' not in item.keys() else item['addrCd']
    gungu = 0 if 'gungu' not in item.keys() else item['gungu']
    sido = 0 if 'sido' not in item.keys() else item['sido']
    resNm = 0 if 'resNm' not in item.keys() else item['resNm']
    rnum = 0 if 'rnum' not in item.keys() else item['rnum']
    ForNum = 0 if 'ForNum' not in item.keys() else item['ForNum']
    NatNum = 0 if 'NatNum' not in item.keys() else item['NatNum']

    jsonResult.append({'yyyymm': yyyymm,
                       'addrCd': addrCd,  # 지역코드 ( 우편번호와 일치한다고 하는데 )
                       'sido': sido,  # 시도
                       'gungo': gungu,  # 구군
                       'resNm': resNm,  # 관광지명
                       'rnum': rnum,  # 관광지에 고유하게 부여된 코드값
                       'ForNum': ForNum,  # 외국인수
                       'NatNum': NatNum})  # 내국인수


''' 추출할 변수 지정하고 필요한 함수 호출하여 결과 받는 메인 함수'''


def main():
    jsonResult = []  # 결과 저장 변수

    # 검색할 변수값 지정
    sido = '서울특별시'  # 시도
    gungu = ''  # 구군
    nPagenum = 1  # 페이지번호
    nTotal = 0
    nItems = 100  # 한 페이지의 레코드 수? 100개가 넘으면 다음 페이지로 넘어가도록
    # sido가 경기도면 100개가 넘어가 페이지 처리가 필요하단다
    nStartYear = 2015  # 추출할 년도의 시작년도
    nEndYear = 2017  # 추출할 년도의 종료년도 + 1

    # -----------------------------------------------------------
    # 여기에 코딩하기
    for year in range(nStartYear, nEndYear):  # 2015 ~ 2016
        for month in range(1, 13):  # 1 ~ 12 월
            yyyymm = '{0}{1:0>2}'.format(str(year), str(month))  # 1 > 01 처럼 표기하기 위해
            nPagenum = 1
            while True:
                jsonData = getTourPointVistor(yyyymm, sido, gungu, nPagenum, nItems)
                if jsonData['response']['header']['resultMsg'] == "OK":
                    # print(jsonData['response']['body'])     # {'items': {'item': [{'addrCd': 1111, 'csForCnt': 23453, 'csNatCnt': 49390, 'gungu': '종로구', 'resNm': '창덕궁', 'rnum': 1, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1111, 'csForCnt': 108087, 'csNatCnt': 196594, 'gungu': '종로구', 'resNm': '경복궁', 'rnum': 2, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1111, 'csForCnt': 1326, 'csNatCnt': 24256, 'gungu': '종로구', 'resNm': '창경궁', 'rnum': 3, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1111, 'csForCnt': 3112, 'csNatCnt': 9854, 'gungu': '종로구', 'resNm': '종묘', 'rnum': 4, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1117, 'csForCnt': 6513, 'csNatCnt': 339073, 'gungu': '용산구', 'resNm': '국립중앙박물관', 'rnum': 5, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1114, 'csForCnt': 8989, 'csNatCnt': 54159, 'gungu': '중구', 'resNm': '덕수궁', 'rnum': 6, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1135, 'csForCnt': 11, 'csNatCnt': 1754, 'gungu': '노원구', 'resNm': '태릉 ·  강릉 · 조선왕릉전시관', 'rnum': 7, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1141, 'csForCnt': 5355, 'csNatCnt': 23464, 'gungu': '서대문구', 'resNm': '서대문형무소역사관', 'rnum': 8, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1141, 'csForCnt': 0, 'csNatCnt': 44478, 'gungu': '서대문구', 'resNm': '서대문자연사박물관', 'rnum': 9, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1144, 'csForCnt': 30234, 'csNatCnt': 10756, 'gungu': '마포구', 'resNm': '트릭아이미술관', 'rnum': 10, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1165, 'csForCnt': 2, 'csNatCnt': 1362, 'gungu': '서초구', 'resNm': '헌릉ㆍ인릉', 'rnum': 11, 'sido': '서울특별시', 'ym': 201501}, {'addrCd': 1168, 'csForCnt': 569, 'csNatCnt': 12155, 'gungu': '강남구', 'resNm': '선릉·정릉', 'rnum': 12, 'sido': '서울특별시', 'ym': 201501}]}, 'numOfRows': 100, 'pageNo': 1, 'totalCount': 12}
                    nTotal = jsonData['response']['body']['totalCount']
                    if nTotal == 0:
                        break
                    else:
                        for item in jsonData['response']['body']['items']['item']:
                            getTourPointData(item, yyyymm, jsonResult)      # 결과값을 json 처럼 만들어주는 함수
                        nPage = math.ceil(nTotal/100)
                        if nPagenum == nPage:
                            break
                        else:
                            nPagenum += 1
                else:
                    break
            with open('./data/%s_관광지입장정보_%d_%d.json'%(sido, nStartYear, nEndYear), 'w', encoding='utf-8') as f:
                saveToJson = json.dumps(jsonResult, indent=4, sort_keys=True, ensure_ascii=False)
                f.write(saveToJson)

    print('%s_관광지입장정보_%d_%d.json로 저장되었읍니다.' % (sido, nStartYear, nEndYear - 1))


''' 프로그램 시작점 '''
if __name__ == '__main__':
    main()
