<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    <title>List To Do's page</title>
</head>
<body>
<%--navigation was here--%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <h1>Hello there ${name}!!! Welcome to your to-do list.</h1>

    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Done</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.name}</td>
                <td>${todo.username}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done ? 'Yes' : 'No'}</td>
                <td class="btn btn-warning"><a href="http://localhost:8080/delete-todo?id=${todo.id}">Delete</a></td>
                <td class="btn btn-success"><a href="http://localhost:8080/modify-todo?id=${todo.id}">Modify</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add New To-Do</a>
</div>
<%@ include file="common/footer.jspf"%>
