"""
     1) 클래스 기초

     ` __init__ 함수 : 객체 초기화 함수( 생성자 역할 )
     ` self : 객체 자신을 가리킨다.
"""


class Sample:
    # 멤버 변수 초기화를 반드시 생성자를 만들어야 한다.
    def __init__(self):
        self.name = '홍길동',
        self.age = 25
        print('생성자 호출')

    def __del__(self):
        print('소멸자 호출')

    # 클래스 생성 - 인스턴스 (객체)


a = Sample()
print(a.name)
print(a.age)
del a
# print(a.name) # error


"""
    2) 
    인스턴스 함수 :  'self'인 인스턴스를 인자로 받고 인스턴스 변수와 같이 하나의 인스턴스에만 한정된 데이터를 생성, 변경, 참조
    클래스   함수 :  'cls'인 클래스를 인자로 받고 모든 인스턴스가 공유하는 클래스 변수와 같은 데이터를 생성, 변경 또는 참조
    static  함수 :  클래스명 접근을 하며 객체끼리의 공유하고자 하는 메소드
    
    - 클래스 함수와 스태틱 함수는 둘 다 클래스명 접근
    - 클래스 함수는 cls를 이용하여 객체를 이용할 수 있다

"""


class Staff:
    def __init__(self, name):
        self.name = name

        # 일반 함수(인스턴스 함수)

    def output(self):
        print('{0} 님은 우리 직원입니다'.format(self.name))

    @staticmethod  # 스태틱 함수라고 선언
    def step(name):
        print('우리 회사는 사원, 직원, 책임으로 구성되어 있습니다.')
        print(name, "님은 책임입니다.")

    @classmethod
    def step2(cls, name):
        print('2. 우리 회사는 사원, 직원, 책임으로 구성되어 있습니다.')
        print(name, "님은 책임입니다.2.")


s2 = Staff('홍길길')
# s2.output()
#
#
# s2.step('홍홍홍')
# Staff.step('홍이삼')


s2.step2('홍성남')
s2.output()
print('=' * 100)

'''
     3) 클래스 상속
        - 파이션은 method overring은 있지만 method overloading 개념은 없다
        - 파이션은 다중상속이 가능
        - 부모 클래스가 2개 이상인 경우 먼저 기술한 부모클래스에서 먼저 우선 해당 멤버를 찾음
'''


class Animal:
    def move(self):
        print('하우 투 런')


class Wolf(Animal):
    def move(self):
        print('늑대는 타닥타닥')


class Human(Animal):
    def move(self):
        print('인간은 터벅터벅')


class WolfHuman(Human, Wolf):
    def move(self):
        super().move()  # 먼저 기술된(앞에 있는) 부모를 받네 !!
        print('늑대인간은 타벅타벅')


w = WolfHuman()
w.move()

