<%--
  Created by IntelliJ IDEA.
  User: eunguhan
  Date: 2019-06-14
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%
    request.setCharacterEncoding( "utf-8" );
    String name = request.getParameter( "name" );
    String gender = request.getParameter( "gender" );
    String job = request.getParameter( "occupation" );
    String[] hobby = request.getParameterValues( "hobby" );
    String hobbyStr = "";
    if (hobby != null) {

        for (String h : hobby) {
            hobbyStr += h + "/";
        }
    }
%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>02_second.jsp</title>
</head>
<body>


이름은 : <%= name %>  <br>
성별은 : <%= gender %>  <br>
직업은 : <%= job %>  <br>
취미는 : <%= hobbyStr %>  <br>


</body>
</html>