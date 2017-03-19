package com.example.leonardlee.iotasynctask;

import java.util.Random;

/**
 * Created by leonardlee on 18/03/2017.
 */

public class SensorData {
    private int temperature;
    private int humidity;
    private int activity;

    // Constructor
    public SensorData(){
        Random random = new Random();
        this.temperature = random.nextInt(121);
        this.humidity = random.nextInt(101);
        this.activity = random.nextInt(501);
    }

    // Setter and Getter for Temperature
//    public void setTemperature(int temp) {
//        this.temperature = temp;
//    }

    public int getTeperature() {
        return temperature;
    }

    // Setter and Getter for Humidity
//    public void setHumidity(int humidity) {
//        this.humidity = humidity;
//    }

    public int getHumidity() {
        return humidity;
    }

    // Setter and Getter for Activity
//    public void setActivity(int activity) {
//        this.activity = activity;
//    }

    public int getActivity() {
        return activity;
    }
}
