package com.employee.app.Employee.app.service.helpers;

/**
 * Created by niyaz on 01.11.2018.
 */
public class RolesHelper {

    public static String RoleIdToString(int id){
        if (id == 1){
            return "Customer";
        } else if(id == 2){
            return "SysAdmin";
        } else if(id == 3){
            return "SiteAdmin";
        } else if(id == 4){
            return "TopManager";
        } else if(id == 5){
            return "OrderOperator";
        } else if(id == 6){
            return "ControllOperator";
        } else if(id == 7){
            return "TruckDriver";
        } else if(id == 8){
            return "DeliveryOperator";
        } else {
            return "Blocked";
        }
    }
}
