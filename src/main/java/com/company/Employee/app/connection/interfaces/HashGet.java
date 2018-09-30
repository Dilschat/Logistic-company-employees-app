package com.company.Employee.app.connection.interfaces;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by niyaz on 30.09.2018.
 */
public interface HashGet {

    @Headers({"Content-Type: application/json"})
    @POST("/get_hash")
    Call<HashResponse> login(@Body String username);

    class HashResponse {
        private String hash, error;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
