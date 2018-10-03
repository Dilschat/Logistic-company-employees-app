package com.company.Employee.app.model;



import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;

@Component
public class CanvasjsChartDaoImpl implements CanvasjsChartDao {

    @Override
    public List<List<Map<Object, Object>>> getCanvasjsChartData() {
        return CanvasjsChartData.getCanvasjsDataList();
    }

}
