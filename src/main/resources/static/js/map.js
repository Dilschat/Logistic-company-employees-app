'use strict';
mapboxgl.accessToken = 'pk.eyJ1IjoidmljYXJvIiwiYSI6ImNqbmlxeGp2czBycGIzcW9zYmFheWZnbnMifQ.cisqDTqvlS5vIoJueqTIGg';
var map = new mapboxgl.Map({
              container: 'map',
              style: 'mapbox://styles/mapbox/streets-v9',
              zoom: 2
            });


var socket = new SockJS('/ws');
var stompClient = Stomp.over(socket);

var markersMap = {};


map.on('load', function(){
    getTrucks();
    stompClient.connect({}, onConnected, onError);
})

function onConnected() {
    stompClient.subscribe('/topic/trucks', onMessageReceived);
}

function onError(error) {
    console.log('Could not connect to WebSocket server.');
}

function onMessageReceived(payload) {

    var truck = JSON.parse(payload.body);

    var layer = map.getLayer(truck.id.toString());
    if (typeof layer != "undefined") {
        console.log("removing layer");
        map.removeLayer(truck.id.toString());
        map.removeSource(truck.id.toString());
    }
    addTruckToMap(truck);
}


function addTruckToMap(truck) {
     map.addLayer({
     "id":  truck.id.toString(),
         "type": "symbol",
         "source": {
         "type": "geojson",
         "data": {
             "type": "Feature",
             "geometry": {
                 "type": "Point",
                 "coordinates": [truck.longitude, truck.latitude]
             },
                 "properties": {
                     "title": truck.id.toString(),
                     "icon": "car"
                 }
             }
         },
         "layout": {
             "icon-image": "{icon}-15",
             "text-field": "{title}",
             "text-font": ["Open Sans Semibold", "Arial Unicode MS Bold"],
             "text-offset": [0, 0.6],
             "text-anchor": "top"
         }
     });
 }

function getWarehouses() {
    const Http = new XMLHttpRequest();
    const url='http:localhost:8083/map/warehouses';
    Http.open("GET", url);
    Http.send();
    Http.onreadystatechange=(e)=>{
        console.log(Http.responseText)
    }
 }

function getTrucks() {
    const Http = new XMLHttpRequest();
    const url='http://localhost:8083/all_trucks';
    Http.open("GET", url);
    Http.send();
    Http.onreadystatechange=(e)=>{
        console.log(Http.responseText)
        var trucks = JSON.parse(Http.responseText);
        console.log(trucks)

        trucks.forEach(function(truck){
            console.log("single truck");
			console.log(truck);
			console.log(truck.id);
			console.log(truck.longitude);
			addTruckToMap(truck);
		});
    }
 }