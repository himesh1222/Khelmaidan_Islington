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

    <!-- Sidebar -->
    <aside class="sidebar">
      <h2 class="sidebar-logo">Futsal Admin</h2>
      <nav class="sidebar-nav">
        <a href="${pageContext.request.contextPath}/AdmindashboardController">Dashboard </a>
         <a href="${pageContext.request.contextPath}/Manageuser">Add ground</a>
        <a href="#" >Bookings</a>
        <a href= "${pageContext.request.contextPath}/AddUser" class="active">Add User </a>
         <a href= "${pageContext.request.contextPath}/Manageuser" >Manage user </a>
      <form action="${pageContext.request.contextPath}/Logout" method="post" style="display:inline;">
  <button type="submit">Logout</button>
</form>



      </nav>
    </aside>

    <!-- Main Content -->
    <main class="main-content">

      <!-- Header with Add User Form -->
      <header class="main-header">
        <div class="form-card">
          <h2>Add User</h2>
          <form action="AddUser" method="post">
            <label for="first_name">First Name</label>
            <input type="text" id="firstname1" name="firstname1" placeholder="Enter first name" required />

            <label for="last_name">Last Name</label>
            <input type="text" id="lastname1" name="lastname1" placeholder="Enter last name" required />

            <label for="email">Email Address</label>
            <input type="email" id="email1" name="email1" placeholder="Enter email" required />

            <label for="password">Password</label>
            <input type="password" id="password1" name="password1" placeholder="Enter password" required />

            <label for="title">Title</label>
            <input type="text" id="title1" name="title1" placeholder="Enter title" required />

            <label for="dob">Date of Birth</label>
            <input type="date" id="dob1" name="dob1" required />

            <button type="submit">Add User</button>
          </form>
        </div>
      </header>

    </main>
  </div>

</body>
</html>
