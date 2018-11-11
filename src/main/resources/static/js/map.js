'use strict';
L.mapbox.accessToken = 'pk.eyJ1IjoidmljYXJvIiwiYSI6ImNqbmlxeGp2czBycGIzcW9zYmFheWZnbnMifQ.cisqDTqvlS5vIoJueqTIGg';
var map = L.mapbox.map('map', 'mapbox.streets')
    .setView([37.9, -77], 2);


var socket = new SockJS('/ws');
var stompClient = Stomp.over(socket);

var markersMap = {};

var currentUrl = window.location.origin;


map.on('ready', function(){
    getTrucks();
    getWarehouses();
    stompClient.connect({}, onConnected, onError);
});

function onConnected() {
    stompClient.subscribe('/topic/trucks', onMessageReceived);
}

function onError(error) {
    console.log('Could not connect to WebSocket server.');
}

function onMessageReceived(payload) {

    var truck = JSON.parse(payload.body);
    console.log(truck);

    addTruckToMap(truck);
}


function addTruckToMap(truck) {
    var oldTruck = markersMap[truck.id];
    if(typeof(oldTruck) != "undefined"){
        map.removeLayer(oldTruck);
    }

    var newMarker = L.marker([truck.latitude, truck.longitude], {
        icon: L.mapbox.marker.icon({
            'marker-size': 'large',
            'marker-symbol': 'bus',
            'marker-color': '#1886c9',
            'title': truck.id.toString()
        })
    });
    markersMap[truck.id] = newMarker;
    newMarker.bindPopup(truck.id.toString()).addTo(map);
}

function addWarehouseToMap(warehouse) {
    L.marker([warehouse.latitude, warehouse.longitude], {
        icon: L.mapbox.marker.icon({
            'marker-size': 'large',
            'marker-symbol': 'grocery',
            'marker-color': '#1886c9'
        })
    }).bindPopup(warehouse.address.toString()).addTo(map);
}

function getTrucks() {
    console.log("getting trucks");
    const Http = new XMLHttpRequest();
    const url=currentUrl + '/all_trucks';
    Http.open("GET", url);
    Http.send();
    Http.onreadystatechange=function(){
        console
        if(this.readyState == 4 && this.status == 200) {
            console.log(Http.responseText)
            var trucks = JSON.parse(Http.responseText);
            console.log(trucks)

            trucks.forEach(function(truck){
                addTruckToMap(truck);
            });
        }
    };
}

function getWarehouses() {
    console.log("getting warehouses");
    const Http = new XMLHttpRequest();
    const url=currentUrl + '/all_warehouses';
    Http.open("GET", url);
    Http.send();
    Http.onreadystatechange=function(){
        if(this.readyState == 4 && this.status == 200) {
            var warehouses = JSON.parse(Http.responseText);
            console.log(warehouses)

            warehouses.forEach(function(warehouse){
                addWarehouseToMap(warehouse);
            });
        }
    };
}