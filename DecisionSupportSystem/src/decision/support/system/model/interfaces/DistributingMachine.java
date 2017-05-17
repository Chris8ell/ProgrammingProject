/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.model.interfaces;

public interface DistributingMachine {
    static final String[] SENSORID = new String[] {
                "01",
                "02",
                "03",
                "04",
                "05"};
    
    static final String[] TESTS = new String[] {
                "A cap should be present in the magazine",
                "After the cap has been released the swival arm should be activated within one second",
                "The swival arm should pick up the cap within 4 seconds of activation",
                "Within 3 seconds the cap should be lifted up with the swival arm",
                "Once the swival arm stops moving the cap should be released immediately",
                "Machine swival are operates within the acceptable speed range"};
   
    static String[] DISTRIBUTING_MACHINE_SENSORS = new String[] {
                SENSORID[0]+":"+Sensor.sensorType.BINARY, 
                SENSORID[1]+":"+Sensor.sensorType.BINARY, 
                SENSORID[2]+":"+Sensor.sensorType.BINARY, 
                SENSORID[3]+":"+Sensor.sensorType.BINARY, 
                SENSORID[4]+":"+Sensor.sensorType.RANGE};
    
    static final int NUMBER_OF_TESTS = 6;
    
    static final String MACHINE_NAME = "Distributing Machine";
}
