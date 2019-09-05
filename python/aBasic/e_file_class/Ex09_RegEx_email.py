"""
    이메일 주소의 적합성 체크
        kim@encore.com   : 올바른 이메일
        kim@encore       : 잘못된 이메일 ( . 하나 없어서 )
        kim_@encore.com  : 잘못된 이메일 ( 특수문자 안됨 )

     [참고]
        ^[]: 시작
        [^] : not
        {2,9} : 최소 2개 최대 9개
        {2,} : 최소 2개만 지정하고 최대는 지정하지 않음
        $ 끝
"""
import re


# def email_check(email):
#     # 여기에 코드 작성
#     if re.findall('^[a-zA-Z0-9](\.?[a-z0-9]){0,}@[a-z0-9-]+\.([a-z]\.)?[a-z]{2,6}', email):
#         print("오케이")
#     else:
#         print("형식에 맞지 않아요.")
#     return True


def email_check(email):
    exp = re.findall('^[\w]{2,10}@[a-z]+\.[a-z]+$', email)
    if len(exp) == 0:
        print('잘못된 이메일')
    else:
        print('올바른 이메일')


email_check('kim@encore.com')  # 올바른 이메일
email_check('kim@encore')  # 잘못된 이메일 ( . 하나 없어서 )
email_check('kim_@encore.com')  # 잘못된 이메일 ( 특수문자 안됨 )
