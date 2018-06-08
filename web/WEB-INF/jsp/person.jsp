<%--
  Created by Ушаков Виталий (Vinty). Skype: vintyk1978
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/uswds.css" type="text/css">
    <script src="${pageContext.request.contextPath}/js/uswds.js"></script>
    <title>Person</title>
</head>
<body>
<div class="preview preview-no_border grid-example grid-text">
    <div class="usa-grid">
        <div class="usa-width-one-half">
            <h3>One Half</h3>
            <h1>${requestScope.mega}</h1>


            <h1 style="color: #0071bc"> ${requestScope.person.name} ${requestScope.person.family} ${requestScope.message} </h1>

            <form action="${pageContext.request.contextPath}/person" method="post">
                <%--Ниспадающий список мы должны поместить в ФОРМУ, что бы по нажатию SUBMIT--%>
                <%--ЗНАЧЕНИЕ (Value)- попало в req.getParameter----%>
                <%--НЕ то, что написано в ниспадающем списке, а то, чему оно равно при выборе--%>
                <%--по дефолту - это значение просто по порядку--%>
                <div class="usa-input-grid usa-input-grid-medium">
                    <h4>Вы выбрали ID = ${requestScope.IdFromSelect}</h4>
                    <select class="usa-form" name="mySelect1">
                        <c:forEach var="elementHero" items="${requestScope.myBestHeros}">
                            <option value="${elementHero.id}">${elementHero.getNameHero()} ${elementHero.age}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <label for="name1">Введите имя</label>
                <input type="text" id="name1" name="name2Attr">
                <label for="family">Введите Фамилию</label>
                <input type="text" id="family" name="family2Attr">
                <button type="submit">Отправить</button>
            </form>
        </div>
        <div class="usa-width-one-half">
            <h3>One Half</h3>
            <table class="usa-table-borderless">
                <caption>Таблица Героев</caption>
                <tr>
                    <th>Имя</th>
                    <th>Возраст</th>
                </tr>
                <c:forEach var="elementHero" items="${requestScope.myBestHeros}">
                    <tr>
                        <td>${elementHero.getNameHero()} </td>
                        <td>${elementHero.age}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <label for="input-type-textarea">Text area label</label>
    <textarea id="input-type-textarea" name="input-type-textarea"></textarea>
</div>
<h1>${requestScope.mega}</h1>
<select>
    <c:forEach var="elementHero" items="${requestScope.myBestHeros}">
        <option>${elementHero.getNameHero()} ${elementHero.age}</option>
    </c:forEach>
</select>
<h1 style="color: #0071bc"> ${requestScope.person.name} ${requestScope.person.family} ${requestScope.message} </h1>
<form action="${pageContext.request.contextPath}/person" method="post">
    <label for="name">Введите имя</label>
    <input type="text" id="name" name="name2Attr">
    <label for="family">Введите Фамилию</label>
    <input type="text" id="family" name="family2Attr">
    <button type="submit">Отправить</button>
</form>
<div class="preview preview-no_border grid-example grid-text">
    <div class="usa-grid">
        <div class="usa-width-one-half">
            <p>------- Через переменную persons -------</p>
            <p>---в которой коллекция объектов Person--</p>
            <%--если коллекция не пустая. то вывести следующее...--%>
            <c:if test="${not empty requestScope.persons}">
                <p>1) ${requestScope.persons.get(1).name} ${requestScope.persons.get(1).family}</p>
                <p>2) ${requestScope.persons.get(0).getName()} ${requestScope.persons.get(0).getFamily()}</p>
                <p>3) ${requestScope.persons}</p>
                <p>4) Имя: ${requestScope.persons.get(1).name}, Фамилия: ${requestScope.persons.get(1).family}</p>
            </c:if>
        </div>
        <div class="usa-width-one-half">
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
                    <h4>${count} - Имя: ${myPerson.name}, Фамилия: ${myPerson.family}</h4>
                </c:forEach>
                <%--а можно вывести 2-й и 3-й (с 1 до 2 исключая нулевой элемент)--%>
                <ul>
                    <c:forEach var="myPerson" begin="1" end="2">
                        <li><p style="color: #4c2c92"> Имя: ${persons[myPerson].name},
                            Фамилия: ${persons[myPerson].family}</p></li>
                    </c:forEach>
                </ul>
                <%--Сделаем все с маленькой буквы. Без Java--%>
                <p style="color: #205493"> ${fn:toLowerCase("НИчеГО не ИзМенилоСь...")}</p>
                <p>Первый элемент надо написать большими буквами. </p>
                <p>Имя: ${fn:toUpperCase(persons.get(0).name)}</p>
                <p>Фамилия: ${fn:toUpperCase(persons.get(0).family)}</p>
                <p>Наша коллекция Persons содержит ${fn:length(persons)} элемента.</p>
            </c:if>
        </div>
        <%--если коллекция не пустая. то вывести следующее...--%>
</body>
</html>
