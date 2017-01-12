
<html>
<head>

<%@include file="links.jsp"%>
<script src="files/js/google.js"></script>
<script>
function myMap() {
  var mapCanvas = document.getElementById("map");
  var mapOptions = {
    center: new google.maps.LatLng(17.4417500, 78.4976656),
    zoom: 18
  }
  var map = new google.maps.Map(mapCanvas, mapOptions);
}
</script>
<title>Contact Us</title>
</head>
<%@include file="header.jsp"%>
<body class="contactus">

<div class="contact-container">
<div>
    
    <h1><p  class="contact-img-title">We Would like to hear from you with pleasure</p> </h1>
    
  </div>

</div>


<h1>My First Google Map</h1>

<div id="map" style="width:100%;height:500px"></div>


<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script> 

<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script> -->
<%@include file="footer.jsp"%>

</body>
</html>