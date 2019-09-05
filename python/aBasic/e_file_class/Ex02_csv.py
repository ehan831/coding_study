# [1] 리스트 데이터를 csv 파일에 저장한다
import csv

data = [[1, '김', '책임'], [2, '박', '선임'], [3, '주', '연구원']]
with open('data/imsi2.csv', 'wt', encoding='utf-8') as f:
    count = csv.writer(f)
    count.writerows(data)

# [2] csv 파일을 읽어서 리스트 변수를 출력하기
data = []
with open('data/imsi2.csv', 'r', encoding='utf-8') as r:
    cin = csv.reader(r)
    data = [row for row in cin if row]
    print(data)
