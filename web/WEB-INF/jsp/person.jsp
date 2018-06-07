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
<h1 style="color: #0071bc"> ${requestScope.person.name} ${requestScope.person.family} ${requestScope.message} </h1>

<form action="${pageContext.request.contextPath}/person" method="post">
    <label for="name">Введите имя</label>
    <input type="text" id="name" name="name2Attr">
    <label for="family">Введите Фамилию</label>
    <input type="text" id="family" name="family2Attr">
    <button type="submit">Отправить</button>
</form>
<p>----- Через переменную persons в которой коллекция объектов Person -----</p>
<c:if test="${not empty requestScope.persons}">
    <p>1) ${requestScope.persons.get(0).name}</p>
    <p>2) ${requestScope.persons.get(0).getName()}</p>
    <p>3) ${requestScope.persons}</p>
    <p>4) Имя: ${requestScope.persons.get(1).name}, Фамилия: ${requestScope.persons.get(1).family}</p>
</c:if>
<c:if test="${not empty requestScope.persons}">
    <p>---------------------- а теперь через цикл ---------------------</p>
    <%--что бы пронумеровать строки автоматически - завел переменную count--%>
    <c:set var="count" value="0" scope="request"/>
    <%--запускаем цикл по коллекции persons (в сервлете мы его туда положили с помощью setAttribute)--%>
    <%--каждый элемент коллекции назовем, например - myPerson--%>
    <%--foreach пройдет сам по всем элементам и с каждым сделает какую-то логику--%>
    <%--в нашем случае - логика - это что-то вывести на экран--%>
    <c:forEach var="myPerson" items="${requestScope.persons}">
        <%--увеличиваю переменную count на 1, что бы потом вставить число вначале строки, пронумеровав ее.--%>
        <c:set var="count" value="${count+1}"/>
        <p>${count} - Имя: ${myPerson.name}, Фамилия: ${myPerson.family}</p>
    </c:forEach>
</c:if>
</body>
</html>
