<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Us - KhelMaidan</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/contact-us.css" />
</head>
<body>
<jsp:include page="/WEB-INF/page/header.jsp" />
<div class="contact-container">
<div class="contact-info">
<h2>Contact Us</h2>
<p>KhelMaidan is your ultimate destination for sports lovers. Whether you're a passionate athlete, an enthusiastic fan, or someone who simply enjoys staying updated with the latest in sports, we bring you real-time updates, expert insights, and a dynamic community to connect with. Join us and be part of the game like never before!</p>

<div class="info-box">
<img src="${pageContext.request.contextPath}/resource/icons/location.png" alt="Location"alt="Location" class="icon">
<div>
<h3>Address</h3>
<p>kathmandu, Nepal</p>
</div>
</div>

<div class="info-box">
<img src="${pageContext.request.contextPath}/resource/icons/phone.png" alt="Location" alt="Phone" class="icon">
<div>
<h3>Phone</h3>
<p> 9876543210</p>
</div>
</div>

<div class="info-box">
<img src="${pageContext.request.contextPath}/resource/icons/gmail.png" alt="Location" class="icon">
<div>
<h3>Email</h3>
<p>support@khelmaidan.com</p>
</div>
</div>
</div>

<div class="contact-form">
<h3>Send Message</h3>
<form action="#" method="post">
<input type="text" name="name" placeholder="Full Name" required>
<input type="email" name="email" placeholder="Email" required>
<textarea name="message" placeholder="Type your message..." required></textarea>
<button type="submit">Send</button>
</form>
</div>
</div>
<jsp:include page="/WEB-INF/page/footer.jsp" />
</body>
</html>