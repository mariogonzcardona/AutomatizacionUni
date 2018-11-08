/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.eltrauni.main;

import com.ijrobotics.eltrauni.utils.UniController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.sikuli.script.App;

/**
 *
 * @author Software-02
 */
public class MainApplication {

    App uniApp;
    UniController cs800;
    StringProperty currentStatus;
    StringProperty progressBar;
    ScheduledExecutorService statusListener;
    AtomicBoolean disableStatusListener;
    String url;

    public MainApplication()  {

        cs800 = new UniController();
        url = "C:/ELTRA GmbH/Uni/Bin/Uni.exe";
//        cs800.whenJavaSerializedToXmlStr_thenCorrect();
//        cs800.whenJavaSerializedToXmlFile_thenCorrect();
//        cs800.whenJavaGotFromXmlStr_thenCorrect();
//        cs800.getResultLIMS();
        
       
//        disableStatusListener = new AtomicBoolean(false);
//
//        //Status
//        currentStatus = new SimpleStringProperty("");
//        currentStatus.addListener((obs, oldValue, newValue) -> onStatusUpdated(oldValue, newValue));
//        
//        //Hilo de Ejecucion
//        statusListener = Executors.newScheduledThreadPool(1);
//        statusListener.scheduleWithFixedDelay(statusTask(), 0, 50, TimeUnit.MILLISECONDS);
    }

    private Runnable statusTask() {
        Runnable task = () -> {
            if (!disableStatusListener.get()) {
                currentStatus.set(cs800.getAnalysisStatus());
            }
        };
        return task;
    }

    private void onStatusUpdated(String oldValue, String newValue) {
        System.out.println("Status: " + newValue);
        System.out.println("Progress: " + cs800.getProgress() + "%");
    }

    public static void main(String[] args) {
        MainApplication app = new MainApplication();
    }
}
