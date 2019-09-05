"""
http://www.seoul.go.kr > 청사안내 > 자치구
https://www.seoul.go.kr/seoul/autonomy.do

BeautifulSoup  : 파서를 이용해서 html 의 요소를 추출하게 해주는 모듈
        - 단점은 개행문자를 고려해야 한다
Tag : 태그
NavigableString : 원래는 tag 사이의 문자열

#  xpath를 사용하면 개행문자를 고려하지 않아도 된단다
#  https://developer.mozilla.org/ko/docs/XPath
"""
import requests
from bs4 import BeautifulSoup, NavigableString

# 구청 이름, 구청 주소, 구청 전화번호, 구청 홈페이지 긁어오기
soup = BeautifulSoup(requests.get('https://www.seoul.go.kr/seoul/autonomy.do').text, 'html.parser')

for li in soup.select('.tabcont'):
    print('=' * 50, '\n**', li.strong.text, li.select_one('ul').text)