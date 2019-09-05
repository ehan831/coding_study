"""
    일단 http://www.hanbit.co.kr 회원가입

    [예] 한빗출판네트워크 ( 단순 페이지 ) : 이 예문은 위키북스 출판사 교재 예문임
                                    <파이썬을 이용한 머신러닝, 딥러닝 실전개발 예문>
    로그인페이지 : http://www.hanbit.co.kr/member/login.html
    마이페이지 : http://www.hanbit.co.kr/myhanbit/membership.html

    1. 로그인 페이지에서 개발자모드에서 로그인 form 태그를 분석
        입력태그의 name='m_id' / name='m_passwd' 확인

    2. 로그인 후에 마이페이지에서 마일리지와 한빛이코인 부분
        마일리지 (.mileage_section1 > span ) / 한빛이코인 (.mileage_section2 > span )

    3. 로그인과정에 어떤 통신이 오가는지 분석
        Network > Preserve log 체크 > Doc 탭을 선택하고 다시 처음부터 로그인을 하면 서버와 통신을 오고간다
        이 때 Name 중 login_proc.php를 선택하고 Headers 부분을 확인한다
        
        Gereral : Request Mathod : POST
        Form Data : m_id와 m_passwd 값 확인
"""
import requests
from bs4 import BeautifulSoup


# 세션 시작하기
sess = requests.session()
login_info = {
    'm_id': '',
    'm_passwd': ''
}
url_logic = 'http://www.hanbit.co.kr/member/login_proc.php'
res = sess.post(url_logic, data=login_info)
res.raise_for_status()      # 해당 사이트에서 오류 발생 시 나도 알려줘 !!


url_mypage = 'http://www.hanbit.co.kr/myhanbit/myhanbit.html'
res = sess.get(url_mypage)
res.raise_for_status()


# 결과 값 파싱하기
soup = BeautifulSoup(res.text, 'html.parser')
# print(soup)


# 원하는 데이터 찾기
print('마일리지', soup.select_one('.mileage_section1 span').text)


