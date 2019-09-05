# 2. 리스트 다루기

# 1. 다음 코드의 실행 결과를 쓰시오    [0, 1, 2] [0, 1]
a = [0, 1, 2, 3, 4]
print(a[:3], a[:-3])

# 2. 다음 코드의 실행 결과를 쓰시오.     [4, 3, 2, 1, 0]
a = [0, 1, 2, 3, 4]
print(a[::-1])

# 3. 다음 코드의 실행 결과를 쓰시오.
first = ["egg", "salad", "bread", "soup", "canafe"]
second = ["fish", "lamb", "pork", "beef", "chicken"]
third = ["apple", "banana", "orange", "grape", "mango"]
order = [first, second, third]
john = [order[0][:-2], second[1::3], third[0]]  # [egg, salad, bread], 'lamb', 'chicken'], [apple]
del john[2]  # [egg, salad, bread], ['lamb', 'chicken']
john.extend([order[2][0:1]])  # [egg, salad, bread], ['lamb', 'chicken'], [apple]
print(john)  # [['egg', 'salad', 'bread'], ['lamb', 'chicken'], ['apple']]

# 4. 다음 코드의 실행 결과를 쓰시오.
list_a = [3, 2, 1, 4]
list_b = list_a.sort()
print(list_a, list_b)  # [3, 2, 1, 4], None

# 5. 다음 코드의 실행 결과를 쓰시오.
fruits = ['apple', 'banana', 'cherry', 'grape', 'orange', 'strawberry', 'melon']
print(fruits[-3:], fruits[1::3])  # ['orange', 'strawberry', 'melon'], ['banana', 'orange']

# 6. 다음 코드의 실행 결과를 쓰시오.
num = [1, 2, 3, 4]
print(num * 2)  # [1, 2, 3, 4, 1, 2, 3, 4]

# 7. 다음 코드의 실행 결과를 쓰시오.
a = [1, 2, 3, 5]
b = ['a', 'b', 'c', 'd', 'e']
a.append('g')  # [1, 2, 3, 5, 'g']
b.append(6)  # ['a', 'b', 'c', 'd', 'e', 6]
print('g' in b, len(b))  # False, 6

# 8. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은?
list_a = ['Hankook', 'University', 'is', 'an', 'academic', 'institute', 'located', 'in', 'South Korea']
list_b = []
for i in range(len(list_a)):
    if i % 2 != 1:
        list_b.append(list_a[i])
print(list_b)  # ['Hankook', 'is', 'academic', 'located', South Korea']

# 9. 다음 코드를 실행한 후, 2018과 "2018"을 각각 입력했을 경우 알맞은 실행 결과끼리 묶인 것은?
# admission_year = input("입학 연도를 입력하세요: ")
# print(type(admission_year))  # <class 'str'> <class 'str'>

# 10. 다음 코드의 실행 결과를 쓰시오.
country = ["Korea", "Japan", "China"]
capital = ["Seoul", "Tokyo", "Beijing"]
index = [1, 2, 3]
country.append(capital)  # ["Korea", "Japan", "China", ["Seoul", "Tokyo", "Beijing"]]
country[3][1] = index[1:]  # "Tokyo" > [2,3]
print(country)  # ['Korea', 'Japan', 'China', ['Seoul', [2, 3], 'Beijing']]

# 11. 다음과 같이 코드를 작성했을 때 예측되는 실행 결과를 쓰고, 이러한결과가 나오는 이유에 대해 서술하시오. ( is키워드는 주소를 비교한다 )
a = [5, 4, 3, 2, 1]
b = a
c = [5, 4, 3, 2, 1]
print(a is b)  # True
print(a is c)  # False

# 12. 다음 코드를 실행하면 다음과 같은 결과가 나온다. 그이유에 대해 서술하시오.
a = 1
b = 1
print(a is b)  # True

a = 300
b = 300
print(a is b)  # True // 이슈가 있는 부분, Console 에서는 False

# 15. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은?
list_1 = [[1, 2], [3], [4, 5, 6]]
a, b, c = list_1  # a = [1, 2] // b = [3] // c = [4, 5, 6]
list_2 = a + b + c
print(list_2)  # [1, 2, 3, 4, 5, 6]

# ============================ 3. 조건문과 반복문 =========
# 1. 다음 코드의 실행 결과를 쓰시오.
fruit = 'apple'
if fruit == 'Apple':
    fruit = 'Apple'
