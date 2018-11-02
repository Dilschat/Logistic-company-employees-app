package com.employee.app.Employee.app.service.helpers;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AddressType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeoHelper {
    final String baseUrl = "http://maps.googleapis.com/maps/api/geocode/json";
    private String address;
    private double latitude;
    private double longitude;
    private List<Double> coordinates; //the first element must be latitude, the second longitude
    private static GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyDkWWuPa3H_Z90L7z_f4gqGDSxVfzMc_8Y") //my google credentials.
            .build();
    private static GeocodingResult[] results;

    public GeoHelper() {
        coordinates = new ArrayList<>();
        address = "";
    }

    public GeoHelper(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        coordinates.add(latitude);
        coordinates.add(longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void addCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void addAddress(String address) {
        this.address = address;
    }

    private GeocodingResult[] getCoordinatesByAddress(String address) {
        try {
            results = GeocodingApi.geocode(context,
                    address).await();
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].formattedAddress));
        return results;
    }

    /**
     * static version of function below
     * @param address
     * @return
     */
    private static GeocodingResult[] getCoordinatesByAddressStatic(String address) {
        GeocodingResult[] res;
        try {
            res = GeocodingApi.geocode(context,
                    address).await();
            com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(res[0].formattedAddress));
            return res;
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getLatitudeByAddress(String address) {
        results = getCoordinatesByAddress(address);
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
        double latitude = Double.parseDouble(gson.toJson(results[0].geometry.location.lat));
        return latitude;
    }

    public double getLongitudeByAddress(String address) {
        results = getCoordinatesByAddress(address);
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
        double longitude = Double.parseDouble(gson.toJson(results[0].geometry.location.lng));
        return longitude;
    }


    public String getAdressByCoordinates(double latitude, double longitude) {
        try {
            GeocodingResult[] results = GeocodingApi.newRequest(context)
                    .latlng(new LatLng(latitude, longitude)).language("en").resultType(AddressType.COUNTRY, AddressType.ADMINISTRATIVE_AREA_LEVEL_1).await();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results.toString();
    }

    public String getAddress() {
        if (!address.equals("")) {
            return address;
        }
        return getAdressByCoordinates(longitude, latitude);
    }
}
