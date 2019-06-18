<%--
  Created by IntelliJ IDEA.
  User: eunguhan
  Date: 2019-06-14
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String msg = "오늘은 금요일인데!!";
%>
<%!
    String name = "홍길동";
%>

<html>
<head>
    <title>0_basic.jsp</title>
</head>
<body>

<% if (name.equals( "홍길동" )) { %>
이름 : <%= name %>
<% } else { %>
오늘 : <%= msg %>
<% } %>

</body>
</html>
