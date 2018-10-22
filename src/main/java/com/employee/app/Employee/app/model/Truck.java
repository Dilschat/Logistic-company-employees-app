package com.employee.app.Employee.app.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude
@JsonPropertyOrder({"id","longitude", "latitude", "type" })
public class Truck {

    private long id;
    private double longitude, latitude;
    private final String type = "truck";

    public Truck(){}
    public Truck(long id, double x, double y) {
        this.id = id;
        this.longitude = x;
        this.latitude = y;

    }

    @JsonCreator
    public static Truck build(
        @JsonProperty("id") long id,
        @JsonProperty("longitude") double longitude,
        @JsonProperty("latitude") double latitude,
        @JsonProperty("type") String type
    ){
        Truck truck = new Truck();
        truck.setId(id);
        truck.setLatitude(latitude);
        truck.setLongitude(longitude);
        return truck;
    }
    @JsonProperty("id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    @JsonProperty("type")
    public String getType(){
        return type;
    }
}

