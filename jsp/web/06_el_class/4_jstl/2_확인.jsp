
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="member.beans.Member" %>
<html>
<head>
    <title>확인하기</title>
</head>
<body>
1. 자바 객체
<br>

<%
    Member m = new Member();
    m.setName( "홍홍홍" );
    m.setAddr( "하하하한국" );
%>

이름 : <%=m.getName()%> /
주소 : <%=m.getAddr()%>
<br>

<%--이건 안되네--%>
이름 : ${m.name} /
주소 : ${m.addr}
<br>

2. c:set 변수 지정 <br>
<c:set var="m2" value="<%=m%>"></c:set>
이름 : ${m2.name} /
주소 : ${m2.addr}
<br>

</body>
</html>
