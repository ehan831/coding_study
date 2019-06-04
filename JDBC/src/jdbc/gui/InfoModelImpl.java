package jdbc.gui;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InfoModelImpl {
    private String url = "jdbc:oracle:thin:@oracle11g.czhstbnsibro.ap-northeast-2.rds.amazonaws.com:1521:ORCL";
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private Connection con;
    private String user, pass;
    public static void main(String[] args) {

    }



    InfoModelImpl() throws Exception {
        Scanner input = new Scanner( System.in );

        System.out.println( "계정명은 :" );
        user = input.nextLine( );

        System.out.println( "패스워드는 :" );
        pass = input.nextLine( );

        /* 1. 드라이버를 메모리 로딩 */
        Class.forName( driver );

        /* 2. 연결 객체 얻어오기 */
    }

    void insert(InfoVO vo) throws SQLException {
        con = DriverManager.getConnection( url, user, pass );

//        3. sql 문장 만들기
        String sql = "INSERT INTO temp(name, id, tel, sex, age, home) VALUES(?,?,?,?,?,?)";
        System.out.println( sql );
//        4. sql 전송 객체 얻어오기 // prepared statement
        PreparedStatement st = con.prepareStatement( sql );
        st.setString( 1, vo.name );
        st.setString( 2, vo.id );
        st.setString( 3, vo.tel );
        st.setString( 4, vo.gender );
        st.setInt( 5, vo.age );
        st.setString( 6, vo.home );


//        5. sql 전송 insert/delete/update (DDL) : int excuteUpdate() 
        int result = st.executeUpdate( );

//        6. 결과처리
        System.out.println( result + "성공" );

//        7. 닫기
        st.close( );
        con.close( );
    }

    ArrayList<InfoVO> selectAllData() throws SQLException {
        con = DriverManager.getConnection( url, user, pass );

        String sql;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            sql = "SELECT * FROM temp";
            st = con.prepareStatement( sql );
            rs = st.executeQuery( );

            ArrayList<InfoVO> list = new ArrayList<>( );

            while (rs.next( )) {
                InfoVO vo = new InfoVO( );
                vo.setName( rs.getString( "name" ) );
                vo.setId( rs.getString( "id" ) );
                vo.setTel( rs.getString( "tel" ) );
                vo.setGender( rs.getString( "sex" ) );
                vo.setAge( rs.getInt( "age" ) );
                vo.setHome( rs.getString( "home" ) );
                list.add( vo );
            }
            return list;
        } finally {
            rs.close( );
            st.close( );
            con.close( );
        }
    }

    InfoVO selectByTel(String tel) throws SQLException {
        con = DriverManager.getConnection( url, user, pass );

        String sql;
        PreparedStatement st = null;
        ResultSet rs = null;
       try {
           sql = "SELECT * FROM temp WHERE tel=?";
           st = con.prepareStatement( sql );
           st.setString( 1, tel );

           rs = st.executeQuery( );
           InfoVO vo = new InfoVO( );

           if (rs.next( )) {
               vo.setName( rs.getString( "name" ) );
               vo.setId( rs.getString( "id" ) );
               vo.setTel( rs.getString( "tel" ) );
               vo.setGender( rs.getString( "sex" ) );
               vo.setAge( rs.getInt( "age" ) );
               vo.setHome( rs.getString( "home" ) );
           }
           return vo;
       }finally {
           rs.close();
           st.close();
           con.close();
       }
    }

    InfoVO selectById(String id) throws SQLException{
        con = DriverManager.getConnection( url, user, pass );

        String sql;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            sql = "SELECT * FROM temp WHERE id=?";
            st = con.prepareStatement( sql );
            st.setString( 1, id );

            rs = st.executeQuery( );
            InfoVO vo = new InfoVO( );

            if (rs.next( )) {
                vo.setName( rs.getString( "name" ) );
                vo.setId( rs.getString( "id" ) );
                vo.setTel( rs.getString( "tel" ) );
                vo.setGender( rs.getString( "sex" ) );
                vo.setAge( rs.getInt( "age" ) );
                vo.setHome( rs.getString( "home" ) );
            }
            return vo;
        }finally {
            rs.close();
            st.close();
            con.close();
        }

    }

    public void modifyData(InfoVO vo) throws SQLException{
        con = DriverManager.getConnection( url, user, pass );

        String sql = "UPDATE temp SET name=?,id=?,tel=?,sex=?,age=?,home=? WHERE tel=?";
        System.out.println( sql );
        PreparedStatement st = con.prepareStatement( sql );
        st.setString( 1, vo.name );
        st.setString( 2, vo.id );
        st.setString( 3, vo.tel );
        st.setString( 4, vo.gender);
        st.setInt( 5, vo.age);
        st.setString( 6, vo.home );
        st.setString( 7, vo.tel );

        int result = st.executeUpdate();
        System.out.println( result + "업데이트 성공" );
        st.close();
        con.close();
    }

    public void deleteData(String tel) throws Exception{
        con = DriverManager.getConnection( url, user, pass );

        String sql = "DELETE temp WHERE tel=?";
        System.out.println( sql );
        PreparedStatement st = con.prepareStatement( sql );
        st.setString( 1, tel );

        int result = st.executeUpdate();
        System.out.println(result + "삭제 성공" );
        st.close();
        con.close();
    }
}

