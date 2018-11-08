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
@XmlRootElement(name = "point")
@XmlAccessorType(XmlAccessType.FIELD)
public class point {
    
    private List<Double> v;

    public List<Double> getV() {
        return v;
    }
     
}
