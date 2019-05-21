package emp.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SelectTest {
    public static void main(String[] args) {

        Connection con = connect_db.main();
        // 3. sql 문장 만들기
        // 4. sql 전송 객체 만들기
        // 5. 전송하기
        // 6. 닫기
        try {
//            String sql = "SELECT * FROM emp ORDER BY EMPNO";
//            Statement st = con.createStatement( );

            // 완성된 문장이라도 prepared statement 써도 됨
//            String sql = "SELECT * FROM emp ORDER BY empno";
//            PreparedStatement st = con.prepareStatement( sql );
//            ResultSet rs = st.executeQuery( ); // sql 지정하면 안됨
//
//            while (rs.next( )) {
//                System.out.println( rs.getInt( "EMPNO" ) + "/"
//                + rs.getString( "ENAME" ) + "/" + rs.getInt( "SAL" ));
//            }

            // 단일행 select 인 경우 while > if를 쓴다. 효율성을 위해서
//            int empno = 5678;
//            String sql = "SELECT * FROM emp WHERE empno=?";
//            PreparedStatement st = con.prepareStatement( sql );
//            st.setInt( 1, empno );
//
//            ResultSet rs = st.executeQuery( ); // sql 지정하면 안됨
//
//            if (rs.next( )) {
//                System.out.println( rs.getInt( "EMPNO" ) + "/"
//                        + rs.getString( "ENAME" ) + "/" + rs.getInt( "SAL" ));
//            }

            // 사원 테이블의 총 사원수와 월급의 평균을 구하기
            String sql = "SELECT count(empno) ct, AVG(sal) avgsal FROM emp";
            PreparedStatement st = con.prepareStatement( sql );
            ResultSet rs = st.executeQuery( );

            if (rs.next( )) {
                System.out.println( rs.getInt( "ct" ) + "/"
                        + rs.getInt( "avgsal" ) );
            }

            rs.close( );
            st.close( );
            con.close( );

        } catch (SQLException ex) {
            System.out.println( "전송 실패" + ex.getMessage( ) );
        }
    }
}
