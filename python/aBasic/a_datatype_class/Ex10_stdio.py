"""
    [ 콘솔 입력 처리 함수 ]
    - input() : 기본적으로 문자열로 입력받음
    - eval() : 함수로 감싸면 숫자 처리됨
"""
name = input('이름은? ')
print('당신은 {0} 입니다.'.format(name))
print('당신은 %s 입니다' % name)

# 나이를 입력받고 한 살 더해서 출력하기
age = int(input('나이는? '))
print('당신의 나이는 %d 입니다.' % (age + 1))

# ----------------------------------
# 단을 입력받아 구구단을 구하기
dan = int(input('몇 단(구구단)? '))
for i in range(1, 10):
    print(dan, '*', i, '=', dan * i)

# -----------------------------------------
# print() 함수


# -------------------------------------------------------
# 명령행 매개변수 받기 - java의 main() 함수의 인자
# [ 콘솔에서 실행 ] python Ex09_stdio.py ourserver scott tiger
#                                   0         1      2      3
import sys
args = sys.argv[2:]
for i in args:
    print('인포 : ', i)