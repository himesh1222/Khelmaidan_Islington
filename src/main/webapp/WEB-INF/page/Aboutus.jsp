<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>About Us</title>
  
   <link rel="stylesheet" type="text/css"
        href="${pageContext.request.contextPath}/css/aboutus.css" />
</head>
<body>
  <jsp:include page="/WEB-INF/page/header.jsp" />

  <div class="container">
    <!-- About Us Section -->
    <div class="text-section">
      <h1>About Us.</h1>
      <p class="highlight">
        At <strong>Khel Maidan</strong>, we are passionate about futsal. What began as a shared love for the game has now evolved into one of Nepal’s first dedicated futsal platforms — a place where players, coaches, and clubs can come together to celebrate, organize, and grow the sport.
      </p>
      <p>
        Nepal's futsal culture is growing, but there has been a lack of dedicated digital platforms that streamline booking, community engagement, and access to resources. That’s where we step in. Khel Maidan aims to bridge this gap by being not just a booking service, but a full ecosystem for the futsal community.
      </p>
      <p>
        Our website offers easy futsal court booking, player profiles, match schedules, club listings, training content, and expert insights — all in one place. Whether you're trying to improve your game, connect with clubs, or just find a place to play with friends, Khel Maidan has you covered.
      </p>
      <p>
        What sets us apart is our commitment to both convenience and community. We're building a platform that empowers players and brings Nepal’s futsal scene into the digital age. From grassroots matches to local leagues, we're here to make futsal accessible, exciting, and organized.
      </p>
      <p>
        Khel Maidan is not just a website — we are a family. Our mission is to uplift every player, coach, and club through technology, storytelling, and community support. As futsal continues to grow across Nepal, we are proud to lead the way.
      </p>
    </div>

    <!-- Team Section -->
    <div class="team-section">
      <h2>Meet Our Team</h2>
      <table class="team-table">
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>Role</th>
          </tr>
        </thead>
        <tbody>
          <tr><td>1</td><td>Barsha Koirala</td><td>Database Developer</td></tr>
          <tr><td>2</td><td>Anis Budakoti</td><td>UI/UX & Frontend Developer</td></tr>
          <tr><td>3</td><td>Rohit Ghubaju</td><td>Wireframe, UI/UX & Frontend Developer</td></tr>
          <tr><td>4</td><td>Om Bikram Malla</td><td>UI/UX & Frontend Developer</td></tr>
          <tr><td>5</td><td>Himesh Shakya</td><td>Backend Developer</td></tr>
        </tbody>
      </table>
    </div>
  </div>

  <jsp:include page="/WEB-INF/page/footer.jsp" />
</body>
</html>
    