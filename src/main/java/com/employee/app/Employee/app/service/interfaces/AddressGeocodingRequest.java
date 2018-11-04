package com.employee.app.Employee.app.service.interfaces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by niyaz on 04.11.2018.
 */
public interface AddressGeocodingRequest {

    @GET("/search")
    Call<GeocodingResponse> getWarehousesList(@Query("limit") int limit, @Query("apikey") String apikey, @Query("q") String address);



    public class GeocodingResponse {

        @SerializedName("result")
        @Expose
        private List<Result> result = null;

        public List<Result> getResult() {
            return result;
        }

        public void setResult(List<Result> result) {
            this.result = result;
        }

    }

    public class Position {

        @SerializedName("lat")
        @Expose
        private double lat;
        @SerializedName("lon")
        @Expose
        private double lon;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

    }

    public class Result {

        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("display_name")
        @Expose
        private String displayName;
        @SerializedName("fias_id")
        @Expose
        private String fiasId;
        @SerializedName("position")
        @Expose
        private Position position;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("type")
        @Expose
        private String type;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getFiasId() {
            return fiasId;
        }

        public void setFiasId(String fiasId) {
            this.fiasId = fiasId;
        }

        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }
}
