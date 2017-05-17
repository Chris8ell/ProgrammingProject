/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.model.interfaces;

import java.util.Date;

public interface Sensor {
    
    public enum sensorType {
		BINARY, RANGE
	}

    /**
     * @param sensorData captures data from sensor
     * @param timeStamp for the sensor data when captured
     */
    public void setSensor(int sensorData, Date timeStamp);
    
    /**
     * @return the ID of this sensor
     */
    public String getSensorID();
    
    /**
     * @return the numeric value of this sensor
     */
    public int getSensorData();
    
    /**
     * @return the Timestamp of this sensor
     */
    public Date getTimeStamp();
    
    /**
     * @return the Type of this sensor
     */
    public sensorType getType();
    
    /**
     * @return the number of times the sensor was triggered based if binary
     */
    public int getTriggerCount();
}
