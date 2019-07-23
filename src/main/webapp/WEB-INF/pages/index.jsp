<%@ page import="mfh.spring.api.model.Customer" %>
<%@ page import="mfh.spring.api.model.ModelFactory" %>
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
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerModelFactory.dataList}" var="customer">
            <tr>
                <td><c:out value="${customer.firstName}"/></td>
                <td><c:out value="${customer.lastName}"/></td>
                <td><c:out value="${customer.email}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%
        ModelFactory<Customer> customerModelFactory = (ModelFactory<Customer>) request.getAttribute("customerModelFactory");
        boolean hasNextPage = customerModelFactory.isHasNextPage();
        boolean hasPrevPage = customerModelFactory.isHasPreviousPage();
        int currentPage = customerModelFactory.getCurrentPage();
    %>
    <ul class="pagination" style="pointer-events:none;">
        <li class="page-item ${hasPrevPage? "active": "disabled"}"><a class="page-link" href="#">Previous</a></li>
        <c:forEach begin="1" end="${customerModelFactory.totalPageNumber}" var="pageNumber">
            <li class="page-item ${currentPage == pageNumber? "active": "disabled"}"><a class="page-link"
                                                                                        href="#">${pageNumber}</a></li>
        </c:forEach>
        <li class="page-item ${hasNextPage? "active": "disabled"}"><a class="page-link" href="#">Next</a></li>
    </ul>
</div>

</body>
</html>
