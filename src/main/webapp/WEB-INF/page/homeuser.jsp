<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Futsal Home</title>
  <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/userhome.css" />
  <script>
    let currentSlide = 0;

    function showSlide(index) {
      const slides = document.querySelectorAll('.slider img');
      slides.forEach((slide, i) => {
        slide.classList.remove('active');
        if (i === index) slide.classList.add('active');
      });
    }

    function nextSlide() {
      const slides = document.querySelectorAll('.slider img');
      currentSlide = (currentSlide + 1) % slides.length;
      showSlide(currentSlide);
    }

    function prevSlide() {
      const slides = document.querySelectorAll('.slider img');
      currentSlide = (currentSlide - 1 + slides.length) % slides.length;
      showSlide(currentSlide);
    }

    function startSlider() {
      setInterval(nextSlide, 4000); // Change slide every 2 seconds
    }

    window.addEventListener('DOMContentLoaded', () => {
      showSlide(currentSlide);
      startSlider();
    });
  </script>
</head>
<body>

  <!-- Image Slider with centered left/right buttons -->
  <div class="slider">
    <img src="${pageContext.request.contextPath}/resource/fustal/euro.png" alt="Futsal 1"" alt="Slide 1" class="active">
    <img src="../resource/futsal/velocity-futsal.jpg" alt="Slide 2">
    <img src="../resource/futsal/slide3.jpg" alt="Slide 3">
    <button class="slider-btn prev" onclick="prevSlide()">&#10094;</button>
    <button class="slider-btn next" onclick="nextSlide()">&#10095;</button>
  </div>

  <!-- Advertisement Banner -->
  <div class="ad-banner">
    <p>Get 20% off on your next booking! Use code <strong>FUTSAL20</strong> at checkout.</p>
  </div>

  <h1>Explore Futsal Courts</h1>

  <!-- Most Popular Courts --> 
  <section class="section">
    <h2 class="section-title left">Most Popular Courts</h2>
    <div class="card-container">
      <div class="card">
        <img src="images/futsal.jpg" alt="Velocity Arena" />
        <h4 class="court-name">Velocity Arena</h4>
        <p class="description">Spacious indoor turf with pro lighting, ideal for quick matches.</p>
        <a href="#" class="book-btn">Book Now</a>
      </div>
      <div class="card">
        <img src="images/futsal.jpg" alt="Prime Turf" />
        <h4 class="court-name">Primes</h4>
        <p class="description">Indoor arena with smooth surface and evening game slots daily.</p>
        <a href="#" class="book-btn">Book Now</a>
      </div>
      <div class="card">
        <img src="images/futsal.jpg" alt="Nexon Futsal" />
        <h4 class="court-name">Sky Futsal</h4>
        <p class="description">Standard 5-a-side pitch with great turf and comfortable seating.</p>
        <a href="#" class="book-btn">Book Now</a>
      </div>
      <div class="card">
        <img src="${pageContext.request.contextPath}/resource/fustal/kumari.png" alt="Urban Kick" />
        <h4 class="court-name">Kathmandu Futsal</h4>
        <p class="description">Quality artificial grass with clean environment and side nets.</p>
        <a href="#" class="book-btn">Book Now</a>
      </div>
    </div>
  </section>

  <!-- Premium Courts -->
  <section class="section">
    <h2 class="section-title left">Premium Courts</h2>
    <div class="card-container">
      <div class="card premium">
        <img src="images/futsal.jpg" alt="Legend Grounds" />
        <h4 class="court-name">Royal Futsal</h4>
        <p class="description">Large synthetic pitch for fast-paced play and group sessions.</p>
        <a href="#" class="book-btn">Book Now</a>
      </div>
      <div class="card premium">
        <img src="images/futsal.jpg" alt="Striker's Den" />
        <h4 class="court-name">S.Glory Futsal</h4>
        <p class="description">Wide outdoor arena, perfect for groups and casual tournaments.</p>
        <a href="#" class="book-btn">Book Now</a>
      </div>
      <div class="card premium">
        <img src="images/futsal.jpg" alt="TurfX Arena" />
        <h4 class="court-name">Futsal Arena Bouddha</h4>
        <p class="description">Evening-friendly turf with overhead netting and chill zones.</p>
        <a href="#" class="book-btn">Book Now</a>
      </div>
      <div class="card premium">
        <img src="images/futsal.jpg" alt="Futsal Hub" />
        <h4 class="court-name">Dhanyentari Futsal</h4>
        <p class="description">Modern facility with comfortable seating and refreshment stalls.</p>
        <a href="#" class="book-btn">Book Now</a>
      </div>
    </div>
  </section>

  <!-- Google Map Location -->
  <div class="map-container">
    <h2 class="section-title left">Find Us on the Map</h2>
    <iframe 
      src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3532.053728731841!2d85.3123296150603!3d27.708955032783834!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39eb198eafbb9c29%3A0xf344ac77a665f86f!2sKathmandu%20Futsal!5e0!3m2!1sen!2snp!4v1641223456789!5m2!1sen!2snp" 
      width="100%" 
      height="400" 
      style="border:0;" 
      allowfullscreen="" 
      loading="lazy" 
      referrerpolicy="no-referrer-when-downgrade">
    </iframe>
  </div>

</body>
</html>