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
@XmlRootElement(name = "header")
@XmlAccessorType(XmlAccessType.FIELD)
public class header {
    
    private double version;
    private String profile;
    private String device;
    private boolean loader;
    private int channels;
    private String elements;
    private String date;
    private String time;

    public double getVersion() {
        return version;
    }

    public String getProfile() {
        return profile;
    }

    public String getDevice() {
        return device;
    }

    public boolean isLoader() {
        return loader;
    }

    public int getChannels() {
        return channels;
    }

    public String getElements() {
        return elements;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    } 
}
