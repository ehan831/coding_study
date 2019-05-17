package emp.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
    public static void main(String[] args) {

        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@192.168.0.95:1521:orcl";
        String user = "scott";
        String pass = "tiger";
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
        try {
            String sql = "INSERT INTO emp(empno, ename, sal, deptno) "
                    + " VALUES(9876, '갓동범', 10, 30)";
            System.out.println( sql );
            Statement st = con.createStatement( );
            st.executeUpdate( sql );
            st.close( );
            con.close( );

        } catch (SQLException ex) {
            System.out.println( "전송 실패" + ex.getMessage( ) );
        }
    }
}
