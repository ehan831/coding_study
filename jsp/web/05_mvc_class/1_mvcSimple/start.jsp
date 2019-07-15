
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String projectName = "/jsp_war_exploded";
%>

<html>
<head>
    <title>start.jsp // mvc 패턴 이해하기</title>
</head>
<body>
1. 기본 방식으로 연결
<a href="<%=projectName%>/05_mvc_class/1_mvcSimple/simpleView.jsp">기존 방식 요청</a>
<hr/>
2. MVC 방식으로 연결 <br>
<a href="<%=projectName%>/xxxxxx.ksm">MVC 요청</a><br>
<a href="<%=projectName%>/simple?type=first">MVC 요청2</a><br>
<a href="<%=projectName%>/SimpleControl">MVC 요청3</a>
</body>
</html>
