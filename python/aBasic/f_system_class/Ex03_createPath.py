from pathlib import Path

# ------------------------------------------------
# 1. 경로의 상태보기
print(Path.cwd())
print(Path.home())
#
# p = Path('Ex03_createPath.py')
# print(p.stat())
# print(p.stat()[stat.ST_CTIME])  # 윈도우 따라했는데 안
# ----------------------------------------------------
# 2. 경로(파일) 생성시간 알아보기


# ------------------------------------------------
# 3. 디렉토리 생성


# ------------------------------------------------
# 4. 파일 생성
p = Path('imsi/a.txt')
with open(p, wt, encoding='utf-8') as f:
    f.write("불금이다아아아아아 가즈아")



# ------------------------------------------------
#  5. 경로 제거