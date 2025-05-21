
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>KhelMaidan</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/header.css" />
	 <style>
    .menu-icon {
      width: 60px;
      height: 60px;
      border-radius: 50%;
      object-fit: cover;
      border: 1px solid #000;
      
    }
    a {
  text-decoration: none;
  color: black;
}

a:hover {
  color: #007bff; /* Optional: color on hover */
  text-decoration: underline; /* Optional: underline on hover */
}
  </style>
</head>
<body>

<header>
<div class="left-section">
 <a href="${pageContext.request.contextPath}/update">
<img src="${pageContext.request.contextPath}/resource/fustal/7749927.png" alt="profile pic" class="menu-icon">
</a>
<a href="${pageContext.request.contextPath}/Fustal">
<span class="menu-text">Home</span>
</a>
<form action="${pageContext.request.contextPath}/searchGround" method="get">
    <input type="text" name="query" class="search-input" placeholder="Search">
</form>

</div>
<div class="logo">KHELMAIDAN</div>
<div class="right-section">
<a href="${pageContext.request.contextPath}/aboutus">About Us</a>
<a href="${pageContext.request.contextPath}/Contactus">Contact Us</a>

<form action="${pageContext.request.contextPath}/Logout" method="post" style="display:inline;">
    <button type="submit" style="background:none; border:none; color:black; cursor:pointer; font-size:18px; font-weight:bold;">
        Logout
    </button>
</form>


</div>
</header>

</body>
</html>