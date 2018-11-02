package com.employee.app.Employee.app;

import com.employee.app.Employee.app.service.daemons.OrdersToApproveManager;
import com.employee.app.Employee.app.service.daemons.WarehousesManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
		OrdersToApproveManager.run();
		WarehousesManager.run();
	}
}
