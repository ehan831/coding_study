class Contact:
    def __init__(self, name, phone_number, email, addr):
        self.name = name
        self.phone_name = phone_number
        self.email = email
        self.addr = addr

    def print_info(self):
        print("이름:", self.name)
        print("전화번호:", self.phone_name)
        print("이메일:", self.email)
        print("주소;", self.addr)


def print_menu():
    print('1. 연락처 입력')
    print('2. 연락처 출력')
    print('3. 연락처 삭제')
    print('4. 종료')
    menu = input('메뉴선택: ')
    return int(menu)


def set_contact():
    # 여기에 코드 작성
    name = input('이름은: ')
    phone_name = input('번호는: ')
    email = input('이멜은: ')
    addr = input('주소는: ')
    return [name, phone_name, email, addr]


def print_contact(contact_list):
    # 여기에 코드 작성
    # print(list(contact_list))   # [['111', '112', '113', '114'], ['21', '22', '23', '24']]
    # print(contact_list[0][0])
    for i in contact_list:
        print('이름은 {0}\n번호는 {1}\n이멜은 {2}\n주소는 {3}\n=== 다음 ==='.format(i[0], i[1], i[2], i[3]))


def delete_contact(contact_list, name):
    for i in contact_list:
        # print(i[0])
        # print(name)
        # print(i[0] == name)
        if i[0] == name:
            contact_list.remove(i)
            print('{0}님의 연락처가 삭제되었습니다.'.format(name))
        else:
            continue


# 여기에 코드 작성
def run():
    # Contact 인스턴스를 저장할 리스트 자료구조 생성
    contact_list = []
    while True:
        menu = print_menu()
        if menu == 4:  # 종료를 선택하면
            break
        elif menu == 1:  # 입력을 선택하면
            contact = set_contact()
            contact_list.append(contact)
        elif menu == 2:  # 출력을 선택하면
            print_contact(contact_list)
        elif menu == 3:  # 삭제를 선택하면
            name = input('삭제할 이름은? ')
            delete_contact(contact_list, name)


if __name__ == "__main__":
    run()
