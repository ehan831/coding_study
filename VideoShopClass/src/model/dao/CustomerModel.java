package model.dao;

import model.CustomerDao;
import model.vo.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerModel implements CustomerDao{

    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@192.168.0.144:1521:orcl";
    String user = "paljo";
    String pass = "1234";
    Connection con = null;

    public CustomerModel() throws Exception{
        // 1. 드라이버로딩
        Class.forName(driver);
    }

    public void insertCustomer(Customer vo) throws Exception{
        // 2. Connection 연결객체 얻어오기
        // 3. sql 문장 만들기
        // 4. sql 전송객체 (PreparedStatement)
        // 5. sql 전송
        // 6. 닫기

        con = DriverManager.getConnection(url, user, pass);
        String sql = "INSERT INTO MEMBER(MEMBERID, NAME, TEL, EXTRA_TEL, ADDRESS, EMAIL) VALUES (member_pk_auto.nextval, ?, ?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, vo.getCustName());
        st.setString(2, vo.getCustTel1());
        st.setString(3, vo.getCustTel2());
        st.setString(4, vo.getCustAddr());
        st.setString(5, vo.getCustEmail());


        int result = st.executeUpdate();

        System.out.println(result+"행 SQL 전송 성공");

        st.close();
        con.close();
    }

    public Customer selectByTel(String tel) throws Exception{
        Customer dao = new Customer();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            //       2. 연결객체 얻어오기
            con = DriverManager.getConnection(url, user, pass);

            //      3. sql 문장 만들기 (*****)
            String sql = "SELECT name, tel, extra_tel, address, email FROM member WHERE TRIM(tel)=?";

            st = con.prepareStatement(sql);
            st.setString(1, tel);
            rs = st.executeQuery();

            //      6. 결과처리
            if(rs.next()) {
                dao.setCustName(rs.getString("name"));
                dao.setCustTel1(rs.getString("tel"));
                dao.setCustTel2(rs.getString("extra_tel"));
                dao.setCustAddr(rs.getString("address"));
                dao.setCustEmail(rs.getString("email"));
            }
            return dao;
        }            // try 쓰고 catch문 없는 이유 : throws로 던짐.
        finally {      // 비정상적 종료가 되더라도 무조건 connection을 닫아줘야 함. -> finally로 수행. 커넥션 닫는 것은 반드시
            //      7. 닫기
            rs.close();
            st.close();
            con.close();
        }



    }


    public int updateCustomer(Customer vo) throws Exception{

        int result = 0;
        Connection con = DriverManager.getConnection(url, user, pass);
        String sql = "UPDATE member SET name=?, extra_tel=?, address=?, email=? WHERE TRIM(tel)=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, vo.getCustName());
        st.setString(2, vo.getCustTel2());
        st.setString(3, vo.getCustAddr());
        st.setString(4, vo.getCustEmail());
        st.setString(5, vo.getCustTel1());

        result = st.executeUpdate();


        st.close();
        con.close();


        return result;
    }
}