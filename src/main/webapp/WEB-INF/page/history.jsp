<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.HistoryModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Booking History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        th, td {
            border: 1px solid #aaa;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .no-history {
            margin-top: 20px;
            color: #555;
        }
        .menu li a {
            color: #000;
            text-decoration: none;
            padding: 10px;
            display: block;
        }
        .menu li.active a {
            font-weight: bold;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userprofile.css" />
</head>
<body>
<jsp:include page="/WEB-INF/page/header.jsp" />
 <c:if test="${not empty sucess}">
                <p style="color:green">${sucess}</p>
                </c:if>

<div class="container">
    <!-- Sidebar Section -->
    <div class="sidebar">
        <div class="profile">
            <img src="${pageContext.request.contextPath}/resource/fustal/history.png" alt="Profile Photo">
            <h3>Personal Profile</h3>
        </div>
        <ul class="menu">
            <li><a href="${pageContext.request.contextPath}/update">Account</a></li>
            <li class="active"><a href="${pageContext.request.contextPath}/HistoryController">My Booking</a></li>
        </ul>
    </div>

    <!-- Main Content Section -->
    <div class="content">
        <h2>My Booking</h2>
        <%
            List<HistoryModel> historyList = (List<HistoryModel>) request.getAttribute("historyList");
            if (historyList != null && !historyList.isEmpty()) {
        %>
        <table>
            <tr>
                <th>Booking ID</th>
                <th>Ground Name</th>
                <th>Date</th>
                <th>Slot Time</th>
                <th>Duration (hrs)</th>
                <th>Amount</th>
                <th>Payment Method</th>
                <th>Status</th>
            </tr>
            <% for (HistoryModel h : historyList) { %>
            <tr>
                <td><%= h.getBookingId() %></td>
                <td><%= h.getGroundName() %></td>
                <td><%= h.getBookingDate() %></td>
                <td><%= h.getSlotTime() %></td>
                <td><%= h.getDurationHours() %></td>
                <td><%= h.getAmount() %></td>
                <td><%= h.getPaymentMethod() %></td>
                <td><%= h.getPaymentStatus() %></td>
            </tr>
            <% } %>
        </table>
        <% } else { %>
        <p class="no-history">No booking history found.</p>
        <% } %>
    </div>
</div>

<jsp:include page="/WEB-INF/page/footer.jsp" />
</body>
</html>
