<%@ page contentType="text/xml; charset=utf-8" %>
<%@ page language="java" import="java.sql.*"%>

<%
String driver="oracle.jdbc.driver.OracleDriver";
String user="teamsix";
String pass="1234";
String dbURL="jdbc:oracle:thin:@192.168.0.170:1521:orcl";


	Class.forName(driver);
	Connection connection=DriverManager.getConnection(dbURL,user,pass);
	
	String sql = "select * from member where name='" + request.getParameter("userId")+"'";
	System.out.println(sql);
	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	String result="NO";
	if (rs.next()){		
		result = "YES";
	}		
	out.print(result);
%>

