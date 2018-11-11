package com.employee.app.Employee.app.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CanvasjsChartService {

    List<List<Map<Object, Object>>> getCanvasjsChartData();

    List<List<Map<Object, Object>>> getCanvasjsColumnChartData();


}
