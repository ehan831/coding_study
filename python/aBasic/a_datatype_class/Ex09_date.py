# import datetime
# today = datetime.date.today()
# print('today is ', today)

# 동일한 코딩
from datetime import date

today2 = date.today()
print('today is ', today2)  # today is  2019-08-19

# 년, 월, 일 출력
print(today2.year)
print(today2.month)
print(today2.day)

# 날짜와 시분초까지
from datetime import datetime

today3 = datetime.today()
print(today3)  # 2019-08-19 16:57:25.945884

# 날짜 계산
from datetime import timedelta
today4 = date.today()
print('어제: ', today4 + timedelta(days=-1))  # 어제:  2019-08-18


# 날짜 출력 형식 strftime
today5 = datetime.today()
print(today5)
print(today5.strftime('%Y %m %d'))
print(today5.strftime('%m %d %Y %H:%M'))    # 08 20 2019 09:43

# 날짜 출력 (문자열로) strptime
str = '2020-08-20 12:25:33'
mydate = datetime.strptime(str, '%Y-%m-%d %H:%M:%S')
print(mydate)
print(type(mydate))     # <class 'datetime.datetime'>



