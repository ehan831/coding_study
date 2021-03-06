# (0) 문자열을 "" 이나 '' 으로 표현


# -----------------------------------------
# (1) 개행을 포함한 문자열
msg = """
    안녕하세요.
    저는 성이 파이이고,
    이름은 썬입니다.
    잘 부탁합니다.
"""
print(msg)

msg = '''
    행복합시다
    즐깁시다
    오늘도
'''
print(msg)
print("=" * 20)

# -----------------------------------------
#  (2) 문자열 연산
#       문자열 합치기 : 문자열 + 문자열
#       문자열 반복 : 문자열 * 숫자

a = '독도는 '
b = "한국이다. "
""" [ 출력결과 ] 
        --------------------------------------------------
        독도는 한국이다. 
        oxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxox
        독도는 한국이다. 독도는 한국이다. 독도는 한국이다. 
        ==================================================
"""
print(a + b)
print(len("oxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxoxox"))
print("ox" * 25)
print((a + b) * 3)
print("=" * 20)

# -----------------------------------------
#  (3) 문자열의 인덱싱과 슬라이싱
#       - 인덱스는 0부터 시작한다
#       - s[i] : s 문자열에서 i번째 문자 추출
#       - s[i:j] : s 문자열에서 i번째에서 j번째 전까지의 문자 추출
#       - s[i:j:k] : s 문자열에서 i번째에서 j번째 전까지에서 k개씩 건너뛰어 문자 추출
#
#       - s[-i] : s 문자열에서 뒤에서부터 i번째 문자 추출
#                 ( 뒤에서 인덱스는 1부터 센다 )

msg = '오늘도 행복 하다'

""" [ 출력결과 ]
        오
        오늘
        늘도 행복
        오도행
        다
"""
print(msg[0])
print(msg[0:2])
print(msg[1:6])
print(msg[0:5:2])
print(msg[-1])
print("=" * 20)

""" [ 참고 ] 
       ` msg[0] == msg[-0] 같은 값을 추출
       ` msg[:] 전체 추출
       ` msg[i:-j] i번째부터 뒤에서 j번째 전까지 추출
"""
print(msg[-0])
print(msg[:])
print(msg[5:-1])
print("=" * 20)

""" [ 확인 ]
    1- 문자열 끝까지라면 두번째 숫자 생략 가능
    2- 처음부터 시작하는 것이라면 첫번째 숫자 생략 가능
"""
# 1) 5번째부터

# 2) 5번째 전의 문자까지

# 3) 5번째 전의 문자까지에서 2개씩 건너뛰어

# 4) 문자열 전체에서 2개씩 건너뛰어

""" [ 연습-1 ]
    날짜와 시간을 표현하는 문자열에서 '2020-02-22 : 12:05:12'
    '2020년 2월 22일' 출력
    '12시 5분' 출력
"""
dt = '2020-02-22 : 12:05:12'
print(dt[0:4] + "년 " + dt[6:7] + "월 " + dt[8:10] + "일")
print(dt[13:15] + "시 " + dt[17:18] + "분")
print("=" * 20)

# -----------------------------------------
#  (4-1) 문자열 관련 함수
#       s.count('글') : s 문자열에서 '글'이라는 문자 개수 세기
#       s.index('글') : s 문자열에서 문자 '글' 위치 알려주기
#       s.find('글') : s 문자열에서 문자 '글' 위치 알려주기
#       s.rfind('글') : s 문자열에서 문자 '글' 오른쪽에서 왼쪽으로 찾아서 위치 알려주기
#       s.len() : s 문자열 길이

msg = '오늘도 행복도 하다'

""" [ 출력결과 ]
    1) '행복'이라는 글자 위치 찾기
    2) '가자'라는 글자 위치 찾기
    3) '행복'이라는 글자를 오른쪽에서 왼쪽으로 찾기
    4) 문자열 전체 길이 구하기
    5) '도'라는 단어의 갯수 구하기
"""
print(msg.find("행복"))
print(msg.index("행복"))
print(msg.find("가자"))
print(msg.rfind("행복"))
print(len(msg))
print(msg.count('도'))

# -----------------------------------------
#  (4-2) 문자열 관련 함수
#   s.upper() : 소문자를 대문자로
#   s.lower() : 대문자를 소문자로
#   s.lstrip() : 왼쪽 공백 지우기
#   s.rstrip() : 오른쪽 공백 지우기
#   s.strip() : 양쪽 공백 지우기

msg = '  This is My Life  '
print(msg.strip())
print(msg.strip().replace(" ", ""))

# -----------------------------------------
#  (4-3) 문자열 관련 함수
#   s.replace("a","b")  :  s 문자열에서 단어 a를 단어 b로 바꾸기
#   s.split() : s 문자열을 공백으로 나누기
#   s.split('z') : s 문자열을 z 기호로 나누기
#   d.join(s) : d 단어를 s 문자열에 삽입

msg = "우리는 독도를 지킨다"

# -----------------------------------------
#  (5) 문자열 포맷

msg = '{}님 오늘도 행복하세요'
print(msg.format("홍길동"))

msg = '{}님 오늘도 행복하세요- {}으로부터'
print(msg.format("홍길동", "김떡순"))

# msg = '{0}님 오늘도 행복하세요- {1}으로부터'
msg = '{1}님 오늘도 행복하세요- {0}으로부터'
print(msg.format("김떡순", "홍길동"))

msg = '{name}님 오늘도 행복하세요- {group}으로부터'
print(msg.format(group="김떡순", name="홍길동"))

# [참고] http://pyformat.info

name = '홍길자'
age = 25
height = 160.9
print('%s 님은 %d 살이고, 키는 %.2f 입니다.' % (name, age, height))

