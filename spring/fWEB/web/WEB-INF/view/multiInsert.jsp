<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>multiInsert.jsp</title>
</head>
<body>

<h3> 멤버 리스트 </h3>
<table border="1">
    <tr>
        <td>아이디</td>
        <td>이름</td>
        <td>나이</td>
    </tr>
    <c:forEach var="aa" items="${memberVOList.list}">
        <tr>
            <td>${aa.id}</td>
            <td>${aa.name}</td>
            <td>${aa.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
