<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title> 고객관리 프로그램 </title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#button").click( function () {
                $.ajax({
                    type: 'get',
                    url: 'DataInput.jsp',
                    data: {
                        name: $("#name").val(),
                        age: $("#age").val(),
                        tel: $("#tel").val(),
                        addr: $("#addr").val()
                    },
                    success: function () {
                        alert("ok");
                    },
                    error: function (e) {
                        alert("error" + e);
                    }
                })
            }) // b click end

            $("#button2").click(function () {
                $.ajax({
                    type: 'get',
                    url: 'DataSelect.jsp',
                    dataType: 'xml',
                    success: function (rtn_xml) {
                        var person = $(rtn_xml).find("person");
                        // var person_count = $(person).length;

                        $(person).each(function () {
                            var pName = $(this).find("name").text();
                            var pAge = $(this).find("age").text();
                            var pTel = $(this).find("tel").text();
                            var pAddr = $(this).find("addr").text();

                            var table="";
                            table += "<tr>";
                            table += "<td>" + pName + "</td>";
                            table += "<td>" + pAge + "</td>";
                            table += "<td>" + pTel + "</td>";
                            table += "<td>" + pAddr + "</td>";
                            table += "</tr>";

                            $("#listTable").append(table);
                        }) // each end
                    },
                    error: function (e) {
                        alert("select error" + e);
                    }
                })
            }) // b2 click end
        }) // f end

    </script>

</head>


<!-- <body> -->
<body>

<h2> 고객정보 입력 </h2>

<form name="inForm" method="post">
    <table border=1>
        <tr>
            <td width="80" align="center">Name</td>
            <td width="50" align="center">Age</td>
            <td width="100" align="center">Tel</td>
            <td width="250" align="center">Addr</td>
        </tr>
        <tr>
            <td align="center"><input type="text" size="8" name="name" id="name"></td>
            <td align="center"><input type="text" size="4" name="age" id="age"></td>
            <td align="center"><input type="text" size="12" name="tel" id="tel"></td>
            <td align="center"><input type="text" size="30" name="addr" id="addr"></td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <input id="button" type="button" value="입력">
            </td>
        </tr>
    </table>

    <br>
    <hr>

    <h2> 고객정보 목록보기 </h2>
    <table border='0' width="510">
        <tr>
            <td align="right"><input id="button2" type="button" value="가져오기"></td>
        </tr>
    </table>
    <table border=1 id="listTable">
        <tr>
            <td width="80" align="center">Name</td>
            <td width="50" align="center">Age</td>
            <td width="100" align="center">Tel</td>
            <td width="250" align="center">Addr</td>
        </tr>
    </table>
    <div id="myDiv"></div>

</form>
</body>
</html>