<%--
  Created by IntelliJ IDEA.
  User: fhasan
  Date: 7/21/19
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Customer Insertion</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>

<div class="container">
    <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <h2><spring:message code="customer.form.title" text="Add New Customer"/></h2>
        <br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title"><fmt:message key="label.signup.title"/></div>
            </div>
            <div class="panel-body">
                <form:form method="post" action="addCustomer" modelAttribute="customer">

                    <%--User name --%>

                    <div id="div_id_username" class="form-group required">
                        <label for="id_username" class="control-label col-md-4  requiredField">
                            <spring:message code="label.username" text="User Name"/>
                            <span class="asteriskField">*</span>
                        </label>

                        <div class="controls col-md-8 ">
                            <fmt:message key="label.username.placeholder" var="userNamePlaceHolder"/>
                            <form:input class="input-md  textinput textInput form-control" id="id_username"
                                        maxlength="30" name="username" placeholder="${userNamePlaceHolder}"
                                        style="margin-bottom: 10px" type="text" path="userName"/>
                        </div>
                    </div>


                    <%--Email --%>
                    <div id="div_id_email" class="form-group required">
                        <fmt:message key="label.email.placeholder" var="emailPlaceHolder"/>
                        <label for="id_email" class="control-label col-md-4  requiredField">
                            <spring:message code="label.email" text="Email"/>
                            <span class="asteriskField">*</span>
                        </label>
                        <div class="controls col-md-8 ">
                            <form:input class="input-md emailinput form-control" id="id_email" name="email"
                                        placeholder="${emailPlaceHolder}" style="margin-bottom: 10px"
                                        type="email" path="email"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="aab controls col-md-4 "></div>
                        <div class="controls col-md-8 ">
                            <input type="submit" name="Signup" value="<fmt:message key="label.signup.button"/>"
                                   class="btn btn-primary btn btn-info"
                                   id="submit-id-signup"/>
                        </div>
                    </div>

                </form:form>


                <div class="">
                    <a href="/">Back</a>
                </div>
            </div>
        </div>
    </div>
</div>


</div>
</body>
</html>
