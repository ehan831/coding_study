import MySQLdb


def payment_select():
    # db 연결
    conn = MySQLdb.connect(host='192.168.0.170', user='scott', passwd='tiger', db='pythondb')
    cur = conn.cursor()

    sql = "SELECT * FROM payment"
    cur.execute(sql)

    conn.commit()
    conn.close()