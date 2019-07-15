<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//작성 버튼이 눌렸을 대
	$('input[value="작성"]').click(function(){
		// 폼 태그의 action 속성을 'BoardSave.jsp'
		// 폼태그의 submit() 호출
		var frm = $('form[name="frm"]');
		frm.attr('action','BoardSave.jsp');		
		frm.submit();
	});
});

</script>
<title>게시판 글쓰기</title>
</head>
 <body>
	<h4> 게시판 글 쓰기 </h4><br/>
	나중에 이쁘게 만드시오 <br/><br/>
	<form name='frm' method='post' class="form-inline">
	작성자 : <input type='text' name='writerName' class="form-control"><br/><br/>
	제  목 : <input type='text'name='title' class="form-control"><br/><br/>
	내  용 : <textarea name='content' rows='10' cols='40' class="form-control"></textarea><br/><br/>
	패스워드(수정/삭제시 필요) :
			 <input type='password' name='password' class="form-control"><br/><br/>
	<input type='button' class="btn btn-info" value='작성'>
	<input type='reset' class="btn btn-warning" value='취소'>
	</form>

</body>
</html>