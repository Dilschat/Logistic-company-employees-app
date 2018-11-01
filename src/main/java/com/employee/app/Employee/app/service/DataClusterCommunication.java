package com.employee.app.Employee.app.service;


import com.employee.app.Employee.app.model.*;
import com.employee.app.Employee.app.service.helpers.RetrofitHelper;
import com.employee.app.Employee.app.service.helpers.RolesHelper;
import com.employee.app.Employee.app.service.interfaces.GetEmployeesList;
import com.employee.app.Employee.app.service.interfaces.OrdersToApproveRequest;
import com.employee.app.Employee.app.service.interfaces.UserByLoginRequest;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
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

        if(response.body() != null) {
            System.out.println(response.body().getPasswordHash());
            LoginResponse result = new LoginResponse(login, response.body().getPasswordHash(),
                    RolesHelper.RoleIdToString(response.body().getAccessRightsId()),
                    response.body().getError());
            return result;
        }
        return new LoginResponse(login, "", "", "");
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
     * API request to data cluster for apporving some order
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

    /**
     * API request to data cluster for adding new employee into the database
     * @param employee to add to database
     * @return
     * @throws IOException
     */
    public static RequestError registerNewEmployee(Employee employee) throws IOException {
        Call<RequestError> call = RetrofitHelper.registerNewEmployee(employee);

        Response<RequestError> response =
                call.execute();
        return response.body();
    }

    /**
     * API request to data cluster for deleting user from the system
     * @param login of the user to delete
     * @return
     * @throws IOException
     */
    public static RequestError deleteEmployee(String login) throws IOException {
        Call<RequestError> call = RetrofitHelper.deleteEmployee(login);

        Response<RequestError> response =
                call.execute();
        return response.body();
    }

    /**
     * API request to data cluster for getting list of all employees in the system
     * @return object with error or list of employees
     * @throws IOException
     */
    public static GetEmployeesList.EmployeesList getEmployeesList() throws IOException {
        Call<GetEmployeesList.EmployeesList> call = RetrofitHelper.getEmployeesList();

        Response<GetEmployeesList.EmployeesList> response =
                call.execute();
        return response.body();
    }

    /**
     * API request to data cluster for changing access right of the employee
     * gets login of a user and new role of the user
     * @return
     * @throws IOException
     */
    public static RequestError changeEmployeesAccessRights(String login, String role) throws IOException {
        Call<RequestError> call = RetrofitHelper.changeEmployeesAccessRights(login, role);

        Response<RequestError> response =
                call.execute();
        return response.body();
    }

    public List<DispatchedOrder> geDispatchedOrders(){
        return new ArrayList<>();
    }

    public DispatchedOrder geDispatchedOrder(String id){
        return new DispatchedOrder();
    }
}