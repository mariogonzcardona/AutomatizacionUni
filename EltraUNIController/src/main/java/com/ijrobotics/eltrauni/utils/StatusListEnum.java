/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijrobotics.eltrauni.utils;

/**
 *
 * @author Software-02
 */
public enum StatusListEnum {
    ONLINE_MODE(100, "Online Mode"),
    CLOSING_FURNACE(101, "Closing Furnace"),
    OPENING_FURNACE(102, "Opening Furnace"),
    ANALYZING(103, "Analyzing"),
    INTEGRATION_DELAY(104, "Integration Delay"),
    WAITING_FOR_STABILITY(105, "Waiting For Stability"),
    UNKNOWN(106, "Unknown"),
    FINISHED_ANALYSIS(107, "Finished Analysis"),
    EMERGENCY_STOP(200, "Emergency Stop"),
    OFFLINE_MODE(201, "Offline Mode"),
    STOP_PROCES_FURNACE(202, "Stop Proces Furnace"),
    ABORT_PROCES_FURNACE(203, "Abort Proces Furnace"),
    SAMPLE_NOT_DETECTED(204, "Sample not detected"),
    NO_OXYGEN_PRESSURE(205, "No Oxygen Pressure"),
    FAIL_CONNECTION_DRIVER(206, "Fail connection to driver");

    int id;
    String status;

    private StatusListEnum(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
