<%@ page import="com.itea.cinema.crud.FilmDAO" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.itea.cinema.controllers.FilmController" %>
<%@ page import="com.itea.cinema.model.Film" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование</title>
</head>

<body>
<p><a href="/films"><< вернуться</a></p>

<%
    int filmId = Integer.valueOf(request.getAttribute("filmId").toString());
    FilmDAO filmDAO = WebApplicationContextUtils.getWebApplicationContext(application).getBean(FilmDAO.class);
    Film film = filmDAO.get(filmId);
%>

<form action="/films/edit/${filmId}" method="post">
    Редактирование фильма
    <div>
        Нова назва: <input type="text" name="name" value="<%=film.getName()%>"/>
    </div>
    <div>
        Нова країна: <input type="text" name="country" value="<%=film.getCountry()%>"/>
    </div>
    <div>
        Новий режисер: <input type="text" name="director" value="<%=film.getDirector()%>"/>
    </div>
    <div>
        Новий жанр: <input type="text" name="genre" value="<%=film.getGenre()%>"/>
    </div>
    <div>
        Нова інформація: <input type="text" name="info" value="<%=film.getInfo()%>"/>
    </div>
    <div>
        Нова прем'єра: <input type="text" name="premiere" value="<%=film.getPremiere()%>"/>
    </div>
    <div>
        <p><input type="submit" value="Save changes"/></p>
    </div>
</form>
</body>
</html>
