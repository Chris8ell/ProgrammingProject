/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.model.interfaces;

import java.util.Map;


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
     * @return Machine name
     */
    public String getMachineName();
    
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
