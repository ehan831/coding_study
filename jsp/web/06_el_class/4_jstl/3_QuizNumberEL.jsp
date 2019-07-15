<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!-- 0. JSTL 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>1~100까지 중 숫자 맞추기</title>
</head>
<body>

<% // 1. 이전화면 값 얻어와 guess 변수에 지정     %>
<c:set var='guess' value='${param.guess}'/>

<% // 2. 그 값이 없다면 임의의 수를 만들어 세션에 지정
    if (session.getAttribute( "answer" ) == null) {
        session.setAttribute( "answer", (int) (Math.random( ) * 99) + 1 );
    }
%>

<% // 3. 세션의 값을 가져와 answer 변수에 지정     %>
<c:set var="answer" value="${sessionScope.answer}"/>


<% // 4. guess의 변수에 값이 있다면
    // (1) guess와 answer값이 같다면 맞춰다고 출력
    // (2) 다르다면 guess값이 answer값보다 크면 크다고 출력 작으면 작다고 출력 %>

<c:choose>
    <c:when test="${guess eq answer}">
        <h1 align="center">축하합니다!
            <b>${sessionScope.answer}</b><br/> 정답입니다!</h1><br/>
        <c:remove var="answer"/>
    </c:when>
    <c:when test="${(guess ge 0) and (guess lt answer)}"><h2 align="center" style="color:blue">HIGHER!</h2></c:when>
    <c:when test="${(guess gt answer) and (guess le 100)}"><h2 align="center" style="color:red">LOWER!</h2></c:when>
    <c:otherwise><h2>뭔가 잘못 도었습니다.. 다시 도전하세요!</h2></c:otherwise>
</c:choose>

<br/>
<br/>

guess:${guess} // answer:${answer}
<hr>
<hr>
1부터 100까지 수 중에서 하나를 잘 찍으시오~!!
<br/>

<form method='get' action='3_QuizNumberEL.jsp'>
    어떤 수일까요? <input type='text' name='guess'> <input type='submit'
                                                     value="Submit">
</form>
</body>
</html>