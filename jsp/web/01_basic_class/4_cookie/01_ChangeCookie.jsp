<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.CookieHandler" %>

<html>
<head><title>쿠키</title></head>
<body>	

<b>Simple Cookie Example</b><hr>

<%	
// 1. 클라이언트로부터 Cookie를 얻어옴

// 2. 쿠키 이름 중에 "yourid"가 있는지 검색
    // 1,2 번은 get 쿠키 파일 참조

// 3. 해당하는 쿠키가 있다면 그 이름과 새 값으로 새 쿠키를 만들고 전송 // 덮어쓰기
    Cookie c = new Cookie( "yourId", "1212" );
    response.addCookie( c );
%>


<br><a href="01_GetCookie.jsp"> 쿠키검색 </a>

</body></html>