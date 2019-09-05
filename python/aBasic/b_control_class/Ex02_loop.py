# ------------------------------------------------------
"""
   (2) for문
        for <타켓변수> in 집합객체 :
            문장들
        else:
            문장들

        ` 반복문 뒤에 else는 반복하는 조건에 만족하지않으면 실행 ( 많이 사용 안함 )

   (3) while 문
        while 조건문 :
            문장들

"""
a = 112  # 숫자형
b = ['1', '2', '3']  # 리스트
c = '987'  # 문자열
d = tuple(b)  # 튜플
e = dict(k=5, j=6)  # 딕셔너리

for entry in b:  # a는 반복이 안되지만 b부터 e까지는 반복된다.
    print(entry)

# 딕셔너리의 경우에는 키만 나온다. 다 필요하면 e.items!!
for entry in e:
    print(entry)

for entry in e.items():
    print(entry)
# ==========================================
# 1 ~ 10 의 합
sum = 0
for i in range(1, 11):
    sum += i
print(sum)
# =========================================================
# while

# a = 1
# while True:  # 무한루프
#    if a == 1:
#        print(a)
#        break


"""
[과제] 2단부터 9단까지 이중 반복문으로 출력
"""
for i in range(2, 10):
    print('===== 구구단 %s단 =====' % i)
    for j in range(1, 10):
        print(i, "*", j, "=", i * j)

# ===================
a = ['z', 'y', 'x']
while a:
    data = a.pop()
    if data == 'y':
        break
    print(data)
else:
    print('=== end ===')

