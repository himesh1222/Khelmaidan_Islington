
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="model.GroundModel" %>
<%
    GroundModel ground = (GroundModel) request.getAttribute("ground");
    Integer userId = (Integer) session.getAttribute("userId");
    Integer bookingId = (Integer) session.getAttribute("bookingId");
    Boolean bookingSuccess = (Boolean) request.getAttribute("bookingSuccess");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Khalti Payment</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/payment.css" />
</head>
<body>

  <% if (bookingSuccess != null && bookingSuccess) { %>
    <div class="success-message" style="color: green; font-weight: bold;">
      Booking successful! Please proceed to payment.
    </div>
  <% } %>



  <div class="payment-container">
    <div class="payment-box">
      <div class="logo-title"> 
        <img src="${pageContext.request.contextPath}/resource/icons/khalti.png" alt="Khalti" class="khalti-logo" />
        <p class="khalti-description">
          <strong>Khalti</strong> is a digital wallet and online payment gateway in Nepal, allowing users to make secure payments for various services.
        </p>
      </div>

      <form action="${pageContext.request.contextPath}/payment" method="post">
        <label for="firstName">First Name</label>
        <input type="text" name="firstName" id="firstName" placeholder="Enter your first name" required />

        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" id="lastName" placeholder="Enter your last name" required />

        <label for="number">Khalti Number</label>
        <input type="text" name="number" id="number" maxlength="10" placeholder="Enter your Khalti number" required />

<p>Ground Name: <span><%= ground.getGroundName() %></span></p>
  <p>Total Rs. <span><%= ground.getPricePerHour() %></span></p>
        <label for="paymentMethod">Payment Method</label>
        <select name="paymentMethod" id="paymentMethod" required>
          <option value="Khalti">Khalti</option>
          <option value="Cash">Cash</option>
        </select>

        <!-- Hidden fields -->
        <input type="hidden" name="futsalId" value="<%= ground.getFutsalId() %>" />
        <input type="hidden" name="amount" value="<%= ground.getPricePerHour() %>" />
        <input type="hidden" name="userId" value="<%= userId %>" />
        <input type="hidden" name="bookingId" value="<%= bookingId != null ? bookingId : "" %>" />

        <button type="submit" class="bank-btn">Make Payment</button>
      </form>
    </div>
  </div>

</body>
</html>
