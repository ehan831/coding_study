"""
    # 패턴과 소스를 비교하는 메소드
    - match() : 패턴의 일치여부 확인
    - findall() : 일치하는 모든 문자열 리스트 반환
    - search() : 첫번째 일치하는 객체 반환
    - split() : 패턴에 맞게 소스를 분리한 후 문자열 조각의 리스트 반환
    - sub() : 대체 인자를
"""

import re

msg = 'We are happy!!. You are happy?!. Happy2019 2020'

# match()
result = re.match('.*happy', msg)
if result:
    print('match:', result.group())
print('=' * 20)

# search()
result = re.search('happy', msg)
if result:
    print('search:', result.group())
print('=' * 20)


# split()
result = re.split('a', msg)
print('split:', result)
print('=' * 20)


# sub()
result = re.sub('a', '@', msg)
print('sub:', result)
print('=' * 20)

