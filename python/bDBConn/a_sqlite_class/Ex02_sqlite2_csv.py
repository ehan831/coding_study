import sqlite3
import csv


def createDBtable(db):
    conn = sqlite3.connect(db)
    cur = conn.cursor()
    sql = '''
        CREATE TABLE if not exists supply
        (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        Supplier_Name VARCHAR(30),
        Invoice NUMBER ,
        Part NUMBER ,
        Cost NUMBER ,
        Purchase DATE
        )
        '''
    cur.execute(sql)
    conn.commit()
    conn.close()


def saveDBtable(db, data):
    conn = sqlite3.connect(db)
    cur = conn.cursor()
    sql = '''INSERT INTO supply(Supplier_Name, Invoice_number, Part_number, Cost, Purchase_date) VALUES(?,?,?,?,?)'''
    cur.execute(sql, (data[0], data[1], data[2], data[3], data[4]))
    conn.commit()
    conn.close()


def viewDBdata(db, table):
    conn = sqlite3.connect(db)
    cur = conn.cursor()
    sql = 'SELECT * FROM {0}'.format(table)
    cur.execute(sql)
    rows = cur.fetchall()     # 전체 결과
    # rows = cur.fetchone()     # 1개의 결과값을
    # rows = cur.fetchmany(3)   # 3줄의 결과값만
    # print(rows)
    for row in rows:
        print(row)

    conn.commit()
    conn.close()


if __name__ == '__main__':

    db_name = '../db/supplyDB.db'

    # (1) DB에 테이블 생성
    # createDBtable(db_name)

    # ------------------------------------------------------
    # (2) csv파일을 읽어서 DB에 테이블 입력
    # file_name = '../files/supply.csv'
    # file = csv.reader(open(file_name, 'r'), delimiter=',')
    # # header 제거
    # header = next(file, None)
    # print(header)
    # for row in file:
    #     # print(row)    # ['Samsung', '1001', '2521', '50000', '2025-01-01']
    #     # print(type(row))    # list
    #     saveDBtable(db_name, row)


    # ------------------------------------------------------
    # (3) DB에 저장되어 있는 테이블값 출력
    viewDBdata(db_name, 'supply')   # 디비명, 테이블명
