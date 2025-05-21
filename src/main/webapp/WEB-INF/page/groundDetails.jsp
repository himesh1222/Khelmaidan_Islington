<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Futsal Grounds</title>
    <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/css/fustal.css" />
</head>
<body>

<jsp:include page="/WEB-INF/page/header.jsp" />

<h2>KhelMaidan - Futsal Grounds</h2>

<c:if test="${not empty searchQuery}">
    <h3>Search Results for: "${searchQuery}"</h3>
</c:if>

<c:choose>
    <c:when test="${not empty groundList}">
        <c:forEach var="ground" items="${groundList}">
            <div class="sport1">
                <a href="${pageContext.request.contextPath}/Innerdetail?futsal_id=${ground.groundId}">
                    <div class="image">
                        <!-- Assuming ground.groundImage has the image path -->
                        <img src="${ground.groundImage}" alt="${ground.groundName}" />
                        <div class="image-icon">
                            <img src="${pageContext.request.contextPath}/resource/icons/bookGreen.png" alt="Booking Icon" />
                        </div>
                    </div>
                </a>
                <div class="sport-info">
                    <h4>${ground.groundName}</h4>
                    <h5>${ground.location}</h5>
                    <div class="view-more">
                        <h6>Rs: ${ground.pricePerHour} per hour</h6>
                    </div>
                    <div class="contact-box">
                        <div class="contact-info">
                            <div class="contact-icon">
                                <img src="${pageContext.request.contextPath}/resource/icons/phone.png" alt="Phone Icon" />
                            </div>
                            <div class="contact-number"><h6>9812672182</h6></div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>No matching grounds found.</p>
    </c:otherwise>
</c:choose>

<jsp:include page="/WEB-INF/page/footer.jsp" />
</body>
</html>
