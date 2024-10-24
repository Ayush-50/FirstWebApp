<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
    <link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css" rel="stylesheet">
    <title>
        Create A New To-Do
    </title>
</head>
<body>
<%@ include file="common/navigation.jspf"%>
<div class="container">

<%--    <form:form action="list-todos" method="post" modelAttribute="todo">--%>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-2">
            Name:<form:input cssClass="form-text" type="text" path="name" required="required"/>
            <form:errors path="name" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            Description:<form:input cssClass="form-text" type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            Target Date:<form:input type="text" path="targetDate" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <input type="submit" value="Submit" class="btn-success"/>

    </form:form>

    <a href="http://localhost:8080/list-todos">
        <button class="btn-success"> Go Back To View List</button>
    </a>
</div>
<%@ include file="common/footer.jspf"%>


<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>