"""
    전세계날씨제공 API : http://openweathermap.org

    1. 회원가입 : 메뉴 > Sign Up > 사용용도 : Education > 대충가입 (무료는 1번에 60번 호출 가능 )
    2. 개발자모드 : Sign In > API Keys 에서 내가 발급받은 키 (추가 키 가능)
    3. 발급받고 바로 지정 안됨 (시간소요)
"""

# API 키를 지정합니다. 자신의 키로 변경해서 사용해주세요.
apikey = "1db47184ebbc18af53fd996be840d270"

# 날씨를 확인할 도시 지정하기
cities = ["Seoul,KR", "Tokyo,JP", "New York,US"]

print(cities)
api = 'http://api.openweathermap.org/data/2.5/weather?q={city}&APPID={key}'


# k2c = lambda k: k-273.15
import requests
import json

for cname in cities:
    url = api.format(city=cname, key=apikey)
    res = requests.get(url)
    print(type(res))  # <class 'requests.models.Response'>
    # print(res.text)  # {"coord":{"lon":126.98,"lat":37.57},"weather":[{"id":721,"main":"Haze","description":"haze","icon":"50d"}],"base":"stations","main":{"temp":303.96,"pressure":1012,"humidity":55,"temp_min":302.15,"temp_max":305.15},"visibility":10000,"wind":{"speed":1,"deg":340},"clouds":{"all":1},"dt":1566802681,"sys":{"type":1,"id":5501,"message":0.006,"country":"KR","sunrise":1566766607,"sunset":1566814311},"timezone":32400,"id":1835848,"name":"Seoul","cod":200}
    # json 으로 변환
    data = json.loads(res.text)
    print(data)       # {'coord': {'lon': 126.98, 'lat': 37.57}, 'weather': [{'id': 721, 'main': 'Haze', 'description': 'haze', 'icon': '50d'}], 'base': 'stations', 'main': {'temp': 303.96, 'pressure': 1012, 'humidity': 55, 'temp_min': 302.15, 'temp_max': 305.15}, 'visibility': 10000, 'wind': {'speed': 1, 'deg': 340}, 'clouds': {'all': 1}, 'dt': 1566802681, 'sys': {'type': 1, 'id': 5501, 'message': 0.006, 'country': 'KR', 'sunrise': 1566766607, 'sunset': 1566814311}, 'timezone': 32400, 'id': 1835848, 'name': 'Seoul', 'cod': 200}
    print('도시명:', data['name'])
    print('날씨:', data['weather'][0]['main'])
    print('최저온도:', data['main']['temp_min'])

