package com.example.leonardlee.iotasynctask;

import java.util.ArrayList;

/**
 * Created by leonardlee on 18/03/2017.
 */


public class SensorDataList {
    private ArrayList<SensorData> list;

    public SensorDataList() {
        list = new ArrayList<>();
    }

    public ArrayList<SensorData> generate(int num) {
        for(int i=0; i<num; i++) {
            SensorData data = new SensorData();
            list.add(data);
        }
        return list;
    }
}
