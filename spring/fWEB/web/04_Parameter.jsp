<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_Parameter.jsp</title>
</head>
<body>
<h2>파라메터 연습</h2>

<a href="param.do?id=hong&age=30">파라메터 요청</a>

<h2> 폼 파라메터 연습 - 로그인 </h2>
<form action="paramForm.do" method="post">
	id : <input type="text" name="id"> <br>
	name : <input type="text" name="name"> <br>


</form>
</body>
</html>