<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Вкинотеатре</title>
    <style>
        <%@ include file="/resources/css/cinema.css" %>
    </style>
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/popup.js" />"></script>
</head>
<body>
<div class="middle">
    <div class="film_image2">
        <p><img class="film_image_param2" src="/resources/image/${film.image}"/></p>
    </div>
    <div class="film_info2">
        <p>Назва: ${film.name}</p>
        <p>
            <c:forEach begin="1" end="${film.rating}">
                *
            </c:forEach>
        </p>
        <p>Країна: ${film.country}</p>
        <p>Режисер: ${film.director}</p>
        <p>Жанр: ${film.genre}</p>
        <p>Інформація: ${film.info}</p>
        <p>Прем'єра: ${film.premiere}</p>
        <hr>
        <input id="button" type="submit" value="Посмотреть сеансы"/>
    </div>
    <div id="popupContact">
        <a id="popupContactClose">×</a>
        <h1>
            Выберите сеанс:
            <select id="seancesComboBoxId" name="seancesComboBoxName">
                <c:forEach items="${seances}" var="seance">
                    <option value="${seance.id}">${seance.date}, ${seance.time}</option>
                </c:forEach>
            </select>
        </h1>
        <script type="text/javascript">
            $("#seancesComboBoxId").change(function(){
                var x=$(this).val();
                alert(x);
            });
        </script>
        Зал:

        <p id="contactArea">

        </p>
    </div>
    <div id="backgroundPopup"></div>

</div>
</body>
</html>
