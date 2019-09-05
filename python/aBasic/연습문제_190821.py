# 6 자료구조

# 1. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은?
list_1 = [0, 3, 1, 7, 5, 0, 5, 8, 0, 4]


def quiz_2(list_data):
    a = set(list_data)
    return (list(a)[1:5])


print(quiz_2(list_1))  # [1, 3, 4, 5]

print('=' * 20)


# 2. 각 자료구조에 대한 설명이다. (가) ~ (라)에 알맞은 용어를 쓰시오. 스택 // 큐 // 튜플 // 셋
# (가) 나중에 넣은 데이터를 먼저 반환하도록 설계된 메모리 구조로, LIFO(Last In First Out)로 구현된다.
# (나) 먼저 넣은 데이터를 먼저 반환하도록 설계된 메모리 구조로, FIFO(First In First Out)로 구현된다.
# (다) 값의 변경이 불가능하며, 리스트의 연산, 인덱싱, 슬라이싱 등을 동일하게 사용한다.
# (라) 값을 순서 없이 저장하면서 중복을 불허한다.


# 3. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은? # False
def delete_a_list_element(list_data, element_value):
    if element_value in list_data:
        list_data.remove(element_value)
        return list_data
    else:
        return "False"


list_data = ['a', 1, 'gachon', '2016.0']  # '2016.0' = str, 2016.0 = float
element = float(2016)
result = delete_a_list_element(list_data, element)
print(result)
print('=' * 20)

# 4. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은? 2019
a = [3, "apple", 2016, 4]
b = a.pop(0)  # 3
c = a.pop(1)  # 2016
print(b + c)  # 2019
print('=' * 20)

# 5. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은? [1, 2, 3, 4, 5, 6]
tuple_1 = (1, 2, 3)
tuple_2 = (4, 5, 6)


def quiz_1(data_1, data_2):
    result = []
    for i in (tuple_1 + tuple_2):
        result.append(i)
    return (result)


print(quiz_1(tuple_1, tuple_2))
print('=' * 20)

# 6. 다음 코드의 실행 결과를 쓰시오. 4
dict_1 = {2: 1, 4: 2, 6: 3, 8: 4, 10: 6}
dict_keys = list(dict_1.keys())  # 2,4,6,8,10
dict_values = list(dict_1.values())  # 1,2,3,4,6
dict_2 = dict()
for i in range(len(dict_keys)):
    dict_2[dict_values[i]] = dict_keys[i]
print(dict_2[2])
print('6=' * 20)

# 7. 다음과 같이 코드를 작성했을 때, 실행 결과로 알맞은 것은? # {4: 'ant', 'ant': 6, 0: 'snake', 2: 'monkey', 8: 'spider'}
animal = ['cat', 'snake', 'monkey', 'ant', 'spider']
legs = [4, 0, 2, 4, 8]
animal_legs_dict = {}
for i in range(len(animal)):
    animal_legs_dict[legs[i]] = animal[i]
    animal_legs_dict['ant'] = 6
print(animal_legs_dict)

# 8. 다음 코드의 실행 결과를 쓰시오. # 10
Mydict = {'1': 1, '2': 2}
Copy = Mydict
Mydict['1'] = 5
result = Mydict['1'] + Copy['1']
print(result)

# 9. 다음 코드의 실행 결과를 쓰시오. # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
a = list(range(10))
a.append(a[3])
a.pop(a[3])
a.insert(3, a[-1])
a.pop()
print(a)

# 10. 다음 코드의 실행 결과를 쓰시오.
data_1 = {'one': (1, 2, 3, 4, 5, 6), 'two': [1, 2, 3, 4, 5, 6], 'three': {'four': 4, 'five': 5}}
for k in ['one', 'two', 'three']:
    try:
        print(data_1[k][:1])
    except TypeError:
        print("error")

for k in ['one', 'two', 'three']:
    try:
        data_1[k][-1] = "a"
        print(data_1[k][-1])
    except TypeError:
        print("error")


# (1,)
# [1]
# error
# error
# a
# a

# ============ 10. 모듈과 패키지 ==========
# 1. 패키지(packages)에 대한 설명 중 틀린것은? # 3
# ① 다양한 모듈의 합으로 디렉터리로 연결된다.
# ② 하나의 대형 프로젝트를 만드는 코드의 묶음이다.
# ③ 개별 .py 파일을 의미한다. >> 모듈
# ④ 다양한 오픈소스들이 관리되는 방법이다.
# ⑤ _ _init_ _, _ _main_ _ 등 키워드 파일명이 사용된다.

# 2. ‘game’이라는 패키지를 만들고 싶다고 가정하자.
# 패키지를만들기 위해 디렉터리별로 필요한 모듈을 구현하고자 한다. 다음 그림에서 빈칸에 들어가야 할 파일은? # 3
# ➀ __main__ ➁import game ➂ __init__.py
# ➃ __main__.py ➄__init__

# 3. 두 코드 파일인 ‘fah_converter.py’와‘module_ex.py’는 같은 디렉터리에 있다.
# 다음과같은 결과값을 얻기 위해 빈칸에 들어갈 적합한 코드를 쓰시오. # import fah_converter as fah

# 4. 모듈을 호출하는 방법이 아닌 것은? # 2
# ➀ import os                       ➁ import os as *
# ➂ from os import listdir         ➃ from os import *
# ➄ import os as linuxos

# 5. ‘calculator_input.py’는 사칙연산 프로그램이다. 다음 빈칸을 채워 프로그램을 완성하시오.
# def sum_func(a, b):
#     return a + b
#
#
# def multiply_func(a, b):
#     return a * b
#
#
# def minus_func(a, b):
#     return a - b
#
#
# def devide_func(a, b):
#     return a / b

# [빈칸] # from calculator import *
# user_input = input("사칙연산 프로그램: ").split(" ")
# first_val, second_val = int(user_input[0]), int(user_input[2])
# fourcal = user_input[1]
# if fourcal == "+":
#     result = sum_func(first_val, second_val)
# elif fourcal == "-":
#     result = minus_func(first_val, second_val)
# elif fourcal == "/":
#     result = devide_func(first_val, second_val)
# else:
#     result = multiply_func(first_val, second_val)
# print("실행 결과는", result)
