package com.employee.app.Employee.app;

import com.employee.app.Employee.app.daemons.OrdersToApproveManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
		new OrdersToApproveManager().run();
	}
}
