package com.company.Employee.app.connection;

import com.company.Employee.app.connection.interfaces.UserByLogin;
import com.company.Employee.app.model.LoginResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class DataClusterCommunication {

    /**
     * connects to the data cluster and gets information about user by login
     * @param login user's login
     * @return LoginResponse with information about the user
     * @throws IOException sometimes(((
     */
    public static LoginResponse userByLogin(String login) throws IOException {
        Call<UserByLogin.UserInfo> call = RetrofitHelper.userByLogin(login);
        Response<UserByLogin.UserInfo> response = call.execute();
        LoginResponse result = new LoginResponse(login, response.body().getPassword(),
                response.body().getRole(), response.body().getError());
        return result;
    }
}
