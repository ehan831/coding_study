package emp.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;


public class SelectTest {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@oracle11g.czhstbnsibro.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
        Scanner input = new Scanner(System.in);
        System.out.println("계정명은 :" );
        String user = input.nextLine() ;
        System.out.println("패스워드는 :" );
        String pass = input.nextLine();
        Connection con = null;

        // 1. 드라이버를 메모리 로딩
        try {
            Class.forName( driver );
            con = DriverManager.getConnection( url, user, pass );
            System.out.println( "연결 성공" );

        } catch (Exception ex) {
            System.out.println( "연결 실패" + ex.getMessage( ) );
        }

        // 3. sql 문장 만들기
        // 4. sql 전송 객체 만들기
        // 5. 전송하기
        // 6. 닫기
//        try {
//            String sql = "SELECT * FROM emp ORDER BY EMPNO";
//            Statement st = con.createStatement( );
//            ResultSet rs = st.executeQuery( sql );
//            while (rs.next( )) {
//                System.out.println( rs.getInt( "EMPNO" ) + "/"
//                + rs.getString( "ENAME" ) + "/" + rs.getInt( "SAL" ));
//            }
//
//            st.close( );
//            con.close( );
//
//        } catch (SQLException ex) {
//            System.out.println( "전송 실패" + ex.getMessage( ) );
//        }
    }
}
