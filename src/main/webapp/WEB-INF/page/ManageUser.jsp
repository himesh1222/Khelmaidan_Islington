<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Manage Users</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Admindashboard.css">
</head>
<body>

<div class="dashboard-container">

  <!-- Sidebar -->
  <aside class="sidebar">
    <h2 class="sidebar-logo">Futsal Admin</h2>
    <nav class="sidebar-nav">
      <a href="${pageContext.request.contextPath}/AdmindashboardController">Dashboard</a>
       <a href="${pageContext.request.contextPath}/Addground">Add ground</a>
      <a href="#">Bookings</a>
      <a href="${pageContext.request.contextPath}/AddUser">Add User</a>
      <a href="${pageContext.request.contextPath}/Manageuser" class="active">Manage User</a>
      <form action="${pageContext.request.contextPath}/Logout" method="post">
        <button type="submit">Logout</button>
      </form>
    </nav>
  </aside>

  <!-- Main Content -->
  <main class="main-content">
    <header class="main-header">
      <h1>Manage Users</h1>
    </header>

    <div class="table-wrapper">
      <table>
        <thead>
          <tr>
            <th>Date</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone no</th>
            <th>Status</th>
            <th>Photo</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          <!-- Iterate over users list and display each user -->
          <c:forEach var="user" items="${users}">
            <tr>
              <td>${user.dob}</td>
              <td>${user.firstName}</td>
              <td>${user.lastName}</td>
              <td>${user.email}</td>
              <td>${user.phone}</td>
              <td>Active</td>
              <td>
                <c:if test="${not empty user.imagePath}">
           <img src="${user.imagePath}" alt="User Photo" width="80" height="70" style="border-radius: 50%;" />

                </c:if>
                <c:if test="${empty user.imagePath}">
                  <span>No Photo</span>
                </c:if>
              </td>
              
              <td>
  <form action="${pageContext.request.contextPath}/Manageuser" method="post" onsubmit="return confirm('Are you sure you want to delete this user?');">
    <input type="hidden" name="userId" value="${user.id}" />
    <button type="submit" class="btn">Delete</button>
  </form>
</td>
              
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

  </main>
</div>

</body>
</html>
