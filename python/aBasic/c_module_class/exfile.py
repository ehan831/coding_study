'''
exfile.py
    - exmodule.py 에 있는 sum() 호출하여 결과 출력
'''

from exmodule import sum_2 as sm

print(sm(1, 2))
print(sm(1.0, 2))
print('=' * 20)
