"""
 - import pathlib 만 선언하면
        Path클래스 사용시 pathlib.Path라고 명시해야 한다. 
"""
from pathlib import Path


# (1) 해당 경로와 하위 목록들 확인
p = Path('/Users/eunguhan')
p = Path('..')          # 부모 경로를 찾아
print(p)
print(p.resolve())      # 경로를 찾아줌


# (2) 파일시스템에 해당 파일이 존재하는지 여부
result = []
# 부모 디렉토리에서 존재하는 파일,디렉토리를 찾기
for x in p.iterdir():
    result.append(x)
print(result)

# 부모 디렉토리에서 존재하는 디렉토리만 찾기
result2 = []
for x in p.iterdir():
    if x.is_dir():
        result2.append(x)
print(result2)

# (3) 윈도우는 경로 구분자로 역슬래쉬를 사용하지만 Path를 사용하면 슬래쉬로도 인식하여
# 운영체제의 영향없이 추상화하여 path를 사용할 수 있다

# 위와 동일하게 컴프레헨션
result3 = [x for x in p.iterdir() if x.is_dir()]
print(result3)


# (2) glob 이용
sub = list(p.glob('a_datatype_class/*.py'))
print(sub)


# 하위 폴더, 하위 파일 전부!!
sub2 = list(p.glob('**/*.py'))
print('sub2:', sub2)


# 어딘가에 있는 data 디렉토리 안에서 csv 파일을 찾기
sub3 = list(p.glob('**/data/*.csv'))
print('sub3:', sub3)