elif fruit == 'fruit':
    fruit = 'fruit'
else:
    fruit = fruit
print(fruit)  # apple

# 2. 다음 코드의 실행 결과를 쓰시오.
# print(float(4))     # 4.0
# print(str(5))       # 5
number = ["1", 2, 3, float(4), str(5)]
if number[4] == 5:
    print(type(number[0]))  #
elif number[3] == 4:
    print(number[2:-1])  # [3, 4.0]

# 3. 다음 코드의 실행 결과를 쓰시오.
num = 0
i = 1
while i < 8:
    if i % 3 == 0:
        break
    i += 1
    num += i
print(num)  # 5

# 4. 다음 코드의 실행 결과를 쓰시오. -5
result = 0
for i in range(5, -5, -2):  # 5, 3, 1, -1, -3
    if i < -3:  #
        result += 1  #
    else:  # 5, 3, 1, -1, -3
        result -= 1  # -5
print(result)  # -5

# 5. 다음 코드의 실행 결과를 쓰시오.
fruit = 'apple'
if fruit == 'Apple':
    fruit = 'Apple'
elif fruit == 'fruit':
    fruit = 'fruit'
else:
    fruit = fruit
print(fruit)  # apple
# 6. 다음 코드의 실행 결과를 쓰시오.
num = ""
for i in range(10):  # 0 ~ 9
    if i <= 5 and (i % 2) == 0:  # 1,2,3,4,5 and 2,4,6,8 >> 2,4
        continue
    elif i is 7 or i is 10:  # 7
        continue
    else:  # 1,3,5,6,8,9
        num = str(i) + num  # 135689
print(num)  # 986531 왜 역순이지??
# 7. 다음 코드의 실행 결과를 쓰시오.
coupon = 0
money = 20000
coffee = 3500
while money > coffee:
    if coupon < 4:  # 0,1,2,3
        money = money - coffee  # -14000 > 6000     // 2차: [0, 8800] > [1, 5300] > [2, 1800]
        coupon += 1
    else:
        money += 2800  # 6000 > 8800
        coupon = 0  # coupon = 0, money = 8800
print(money)  # 1800

# 8. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은?
list_data_a = [1, 2]
list_data_b = [3, 4]
for i in list_data_a:
    for j in list_data_b:
        result = i + j  # finally 2 + 4
print(result)  # 6

# ============= 제어문
# 1. BMI(Body Mass Index)는 체중(kg)을 신장(m)의 제곱(**2)으로나눈 값으로 체지방 축적을 잘 반영하기 때문에 비만도 판정에 많이 사용한다.
# 사용자로부터 신장과 체중을입력 받아서 BMI 값에 따라서 다음과 같은 메시지를 출력하는 프로그램을 작성하여 보자.
# BMI // 메시지
# 20∼24.9   // 정상입니다.
# 25∼29.9   // 과체중입니다.
# 30이상     // 비만입니다.
#
height = float(input('키를 입력해주세요. ex. 1.83 '))
weight = float(input('몸무게를 입력해주세요. ex. 86 '))
bmi_no = round(weight/(height ** 2), 2)
print('BMI 지수는 : ', bmi_no)
if bmi_no >= 30:
    print('비만입니다.')
elif bmi_no >= 25:
    print('과제중 입니다')
elif bmi_no >= 20:
    print('정상입니다.')
else:
    print('이상한 수치네요 :)')
# print(bmi)

# 2. 1부터 99까지 2자리의 정수로 이루어진 복권이 있다고 하자. 2자리가 전부 일치하면 1등상 100만원을 받는다.
# 2자리중에서 하나만 일치하면 50만원을 받고 하나도 일치하지 않으면 상금은 없다
num = int(input('복권 번호(1-99)를 입력하시오 '))
import random

number = random.randint(1, 100)
print('입력번호 : ', num)
print('당첨번호 : ', number)

num_sp = list(str(num))
if len(num_sp) != 2:
    num_sp = ['0'] + num_sp
# print(num_sp)
number_sp = list(str(number))
if len(number_sp) != 2:
    number_sp = ['0'] + number_sp

aa = list(zip(num_sp, number_sp))
print(aa)   # [('0', '6'), ('3', '8')]

score = 0
for a, b in aa:
    if a == b:
        score += 50
print(score, "만원")


# print(number_sp)  ['7', '3']
# score = 0
# for i in num_sp:
#     if i in number_sp:
#         score += 50
# print(score, '만원')
