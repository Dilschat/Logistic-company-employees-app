package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.Warehouse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.util.List;

/**
 * Created by niyaz on 01.11.2018.
 */
public interface GetWarehouses {

    @Headers({"Content-Type: application/json"})
    @GET("/get_warehouses ")
    Call<WarehousesResponse> getWarehousesList();

    public class WarehousesResponse {

        @SerializedName("error")
        @Expose
        private String error;
        @SerializedName("warehouses")
        @Expose
        private List<Warehouse> warehouses = null;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public List<Warehouse> getWarehouses() {
            return warehouses;
        }

        public void setWarehouses(List<Warehouse> warehouses) {
            this.warehouses = warehouses;
        }

    }
}
