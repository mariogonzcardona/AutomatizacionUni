/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.eltrauni.bean;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Software-02
 */
@XmlRootElement(name = "peak")
@XmlAccessorType(XmlAccessType.FIELD)
public class peak {

    private int number;
    private double average;
    private point point;

    public int getNumber() {
        return number;
    }

    public double getAverage() {
        return average;
    }

    public point getPoint() {
        return point;
    }

}
