<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String id = request.getParameter( "id" );
%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> 방명록 삭제 </title>
</head>
<body>
메세지를 삭제하려면 암호를 입력하세요. <br/><br/>
<%-- get 으로 확인하고 잘되면 post 로 암호화 하기 --%>
<form action="deleteConfirm.jsp" method="get">
    암호 : <input type="password" name="password"/>
    <input type="hidden" name="messageId" value="<%= id %>" />
    <input type="submit" value="메세지 삭제"/>
</form>
</body>
</html>