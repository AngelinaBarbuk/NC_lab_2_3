<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Gift</title>

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link href="http://bootstrap-3.ru/examples/dashboard/dashboard.css" rel="stylesheet">
</head>
<body>

<%@include file="header.jsp"%>
<div class="container-fluid">
    <h2 class="sub-header">Gift</h2>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <td>Name</td>
                <td>Weight</td>
                <td>Cost</td>
                <td>Type</td>
                <td>Info</td>
            </tr>
            </thead>
            <c:forEach var="candy" items="${Gift.getCandies()}">
                <tr>
                    <td>
                        <h2>${candy.getCandyName()}</h2>
                    </td>
                    <td>
                        <h2>${candy.getWeight()}</h2>
                    </td>
                    <td>
                        <h2>${candy.getCost()}</h2>
                    </td>
                    <td>
                        <h2>${candy.getType()}</h2>
                    </td>
                    <td>
                        <a href="/controller?id=${candy.getId()}&command=ViewCandy" class="btn btn-primary">Show Info</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>