# 1. 모듈 전체를 참조할 때에는 import
# import mymodule
#
# today = mymodule.get_weather()
# print('오늘의 날씨는', today)
# print(mymodule.get_date(), '요일입니다.')

# 2. 모듈에 별칭 부여
# import mymodule as my
# today = my.get_weather()
# print('오늘의 날씨는', today)
# print(my.get_date(), '요일입니다.')


# 3. 모듈에서 필요한 부분만 import
from mymodule import get_weather
today = get_weather()
print('오늘의 날씨는', today)

from mymodule import get_date as gd
print(gd(), '요일입니다.')
