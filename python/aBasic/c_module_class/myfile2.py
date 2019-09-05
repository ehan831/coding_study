'''
myfile2.py
    - mypackage 안에 있는 mymodule 을 임포트하여 사용하고자 함
'''

import mypackage.mymodule

today = mypackage.mymodule.get_weather()
print(today)