package com.employee.app.Employee.app;

import com.employee.app.Employee.app.service.daemons.OrdersToApproveManager;
import com.employee.app.Employee.app.service.daemons.TruckPlaceManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
		new OrdersToApproveManager().run();
		Thread t1 = new Thread(new TruckPlaceManager());
		t1.setDaemon(true);
		t1.start();
	}
}
