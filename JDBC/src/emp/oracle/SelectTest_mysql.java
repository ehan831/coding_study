//package emp.oracle;
//
//import java.sql.PreparedStatement;
//
//public class SelectTest_mysql {
//    public static void main(String[] args) {
//        connect_db.main(  );
//
//        // 3. sql 문장 만들기
//        // 4. sql 전송 객체 만들기
//        // 5. 전송하기
//        // 6. 닫기
//        try {
//            int empno = 5670;
//            String ename = "동범짱";
//            int sal = 8000;
//            int deptno = 40;
//            String job = "IT";
//
////            String sql = "INSERT INTO emp(empno, ename, sal, deptno, job)  "
////                    + "  VALUES(" + empno + ", '" + ename + "', " + sal + ", " + deptno + ", '" + job + "' )";
////            System.out.println( sql );
////
////            Statement st = con.createStatement( );
////            int result = st.executeUpdate( sql );
//
//            String sql = "INSERT INTO emp(empno, ename, sal, deptno, job)  "
//                    + "  VALUES(?,?,?,?,?)";
//            System.out.println( sql );
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setInt( 1, empno );
//            st.setString( 2, ename );
//            st.setInt( 3, sal );
//            st.setInt( 4, deptno );
//            st.setString( 5, job );
//
//
//            st.close( );
//            con.close( );
//
//        } catch (SQLException ex) {
//            System.out.println( "전송 실패" + ex.getMessage( ) );
//        }
//    }
//}
