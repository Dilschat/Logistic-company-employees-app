package com.employee.app.Employee.app.service;

import com.employee.app.Employee.app.service.interfaces.OrdersToApproveRequest;
import com.employee.app.Employee.app.service.interfaces.UserByLoginRequest;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by niyaz on 30.09.2018.
 */
public class RetrofitHelper {

    private static final String BASE_URL = "http://10.240.17.182:5000";

    public static Call<UserByLoginRequest.UserInfo> userByLogin(String login){
        UserByLoginRequest retrofit = getRetrofit().create(UserByLoginRequest.class);
        return retrofit.userByLogin(login);
    }

    public static Call<OrdersToApproveRequest.OrdersToApproveResponse> ordersToApprove(){
        OrdersToApproveRequest retrofit = getRetrofit().create(OrdersToApproveRequest.class);
        return retrofit.ordersToApprove();
    }

    /**
     * @return configurated retrofit object
     */
    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}