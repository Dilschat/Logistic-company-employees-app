package com.employee.app.Employee.app.service.helpers;

import com.employee.app.Employee.app.service.interfaces.AddressGeocodingRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import javafx.util.Pair;
import retrofit2.Call;
import retrofit2.Response;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.util.List;

public class GeoHelper {
    private static GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyDkWWuPa3H_Z90L7z_f4gqGDSxVfzMc_8Y") //Anastasia's google credentials.
            .build();

    /**
     * static function to transform address to coordinates
     * @param address
     * @return
     */
    public static GeocodingResult[] getCoordinatesByAddressStatic(String address) {
        GeocodingResult[] res;
        try {
            res = GeocodingApi.geocode(context,
                    address).await();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(res[0].formattedAddress));
            System.out.println(res);
            return res;
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AddressGeocodingRequest.Position getCoordinatesByAddress(String address){
        Call<AddressGeocodingRequest.GeocodingResponse> call = RetrofitHelper.getCoordinates(address);

        try {
            Response<AddressGeocodingRequest.GeocodingResponse> response = call.execute();

            if (response.body() != null && response.body().getResult() != null
                    && response.body().getResult().size() > 0){

                return response.body().getResult().get(0).getPosition();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
