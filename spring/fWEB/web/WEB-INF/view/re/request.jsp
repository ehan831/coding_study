<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/WEB-INF/View/re/request.jsp</title>
</head>
<body>
 뷰 페이지 입니다<br/>
 아이디 : ${param.id } <br/>
  이름: ${param.name } <br/>
  나이 : ${param.age} <br/>
 <hr/>
 
 객체명으로 출력<br/>
  아이디 : ${memberVO.id } <br/>
  이름: ${memberVO.name } <br/>
  나이 : ${memberVO.age} <br/>
  <hr/>
  
<!--   변수명 지정하면 객체명으로 접근 불가 -->
  지정 변수명으로 출력<br/>
  아이디 : ${vo.id } <br/>
  이름: ${vo.name } <br/>
  나이 : ${vo.age} <br/>
  <hr/>
</body>
</html>