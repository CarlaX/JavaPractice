<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="rhs" uri="/WEB-INF/responseHeaderTag.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h2>
    <rhs:resTag cacheControl="no-cache" pragma="no-cache" expires="6000">test</rhs:resTag>
</h2>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>