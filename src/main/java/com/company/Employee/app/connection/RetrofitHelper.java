package com.company.Employee.app.connection;

import com.company.Employee.app.connection.interfaces.HashGet;
import com.company.Employee.app.connection.interfaces.LoginRequest;
import com.company.Employee.app.connection.interfaces.UserByLogin;
import org.apache.catalina.User;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by niyaz on 30.09.2018.
 */
public class RetrofitHelper {

    private static final String BASE_URL = "http://";

    public static Call<UserByLogin.UserInfo> userByLogin(String login){
        UserByLogin user = getRetrofit().create(UserByLogin.class);
        return user.userByLogin(login);
    }

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }


    /*
    deprecated methods
     */
    public static Call<LoginRequest.LoginResponseData> login(String username, String password) {
        LoginRequest api = getRetrofit().create(LoginRequest.class);
        LoginRequest.LoginData loginData =
                new LoginRequest.LoginData(username, password);
        return api.login(loginData);
    }

    public static Call<HashGet.HashResponse> getHash(String username) {
        HashGet api = getRetrofit().create(HashGet.class);
        return api.login(username);
    }
}
