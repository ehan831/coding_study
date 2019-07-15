<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="sp"></fmt:setLocale>
<fmt:bundle basename="resource.message">
<fmt:message key="TITLE" var="title"></fmt:message>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<h1><fmt:message key="GREETING"></fmt:message></h1>

</body>
</html>
</fmt:bundle>