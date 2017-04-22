/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model.interfaces;

import java.util.Map;

/**
 *
 * @author Phidias Burnell
 */

public interface Machine {

      
    public enum statusFlag {
		GREEN, AMBER, RED
	}
    
    /**
     *
     * @param sensordata from each machine initialised 
     */
    public void initialiseSensors(String[] sensordata);
    
    /**
     * creates a new sensor and determines ID
     * @param sensor add sensor to the machine
     */
    public void addSensor(Sensor sensor);
   
    /**
     *
     * @return return a string which contains sensor ID, timestamp, sensor data, 
     * calculated status flag (green, amber, or red), and count for binary sensors.
     */
    public statusFlag[] calculateMachineStatus();
    
    /**
     *
     * @return the ID of the machine as a string
     */
    public String getMachineID();
    
    /**
     *
     * @param id
     * @return
     */
    public Sensor getSensor(String id);
    
    /**
     *
     * @return
     */
    public Map <String, Sensor> getSensors();
    
    /**
     *
     * @return
     */
    public statusFlag[] getTestArray();
}
