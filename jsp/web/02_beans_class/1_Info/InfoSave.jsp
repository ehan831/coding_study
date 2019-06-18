<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>

 <%@page import="info.beans.infoBeans" %>
<%-- 요런 방법 있음 --%>
<%-- <% --%>
<%--	infoBeans bean = new infoBeans(  );--%>
<%--	String name = request.getParameter( "name" );--%>
<%--	String id = request.getParameter( "id" );--%>
<%--	--%>
<%--	bean.setName( name );--%>
<%--	bean.setId( id );--%>
<%-- %> --%>

<jsp:useBean id="bean" class="info.beans.infoBeans">
	<jsp:setProperty name="bean" property="*"></jsp:setProperty>
</jsp:useBean>


<!DOCTYPE html>
<html>
<body>
	<h2>  당신의 신상명세서 확인 </h2>
	이   름  : <%= bean.getName() %>><br/>
	주민번호 : <jsp:getProperty name="bean" property="id"/><br/>
	성  별   : <%= bean.getGender() %>/><br/>
	맞습니까????
</body>
</html>