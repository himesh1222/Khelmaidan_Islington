<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Futsal Booking - Admin Dashboard</title>
  <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/css/AddUser.css" />
</head>
<body>

<div class="dashboard-container">

  <aside class="sidebar">
    <h2 class="sidebar-logo">Futsal Admin</h2>
    <nav class="sidebar-nav">
      <a href="${pageContext.request.contextPath}/AdmindashboardController"> Dashboard </a>
       <a href="${pageContext.request.contextPath}/AddGround"  class="active">Add ground</a>
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

  <!-- Header with Add Ground Form -->
  <header class="main-header">
    <div class="form-card">
      <h2>Add New Futsal Ground</h2>
      <form action="AddGround" method="post" enctype="multipart/form-data">
        
        <label for="groundName">Ground Name</label>
        <input type="text" name="groundName" id="groundName" placeholder="Enter ground name" required />

        <label for="location">Location</label>
        <input type="text" name="location" id="location" placeholder="Enter location" required />

        <label for="capacity">Capacity</label>
        <input type="number" name="capacity" id="capacity" placeholder="Enter capacity" required />

        <label for="pricePerHour">Price Per Hour (Rs)</label>
        <input type="number" step="0.01" name="pricePerHour" id="pricePerHour" placeholder="Enter price" required />

        <label for="description">Description</label>
        <textarea name="description" id="description" rows="4" placeholder="Enter ground description" required></textarea>

        <label for="groundImage">Ground Image</label>
        <input type="file" name="groundImage" id="groundImage" accept="image/*" required />

        <button type="submit">Add Ground</button>
      </form>
    </div>
  </header>

</main>
  
</div>

</body>
</html>
