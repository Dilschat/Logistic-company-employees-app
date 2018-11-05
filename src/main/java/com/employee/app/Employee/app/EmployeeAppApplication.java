package com.employee.app.Employee.app;

import com.employee.app.Employee.app.service.daemons.OrdersToApproveManager;
import com.employee.app.Employee.app.service.daemons.WarehousesManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
		OrdersToApproveManager.run();
		WarehousesManager.run();
	}

	@Bean
	public ErrorPageRegistrar errorPageRegistrar(){
		return new CustomErrorPageRegistrar();
	}

	private static class CustomErrorPageRegistrar implements ErrorPageRegistrar {

		// Register your error pages and url paths.
		@Override
		public void registerErrorPages(ErrorPageRegistry registry) {
			registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
			registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
			registry.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/401"));
			registry.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
			registry.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
			registry.addErrorPages(new ErrorPage(HttpStatus.NOT_IMPLEMENTED, "/501"));
			registry.addErrorPages(new ErrorPage(HttpStatus.BAD_GATEWAY, "/502"));
			registry.addErrorPages(new ErrorPage(HttpStatus.SERVICE_UNAVAILABLE, "/503"));
			registry.addErrorPages(new ErrorPage(HttpStatus.MULTI_STATUS, "/520"));
			registry.addErrorPages(new ErrorPage(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "/521"));









		}

	}
}
