/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.eltrauni.xml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ijrobotics.eltrauni.bean.uni;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Software-02
 */
public class xml2json {

    private final static String XML_FILE = "lims0001.xml";

    public xml2json() {
        try {
            uni uni = limsDesirialize(new FileInputStream(new File(XML_FILE)));
            System.out.println("uni" + convertToJson(uni));
        } catch (JAXBException | FileNotFoundException ex) {
            Logger.getLogger(xml2json.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        xml2json obj = new xml2json();
    }

    /**
     * *
     * Code
     *
     * @param in InputStream from lims.xml report from uni software
     * @return POJO from uni class
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public static uni limsDesirialize(InputStream in) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(uni.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (uni) unmarshaller.unmarshal(in);
    }

    public static String convertToJson(uni uni) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();
        return gson.toJson(uni, uni.class);
    }
}
