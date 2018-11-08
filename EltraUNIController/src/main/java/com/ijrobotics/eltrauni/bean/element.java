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
@XmlRootElement(name = "element")
@XmlAccessorType(XmlAccessType.FIELD)
public class element {
    
    private String name;
    private double value;

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
