<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, org.json.JSONArray" %>
<%
    // Retrieve payment data from servlet
    List<String> dates = (List<String>) request.getAttribute("dates");
    List<Double> amounts = (List<Double>) request.getAttribute("amounts");

    // Convert to JSON
    JSONArray jsonDates = new JSONArray(dates);
    JSONArray jsonAmounts = new JSONArray(amounts);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Futsal Booking - Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Admindashboard.css" />
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<div class="dashboard-container">

  <aside class="sidebar">
    <h2 class="sidebar-logo">Futsal Admin</h2>
    <nav class="sidebar-nav">
      <a href="${pageContext.request.contextPath}/AdmindashboardController" class="active"> Dashboard </a>
       <a href="${pageContext.request.contextPath}/AddGround">Add ground</a>
      <a href="${pageContext.request.contextPath}/ViewBooking">Bookings</a>
      <a href="${pageContext.request.contextPath}/AddUser">Add User</a>
      <a href="${pageContext.request.contextPath}/Manageuser">Manage user</a>
      <form action="${pageContext.request.contextPath}/Logout" method="post" style="display:inline;">
        <button type="submit">Logout</button>
      </form>
    </nav>
  </aside>

  <!-- Main Content -->
  <main class="main-content">

    <!-- Header -->
    <header class="main-header">
      <h1>Admin Dashboard</h1>
      <p>Welcome back! Here is an overview of current stats.</p>
    </header>

    <!-- Statistics -->
    <section class="stats-section">
      <div class="stat-card">
        <p>Total Bookings</p>
        <h3>${totalBookings}</h3>
      </div>
      <div class="stat-card">
        <p>Total Income</p>
        <h3>NPR ${totalRevenue}</h3>
      </div>
     
      <div class="stat-card">
        <p>Total Users</p>
        <h3>${totalUsers}</h3>
      </div>
    </section>



    <!-- Graph Section (Payment Chart) -->
    <section class="graph-section">
      <h2>Payment Overview</h2>
      <canvas id="paymentChart" width="400" height="200"></canvas>
    </section>

    <!-- Bookings Table -->
    <section class="table-section">
      <h2>Recent Bookings</h2>
      <table>
        <thead>
          <tr>
            <th>Date</th>
            <th>Time</th>
            <th>User</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Apr 20</td>
            <td>6 PM</td>
            <td>Ahmad</td>
            <td class="status confirmed">Confirmed</td>
          </tr>
          <tr>
            <td>Apr 20</td>
            <td>8 PM</td>
            <td>Sarah</td>
            <td class="status pending">Pending</td>
          </tr>
          <tr>
            <td>Apr 19</td>
            <td>7 PM</td>
            <td>Ali</td>
            <td class="status cancelled">Cancelled</td>
          </tr>
          <tr>
            <td>Apr 18</td>
            <td>5 PM</td>
            <td>Farah</td>
            <td class="status confirmed">Confirmed</td>
          </tr>
        </tbody>
      </table>
    </section>

  </main>
</div>

<script>
  const dates = <%= jsonDates.toString() %>;
  const amounts = <%= jsonAmounts.toString() %>;

  // Debug logs
  console.log("Chart.js version:", Chart.version);
  console.log("Dates:", dates);
  console.log("Amounts:", amounts);

  const ctx = document.getElementById('paymentChart').getContext('2d');
  const paymentChart = new Chart(ctx, {
      type: 'line', // Line chart type
      data: {
          labels: dates,
          datasets: [{
              label: 'Payment Amount (NPR)',
              data: amounts,
              backgroundColor: 'rgba(75, 192, 192, 0.2)', // Fill under the line
              borderColor: 'rgba(75, 192, 192, 1)', // Line color
              borderWidth: 2, // Thicker line
              fill: true, // Fill the area under the line
          }]
      },
      options: {
          responsive: true,
          scales: {
              y: {
                  beginAtZero: true
              }
          }
      }
  });
</script>

</body>
</html>
