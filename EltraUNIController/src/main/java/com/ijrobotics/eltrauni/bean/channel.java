/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.eltrauni.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Software-02
 */
@XmlRootElement(name = "channel")
@XmlAccessorType(XmlAccessType.FIELD)
public class channel {
    
    private int number;
    private boolean enabled;
    private String element;
    private double result;
    private double zero;
    private double comporator;
    private double maximum;
    private int length;
    private double blank;
    private double basecalibration;
    private double calibration;
    private double linearity;
    private double multipoint;

    public int getNumber() {
        return number;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getElement() {
        return element;
    }

    public double getResult() {
        return result;
    }

    public double getZero() {
        return zero;
    }

    public double getComporator() {
        return comporator;
    }

    public double getMaximum() {
        return maximum;
    }

    public int getLength() {
        return length;
    }

    public double getBlank() {
        return blank;
    }

    public double getBasecalibration() {
        return basecalibration;
    }

    public double getCalibration() {
        return calibration;
    }

    public double getLinearity() {
        return linearity;
    }

    public double getMultipoint() {
        return multipoint;
    }

   
    
}
