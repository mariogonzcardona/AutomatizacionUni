/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.eltrauni.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

/**
 *
 * @author Software-02
 */
public class UniController {

    private App uniApp;
    private Screen screen;
    private Pattern off, on, scan;
    private Region rgOff, rgOn, rgScan;
    private int codeMode;
    private DecimalFormat dfMode;
    private boolean startAnalysis;
    //private ArrayList<String> crrt_task;
    private int task_counter;
    StatusListEnum statusEnum;
    String output;
    XmlMapper mapper = new XmlMapper();

    public UniController() {
        screen = new Screen();
        off = null;
        on = null;
        scan = null;
        rgOff = null;
        rgOn = null;
        rgScan = null;
        codeMode = 0;
        dfMode = new DecimalFormat("#0.00");
        startAnalysis = true;
        task_counter = 0;
        output = "";
    }

    public void startUni(String url) {
        uniApp.open(url);
        screen.wait(2.0);
    }

    public void enterProfile() {
        screen.keyDown(KeyEvent.VK_ENTER);
        screen.keyUp(KeyEvent.VK_ENTER);
        screen.wait(2.0);
    }

    public int mode() {
        try {
            off = new Pattern("src/main/java/com/ijrobotics/eltrauni/images/offlineError.png").similar(0.5f);
            rgOff = screen.find(off);
            Double match = Double.valueOf(dfMode.format(rgOff.find(off.similar(0.5f)).getScore()));

            if (match > 0.80) {
                codeMode = 201;
                System.out.println("Error: Offline Mode, Code: " + codeMode);
                screen.keyDown(KeyEvent.VK_TAB);
                screen.keyUp(KeyEvent.VK_TAB);
                screen.keyDown(KeyEvent.VK_ENTER);
                screen.keyUp(KeyEvent.VK_ENTER);
                screen.wait(3.0);
            } else if (screen.contains(rgOn)) {
                codeMode = 100;
                System.out.println("Start Uni Software Online, Code: " + codeMode);
                screen.wait(2.0);
            }
        } catch (FindFailed ex) {
            Logger.getLogger(UniController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codeMode;
    }

    public void selectID() {
        try {
            Pattern patron = new Pattern("src/main/java/com/ijrobotics/eltrauni/images/firstClick.png").similar(0.5f);
            Region region = screen.find(patron);
            if (screen.contains(region)) {
                screen.click(patron);
            }
        } catch (Exception e) {

        }
    }

    public void setID(String id) {
        screen.type(id);
        screen.wait(1.0);
        jumpWeigth();
    }

    public void jumpWeigth() {
        screen.keyDown(KeyEvent.VK_TAB);
        screen.keyUp(KeyEvent.VK_TAB);
        screen.wait(1.0);
    }

    public void setWeigth(String weigth) {
        screen.type(weigth);
        screen.wait(1.0);
        jumpApplication();
    }

    public void jumpApplication() {
        screen.keyDown(KeyEvent.VK_TAB);
        screen.keyUp(KeyEvent.VK_TAB);
    }

    public void setApplication(int index) {

        screen.keyDown(KeyEvent.VK_DOWN);
        screen.keyUp(KeyEvent.VK_DOWN);
        screen.wait(1.0);

        screen.keyDown(KeyEvent.VK_PAGE_UP);
        screen.keyUp(KeyEvent.VK_PAGE_UP);
        screen.wait(1.0);

        for (int i = 1; i < index; i++) {
            screen.keyDown(KeyEvent.VK_DOWN);
            screen.keyUp(KeyEvent.VK_DOWN);
        }

        screen.keyDown(KeyEvent.VK_SHIFT);
        screen.keyDown(KeyEvent.VK_ENTER);
        screen.keyUp(KeyEvent.VK_ENTER);
        screen.keyUp(KeyEvent.VK_SHIFT);
        screen.wait(2.0);
    }

    public void upFurnance() {
        screen.keyDown(KeyEvent.VK_F2);
        screen.keyUp(KeyEvent.VK_F2);
    }

    public void downFurnace() {
        screen.keyDown(KeyEvent.VK_F2);
        screen.keyUp(KeyEvent.VK_F2);
    }

    public void startFurnance() {
        screen.keyDown(KeyEvent.VK_F5);
        screen.keyUp(KeyEvent.VK_F5);
        startAnalysis = true;
    }

    public void abortFurnace() {
        try {
            screen.click("src/main/java/com/ijrobotics/eltrauni/images/abortFurnace.png");
        } catch (FindFailed ex) {
            Logger.getLogger(UniController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopFurnace() {
        try {
            screen.click("src/main/java/com/ijrobotics/eltrauni/images/stopFurnace.png");
        } catch (FindFailed ex) {
            Logger.getLogger(UniController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getAnalysisStatus() {
        Region rg = new Region(106, 440, 100, 25);
//        rg.setRect(106, 440, 100, 25);
//        rg.highlight(2);
        String rawResult = rg.text();

        if (startAnalysis == true) {
            if (rawResult.startsWith("Closing")) {
                task_counter = 1;
                codeMode = statusEnum.CLOSING_FURNACE.getId();
                output = statusEnum.CLOSING_FURNACE.getStatus();
            } else if (rawResult.startsWith("Waiting")) {
                task_counter = 2;
                output = statusEnum.WAITING_FOR_STABILITY.getStatus();
                codeMode = statusEnum.WAITING_FOR_STABILITY.getId();
            } else if (rawResult.startsWith("Integration")) {
                task_counter = 3;
                output = statusEnum.INTEGRATION_DELAY.getStatus();
                codeMode = statusEnum.INTEGRATION_DELAY.getId();
            } else if (rawResult.startsWith("Analyzing")) {
                task_counter = 4;
                output = statusEnum.ANALYZING.getStatus();
                codeMode = statusEnum.ANALYZING.getId();
            } else if (rawResult.startsWith("Opening")) {
                task_counter = 5;
                output = statusEnum.OPENING_FURNACE.getStatus();
                codeMode = statusEnum.OPENING_FURNACE.getId();
            } else if (rawResult.startsWith("NoOxygen")) {
                output = statusEnum.NO_OXYGEN_PRESSURE.getStatus();
                codeMode = statusEnum.NO_OXYGEN_PRESSURE.getId();
            } else if (rawResult.startsWith("")) {
                output = statusEnum.UNKNOWN.getStatus();
                codeMode = statusEnum.UNKNOWN.getId();
                scanFinishResult();
            }
//           System.out.println(rawResult);
        }
        return output;
    }

    public void scanFinishResult() {
        try {
            //Recuerda Cambiar Imagen por la resolucion de Uni y no del Video
            scan = new Pattern("src/main/java/com/ijrobotics/eltrauni/images/analysis2.png");
            rgScan = screen.find(scan);
            Double match = Double.valueOf(dfMode.format(rgScan.find(scan.similar(0.5f)).getScore()));
//            System.out.println(match);
            if (match < 0.98) {
                task_counter = 6;
                codeMode = statusEnum.FINISHED_ANALYSIS.getId();
                output = statusEnum.FINISHED_ANALYSIS.getStatus();
                startAnalysis = false;
            }
        } catch (FindFailed ex) {
            Logger.getLogger(UniController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getProgress() {
        double progress = 0.00;
        if (task_counter > 0) {
            double counter = Double.valueOf(task_counter);
            progress = Double.valueOf(dfMode.format((counter / 6) * 100));
        }
        return progress;
    }

    public void startProfile(String id, String weight_sample, int application) {
        setID(id);
        setWeigth(weight_sample);
        setApplication(application);
    }

}
