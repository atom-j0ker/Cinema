<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Сеансы</title>
        <style>
            <%@ include file="/resources/css/cinema.css"%>
        </style>
    </head>
</head>

<body>
<p><a href="/films"><< вернуться</a></p>
<form action="/films">
    <c:forEach items="${seances}" var="seance">
        <p>
                ${seance.date}; ${seance.time}
            <input type="submit" value="Забронировать билет"/>
        </p>
    </c:forEach>
</form>
</body>
</html>
