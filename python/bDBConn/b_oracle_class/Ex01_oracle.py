import cx_Oracle as oci


conn = oci.connect('scott/tiger@localhost:1521/orcl')
print(conn.version)


# 이후 conn, cur 동일함

