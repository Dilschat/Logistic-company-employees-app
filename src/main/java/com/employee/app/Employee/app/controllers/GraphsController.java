package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.service.CanvasjsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/graph")
public class GraphsController {

    @Autowired
    private CanvasjsChartService canvasjsChartService;

    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public String chart(ModelMap modelMap) {
        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
        modelMap.addAttribute("dataPointsList", canvasjsDataList);
        return "chart";
    }

    @RequestMapping(value = "/column_chart", method = RequestMethod.GET)
    public String column_chart(ModelMap modelMap) {
        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsColumnChartData();
        modelMap.addAttribute("dataPointsList", canvasjsDataList);
        return "column_chart";
    }




}
