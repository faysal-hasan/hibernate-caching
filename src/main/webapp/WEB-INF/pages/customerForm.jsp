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
    <title>Sign up</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="/js/signup.js"></script>
</head>
<body>

<div class="container">
    <div id="signupbox" style=" margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <h2><spring:message code="customer.form.title" text="Add New Customer"/></h2>
        <br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title"><fmt:message key="label.signup.title"/></div>
                <div style="float:right; font-size: 85%; position: relative; top:-10px">
                    <a id="signinlink" href="/accounts/login/"><fmt:message key="label.signin"/></a>
                </div>
            </div>
            <div class="panel-body">
                <form:form method="post" action="addCustomer" modelAttribute="customer">
                    <%--<input type='hidden' name='csrfmiddlewaretoken' value='XFe2rTYl9WOpV8U6X5CfbIuOZOELJ97S'/>--%>


                    <%--<form:form class="form-horizontal" method="post">--%>
                    <%--<input type='hidden' name='csrfmiddlewaretoken' value='XFe2rTYl9WOpV8U6X5CfbIuOZOELJ97S'/>--%>


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
                                        style="margin-bottom: 10px" type="text" path="firstName"/>
                        </div>
                    </div>

                    <%--First name --%>

                    <div id="div_id_firstname" class="form-group required">
                        <label for="id_firstname" class="control-label col-md-4  requiredField">
                            <spring:message code="label.firstname" text="First Name"/>

                        </label>

                        <div class="controls col-md-8 ">
                            <fmt:message key="label.firstname.placeholder" var="firstNamePlaceHolder"/>
                            <form:input class="input-md  textinput textInput form-control" id="id_firstname"
                                        maxlength="30" name="firstname" placeholder="${firstNamePlaceHolder}"
                                        style="margin-bottom: 10px" type="text" path="firstName"/>
                        </div>
                    </div>

                    <%--Last name --%>

                    <div id="div_id_lastname" class="form-group required">
                        <label for="id_lastname" class="control-label col-md-4  requiredField">
                            <spring:message code="label.lastname" text="Last Name"/>
                        </label>

                        <div class="controls col-md-8 ">
                            <fmt:message key="label.firstname.placeholder" var="lastNamePlaceHolder"/>
                            <form:input class="input-md  textinput textInput form-control" id="id_lastname"
                                        maxlength="30" name="lastname" placeholder="${lastNamePlaceHolder}"
                                        style="margin-bottom: 10px" type="text" path="lastName"/>
                        </div>
                    </div>

                    <%--Full name --%>

                    <div id="div_id_fullname" class="form-group required">
                        <label for="id_fullname" class="control-label col-md-4  requiredField">
                            <spring:message code="label.fullname" text="Full Name"/>
                        </label>

                        <div class="controls col-md-8 ">
                            <fmt:message key="label.fullname.placeholder" var="fullNamePlaceHolder"/>
                            <form:input class="input-md  textinput textInput form-control" id="id_fullname"
                                        maxlength="30" name="fullname" placeholder="${fullNamePlaceHolder}"
                                        style="margin-bottom: 10px" type="text" path="fullName"/>
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

                    <%--  <div id="div_id_password1" class="form-group required">
                          <label for="id_password1" class="control-label col-md-4  requiredField">Password<span
                                  class="asteriskField">*</span> </label>
                          <div class="controls col-md-8 ">
                              <input class="input-md textinput textInput form-control" id="id_password1"
                                     name="password1" placeholder="Create a password" style="margin-bottom: 10px"
                                     type="password"/>
                          </div>
                      </div>
                      <div id="div_id_password2" class="form-group required">
                          <label for="id_password2" class="control-label col-md-4  requiredField"> Re:password<span
                                  class="asteriskField">*</span> </label>
                          <div class="controls col-md-8 ">
                              <input class="input-md textinput textInput form-control" id="id_password2"
                                     name="password2" placeholder="Confirm your password" style="margin-bottom: 10px"
                                     type="password"/>
                          </div>
                      </div>

                      <div id="div_id_gender" class="form-group required">
                          <label for="id_gender" class="control-label col-md-4  requiredField"> Gender<span
                                  class="asteriskField">*</span> </label>
                          <div class="controls col-md-8 " style="margin-bottom: 10px">
                              <label class="radio-inline"> <input type="radio" name="gender" id="id_gender_1"
                                                                  value="M" style="margin-bottom: 10px">Male</label>
                              <label class="radio-inline"> <input type="radio" name="gender" id="id_gender_2"
                                                                  value="F" style="margin-bottom: 10px">Female
                              </label>
                          </div>
                      </div>--%>

                    <%--<div id="div_id_number" class="form-group required">
                        <label for="id_number" class="control-label col-md-4  requiredField"> contact number<span
                                class="asteriskField">*</span> </label>
                        <div class="controls col-md-8 ">
                            <input class="input-md textinput textInput form-control" id="id_number" name="number"
                                   placeholder="provide your number" style="margin-bottom: 10px" type="text"/>
                        </div>
                    </div>
                    <div id="div_id_location" class="form-group required">
                        <label for="id_location" class="control-label col-md-4  requiredField"> Your Location<span
                                class="asteriskField">*</span> </label>
                        <div class="controls col-md-8 ">
                            <input class="input-md textinput textInput form-control" id="id_location"
                                   name="location" placeholder="Your Pincode and City" style="margin-bottom: 10px"
                                   type="text"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="controls col-md-offset-4 col-md-8 ">
                            <div id="div_id_terms" class="checkbox required">
                                <label for="id_terms" class=" requiredField">
                                    <input class="input-ms checkboxinput" id="id_terms" name="terms"
                                           style="margin-bottom: 10px" type="checkbox"/>
                                    Agree with the terms and conditions
                                </label>
                            </div>

                        </div>
                    </div>--%>
                    <div class="form-group">
                        <div class="aab controls col-md-4 "></div>
                        <div class="controls col-md-8 ">
                            <input type="submit" name="Signup" value="<fmt:message key="label.signup.button"/>"
                                   class="btn btn-primary btn btn-info"
                                   id="submit-id-signup"/>
                        </div>
                    </div>

                    <%--</form:form>--%>

                </form:form>
            </div>
        </div>
    </div>
</div>


</div>
</body>
</html>
