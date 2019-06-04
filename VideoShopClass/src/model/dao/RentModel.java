package model.dao;

import model.RentDao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class RentModel implements RentDao {

    String url = "jdbc:oracle:thin:@192.168.0.144:1521:orcl";
    String user = "paljo";
    String pass = "1234";
    Connection con = null;

    public RentModel() throws Exception {
        // 1. 드라이버로딩
        OracleCon.getInstance();
    }

    // 대여 매소드
    public void rentVideo(String tel, String vnum) throws Exception {
        con = DriverManager.getConnection( url, user, pass );    // 연결 객체
        System.out.println( tel + "//" + vnum );    // 넘어온 값 확인
        if (vnum.equals("") || tel.equals( "" )) {
            JOptionPane.showMessageDialog( null, "전화번호와 비디오번호를 입력해주세요" );
        }else {
            String sql = "INSERT INTO borrow(borrowno, borrowdate, tel, videono) VALUES (borrow_no_sq.nextval, sysdate,?,?)";    // sql 문장
            System.out.println( sql );     // 확인용

            PreparedStatement st = con.prepareStatement( sql );    // 전송객체
            st.setString( 1, tel );
            st.setString( 2, vnum );


            int result = st.executeUpdate( );        // 전송
            System.out.println( result + " 성공" );

            st.close( );        // 닫기
            con.close( );
        }
    }

    // 반납 메소드
    public String returnVideo(String vnum) throws Exception {
        con = DriverManager.getConnection( url, user, pass );    // 연결 객체
        System.out.println( vnum );    // 넘어온 값 확인
        String sql = "UPDATE borrow SET returnstatus = '반납완료'  WHERE VIDEONO = ?";    // sql 문장
        System.out.println( sql );     // 확인용

        PreparedStatement st = con.prepareStatement( sql );    // 전송객체
        st.setString( 1, vnum );

        int result = st.executeUpdate( );        // 전송
        System.out.println( result + " 성공" );

        st.close( );        // 닫기
        con.close( );

        return vnum;
    }

    // 대여 중인 비디오 검색 메소드
    public ArrayList selectList() throws Exception {
        con = DriverManager.getConnection( url, user, pass );
        String sql = "SELECT b.VIDEONO, v.TITLE, m.NAME, m.TEL, TO_CHAR((b.BORROWDATE + INTERVAL '3' DAY), 'YYYY-MM-DD') AS RETURNDATE, b.RETURNSTATUS\n" +
                "       FROM BORROW b\n" +
                "          JOIN MEMBER m ON b.TEL = m.TEL\n" +
                "          JOIN VIDEO v ON b.VIDEONO = v.VIDEONO\n" +
                "WHERE b.RETURNSTATUS = '대여중' \n" +
                "ORDER BY 5 DESC";
        System.out.println( sql );

        ArrayList list = new ArrayList( );
        PreparedStatement st = con.prepareStatement( sql );

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            ArrayList data = new ArrayList(  );
            data.add(rs.getString( "VIDEONO" ));
            data.add(rs.getString( "TITLE" ));
            data.add(rs.getString( "NAME" ));
            data.add(rs.getString( "TEL" ));
            data.add(rs.getString( "RETURNDATE" ));
            data.add(rs.getString( "RETURNSTATUS" ));

            list.add(data);
        }
        return list;
    }
}
