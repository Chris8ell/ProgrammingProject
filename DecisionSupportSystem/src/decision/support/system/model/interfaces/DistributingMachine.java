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
                "Once the swival arm reaches stops moving the cap should be released immediately",
                "Machine swival are operates within the acceptable speed range"};
   
    static String[] DISTRIBUTING_MACHINE_SENSORS = new String[] {
                SENSORID[0]+":"+Sensor.sensorType.BINARY, 
                SENSORID[1]+":"+Sensor.sensorType.BINARY, 
                SENSORID[2]+":"+Sensor.sensorType.BINARY, 
                SENSORID[3]+":"+Sensor.sensorType.BINARY, 
                SENSORID[4]+":"+Sensor.sensorType.RANGE};
    
    static final int NUMBER_OF_TESTS = 6;
}
