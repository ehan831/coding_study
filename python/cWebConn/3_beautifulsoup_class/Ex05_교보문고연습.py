'''
 [과제] 교보문고에서 파이썬 책 검색하여
    - csv 파일로 저장
    - mysql 테이블에 저장
'''

from urllib.request import urlopen
from bs4 import BeautifulSoup

# 교보문고 > '파이썬' 검색 > 국내도서
html = urlopen(
    "http://www.kyobobook.co.kr/search/SearchKorbookMain.jsp?vPstrCategory=KOR&vPstrKeyWord=python&vPplace=top")

# 책의 제목들을 출력 - 총 책의 권 수를 출력하기
soup = BeautifulSoup(html, 'html.parser')
title = soup.select('.title strong')
count = len(title)
# print(title)    # [<strong> 혼자 공부하는 파이썬</strong>, <strong> Do it! 점프 투 파이썬</strong>, <strong> 머신 러닝 교과서 with 파이썬  사이킷런  텐서플로</strong>, <strong> 파이썬 라이브러리를 활용한 데이터 분석</strong>, <strong> 케라스 창시자에게 배우는 딥러닝(Deep Learning with Python)</strong>, <strong> 파이썬 자료구조와 알고리즘</strong>, <strong> 파이썬 라이브러리를 활용한 (번역개정판)</strong>, <strong> 모두의 데이터 분석 with 파이썬</strong>, <strong>Effective Python 파이썬 코딩의 기술</strong>, <strong> 파이썬 머신러닝 판다스 데이터 분석</strong>, <strong> 파이썬 데이터 분석 입문</strong>, <strong> 파이썬 GUI 프로그래밍 쿡북 2/e</strong>, <strong> 파이썬 데이터 사이언스 핸드북</strong>, <strong> 파이썬 코딩 수학 with 딥러닝</strong>, <strong> 파이썬 날코딩으로 알고 짜는 딥러닝</strong>, <strong> 파이썬 프로그래밍으로 지루한 작업 자동화하기</strong>, <strong> 파이썬으로 웹 크롤러 만들기</strong>, <strong>초보자를 위한 파이썬(Python) 200제</strong>, <strong> 게임으로 배우는 파이썬</strong>, <strong> 파이썬 디자인 패턴</strong>, <strong> 파이썬(Python)(다양한 예제로 배우는 완전 쉬운)</strong>, <strong> Python Cookbook(3판)</strong>, <strong>안녕, 파이썬 파이썬 도서 전체 목록입니다. 새로운 책을 발견해보세요!</strong>, <strong>마우스패드 증정 파이썬 행사도서 구매 시, 마우스패드 증정</strong>, <strong>파이썬에 대한 좋은 입문서 </strong>, <strong>어린이 파이썬 </strong>, <strong><a href="http://bc.kyobobook.co.kr/front/subscribe/detailCotents.ink?contents_no=244&amp;orderClick=LIJ" target="_blank" title="새 창 열림">[북캐스트]마인크래프트로 배우는 우리 아이 첫 코딩! </a></strong>, <strong><a href="javascript:goBooknews('03050900', '11825', 'LIJ')" title="새 창 열림">[북뉴스]5분 안에 시작하는 파이썬 웹 프로그래밍 </a></strong>, <strong>Python Machine Learning By Example</strong>, <strong>파이썬 마이크로서비스(소프트웨어 아키텍처)</strong>]
for i, t in enumerate(title):
    print(i + 1, '>', t.text)
