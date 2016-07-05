<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/login" method="post">
    <p>Логин: <input type="text" name="login"/></p>
    <p>Пароль: <input type="password" name="password"/></p>
    <input type="submit" value="Войти"/>
</form>

<a href="<spring:url value="/registration.html" htmlEscape="true" />"><input type="submit" value="Зарегистрироваться"/></a>
