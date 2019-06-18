<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="member.beans.*" %>

<!-- 하나씩 천천히 도전합시다 -->

<%--1. 폼의 입력 값을 빈즈의 멤버 변수로 지정--%>
<% request.setCharacterEncoding( "utf-8" ); %>
<jsp:useBean id="mb" class="member.beans.Member">
    <jsp:setProperty name="mb" property="*"></jsp:setProperty>
</jsp:useBean>

<%-- 2. JDBC 연결 --%>
<%
    try {
    MemberDao dao = MemberDao.getInstance();
    dao.insertMember( mb );
    } catch (MemberException e) {
        e.printStackTrace( );
    }

%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> 회원가입 확인 </title>
</head>
<body>
아이디 : <%= mb.getId( ) %> <br>
패스워드 : <%= mb.getPassword( ) %> <br>
이름 : <%= mb.getName( ) %> <br>
전화 : <%= mb.getTel( ) %> <br>
주소 : <%= mb.getAddr( ) %> <br>
</body>
</html>