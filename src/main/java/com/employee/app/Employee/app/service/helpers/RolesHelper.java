package com.employee.app.Employee.app.service.helpers;

/**
 * Created by niyaz on 01.11.2018.
 */
public class RolesHelper {

    public static final String CUSTOMER = "Customer";
    public static final String SYS_ADMIN = "SysAdmin";
    public static final String SITE_ADMIN = "SiteAdmin";
    public static final String TOP_MANAGER = "TopManager";
    public static final String ORDER_OPERATOR = "OrderOperator";
    public static final String CONTROL_OPERATOR = "ControlOperator";
    public static final String TRUCK_DRIVER = "TruckDriver";
    public static final String DELIVERY_OPERATOR = "DeliveryOperator";
    public static final String BLOCKED = "Blocked";

    public static String RoleIdToString(int id){
        if (id == 1){
            return CUSTOMER;
        } else if(id == 2){
            return SYS_ADMIN;
        } else if(id == 3){
            return SITE_ADMIN;
        } else if(id == 4){
            return TOP_MANAGER;
        } else if(id == 5){
            return ORDER_OPERATOR;
        } else if(id == 6){
            return CONTROL_OPERATOR;
        } else if(id == 7){
            return TRUCK_DRIVER;
        } else if(id == 8){
            return DELIVERY_OPERATOR;
        } else {
            return BLOCKED;
        }
    }
}
