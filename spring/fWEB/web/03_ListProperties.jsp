<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_ListProperties.jsp</title>
</head>
<body>
	<form action="multiInsert.do" method="post">
		<table width="600">
			<tr>
				<td width="50">선택</td>
				<td width="100">아이디</td>
				<td width="250">이름</td>
				<td width="200">나이</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="list[0].state"></td>
				<td><input type="text" name="list[0].id"></td>
				<td><input type="text" name="list[0].name"></td>
				<td><input type="text" name="list[0].age"></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="list[1].state"></td>
				<td><input type="text" name="list[1].id"></td>
				<td><input type="text" name="list[1].name"></td>
				<td><input type="text" name="list[1].age"></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="list[2].state"></td>
				<td><input type="text" name="list[2].id"></td>
				<td><input type="text" name="list[2].name"></td>
				<td><input type="text" name="list[2].age"></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>