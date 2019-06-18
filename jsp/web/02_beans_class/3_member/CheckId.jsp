<%@ page import="member.beans.MemberDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String id = request.getParameter( "userId" );
    Boolean flag = MemberDao.getInstance( ).isDuplicatedId( id );
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> 아이디 중복 확인 </title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                opener.frm.id.value = document.frm.userId.value;
                // var inputId = document.getElementById("userId").val;
                // opener.getElementById("#id").val(inputId);
                // opener.$('input[name="id"]').val($('input[name="userId"]').val());
                window.close();
            });
        });
    </script>
</head>
<body>
<%
    if (flag == true) {
%>
사용중인 아이디가 있습니다. 다시 입력하여 주십시오.
<% } else { %>
사용할 수 있는 아이디입니다.
<% } %>
<br>
<br>
<%-- action 을 값을 입력하지 않으면, 디폴트 = 지금 화면 다시 열기 --%>
<form id="frm" name="frm" action="">
    <input type="text" name="userId" id="userId" value="<%= id %>">
    <input type="submit" value="중복확인">
    <input type="button" name="btn" id="btn" value="아이디사용">
</form>
</body>
</html>