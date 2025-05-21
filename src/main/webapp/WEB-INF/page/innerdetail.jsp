<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ground.groundName} - Details</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/innerdetails.css" />
</head>
<body>

<jsp:include page="/WEB-INF/page/header.jsp" />

<div class="inner-main">
    <div class="inner-image">
        <img src="${ground.groundImage}" alt="${ground.groundName}" width="100%" style="border-radius:10px;" />
        <div class="image-container">${ground.groundName}</div>
        <div class="contact-info">${ground.location}</div>
        
    </div>
    <div class="inner-details">
        <h4>Amenities</h4>
        <ul>
            <li>Artificial Turf</li>
            <li>Floodlights</li>
            <li>Shower & Changing Rooms</li>
            <li>Refreshment Area</li>
            <li>Parking Facility</li>
        </ul>
        <h4>Opening Hours</h4>
        <p>Monday - Sunday: 6:00 AM - 10:00 PM</p>
        <h4>Price</h4>
        <p>Rs. ${ground.pricePerHour} per hour</p>
        <h4>Promo Code</h4>
        <p>Use <strong>Esewa1</strong> on Esewa and get 3% off on your booking!</p>

        <!-- Dynamic book now link -->
        <a href="${pageContext.request.contextPath}/AdminBooking?futsal_id=${ground.groundId}">
            <button class="book-button">Book Now</button>
        </a>
    </div>
</div>

<div class="location">
    <h3>Location</h3>
    <p>${ground.location}</p>
    <iframe src="https://www.google.com/maps/embed?pb=..." width="100%" height="300" style="border-radius:10px;"></iframe>
</div>

<div class="comment-section">
    <h3>Comments</h3>
    <form>
        <textarea rows="7" placeholder="Leave a comment..."></textarea><br>
        <button type="submit">Submit</button>
    </form>
</div>

<jsp:include page="/WEB-INF/page/footer.jsp" />
</body>
</html>
