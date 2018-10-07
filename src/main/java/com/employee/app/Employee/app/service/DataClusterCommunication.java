package com.employee.app.Employee.app.service;


import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.model.LoginResponse;
import com.employee.app.Employee.app.model.RequestError;
import com.employee.app.Employee.app.service.interfaces.OrdersToApproveRequest;
import com.employee.app.Employee.app.service.interfaces.UserByLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
@Component
public class DataClusterCommunication {

    /**
     * connects to the data cluster and gets information about user by login
     * @param login user's login
     * @return LoginResponse with information about the user
     * @throws IOException sometimes(((
     */
    public static LoginResponse userByLogin(String login) throws IOException {
        Call<UserByLoginRequest.UserInfo> call = RetrofitHelper.userByLogin(login);
        Response<UserByLoginRequest.UserInfo> response = call.execute();

        LoginResponse result = new LoginResponse(login, response.body().getPassword(),
                response.body().getRole(), response.body().getError());
        return result;
    }

    /**
     * returns all orders that must be approved
     * @return
     * @throws IOException
     */
    public static List<Order> getOrderToApprove() throws IOException {
        Call<OrdersToApproveRequest.OrdersToApproveResponse> call = RetrofitHelper.ordersToApprove();

        Response<OrdersToApproveRequest.OrdersToApproveResponse> response =
                call.execute();
        return response.body().getOrders();
    }

    /**
     * API request to data clister for apporving some order
     * @param order to approve
     * @return
     * @throws IOException
     */
    public static RequestError approveOrder(Order order) throws IOException {
        Call<RequestError> call = RetrofitHelper.approveOrder(order);

        Response<RequestError> response =
                call.execute();
        return response.body();
    }
}