import re

# findall(검색어, 문자열) : 문자열에서 검색어와 일하는 내용들을 리스트로 반환

msg = 'We_are_happy!! You are happy?? Happy2019-2020 안녕'

# findall
a = re.findall('happy', msg)
print('findall a:', a)
print('=' * 20)

# 소문자만 findall // 소문자 뺴고 findall // 소문자 찾아서 붙여서 출력
b = re.findall('[a-z]', msg)
c = re.findall('[^a-z]', msg)
d = re.findall('[a-z]+', msg)
print('findall b:', b)
print('findall c:', c)
print('findall d:', d)
print('=' * 20)


# 소문자와 대문자 찾기
e = re.findall('[a-z,A-Z]+', msg)
print('findall e:', e)
print('=' * 20)


# 숫자 찾기
f = re.findall('[0-9]+', msg)
print('findall f:', f)
print('=' * 20)

# 소문자, 대문자, 숫자 아닌 것을 찾기
g = re.findall('[^0-9a-zA-Z]', msg)
print('findall g:', g)
print('=' * 20)


# 영문자, 숫자, 언더바_, 를 쉽게 찾기
h = re.findall('[\w]+', msg)
print('findall h:', h)
print('=' * 20)
