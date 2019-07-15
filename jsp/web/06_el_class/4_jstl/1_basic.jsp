<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>JSTL 연습</title>
</head>
<body>
<%--변수선언--%>

<c:set var="gender" value="male" />

<%--조건문--%>

<c:if test="${gender == 'male'}">당신은 남자 입니다.</c:if>
<c:if test="${gender == 'female'}">당신은 여자 입니다.</c:if>

<%--변수 선언 나이--%>

<c:set var="age" value="25"></c:set>
<c:choose>
<c:when test="${age le '10'}">어린이입니다.</c:when>
<c:when test="${age gt '10' and age lt '20'}">청소년입니다.</c:when>
<c:otherwise>성인입니다.</c:otherwise>
</c:choose>
<br>

<c:set var="sum" value="0"/>
<c:forEach var="i" begin="1" end="100">
    <c:set var="sum" value="${sum+i}"/>
</c:forEach>
1 ~ 100 까지의 합 : ${sum}
<br>

<c:forEach var="i" begin="1" end="100">
    <c:if test="${i%2 == 0}"><c:set var="even" value="${even+i}"></c:set></c:if>
    <c:if test="${i%2 == 1}"><c:set var="odd" value="${odd+i}"></c:set></c:if>
</c:forEach>
짝수의 합 : ${even}
짝수의 합 : ${odd}
<br>


</body>
</html>
