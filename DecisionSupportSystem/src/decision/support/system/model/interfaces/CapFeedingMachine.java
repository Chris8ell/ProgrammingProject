/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model.interfaces;

/**
 *
 * @author Phidias Burnell
 */
public interface CapFeedingMachine {
    static final String[] SENSORID = new String[] {
                "01",
                "02",
                "03",
                "04",
                "05"};
   
    static String[] CAP_FEED_MACHINE_SENSORS = new String[] {
                SENSORID[0]+":"+Sensor.sensorType.BINARY, 
                SENSORID[1]+":"+Sensor.sensorType.BINARY, 
                SENSORID[2]+":"+Sensor.sensorType.BINARY, 
                SENSORID[3]+":"+Sensor.sensorType.BINARY, 
                SENSORID[4]+":"+Sensor.sensorType.RANGE};
}
