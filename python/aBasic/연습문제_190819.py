# 1. 다음 코드의 실행 결과를 쓰시오.
a = 777
b = 777
print(a == b, a is b)
# True True
# 이걸 파이썬 콘솔에서 돌리면 False 가 나온다. 이유: 1~255 까지는 메모리에 미리 올려놓는데, 그 밖에 있는 숫자는 새로 올리기 때문이다.


# 2. 다음 중 변수를 메모리에서 삭제하기 위해 사용하는 명령어는?
# ➀ del ➁ delete ➂ remove ➃ pop ➄ clear
# 1


# 3. 빈칸에 들어갈 각각의 코드 실행 결과를 쓰시오.
a = 3.5
b = int(3.5)  # 3
print(a ** ((a // b) * 2))
print(((a - b) * a) // b)
b = (((a - b) * a) % b)
print(b)
print((a * 4) % (b * 4))
# 12.25
# 0.0
# 1.75
# 0.0


# 4. 입력받은 섭씨온도를 화씨온도로 변환하는 프로그램을 코딩하려고 한다. 코드 순서를 바르게 나열한 것은?
# (1) fahrenheit = (( 9 / 5) * celsius) + 32
# (2) celsius = input("섭씨온도를 입력하세요:")
# (3) print("섭씨온도:", celsius, "화씨온도:", fahrenheit)
# (4) celsius = float(input("섭씨온도를 입력하세요:"))
# 답: 4-1-3 // input 은 str 로 받나보네


# 5. 다음 변수 a의 자료형은?
a = "True"
print(type(a))
# <class 'str'>
print("=" * 20)

# 6. 다음과 같은 코드 작성 시, 실행 결과로 알맞게 짝지어진것은?
a = 10.6
b = 10.5
print(a * b)
print(type(a + b))
# 111.3
# <class 'float'>


# 7. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은?
a = "3.5"
b = 4
print(a * b)
# 3.53.53.53.5


# 8. a = "3.5", b= "1.5"일 때,print(a + b)의 실행 결과는?
a = "3.5"
b = "1.5"
print(a + b)
# 3.51.5


# 9. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은?
a = '3'
b = float(a)
print(b ** int(a))
# 27.0

# 10. 변수(variable)에 대한 설명으로 틀린것은? 3
# ① 프로그램에서 사용하기 위한 특정한 값을 저장하는 공간이다.
# ② 선언되는 순간 메모리의 특정 영역에 공간이 할당된다.
# ③ 변수에 할당된 값은 하드디스크에 저장된다.
# ④ A = 8은 "A는 8이다"라는뜻이 아니다.
# ⑤ ‘2x + 7y’는 14라고 하면, 이 식에서 x와 y가 변수이다.
print("=" * 20)

# 11. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은? Typeerror
# a = '20'
# b = '4'
# print(type(float(a / b)))


# 12. 다음 코드의 실행 결과가 나오도록 빈 칸에 코드를 추가하시오.(단, 변수를 삭제하면 안 됨.)
a = "Gachon"
b = "CS"
c = 200
# 빈칸
c = int(c / 4)
print(a, b, c)
# 결과: Gachon CS 50


# 13. 변수명을 지을 때 권장하는 규칙 중 틀린 것은? 2 or 5 ??
# ① 변수명은 알파벳, 숫자, 언더스코어(_ ) 등을 사용하여 표현할 수 있다.
# ② 변수명은 의미 있는 단어로 쓰는 것을 권장하며, 한글도사용할 수 있다.
# ③ 변수명은 대소문자가 구분된다.
# ④ 문법으로 사용되는 특별한 예약어는 변수명으로 쓰지 않는다.
# ⑤ 변수명은 “a”, “b” 등으로 사용하는 것은 권장하지 않는다.

# ==============================
print("=" * 50)
# 5. 문자열

# 1. 다음 코드의 실행 결과로 알맞은 것은?
a = 11
b = 9
print('a' + 'b')
# ab


# 2. 다음 코드의 실행 결과로 알맞은 것은? 3+5+13 = 21
fact = "Python is funny"
print(str(fact.count('n') + fact.find('n') + fact.rfind('n')))

# 3. 다음 코드의 실행 결과로 알맞은 것은? Gachon Human
text = 'Gachon CS50 - programming with python'
text2 = " Human cs50 knowledge belongs to the world "
text.lower()
print(text[:5] + text[-1] + text[6] + text2.split()[0])

# 4. 다음 코드의 실행 결과로 알맞은 것은? introduction programming with python
class_name = 'introduction programming with python'
for i in class_name:
    if i == 'python':
        i = i.upper()
print(class_name)

# 5. 다음 코드의 실행 결과를 쓰시오. 1010102
a = '10'
b = '5-2'.split('-')[1]
print(a * 3 + b)

# 6. 다음 코드의 실행 결과를 쓰시오. aa
a = "abcd e f g"
b = a.split()
# print(b)    ['abcd', 'e', 'f', 'g']
c = (a[:3][0])
d = (b[:3][0][0])
print(c + d)

# 7. 다음 코드의 실행 결과를 쓰시오. 8,1
result = "CODE2018"
print("{0},{1}".format(result[-1], result[-2]))

# 8. 다음 중 문자열 함수의 설명으로 틀린 것은?   3
# ① capitalize( ): 첫 문자를 대문자로변환한다.
# ② title( ): 각 단어의 앞 글자만대문자로 변환한다.
# ③ strip( ): 공백을 기준으로 나눠리스트를 반환한다.
# ④ isdigit( ): 문자열이 숫자인지의여부를 반환한다.
# ⑤ upper( ): 문자를 대문자로 변환한다.
