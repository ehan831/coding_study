'''
    http://www.data.go.kr
            - 회원가입필수
            - 일반인증키 요청 ( 바로 받을 수 있고 자료요청시 바로 승인됨 )

    >  관광자원통계서비스  >  상세기능 > 유료관광지방문객수조회
    : 전국의 주요 유로관광지 방문객수를 조회하기 위한 서비스로서
    기간,지역, 관광지별 외국인 방문객수와 내국인 방문객수를 조회한다.

    의미있는 데이타를 추출하여 출력한다

'''


from urllib import request
from urllib import parse
import json


# access_key = 'ImeIkN0eZB2Ej8%2FVO1irPSttfHTzA9XILiuzDCwfLvkX9z3dntJXUK8tWVFO6GP5Op7UPhdCWLpn8h75bu2A6w%3D%3D'   # 내키
access_key = 'r6j5ATGdXxiy57RCSG4gD5DWdM51YxkvX05Wb2mWdlNzh9ev8EdNL6x11u4hmqErPC4xDtDJpYDK6bIi8UGHww%3D%3D'     # 진경님 키
url = 'http://openapi.tour.go.kr/openapi/service/TourismResourceStatsService/getPchrgTrrsrtVisitorList'
queryParams = '?_type=json'
queryParams += '&serviceKey=' + access_key
queryParams += '&YM=' + '201201'
queryParams += '&SIDO=' + parse.quote('부산광역시')
queryParams += '&GUNGU=' + parse.quote('해운대구')
queryParams += '&RES_NM=' + parse.quote('부산시립미술관')

# print(queryParams)      # ?_type=json&serviceKey=gfv%2FQE9WxM7Y%2FZR%2BmfEXdk%2FYnRE9aixgUEIdoaDaKsWZGVNxhkpD83ZzAhbY3cIttskRXHal0dSoUPiF4M0EhQ%3D%3D&YM=201201&SIDO=%EB%B6%80%EC%82%B0%EA%B4%91%EC%97%AD%EC%8B%9C&GUNGU=%ED%95%B4%EC%9A%B4%EB%8C%80%EA%B5%AC&RES_NM=%EB%B6%80%EC%82%B0%EC%8B%9C%EB%A6%BD%EB%AF%B8%EC%88%A0%EA%B4%80
req = request.Request(url+queryParams)
res = request.urlopen(req)
returnData = res.read().decode('utf-8')
# print(returnData)   # {"response":{"header":{"resultCode":"0000","resultMsg":"OK"},"body":{"items":{"item":{"addrCd":2635,"csForCnt":286,"csNatCnt":9110,"gungu":"해운대구","resNm":"부산시립미술관","rnum":1,"sido":"부산광역시","ym":201201}},"numOfRows":10,"pageNo":1,"totalCount":1}}}
# print(type(returnData))     # <class 'str'>
data = json.loads(returnData)
print(data['response']['body']['items']['item']['resNm'])   # 부산시립미술관
# print(data)     # {'response': {'header': {'resultCode': '0000', 'resultMsg': 'OK'}, 'body': {'items': {'item': {'addrCd': 2635, 'csForCnt': 286, 'csNatCnt': 9110, 'gungu': '해운대구', 'resNm': '부산시립미술관', 'rnum': 1, 'sido': '부산광역시', 'ym': 201201}}, 'numOfRows': 10, 'pageNo': 1, 'totalCount': 1}}}

