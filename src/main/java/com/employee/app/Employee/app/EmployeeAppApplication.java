package com.employee.app.Employee.app;

import com.employee.app.Employee.app.service.daemons.OrdersToApproveManager;
import com.employee.app.Employee.app.service.daemons.WarehousesManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
		OrdersToApproveManager.run();
		WarehousesManager.run();
	}
}
