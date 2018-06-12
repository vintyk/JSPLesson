<%--
  Created by Ушаков Виталий (Vinty). Skype: vintyk1978
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>JqueryExample</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/uswds.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/uswds.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/example.js"></script>
</head>
<body>
<div class="preview preview-no_border grid-example grid-example-blank">
    <div class="usa-grid">
        <div class="usa-width-one-whole">
            <%--<form action="${pageContext.request.contextPath}/jqueryExample">--%>
            <label for="data-input">First name</label>
            <input id="data-input" name="first-name" type="text" required aria-required="true">
            <label for="data-input2">Family</label>
            <input id="data-input2" name="family" type="text" required aria-required="true">
            <button onclick="sendInputDataToServer()" class="usa-button-secondary usa-button-hover">Hover</button>
            <%--</form>--%>
            <div id="msg"></div>
        </div>
    </div>
</div>
</body>
</html>
