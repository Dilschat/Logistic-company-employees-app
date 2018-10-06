package com.employee.app.Employee.app.service;


import com.employee.app.Employee.app.model.Response;
import com.employee.app.Employee.app.service.interfaces.UserByLogin;
import retrofit2.Call;

import java.io.IOException;

public class DataClusterCommunication {

    /**
     * connects to the data cluster and gets information about user by login
     * @param login user's login
     * @return Response with information about the user
     * @throws IOException sometimes(((
     */
    public static Response userByLogin(String login) throws IOException {
        Call<UserByLogin.UserInfo> call = RetrofitHelper.userByLogin(login);
        retrofit2.Response<UserByLogin.UserInfo> response = call.execute();
        Response result = new Response(login, response.body().getPassword(),
                response.body().getRole(), response.body().getError());
        return result;
    }
}