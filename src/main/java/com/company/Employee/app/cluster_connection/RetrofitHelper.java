package com.company.Employee.app.cluster_connection;

import com.company.Employee.app.cluster_connection.interfaces.UserByLogin;
import org.apache.catalina.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by niyaz on 30.09.2018.
 */
public class RetrofitHelper {

    private static final String BASE_URL = "http://127.0.0.1:5000";

    public static Call<UserByLogin.UserInfo> userByLogin(String login){
        UserByLogin user = getRetrofit().create(UserByLogin.class);
        return user.userByLogin(login);
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