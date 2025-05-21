<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/register.css" />
</head>
<body>



<div class="main-register">
<div class="form-container">
    <!-- Header -->
    <div class="header-text">Create your account to have access to a more personalised experience.</div>
    <div class="login-link">
        Already have a KHELMAIDAN account?   <a href="${pageContext.request.contextPath}/login" >Log in here.</a>
    </div>

  <form action="register" method="post">
  
        <!-- Row 1 -->
        <div class="form-row">
            <div class="form-group">
                <label for="email">Email *</label>
                <input type="email" id="email" name="email" >
                <c:if test="${not empty EmailError}">
                <p style="color:red">${EmailError}</p>
                </c:if>
            </div>
            <div class="form-group">
                <label for="title">Title *</label>
                <select id="title" name="title" >
                    <option value="">Select your title</option>
                    <option value="Mr">Mr</option>
                    <option value="Ms">Ms</option>
                    <option value="Mrs">Mrs</option>
                    <option value="Dr">Dr</option>
                </select>
                <c:if test="${not empty TitleError}">
                <p style="color:red">${TitleError}</p>
                </c:if>
            </div>
        </div>

        <!-- Row 2 -->
        <div class="form-row">
            <div class="form-group">
                <label for="firstName">First Name *</label>
                <input type="text" id="firstName" name="firstName" >
                <c:if test="${not empty FirstError}">
                <p style="color:red">${FirstError}</p>
                </c:if>
            </div>
            
            <div class="form-group">
                <label for="lastName">Last Name *</label>
                <input type="text" id="lastName" name="lastName" >
                <c:if test="${not empty LastError}">
                <p style="color:red">${LastError}</p>
                </c:if>
            </div>
            
        </div>

        <!-- Row 3 -->
        <div class="form-row">
            <div class="form-group">
                <label for="password">Password *</label>
                <input type="password" id="password" name="password" >
                <c:if test="${not empty PasswordError}">
                <p style="color:red">${PasswordError}</p>
                </c:if>
            </div>
            <div class="form-group">
                <label for="rePassword">Confirm Password *</label>
                <input type="password" id="rePassword" name="rePassword" >
                <c:if test="${not empty ReError}">
                <p style="color:red">${ReError}</p>
                </c:if>
            </div>
        </div>

        <!-- Row 4 -->
        <div class="form-row">
            <div class="form-group" style="flex: 1;"></div>
            <div class="form-group" style="flex: 1;">
                <label for="dob">Date of Birth</label>
                <input type="date" id="dob" name="dob" >
                <c:if test="${not empty DOBError}">
                <p style="color:red">${DOBError}</p>
                </c:if>
            </div>
        </div>

        <!-- Submit Button -->
        <div class="submit-row">
            <button type="submit" class="submit-btn">Register</button>
        </div>
    </form>
</div>
</div>


</body>
</html>
