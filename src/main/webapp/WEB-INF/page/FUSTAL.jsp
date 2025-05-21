<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Your Futsal</title>
<link rel="stylesheet" type="text/css"
    href="${pageContext.request.contextPath}/css/fustal.css" />
</head>
<body>
<jsp:include page="/WEB-INF/page/header.jsp" />

<div class="show-sport-section">
    <div><h2>BOOK YOUR FUTSAL NOW</h2></div>

    <div class="sport-details">
    <c:forEach var="ground" items="${grounds}">
        <%-- Futsal 1 --%>
        <div class="sport1">
            <a href="${pageContext.request.contextPath}/Innerdetail?futsal_id=${ground.groundId}">
                <div class="image">
                    <img src="${ground.groundImage}" alt="BHATBATINI FUSTAL" />
                    <div class="image-icon">
                        <img src="${pageContext.request.contextPath}/resource/icons/bookGreen.png" alt="Booking Icon" />
                    </div>
                </div>

                <div class="sport-info">
                    <h4>${ground.groundName}</h4>
                    <h5>${ground.location}</h5>
                    <div class="view-more"><h6>Rs:${ground.pricePerHour} per hour</h6></div>
                    <div class="contact-box">
                        <div class="contact-info">
                            <div class="contact-icon">
                                <img src="${pageContext.request.contextPath}/resource/icons/phone.png" alt="Phone Icon" />
                            </div>
                            <div class="contact-number"><h6>9812672182</h6></div>
                        </div>
                    </div>
                </div>
            </a>
        </div>
    </c:forEach>

    </div> <%-- End of sport-details --%>
</div> <%-- End of show-sport-section --%>

<jsp:include page="/WEB-INF/page/footer.jsp" />
</body>
</html>
