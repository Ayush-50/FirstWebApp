<html>
<head>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    <title>
        Welcome
    </title>
</head>
<body>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<h2>Hello there ${name} </h2>
Please view your to-do list by clicking <a class="btn-success" href="http://localhost:8080/list-todos">here</a>.
</div>
<%@ include file="common/footer.jspf"%>
