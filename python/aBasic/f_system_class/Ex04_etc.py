"""
경로 이동은  Path 모듈로 안되어 os 모듈이 필요하다
"""
from pathlib import Path
import os

# print(Path.cwd())
# os.chdir('..')
# print(Path.cwd())

print(os.environ["HOME"])
sub = Path('app/hadoop')
p = Path(os.environ["HOME"], sub)
print(p)


import shutil
# shutil.rmtree('imsi')
shutil.copy('Ex00.txt', Path('copy.txt'))       # 파일 카피 가능

shutil.copytree('.', '../f_copy')   # 디렉토리 통으로 카피 가능
