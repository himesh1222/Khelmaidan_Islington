<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Account Settings</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/userprofile.css" />
    <style>
        /* Style for the menu links */
        .menu li a {
            color: #000; /* Default text color */
            text-decoration: none; /* No underline */
            padding: 10px; /* Padding for spacing */
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/page/header.jsp" />

    <div class="container">
        <!-- Sidebar Section -->
        <div class="sidebar">
            <div class="profile">
           <c:choose>
    <c:when test="${not empty user.imagePath 
                    and fn:trim(user.imagePath) != '' 
                    and user.imagePath != 'null' 
                    and user.imagePath != 'uploads/default.png'}">
        <img src="${pageContext.request.contextPath}/${user.imagePath}" alt="User Photo">
    </c:when>
    <c:otherwise>
        <img src="${pageContext.request.contextPath}/resource/fustal/human.jpg" alt="Default Photo">
    </c:otherwise>
</c:choose>
        
               
                <h3>Personal Profile</h3>
            </div>
            <ul class="menu">
                <li class="active"><a href="${pageContext.request.contextPath}/Userprofile">Account</a></li>
                <li><a href="${pageContext.request.contextPath}/HistoryController">My Booking </a></li>
            </ul>
        </div>

        <!-- Main Content Section -->
        <div class="content">
            <h2>Account Settings</h2>
            <form action="update" method="post" enctype="multipart/form-data">
                
                <!-- Name Section -->
                <div class="row">
                    <div class="input-group">
                        <label for="firstName">First Name</label>
                        <input type="text" name="firstName" id="firstName" value="${user.firstName}" required>
                    </div>
                    <div class="input-group">
                        <label for="lastName">Last Name</label>
                        <input type="text" name="lastName" id="lastName" value="${user.lastName}" required>
                    </div>
                </div>

                <!-- Password & Phone Section -->
                <div class="row">
                    <div class="input-group">
                        <label for="newPassword">New Password</label>
                        <input type="password" name="newPassword" id="newPassword" required>
                    </div>
                    <div class="input-group">
                        <label for="phone">Phone Number</label>
                        <input type="tel" name="phone" id="phone" value="${user.phone}" required>
                    </div>
                </div>

                <!-- Profile Image Upload -->
                <div class="row">
                    <div class="input-group">
                        <label for="profileImage">Profile Image</label>
                        <input type="file" name="profileImage" id="profileImage" accept="image/*">
                    </div>
                </div>

                <!-- Buttons -->
                <div class="buttons">
                    <button type="submit" class="update">Update</button>
                    <button type="button" class="cancel" onclick="window.location.href='${pageContext.request.contextPath}/Userprofile'">Cancel</button>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="/WEB-INF/page/footer.jsp" />
</body>
</html>
