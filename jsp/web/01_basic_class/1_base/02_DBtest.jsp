<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page errorPage="02_NormalErrorPage.jsp" %>

<%
    // 1. 드라이버 로딩
    String url = "jdbc:oracle:thin:@oracle11g.czhstbnsibro.ap-northeast-2.rds.amazonaws.com:1521:ORCL";

    Connection con = null;

    // 2. 연결객체 얻어오기
    Class.forName( "oracle.jdbc.driver.OracleDriver" );
    con = DriverManager.getConnection( url, "scott", "tiger" );

    // 3. sql 문장 만들기
    String sql = "SELECT * FROM emp";

    // 4. 전송 객체 얻어오기
    // 5. 전송

    PreparedStatement st = con.prepareStatement( sql );
    ResultSet rs = st.executeQuery( ); // sql 지정하면 안됨

%>


<!DOCTYPE html>
<html>
<head><title> 디비 테스트 </title>
</head>
<body>

<div align=center>
    <table border=2 cellSpacing=3>

        <tr class="title">
            <td>사번</td>
            <td>사원명</td>
            <td>업무</td>
            <td>관리자사번</td>
            <td>입사일</td>
        </tr>


        <% while (rs.next( )) { %>
        <tr>
            <td><%= rs.getInt( "EMPNO" ) %></td>
            <td><%= rs.getString( "ENAME" ) %></td>
            <td><%= rs.getString( "JOB" ) %></td>
            <td><%= rs.getString( "MGR" ) %></td>
            <td><%= rs.getString( "HIREDATE" ) %></td>
        </tr>
        <% } %>

    </table>
</div>
</body>
</html>
