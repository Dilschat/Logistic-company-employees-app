package com.employee.app.Employee.app.model;


import java.util.*;

public class CanvasjsChartData {

    static Map<Object,Object> map = null;
    static List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
    static List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();

    static {
        int count = 24;
        int yVal = 10;
        Random rand = new Random();

        for(int i = 0; i < count+1; i++){
            yVal = rand.nextInt(11) ;
            map = new HashMap<Object,Object>(); map.put("x", i ); map.put("y", yVal); dataPoints1.add(map);
        }

        list.add(dataPoints1);
    }

    public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
        dataPoints1 = new ArrayList<>();
        list = new ArrayList<>();
        int count = 24;
        int yVal = 10;
        Random rand = new Random();

        for(int i = 0; i < count+1; i++){
            yVal = rand.nextInt(11) ;
            map = new HashMap<Object,Object>(); map.put("x", i ); map.put("y", yVal); dataPoints1.add(map);
        }

        list.add(dataPoints1);
        return list;
    }
}
