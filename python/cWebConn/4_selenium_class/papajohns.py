from urllib import request as req
from bs4 import BeautifulSoup

# html = req.urlopen('http://www.pji.co.kr/menu/menuList.jsp?cl_cd=1')
# soup = BeautifulSoup(html, 'html.parser')
# lists = soup.find('ul', {'id': 'menuListContent'})
#
# print(lists)


html = req.urlopen('https://www.pizzahut.co.kr/menu/pizza/pizzaList/B02')
html_detail = req.urlopen('https://www.pizzahut.co.kr/menu/pizza/pizzaDetail')

soup = BeautifulSoup(html, 'html.parser')
lists = soup.select('.section_portfolio_thumb')

for i in lists:
    print(i.select_one('.thumb_text strong').text)
    print(i.select_one('.thumb_img_on').attrs['src'])
    prices = i.select('.thumb_price li')
    for pr in prices:
        print(pr.span.text, pr.em.text)
    print('=' * 20)

