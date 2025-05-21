<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/search.css" />
</head>
<body>
<jsp:include page="/WEB-INF/page/header.jsp" />
 
 <%-- Futsal 6 --%>
<div class="futsal-box">
    <div class="futsal-img-container">
        <img src="${pageContext.request.contextPath}/resource/fustal/chaur_recreational_center.png" alt="Futsal 6" />
        <div class="futsal-icon">
            <img src="${pageContext.request.contextPath}/resource/icons/bookGreen.png" alt="Booking Icon" />
        </div>
    </div>
    <div class="futsal-info">
        <h4>CHAUR CENTER</h4>
        <h5>Baluwatar, Kathmandu</h5>
        <div class="futsal-rate">
            <h6>Rs:4000/- per hour</h6>
        </div>
        <div class="futsal-contact-wrap">
            <div class="futsal-contact">
                <div class="futsal-contact-icon">
                    <img src="${pageContext.request.contextPath}/resource/icons/phone.png" alt="phone logo" />
                </div>
                <div class="futsal-phone">
                    <h6>9833672291</h6>
                </div>
            </div>
        </div>
    </div>
</div>
 
</body>
</html>