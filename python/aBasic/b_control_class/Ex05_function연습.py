# [ 연습문제 ]
#
# - 리스트를 인자로 받아 짝수만 갖는 리스트 반환하는 함수
#     [ 출력 결과 ]
# print(even_filter([1, 2, 4, 5, 8, 9, 10]))
even_filter = lambda list_input: [n for n in list_input if n % 2 == 0]
print(even_filter([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))

# - 주어진 수가 소수인지 아닌지 판단하는 함수
#     [ 출력 결과 ]
x = int(input('숫자를 입력해주세요. '))


def is_prime_number(x):
    if x == 2:
        return True
    elif x > 1:
        for i in range(2, x):
            if x % i != 0:
                return True
            else:
                return False
    else:
        return False


print('%s는 소수입니까? ' % x, is_prime_number(x))


# print(is_prime_number(2))
# print(is_prime_number(5))
# print(is_prime_number(60))
# print(is_prime_number(61))


# - 주어진 문자열에서 모음의 개수를 출력하는 함수
#     [ 출력 결과 ]
# print(count_vowel("pythonian"))
input_txt = input('문자열을 입력해주세요. ').lower()


def count_vowel(input_txt):
    w_count = {txt: input_txt.count(txt) for txt in ['a', 'e', 'i', 'o', 'u']}
    return sum(w_count.values())


print('모음의 개수는 ? ', count_vowel(input_txt))

# word = 'LOVE LOL'
# wcnt = {letter: word.count(letter) for letter in word}
# print(wcnt)     # {'L': 3, 'O': 2, 'V': 1, 'E': 1, ' ': 1}
