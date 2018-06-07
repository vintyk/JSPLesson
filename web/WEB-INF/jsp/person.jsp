<%--
  Created by Ушаков Виталий (Vinty). Skype: vintyk1978
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Person</title>
</head>
<body>
<h1 style="color: #0071bc"> ${requestScope.person.name} ${requestScope.person.family}  ${requestScope.message} </h1>

<form action="${pageContext.request.contextPath}/person" method="post">
    <label for="name">Введите имя</label>
    <input type="text" id="name" name="name2Attr">
    <label for="family">Введите Фамилию</label>
    <input type="text" id="family" name="family2Attr">
    <button type="submit">Отправить</button>
</form>

</body>
</html>
