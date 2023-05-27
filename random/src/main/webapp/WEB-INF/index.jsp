<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>You have generated a word <c:out value="${number}"/> times</p>
<p><c:out value="${word}"/></p>
<a href="/random">Generate</a>
<p>the last time you generated a word was:</p>
<c:out value="${fecha}"/>
</body>
</html>