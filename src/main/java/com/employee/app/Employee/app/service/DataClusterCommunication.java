package com.employee.app.Employee.app.service;


import com.employee.app.Employee.app.model.DispatchedOrder;
import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.model.LoginResponse;
import com.employee.app.Employee.app.model.RequestError;
import com.employee.app.Employee.app.service.helpers.RetrofitHelper;
import com.employee.app.Employee.app.service.interfaces.OrdersToApproveRequest;
import com.employee.app.Employee.app.service.interfaces.UserByLoginRequest;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
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

    public List<DispatchedOrder> geDispatchedOrders(){
        List<DispatchedOrder> orders =  new ArrayList<>();
        DispatchedOrder order1 = new DispatchedOrder();
        order1.setId("1");
        order1.setReceiver_city("Innopolis");
        order1.setReceiver_country("Russia");
        order1.setProfitValue(new BigDecimal(100));
        order1.setProfitCurrency(Currency.getInstance("USD").getDisplayName());
        DispatchedOrder order2 = new DispatchedOrder();
        order2.setId("2");
        order2.setReceiver_city("NY");
        order2.setReceiver_country("USA");
        order2.setProfitValue(new BigDecimal(1000000000));
        order2.setProfitCurrency(Currency.getInstance("USD").getDisplayName());
        orders.add(order1);
        orders.add(order2);
        return orders;
    }

    public DispatchedOrder geDispatchedOrder(String id){
        if(id.equals("1")){
            DispatchedOrder order1 = new DispatchedOrder();
            order1.setId("1");
            order1.setReceiver_city("Innopolis");
            order1.setReceiver_country("Russia");
            order1.setProfitValue(new BigDecimal(100));
            order1.setProfitCurrency(Currency.getInstance("USD").getDisplayName());
            order1.setClientFeedback("I got my parcel very fast. I'm happy!");
            return order1;
        } else if(id.equals("2")){
            DispatchedOrder order2 = new DispatchedOrder();
            order2.setId("2");
            order2.setReceiver_city("NY");
            order2.setReceiver_country("USA");
            order2.setProfitValue(new BigDecimal(100000));
            order2.setProfitCurrency(Currency.getInstance("USD").getDisplayName());
            order2.setClientFeedback("I got my parcel very fast. I'm happy!");
            return order2;
        } else {
            return new DispatchedOrder();
        }


    }
}