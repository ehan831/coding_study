"""
#----------------------------------------------------------
[튜플 자료형]
    1- 리스트와 유사하지만 튜플은 값을 변경 못한다.
    2- 각 값에 대해 인덱스가 부여
    3- 변경 불가능 (*****)
    4- 소괄호 () 사용
"""

# (1) 튜플 생성
print('------------------- 1. 튜플 생성-----------------')
t = (1, 2, 3)
print(t)
print(t[0])
print(type(t))

t2 = 2, 4, 6  # 괄호 없어도 튜플이 된다. 하지만 권장하지 않음.
print(t2)
print(type(t2))

# 빈 튜플 생성
a = ()
print(a)
print(type(a))

# (2) 튜플은 요소를 변경하거나 삭제 안됨
print('------------------- 2 -----------------')
# t[1] = 0;  # 블럭이 생기면서 실행 안됨
# del t[1]   # 에러 발생

# (3) 하나의 요소를 가진 튜플
print('------------------- 3 -----------------')
# 하나일 때는 콤마를 붙여야 한다?
t3 = ('A')
print(t3)
print(type(t3))

t3 = ('A',)
print(t3)
print(type(t3))

# (4) 인덱싱과 연산자
print('------------------- 4 -----------------')
print(t[2])
print(t[1:])
print(t * 3)
print(t + t2)

# (5) 요소 풀기
print('------------------- 5 -----------------')
t5 = (1, 2, 3)
a, b, c = t5
print(a + b + c)