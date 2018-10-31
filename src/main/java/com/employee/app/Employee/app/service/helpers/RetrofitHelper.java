package com.employee.app.Employee.app.service.helpers;

import com.employee.app.Employee.app.model.Employee;
import com.employee.app.Employee.app.model.LoginRequest;
import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.model.RequestError;
import com.employee.app.Employee.app.service.interfaces.*;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by niyaz on 30.09.2018.
 */
public class RetrofitHelper {

    private static final String BASE_URL = "http://127.0.0.1:5000";

    public static Call<UserByLoginRequest.UserInfo> userByLogin(String login){
        UserByLoginRequest retrofit = getRetrofit().create(UserByLoginRequest.class);
        return retrofit.userByLogin(login);
    }

    public static Call<Login.UserInfo> login(LoginRequest login){
        Login retrofit = getRetrofit().create(Login.class);
        return retrofit.userByLogin(login);
    }

    public static Call<OrdersToApproveRequest.OrdersToApproveResponse> ordersToApprove(){
        OrdersToApproveRequest retrofit = getRetrofit().create(OrdersToApproveRequest.class);
        return retrofit.ordersToApprove();
    }

    public static Call<RequestError> approveOrder(Order order){
        ApproveOrder retrofit = getRetrofit().create(ApproveOrder.class);
        return retrofit.approveOrder(order);
    }

    public static Call<RequestError> registerNewEmployee(Employee employee) {
        RegisterNewEmployee retrofit = getRetrofit().create(RegisterNewEmployee.class);
        return retrofit.registerNewEmployee(employee);
    }

    public static Call<getDispatchedOrder.Order> getOrder(Integer id){
        getDispatchedOrder retrofit = getRetrofit().create(getDispatchedOrder.class);
        return retrofit.getOrder(id);
    }
    public static Call<GetEmployeesList.EmployeesList> getEmployeesList() {
        GetEmployeesList retrofit = getRetrofit().create(GetEmployeesList.class);
        return retrofit.getEmployeesList();
    }

    public static Call<GetDispatchedOrders.OrderList> getOrders(){
        GetDispatchedOrders retrofit = getRetrofit().create(GetDispatchedOrders.class);
        return retrofit.getOrders();

    }
    public static Call<RequestError> changeEmployeesAccessRights(String newLogin, String newRole) {
        ChangeEmployeesAccessRight retrofit = getRetrofit().create(ChangeEmployeesAccessRight.class);
        return retrofit.changeRights(newLogin, newRole);
    }

    public static Call<RequestError> deleteEmployee(String login) {
        DeleteEmployee retrofit = getRetrofit().create(DeleteEmployee.class);
        return retrofit.deleteEmployee(login);
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