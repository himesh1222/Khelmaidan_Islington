<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Terms and Conditions</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/term.css" />

</head>
<body>
  <jsp:include page="/WEB-INF/page/header.jsp" />

  <div class="terms-container">
    <h1>Terms & Conditions</h1>

    <p class="intro">
      Welcome to Khel Maidan. By accessing and using our platform, you agree to the following terms and conditions. Please read them carefully before making any booking.
    </p>

    <h2>1. Booking Policy</h2>
    <hr />
    <ul>
      <li>All bookings must be made through our official website or app in advance.</li>
      <li>Slots are allocated on a first-come, first-served basis.</li>
      <li>Provide accurate information while booking to avoid cancellation.</li>
    </ul>

    <h2>2. No Refund Policy</h2>
    <hr />
    <ul>
      <li>All bookings are non-refundable.</li>
      <li>Once a booking is confirmed, cancellations are not eligible for any refunds, regardless of the reason.</li>
      <li>Exceptions may be considered only in the event of a technical fault or double booking.</li>
    </ul>

    <h2>3. Rescheduling</h2>
    <hr />
    <ul>
      <li>Rescheduling is allowed only if requested 24 hours or more before the scheduled slot.</li>
      <li>No rescheduling will be accepted within 24 hours of the booking time.</li>
    </ul>

    <h2>4. User Responsibilities</h2>
    <hr />
    <ul>
      <li>Users must follow all futsal ground rules and respect other players.</li>
      <li>Khel Maidan is not responsible for any physical injury, loss, or conflict at the venue.</li>
      <li>Users must take full responsibility for personal items and behavior during the game.</li>
    </ul>

    <h2>5. Venue Liability</h2>
    <hr />
    <ul>
      <li>Khel Maidan is a booking platform only and is not responsible for venue conditions or management.</li>
      <li>For complaints regarding facilities, users should directly contact the venue provider.</li>
    </ul>

    <h2>6. Modification of Terms</h2>
    <hr />
    <ul>
      <li>We reserve the right to change these terms at any time without prior notice.</li>
      <li>It is the user's responsibility to stay updated with the latest terms.</li>
    </ul>

    <h2>7. Agreement</h2>
    <hr />
    <p>
      By using Khel Maidan’s services, you confirm that you have read, understood, and agreed to our Terms and Conditions.
    </p>
  </div>

  <jsp:include page="/WEB-INF/page/footer.jsp" />
</body>
</html>
    