<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Про кинотеатр</title>
    <style>
        <%@ include file="/resources/css/cinema.css" %>
        #map_canvas {
            height: 500px;
        }
    </style>
    <!-- Google Maps and Places API -->
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&sensor=false"></script>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript">
        function initGeolocation() {
            if (navigator.geolocation) {

                // Call getCurrentPosition with success and failure callbacks
                navigator.geolocation.getCurrentPosition(success, fail);
            }
            else {
                alert("Sorry, your browser does not support geolocation services.");
            }
        }

        var map;
        function success(position) {
            // Define the coordinates as a Google Maps LatLng Object
            //var coords = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
            var coords = new google.maps.LatLng(50.39606807, 30.63208759);

            // Prepare the map options
            var mapOptions =
            {
                zoom: 14,
                center: coords,
                mapTypeControl: false,
                navigationControlOptions: {style: google.maps.NavigationControlStyle.SMALL},
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

            // Create the map, and place it in the map_canvas div
            map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);

            // Place the initial marker
            var marker = new google.maps.Marker({
                position: coords,
                map: map,
                title: "Your current location!"
            });

        }

        function fail() {
            // Could not obtain location
        }

        //Request places from Google
        function placesRequest(title, latlng, radius, types, icon) {
            //Parameters for our places request
            var request = {
                location: latlng,
                radius: radius,
                types: types
            };
            //Make the service call to google
            var callPlaces = new google.maps.places.PlacesService(map);
            callPlaces.search(request, function (results, status) {
                //trace what Google gives us back
                $.each(results, function (i, place) {
                    var placeLoc = place.geometry.location;
                    var thisplace = new google.maps.Marker({
                        map: map,
                        position: place.geometry.location,
                        icon: icon,
                        title: place.name
                    });
                })
            });

        }
    </script>

</head>
<body onload="initGeolocation();">
<div class="top">
    <jsp:include page="fragments/header.jsp"/>
    <div class="registration">
        <jsp:include page="fragments/authorization.jsp"/>
    </div>
</div>
<hr>

<div class="about_info">
    Адрес: г. Киев, ул. Вертолётчиков, 2/12.<br>
    Телефон: (044) 123-45-67, (093) 123-45-67<br>
    Мы на карте:<br>

<div id="map_canvas"
     style="height: 70%; width: 70%; margin-left: 15%; margin-bottom: 5%; border-right: 1px solid #666666; border-bottom: 1px solid #666666; border-top: 1px solid #AAAAAA; border-left: 1px solid #AAAAAA;"></div>
    Информация о кинотеатре...
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
