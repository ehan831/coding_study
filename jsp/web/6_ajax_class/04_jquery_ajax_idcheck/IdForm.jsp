<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> 아이디 중복 검사 </title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".userinput").keyup(function () {
        // $("#id_check").click(function () {
            $.ajax({
                type: "get",
                url: "IdCheck.jsp",
                data: {
                    userId : $("input[name='id']").val()
                },
                dataType: "text",
                success : function (data) {
                    // alert("ok" + data);
                    if(data.trim() == 'YES') {
                        $("#idmessage").text("사용 중인 아이디");
                        $("#idmessage").show();
                    }else {
                        $("#idmessage").text("사용 가능한 아이디");
                        $("#idmessage").show();
                    }
                },
                error : function (e) {
                    alert("에러발생" + e);
                }
            }); // ajax end
        }); // click end
    });
</script>

</head>
<body>

<input name="id" type="text" class="userinput" size="15" />
<button type="button" id="id_check">중복체크</button><br/><br/>
<div id="idmessage" style="display:none;"></div>

</body>
</html>