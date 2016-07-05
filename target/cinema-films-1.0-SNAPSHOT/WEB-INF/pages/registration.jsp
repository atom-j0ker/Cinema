<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <style>
        <%@ include file="/resources/css/cinema.css" %>
    </style>
</head>

<body>
<%--<p><a href="/cinema"><< вернуться</a></p>--%>

<%--<form action="/registration" method="post">--%>
<%----%>
<%--<p>Логин: <input type="text" name="login"/></p>--%>
<%--<p>Пароль: <input type="password" name="password"/></p>--%>
<%--<input type="submit" value="Зарегистрироваться"/>--%>
<%--</form>--%>

<form:form modelAttribute="registration" method="post">
    <table>
        <tr>
            <td><form:label path="username">Name</form:label></td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Зарегистрироваться"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>