import json

f = open('../data/temp.json', 'rt', encoding='utf-8')
json_data = f.read()
data = json.loads(json_data)
print(data)
#
# for item in data:
#     print('>', item)

# (1)   이름: ㅇㅇㅇ
#       번호: ㅇㅇㅇ
#       직업: ㅇㅇㅇ
#       형태로 출력해보기

for item in data:
    print('이름:', item)
    print('번호:', data[item]['No'])
    print('직업:', data[item]['Job'])
    # for value in data[item]:
    #     # print(value)
    #     # print(data[item][value])
    #     if value == 'No':
    #         print('번호:', data[item][value])
    #     elif value == 'Job':
    #         print('직업:', data[item][value])
    print()
f.close()

