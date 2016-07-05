<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Character[] letters = new Character[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',};
%>
<div class="search_form">
    <form class="search_form_left" action="/searchFilmsByLetter" method="post">

        <%for (int i = 0; i < letters.length; i++) {%>
        <a href="/films" name="letter"><%=letters[i]%>
        </a>
        <%
            }
        %>
    </form>

    <form class="search_form_right" action="/searchFilms" method="post">
        <input class="search_form_string" type="text" name="searchString"/>
        <input class="search_form_button" type="submit" value="Поиск"/>
    </form>

</div>