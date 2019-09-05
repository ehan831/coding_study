'''
exmodule.py

sum() 함수 정의
    - 2개의 인자 받아서 더한 값을 리턴(같은 자료형일 때만)
    - 2개의 인자의 자료형이 일치하지 않으면 에러 '자료형이 달라서 계산할 수 없음'
'''


def sum_2(first, second):
    if type(first) == type(second):
        sum_all = first + second
        return sum_all
    else:
        return '자료형이 달라서 계산 할 수 없음'

