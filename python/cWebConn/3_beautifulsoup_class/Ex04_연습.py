from bs4 import BeautifulSoup
from urllib import request as req

# http://www.pythonscraping.com/pages/warandpeace.html
# 녹색 글자만 추출하여 출력
html = req.urlopen('http://www.pythonscraping.com/pages/warandpeace.html')
soup = BeautifulSoup(html, 'html.parser')
# print(soup)  # html 출력
contents = soup.select('.green')
# print(contents)
for ct in contents:
    print(ct.text)


# -------------------------------------------

# http://www.pythonscraping.com/pages/page3.html
# 아이템과 가격을 추출


# -------------------------------------------
# https://wikidocs.net/
#  1) 책 제목과 설명만 추출
#  2) 이미지 다운
