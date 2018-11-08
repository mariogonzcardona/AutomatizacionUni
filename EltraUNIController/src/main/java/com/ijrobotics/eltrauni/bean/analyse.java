/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.eltrauni.bean;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Software-02
 */
@XmlRootElement(name = "analyse")
@XmlAccessorType(XmlAccessType.FIELD)
public class analyse {
    private String date;
    private String time;
    private String application;
    private double pressure;
    private String sample;
    private double weight;
    private int duration;
    private int timemin;
    private int timemax;

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getApplication() {
        return application;
    }

    public double getPressure() {
        return pressure;
    }

    public String getSample() {
        return sample;
    }

    public double getWeight() {
        return weight;
    }

    public int getDuration() {
        return duration;
    }

    public int getTimemin() {
        return timemin;
    }

    public int getTimemax() {
        return timemax;
    }

    
}
