from bs4 import BeautifulSoup

html = """
    <html>
        <body>
            <ul>
                <li><a href='http://www.naver.com'>네이브</a></li>
                <li><a href='http://www.daum.net'>다아음</a></li>
            </ul>
        </body>
    </html>
"""
# attrs['속성명']
# 리스트의 내용과 해당 경로를 추출하기
soup = BeautifulSoup(html, 'html.parser')

# print(soup.body.ul.li.a.attrs['href'])      # http://www.naver.com
print('네아브 >>>', soup.find('a', {'href': 'http://www.naver.com'}).attrs['href'])
print('다아음 >>>', soup.find('a', {'href': 'http://www.daum.net'}).attrs['href'])


print('=' * 20)
links = soup.find_all('a')
for a in links:
    text = a.text
    href = a.attrs['href']
    print(text, '>>>', href)
