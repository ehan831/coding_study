"""
    기상청 사이트에서 필요한 데이타를 추출하고자 한다면?
        - 데이타 가져오기     ` requests 모듈
                             ` urllib.request 모듈의 urlopen() 이용
        - 데이타 추출    BeautifulSoup 이용
"""

from bs4 import BeautifulSoup
from urllib import request as req

# 1. 데이타 가져오기
rssUrl = 'http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108'
res = req.urlopen(rssUrl)
# print(res)    # <http.client.HTTPResponse object at 0x7fbb002be978>

# 2. 필요 데이타 추출하기
soup = BeautifulSoup(res, 'html.parser')
# print(soup)
locations = soup.select('location')

for l in locations:
    data = l.select('data')
    for dt in data:
        print('도시명:', l.city.text, '|', dt.tmef.text, dt.wf.text)


