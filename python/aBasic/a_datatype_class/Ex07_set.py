# -----------------------------------------------
#  집합
#       - 집합에 관련된 자료형
#       - 순서를 지정하지 않는다
#       - 중복을 허용하지 않는다


s = set()  # 빈 집합을 생성
s = set([1, 2, 3, 1, 1])
print(s)

s3 = {3, 4, 5, 6}

print(s & s3)
print(s | s3)
print(s - s3)
print('=' * 20)

hungry = True
sleepy = False

print(hungry and sleepy)    # False
print(hungry or sleepy)     # True
print(hungry & sleepy)      # False

