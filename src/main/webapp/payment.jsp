<%@ page contentType="text/html; charset=UTF-8" %>

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
    <link href="${pageContext.request.contextPath}/cssStyle/style.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row pt-3">
        <h3>Вы выбрали ряд: <%=request.getAttribute("row")%>
            место: <%=request.getAttribute("cell")%> Сумма : 500 рублей.
        </h3>
    </div>
    <div class="alert">
        <h6>Введите ФИО и телефон чтобы забронировать место</h6>
    </div>
    <div class="row">
        <form action="<%=request.getContextPath()%>/checkout.do" method="post">
            <div class="form-group">
                <label for="username">ФИО</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="ФИО">
            </div>
            <div class="form-group">
                <label for="phone">Номер телефона</label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Номер телефона">
            </div>
            <button type="submit" class="btn btn-success" name="rowCell"
                    value="<%=request.getAttribute("row")
                        + ":" + request.getAttribute("cell")
                        + ":" + request.getAttribute("id")%>">Забронировать
            </button>
        </form>
    </div>
</div>
</body>
</html>
