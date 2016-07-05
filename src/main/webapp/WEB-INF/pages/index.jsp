<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Вкинотеатре</title>
    <style>
        <%@ include file="/resources/css/cinema.css" %>
    </style>
</head>
<body>
<div class="top">
    <jsp:include page="fragments/header.jsp"/>
    <div class="registration">
        <jsp:include page="fragments/authorization.jsp"/>

    </div>
</div>
<hr>

<table class="index_buttons">
    <tr>
        <td><a href="/films">
            <button class="index_btn">Фильмы</button>
        </a>
        </td>
        <td><a href="/about">
            <button class="index_btn">Про кинотеатр</button>
        </a>
        </td>
        <td>
            <button class="index_btn">Что-то еще</button>
        </td>
        <td>
            <button class="index_btn">И еще...</button>
        </td>
    </tr>
</table>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
