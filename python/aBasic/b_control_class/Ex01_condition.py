"""
 [ 제어문 ]
    - 파이썬은 들여쓰기를 하여 블록을 표현한다
    - 들여쓰기는 탭과 공백을 섞어 쓰지 말자

    [ex]
    if a>b:
        print(a)
            print(b)  => 에러발생

    (1) if 문
        if 조건식A :
            문장들
        elif 조건식B :
            문장들
        else :
            문장들

        ` 조건식이나 else 뒤에는 콜론(:) 표시
        ` 조건식을 ( ) 괄호 필요없다
        ` 실행할 코드가 없으면 pass
        ` 파이썬은 switch 문 없음
"""

# 거짓(False)의 값
i = 0;
i2 = 0.0
i3 = ""
i4 = str()
i5 = list()
i6 = tuple()
i7 = set()
i8 = dict()
i9 = {}
i10 = None

# 간단한 if 문
a = -1      # 0 이거나 ''(값이 없으면) False 나옴
if a:
    print('True a')
else:
    print('False a')

if not a:
    print('not a')

# 논리 연산자를 이용한 조건
a = 10
b = 0
if a and b:     # False
    print('if and !!')
if a or b:      # True
    print('if or !!')

print('=' * 20)

a = -1
b = 10
if a and b:     # False
    print('if and !!')
if a or b:      # True
    print('if or !!')
print(a and b)
print(a or b)

# 3. find - 찾으면 인덱스 반환 // 못 찾으면 -1 리턴
word = 'korea'
if word.find('k'):
    print('find')

if word.find('z'):
    print('not find')
# 결과 = not find. 왜지?! k 의 인덱스는 0, 0 을 리턴함. 그러면 False 가 되어버림. z는 -1 리턴 > True 가 되어버림.

if word.find('k') != -1:
    print('find')
# 이런 식으로 표현 하거나, +1 해주거나 등등의 조치가 필요함
