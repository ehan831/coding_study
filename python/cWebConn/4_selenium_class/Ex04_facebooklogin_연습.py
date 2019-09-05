"""
    [연습] 페이스북에 접속해서 로그인 하기

        로그인 후에 보안창은 없는데 안 넘어가서

        from selenium.webdriver.common.keys import Keys

        아이디와 패스워드 지정후에
        elem.send_keys(Keys.RETURN)

"""
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

myID = 'musiq831@gmail.com'
myPW = input('비밀번호를 입력해주세요: ')

# 1. webdriver 객체생성
driver = webdriver.Chrome('./webdriver/chromedriver')
driver.implicitly_wait(5)  # 암묵적으로 자원로드될 때까지 3초 기다림

# 네이버로그인 하기 -[결론] 네이버 보안에 걸림
# 보안에 안걸렸으면 로그인된 상태로 많은 정보를 가져올 수 있다

driver.get('https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110')
elem = driver.find_element_by_id('email')
elem.send_keys(myID)
elem = driver.find_element_by_id('pass')
elem.send_keys(myPW)
# 로그인 버튼을 눌러주자.

driver.find_element_by_xpath('//*[@id="loginbutton"]').click()
elem.send_keys(Keys.RETURN)
