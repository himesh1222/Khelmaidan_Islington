<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login - KhelMaidan</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/Login.css" />
</head>
<body>



<div class="all-login">

<div class="login-container"> 
<div class="login-box">


<h2><b>LOGIN</b></h2>

<form action="#" method="POST">
<label for="email">Email <span>*</span></label>
<input type="email" id="email" name="email" placeholder="Email" required>

<label for="password">Password <span>*</span></label>
<input type="password" id="password" name="password" placeholder="Password" required>
<c:if test="${not empty errorMessage}">
                <p style="color:red">${errorMessage}</p>
                </c:if>
<button type="submit" class="login-button">LOG IN</button>

<a href="#" class="forgot-password">Forgot your password?</a>


<a href="${pageContext.request.contextPath}/register" class="create-account">CREATE ACCOUNT</a>

</form>
</div>
</div></div>




</body>
</html>