<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.BookingModel" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Admindashboard.css" />
<meta charset="UTF-8">
<title>All Bookings - Futsal Admin</title>
<style>
 
  
   
    }
    table {
        border-collapse: collapse;
        width: 100%;
        margin-top: 20px;
    }
    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #ecf0f1;
    }
</style>
</head>
<body>
<div class="dashboard-container">

  <aside class="sidebar">
    <h2 class="sidebar-logo">Futsal Admin</h2>
    <nav class="sidebar-nav">
      <a href="${pageContext.request.contextPath}/AdmindashboardController">Dashboard</a>
      <a href="${pageContext.request.contextPath}/Manageuser">Add ground</a>
      <a href="${pageContext.request.contextPath}/ViewBooking" class="active">Bookings</a>
      <a href="${pageContext.request.contextPath}/AddUser">Add User</a>
      <a href="${pageContext.request.contextPath}/Manageuser">Manage user</a>
      
      <form action="${pageContext.request.contextPath}/Logout" method="post">
        <button type="submit">Logout</button>
      </form>
    </nav>
  </aside>

  <!-- Main Content -->
  <main class="main-content">
    <h2>All Bookings</h2>
    <table>
        <tr>
            <th>Booking ID</th>
            <th>User ID</th>
            <th>Booking Date</th>
            <th>Slot Time</th>
            <th>Duration</th>
            <th>Status</th>
            
        </tr>
        <%
            List<BookingModel> bookings = (List<BookingModel>) request.getAttribute("bookings");
            if (bookings != null && !bookings.isEmpty()) {
                for (BookingModel b : bookings) {
        %>
        <tr>
            <td><%= b.getBookingId() %></td>
            <td><%= b.getUserId() %></td>
            <td><%= b.getBookingDate() %></td>
            <td><%= b.getSlotTime() %></td>
            <td><%= b.getDurationHours() %></td>
            <td><%= b.getBookingStatus() %></td>
           
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="7">No bookings available.</td></tr>
        <% } %>
    </table>
  </main>

</div>
</body>
</html>
