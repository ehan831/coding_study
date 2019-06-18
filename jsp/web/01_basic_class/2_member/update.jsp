<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: eunguhan
  Date: 2019-06-14
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setCharacterEncoding( "utf-8" );
    String name = request.getParameter( "name" );
    String email = request.getParameter( "email" );
    String website = request.getParameter( "website" );
    String password = request.getParameter( "password" );
%>

<%
    // 1. 드라이버 로딩
    String url = "jdbc:oracle:thin:@192.168.0.170:1521:orcl";

    Connection con = null;

    // 2. 연결객체 얻어오기
    Class.forName( "oracle.jdbc.driver.OracleDriver" );
    con = DriverManager.getConnection( url, "teamsix", "1234" );

    // 3. sql 문장 만들기
    String sql = "UPDATE MEMBER SET name = ?, weburl = ?, password =? WHERE email = ?";

    // 4. 전송 객체 얻어오기
    // 5. 전송

    PreparedStatement st = con.prepareStatement( sql );
    st.setString( 1, name );
    st.setString( 2, website );
    st.setString( 3, password );
    st.setString( 4, email );

    st.executeUpdate( );
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>update.jsp</title>
</head>
<body>
<h2> 수정되었습니다. </h2>
<form action="update.jsp" method="post">
    <div>
        <label for="name"> 이름은 : </label>
        <input name="name" id="name" type="text" value="<%= name %>"/>
    </div>
    <div>
        <label for="email"> 이메일은 : </label>
        <input name="email" id="email" type="text" value="<%= email %>" readonly/>
    </div>
    <div>
        <label for="website"> 웹사이트는 : </label>
        <input name="website" id="website" type="text" value="<%= website %>"/>
    </div>
    <div>
        <label for="password"> 암호는 : </label>
        <input name="password" id="password" type="text" value="<%= password %>"/>
    </div>
    <input type="button" value="닫기" onclick="window.close()" />
</form>
</body>
</html>
