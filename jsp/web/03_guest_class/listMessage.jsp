<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="guest.model.*,guest.service.*" %>
<%@ page import="java.util.List" %>

<%
    // getTotalCount
    ListMessageService listService = ListMessageService.getInstance( );
    int totalPageCount = listService.getTotalPage();

    // page 번호 받기
    String pNum = request.getParameter( "page" );

    // 전체 메세지 레코드 검색
    List<Message> mList = listService.getMessageList( pNum );



%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> 방명록 목록 </title>
</head>
<body>

<% if (mList.isEmpty( )) { %>
남겨진 메세지가 하나도~~없습니다. <br>
<% } else { %>
<table border="1">

    <% for (Message m : mList) { %>
    <tr>
        <td><%= m.getMessageId( ) %>
        </td>
        <td><%= m.getGuestName( ) %>
        </td>
        <td align="center"><a href="deleteMessage.jsp?id=<%=m.getMessageId()%>" > 삭제하기 </a></td>
    </tr>
    <tr>
        <td colspan='3'>
			<textarea cols=35 rows=3
                      style="font-family: '돋움', '돋움체'; font-size: 10pt; font-style: normal; line-height: normal; color: #003399;background-color:#D4EBFF;"><%= m.getMessage( ) %>
			</textarea>
        </td>
    </tr>
    <% } %>
</table>

<% } // end if-else %>

<a href="insertMessage.jsp">글쓰기</a><br>

<%-- 페이지 번호 출력 --%>
<% for(int i=1; i<=totalPageCount; i++) { %>
<%--숫자에 링크 걸기--%>
<a href="listMessage.jsp?page=<%=i%>">[<%= i %>]</a>
<% } // for end%>

</body>
</html>