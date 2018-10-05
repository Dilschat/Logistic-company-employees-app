package com.company.Employee.app.controller;

import java.util.List;
import java.util.Map;

import com.company.Employee.app.service.CanvasjsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/graph")
public class GraphsController {

    @Autowired
    private CanvasjsChartService canvasjsChartService;

    @RequestMapping(method = RequestMethod.GET)
    public String springMVC(ModelMap modelMap) {
        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
        modelMap.addAttribute("dataPointsList", canvasjsDataList);
        return "jsp/chart";
    }

}