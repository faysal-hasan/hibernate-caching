<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Customers</h2>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>User Name</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><c:out value="${customer.userName}"/></td>
                <td><c:out value="${customer.email}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="">
        <a href="customer-form">Add customer?</a>
    </div>
</div>

</body>
</html>
