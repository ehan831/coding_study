//package emp.oracle;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class UpdateTest {
//    public static void main(String[] args) {
//        String driver = "oracle.jdbc.driver.OracleDriver";
//        String url = "jdbc:oracle:thin:@oracle11g.czhstbnsibro.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
//
//        Scanner input = new Scanner( System.in );
//        System.out.println( "계정명은 :" );
//        String user = input.nextLine( );
//        System.out.println( "패스워드는 :" );
//        String pass = input.nextLine( );
//        Connection con = null;
//
//        // 1. 드라이버를 메모리 로딩
//        try {
//            Class.forName( driver );
//            con = DriverManager.getConnection( url, user, pass );
//            System.out.println( "연결 성공" );
//
//        } catch (Exception ex) {
//            System.out.println( "연결 실패" + ex.getMessage( ) );
//        }
//
//        // 3. sql 문장 만들기
//        // 4. sql 전송 객체 만들기
//        // 5. 전송하기
//        // 6. 닫기
//        try {
//            int empno = 5678;
//            String ename = "동범갓";
//            int sal = 8000;
//            int deptno = 50;
//            String job = "GROWTH";
//
//            String sql = "UPDATE emp SET ename=?, sal=?, deptno=?, job=?  "
//                    + "  WHERE empno=?";
//            System.out.println( sql );
//
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setString( 1, ename );
//            st.setInt( 2, sal );
//            st.setInt( 3, deptno );
//            st.setString( 4, job );
//            st.setInt( 5, empno );
//
//            int result = st.executeUpdate();    //sql 전송하면 안됨
//
//            st.close( );
//            con.close( );
//            System.out.println( result + "행 sql 전송 성공" );
//
//        } catch (SQLException ex) {
//            System.out.println( "전송 실패" + ex.getMessage( ) );
//        }
//    }
//}
