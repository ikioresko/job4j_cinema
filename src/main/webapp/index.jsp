<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <title>Cinema service</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="js/script.js"></script>
    <link href="${pageContext.request.contextPath}/cssStyle/style.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <form action="<%=request.getContextPath()%>/payment.do" method="post">
        <div className="row pt-3">
            <h4>
                Бронирование места на сеанс
            </h4>
            <table class="table" id="table">
                <thead>
                <tr>
                    <th style="width: 120px;">Ряд / Место</th>
                    <th>Место 1</th>
                    <th>Место 2</th>
                    <th>Место 3</th>
                </tr>
                </thead>
                <tbody id='tb' name="tbName">
                </tbody>
            </table>
        </div>
        <button type="submit" class="btn btn-success">Подтвердить</button>
        <c:if test="${not empty error}">
            <div style="color:red; font-weight: bold; margin: 30px 0;">
                <c:out value="${error}"/>
            </div>
        </c:if>
    </form>
</div>
</body>
</html>