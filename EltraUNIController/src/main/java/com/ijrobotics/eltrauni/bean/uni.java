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
@XmlRootElement(name = "uni")
@XmlAccessorType(XmlAccessType.FIELD)
public class uni {
    private uni uni;
    private header header;
    private analyse analyse;
    private deficiency deficiency;
    private results results;
    private measurement measurement;
    private graph graph;

    public uni getUni() {
        return uni;
    }

    public header getHeader() {
        return header;
    }

    public analyse getAnalyse() {
        return analyse;
    }

    public deficiency getDeficiency() {
        return deficiency;
    }

    public results getResults() {
        return results;
    }

    public measurement getMeasurement() {
        return measurement;
    }

    public graph getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        return "uni{" + "uni=" + uni + ", header=" + header + ", analyse=" + analyse + ", deficiency=" + deficiency + ", results=" + results + ", measurement=" + measurement + ", graph=" + graph + '}';
    }
    
    
   
    
}
