package model.dao;

import model.VideoDao;
import model.vo.Video;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VideoModel implements VideoDao {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@192.168.0.144:1521:orcl";
    String user = "paljo";
    String pass = "1234";
    Connection con = null;

    public VideoModel() throws Exception {
        // 1. 드라이버로딩
        Class.forName( driver );
    }


    public void insertVideo(Video vo, int count) throws Exception {
        // 2. Connection 연결객체 얻어오기
        con = DriverManager.getConnection( url, user, pass );
        System.out.println( "넘어온  카운트 값 :" + count );
        // 3. sql 문장 만들기
        String sql = "INSERT INTO video(videono, producer, actor, explain, title, jenre) VALUES(video_no_sequence.nextval,?,?,?,?,?)";
        // 4. sql 전송객체 (PreparedStatement)
        PreparedStatement st = null;

        st = con.prepareStatement( sql );
        st.setString( 1, vo.getDirector( ) );
        st.setString( 2, vo.getActor( ) );
        st.setString( 3, vo.getExp( ) );
        st.setString( 4, vo.getVideoName( ) );
        st.setString( 5, vo.getGenre( ) );

//        if (count <= 0) {
//            count = 1;
//        }
        for (int i = 0; i < count; i++) {
            int result = st.executeUpdate( );
            System.out.println( i + "성공" );
        }
        // 5. sql 전송

        // 6. 닫기
        st.close( );
        con.close( );
    }

    public ArrayList searchVideo(int sel, String word) throws Exception {
        String[] cols = {"TITLE", "PRODUCER"};

        // 2. 연결 객체
        con = DriverManager.getConnection( url, user, pass );
        // 3. sql 문장
        String sql = "SELECT videono, title, jenre, producer, actor FROM video " +
                " WHERE " + cols[sel] + " LIKE '%" + word + "%'";
        System.out.println( sql );

        ArrayList list = new ArrayList( );
        // sql 전송 객체
        PreparedStatement st = con.prepareStatement( sql );
        // sql 전송
        ResultSet rs = st.executeQuery( );

        while (rs.next( )) {
            ArrayList data = new ArrayList( );
            data.add( rs.getInt( "videono" ) );
            data.add( rs.getString( "title" ) );
            data.add( rs.getString( "jenre" ) );
            data.add( rs.getString( "producer" ) );
            data.add( rs.getString( "actor" ) );

            list.add( data );
        }
        return list;  // 리턴값, ArrayList
    }

    public Video selectByPk(int vNum) throws Exception {
        Video vo = new Video( );
        con = DriverManager.getConnection( url, user, pass );
        String sql = "SELECT videono, title, jenre, producer, actor, explain FROM video WHERE videono = ?";

        PreparedStatement st = con.prepareStatement( sql );
        st.setInt( 1, vNum );
        ResultSet rs = st.executeQuery( );

        if (rs.next( )) {
            vo.setVideoNo( Integer.parseInt( rs.getString( "videono" ) ) );
            vo.setVideoName( rs.getString( "title" ) );
            vo.setGenre( rs.getString( "jenre" ) );
            vo.setDirector( rs.getString( "producer" ) );
            vo.setActor( rs.getString( "actor" ) );
            vo.setExp( rs.getString( "explain" ) );
        }
        return vo;
    }

}
