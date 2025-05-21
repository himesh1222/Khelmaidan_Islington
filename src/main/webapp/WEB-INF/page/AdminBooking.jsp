<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Booking Form</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Adminbooking.css" />
</head>
<body>
<jsp:include page="/WEB-INF/page/header.jsp" />

  <div class="form-container">
    <h1>Booking Form</h1>

    <!-- Display Ground & User Info -->
    <div class="ground-details">
      <h2>Ground Name: <span>${ground.groundName}</span></h2>
      <p>Price per hour: Rs. <span>${ground.pricePerHour}</span></p>
      <p>User ID: <span>${sessionScope.userId}</span></p>
    </div>

    <form action="${pageContext.request.contextPath}/AdminBooking" method="POST">
  <!-- Booking Date -->
  <div class="form-group">
    <label>Booking Date<span>*</span></label>
    <input type="date" name="bookingDate" required />
  </div>

  <!-- Slot Time -->
  <div class="form-group">
    <label>Slot Time<span>*</span></label>
    <input type="time" name="slotTime" required />
  </div>

  <!-- Duration Hours -->
  <div class="form-group">
    <label>Duration (Hours)<span>*</span></label>
    <input type="number" name="durationHours" min="1" placeholder="e.g. 1" required />
  </div>

  <!-- Booking Status (optional - can default in backend) -->
  <div class="form-group">
    <label>Booking Status</label>
    <select name="bookingStatus">
      <option value="Pending">Pending</option>
      <option value="Confirmed">Confirmed</option>
      <option value="Cancelled">Cancelled</option>
    </select>
  </div>

  <!-- Hidden Fields -->
  <input type="hidden" name="futsalId" value="${ground.groundId}" />
  <input type="hidden" name="userId" value="${sessionScope.userId}" />

  <!-- Submit -->
  <button type="submit">Book</button>
</form>
    
  </div>

<jsp:include page="/WEB-INF/page/footer.jsp" />
</body>
</html>
