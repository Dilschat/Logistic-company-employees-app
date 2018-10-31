'use strict';
mapboxgl.accessToken = 'pk.eyJ1IjoidmljYXJvIiwiYSI6ImNqbmlxeGp2czBycGIzcW9zYmFheWZnbnMifQ.cisqDTqvlS5vIoJueqTIGg';
var map = new mapboxgl.Map({
              container: 'map',
              style: 'mapbox://styles/mapbox/streets-v9',
              zoom: 2
            });

var socket = new SockJS('/ws');
var stompClient = Stomp.over(socket);

stompClient.connect({}, onConnected, onError);


function onConnected() {
    stompClient.subscribe('/topic/public', onMessageReceived);
}

function onError(error) {
    console.log('Could not connect to WebSocket server.');
}

function onMessageReceived(payload) {

    var truck = JSON.parse(payload.body);
    console.log(truck.longitude);
    console.log(truck.latitude);
    console.log(truck.id);

    var layer = map.getLayer(truck.id.toString());
    if (typeof layer != "undefined") {
        console.log("removing layer");
        map.removeLayer(truck.id.toString());
        map.removeSource(truck.id.toString());
    }
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