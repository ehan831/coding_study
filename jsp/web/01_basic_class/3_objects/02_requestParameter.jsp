<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>

<%
    //	한글이 깨질 수도 있다. 캐릭터 인코딩 하기
    request.setCharacterEncoding( "utf-8" );
// 폼의 입력값을 얻어오기
    String name = request.getParameter( "name" );
    String address = request.getParameter( "address" );
    String[] pet = request.getParameterValues( "pet" );
    String petStr = "";
    if (pet != null) {

        for (String p : pet) {
            petStr += p + "/";
        }
    }
%>
<!DOCTYPE html>
<html>
<head><title>요청 파라미터 출력</title></head>
<body>
<h5> 1. 이전 화면에서 사용자의 입력값을 출력 </h5>
<%-- 얻어온 입력 값을 출력 하기 --%>
이름은 : <%= name %> <br>
주소는 : <%= address %> <br>
동물은 : <%= petStr %> <br>

<h5> 방법 2 </h5>


<h5> 방법 3 </h5>


</body>
</html>
