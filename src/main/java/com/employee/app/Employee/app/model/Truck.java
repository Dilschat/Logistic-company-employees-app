package com.employee.app.Employee.app.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;


@JsonInclude
@JsonPropertyOrder({"id","longtitude", "latitude", "type" })
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
        @JsonProperty("longtitude") long longitude,
        @JsonProperty("latitude") long latitude,
        @JsonProperty("type") long type
    ){
        Truck truck = new Truck();
        if(id == 0) throw new IllegalArgumentException("id cant be equal to 0");
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
    @JsonProperty("longtitude")
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

