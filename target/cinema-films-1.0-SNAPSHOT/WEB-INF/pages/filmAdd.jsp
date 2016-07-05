<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление</title>
</head>

<body>
<p><a href="/films"><< вернуться</a></p>

<form:form modelAttribute="filmAdd" method="post">
    <table>
        <tr>
            Добавление фильма
        </tr>
        <tr>
            <td><form:label path="name">Назва: </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="country">Країна: </form:label></td>
            <td><form:input path="country"/></td>
        </tr>
        <tr>
            <td><form:label path="director">Режисер: </form:label></td>
            <td><form:input path="director"/></td>
        </tr>
        <tr>
            <td><form:label path="genre">Жанр: </form:label></td>
            <td><form:input path="genre"/></td>
        </tr>
        <tr>
            <td><form:label path="info">Інфо: </form:label></td>
            <td><form:input path="info"/></td>
        </tr>
        <tr>
            <td><form:label path="premiere">Прем'єра: </form:label></td>
            <td><form:input path="premiere"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Добавить"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
