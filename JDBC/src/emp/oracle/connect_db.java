package emp.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class connect_db {
    public static Connection main() {
        //        String driver = "com.mysql.cj.jdbc.Driver";
//        String url = "jdbc:mysql://mysqldb.czhstbnsibro.ap-northeast-2.rds.amazonaws.com:3306/mydb";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@oracle11g.czhstbnsibro.ap-northeast-2.rds.amazonaws.com:1521:ORCL";

        Scanner input = new Scanner( System.in );
        System.out.println( "계정명은 :" );
        String user = input.nextLine( );
        System.out.println( "패스워드는 :" );
        String pass = input.nextLine( );
        Connection con = null;

        // 1. 드라이버를 메모리 로딩
        try {
            Class.forName( driver );
            con = DriverManager.getConnection( url, user, pass );
            System.out.println( "연결 성공" );

        } catch (Exception ex) {
            System.out.println( "연결 실패" + ex.getMessage( ) );
        }
        return con;
    }
}
