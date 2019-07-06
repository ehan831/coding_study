<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_requestMapping.jsp</title>
</head>
<body>
<h3>요청확인</h3>
<a href='re/a.do'>요청1</a><br/>
<a href='re/b.do'>요청2</a><br/>
<a href='re/c.do?id=hong'>요청3</a><br/>
<a href='re/c.do'>요청4</a><br/>
<hr/>

<h3> 폼의 데이터 </h3>
<form action='re/request.do' method='post'>
	id : <input type='text' name="id"><br/>
	name : <input type='text' name='name'><br/>
	age : <input type='text' name='age'><br/>
	<input type='submit' value='전송'/>
</form>

</body>
</html>