/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.model.interfaces;

public interface CapFeedingMachine {
    static final String[] SENSORID = new String[] {
                "01",
                "02",
                "03",
                "04",
                "05"};
    
    static final String[] TESTS = new String[] {
                "If sensor 1 is triggered, sensor 2 should trigger within 2 seconds. 1 < amber, 2 < red",
                "If sensor 2 is trigerred sensor 3 should trigger within 0.5 second. 0.5 < amber, 1 < red",
                "If sensor 3 is triggered sensor 4 should trigger within 1 second if sensor 1 count is > 1. amber <2< red",
                "Sensor 3 count should always be less than or equal to sensor 2 count. red <-1...0 >= red",
                "Sensor 4 count should always be less than or equal to sensor 3 count. > red",
                "Sensor 5 should always be between 4000 and 5000. red <= 3500 <= amber <= 4000 ... 5000 => amber => 5500 => red"};
   
    static String[] CAP_FEED_MACHINE_SENSORS = new String[] {
                SENSORID[0]+":"+Sensor.sensorType.BINARY, 
                SENSORID[1]+":"+Sensor.sensorType.BINARY, 
                SENSORID[2]+":"+Sensor.sensorType.BINARY, 
                SENSORID[3]+":"+Sensor.sensorType.BINARY, 
                SENSORID[4]+":"+Sensor.sensorType.RANGE};
    
    static final int NUMBER_OF_TESTS = 6;
    
    static final String MACHINE_NAME = "Cap Feeding Machine";
}
