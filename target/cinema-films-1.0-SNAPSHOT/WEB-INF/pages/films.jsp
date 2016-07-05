<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<%
    request.getSession(true);

    if (session.isNew()) {
        session.setAttribute("adminIn", false);
        session.setAttribute("userIn", false);
    }

%>

<%
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username;

    if (principal instanceof UserDetails) {
        username = ((UserDetails) principal).getUsername();
    } else {
        username = principal.toString();
    }
%>


<div class="middle">

    <div class="film_add">

        <%
            if (username.equals("admin")) {
        %>
        <a href="<spring:url value="/films/add.html" htmlEscape="true" />">
            <input class="film_add_btn" type="submit" value="Добавить фильм"/>
        </a>
        <%
            }
        %>

    </div>

    <table class="films">
        <% int count = 0;%>
        <c:forEach items="${films}" var="film">
            <% if (count % 4 == 0) { %>
            <tr></tr>
            <% } %>
            <td>
                    <a href="<spring:url value="/film/{filmId}" htmlEscape="true">
                    <spring:param name="filmId" value="${film.id}"/></spring:url>">
                        <img class="film_image" src="/resources/image/${film.image}"/>
            </td>
            <% count++; %>
        </c:forEach>
    </table>
</div>

<hr>

<%
    if (username.equals("admin")) {
%>
<c:forEach items="${films}" var="film">
    <div class="film_image_admin">
        <p><img class="film_image_param" src="/resources/image/${film.image}"/></p>
    </div>
    <div class="film_info">

        <p>
            <a href="<spring:url value="/films/seances/{filmId}" htmlEscape="true"><spring:param name="filmId" value="${film.id}"/></spring:url>">Назва: ${film.name} </a>
            <c:forEach begin="1" end="${film.rating}">
                *
            </c:forEach>
        </p>
        <p>Країна: ${film.country}</p>
        <p>Режисер: ${film.director}</p>
        <p>Жанр: ${film.genre}</p>
        <p>Інформація: ${film.info}</p>
        <p>Прем'єра: ${film.premiere}</p>

        <a href="<spring:url value="/films/edit/{filmId}" htmlEscape="true"><spring:param name="filmId" value="${film.id}"/></spring:url>">
            <input type="submit" value="Редактировать"/>
        </a>
        <form:form action="/films/${film.id}">
            <input type="submit" value="Удалить">
        </form:form>

    </div>
    <p>
    <hr>
    </p>
</c:forEach>
<%
    }
%>

</div>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
