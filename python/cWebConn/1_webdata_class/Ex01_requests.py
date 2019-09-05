"""
    파이썬에서 웹을 요청할 수 있는 라이브러리
        1- requests 라이브러리 (s붙음 주의) - 추가
        2- urllib 라이브러리 - 내장모듈

    차이점
        1- requests는 요청 메소드(get/post)를 구분하지만 urllib는 보내는 데이타 여부에 따라 구분됨
        2- 데이타 보낼 때 requests는 딕셔러니 형태로 urllib는 인코딩한 바이너리 형태로 보낸다
        
    requests 라이브러리 추가
    메뉴 > File > Settings > Project Interpreter > + 버튼 > 'requests' 검색 후 인스톨

[ requests 모듈 ]
(1) Rest API 지원
    import requests
    resp = requests.get('http://www.mywebsite.com/user')
    resp = requests.post('http://www.mywebsite.com/user')
    resp = requests.put('http://www.mywebsite.com/user/put')
    resp = requests.delete('http://www.mywebsite.com/user/delete')

(2) 파라미터가 딕셔너리 인수로 가능
    data = {'firstname':'John', 'lastname':'Kim', 'job':'baksu'}
    resp = requests.post('http://www.mywebsite.com/user', data=userdata)

(3) json 디코더 내장 (따로 json 모듈 사용 안해도 됨)
    resp.json()
"""
import requests as rq

url = 'http://google.com'
res = rq.get(url)
# print(res)  # <Response [200]>

headers = res.headers

# print(headers)      # {'Date': 'Mon, 26 Aug 2019 05:44:14 GMT', 'Expires': '-1', 'Cache-Control': 'private, max-age=0', 'Content-Type': 'text/html; charset=ISO-8859-1', 'P3P': 'CP="This is not a P3P policy! See g.co/p3phelp for more info."', 'Content-Encoding': 'gzip', 'Server': 'gws', 'Content-Length': '5342', 'X-XSS-Protection': '0', 'X-Frame-Options': 'SAMEORIGIN', 'Set-Cookie': '1P_JAR=2019-08-26-05; expires=Wed, 25-Sep-2019 05:44:14 GMT; path=/; domain=.google.com, NID=188=DrT05uPmoo9YocDGEBUXbWg0Ne2Y17Os2AK9b_7Ff04ouxokl-bwkILewpEyur1JHTwXTlpJVaW0dAoVSGwk6399XZpOYiVuVgbhnb3xT4yGYs5XsVcdtahPlWzhUI3XHoLuqLJtJ8BY-57FiaJ9d7lzvBFjnjIKGHu19pEoMag; expires=Tue, 25-Feb-2020 05:44:13 GMT; path=/; domain=.google.com; HttpOnly'}
for k, v in headers.items():
    print(k, v)
