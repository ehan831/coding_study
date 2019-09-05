'''
myfile3.py
    - mypackage > exam 안에 있는 exmodule 을 임포트하여 사용하고자 함
'''

import mypackage.exam.exmodule as mee

sum = mee.sum_2(1, 2)
print(sum)
