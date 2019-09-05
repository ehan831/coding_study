"""
    [ 함수 ]

     반복적인 구문을 만들어 함수로 선언하여 간단하게 호출만 하고자 한다

     def 함수명(매개변수):
        수행할 문장들
"""


# def func():
#     print('func inside')    # func inside
# func()      # func inside
# print(func())   # None

def func(arg1, arg2):
    return arg1 * 2, arg2 + 10


# 1. 파이썬은 return 을 여러 개 날릴 수도 있음
print(func(2, 3))

a, b = func(4, 5)
print(a, b)


# 2. 위치 인자 (positional argument)
def func(greeting, name):
    print(name, '님', '!!!', greeting)


func('안녕하세요', '홍길동')
func('홍길동', '하이')

# 3. 키워드 인자 (keyword argument), 키워드를 지정해주면 맞는 키워드로 들어감. 없으면 순서대로(2번 참조)
func(name='홍길동', greeting='하이')


# 4. 기본 매개 변수
# func('홍길동')     # error !! 인자가 2개가 필요한데 하나만 넣으면 에러
def func2(greeting, name='홍길동'):
    print(name, '님', '^^', greeting)


func2('hello')  # 에러 안남. name 에 default 값을 넣음


def buggy(arg, result=[]):
    result.append(arg)
    print(result)


buggy('AA')
buggy('CG')
buggy('B', [1, 2, 3, 4])

'''
1번째와 2번째는 인자가 반드시 들어가고 3번째는 인자가 들어갈 수도 있고 없으면 0으로 초기화한다
그러나 4번째 인자부터는 정확히 모른다면?
print(func(4, 5))
print(func(4, 5, 6))
print(func(4, 5, 6, 7))
print(func(4, 5, 6, 7, 8, 9))       # i9에 7,8,9가 튜플로 들어간다
'''


# 5. 위치 인자 모으기
def func3(i, j, k=0, *args):  # *args : 위치인자들
    sum(i + j + k)
    for p in args:
        sum += p
    return sum


print('=' * 100)


# 6. 키워드 인자 모으기
def func4(i, j, k=100, *args, **kwargs):  # **kwargs 키워드 인자가 여려 개인 경우
    print(i, j, k)
    print(args)
    print(kwargs)
    print('=' * 100)


func4(1, 2, 3)
func4(1, 2, 3, 4, 5, 6)
func4(1, 2, 3, a=100, b=200, c=300)


def case1():
    print('case-1')


def case2():
    print('case-2')


def case3():
    print('case-3')
    print('=' * 100)


f = {'case1': case1(), 'case2': case2(), 'case3': case3()}
print(f['case3'])
# f['case3']()    # TypeError: 'NoneType' object is not callable



