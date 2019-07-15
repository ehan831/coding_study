<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>


<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="info" class="info.beans.InfoBeans">
	<jsp:setProperty name="info" property="name" />
  <jsp:setProperty name="info" property="id" />
</jsp:useBean>

<!DOCTYPE html>
<HTML>
<HEAD><TITLE> 자료 출력 </TITLE></HEAD>
<BODY>
	<H2>  당신의 신상명세서 확인 </H2>
<%--		변수를 부르는 것이 아니고, getter 를 불러오는 것 --%>
	이   름  : ${info.name}<br/>
	주민번호 : ${info.id}<br/>
	성  별   : ${info.gender}<br/>
	맞습니까????
</BODY>
</HTML>