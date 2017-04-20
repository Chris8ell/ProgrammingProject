/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import decision.support.system.model.interfaces.CapFeedingMachine;
import decision.support.system.model.interfaces.DecisionSupportEngine;

/**
 *
 * @author Phidias Burnell
 */
public class CapFeedingMachineImpl extends MachineImpl implements CapFeedingMachine {
    statusFlag tests[] = new statusFlag[6];
    int test;
    
    public CapFeedingMachineImpl(String machineID, DecisionSupportEngine decisionSupportEngine) {
        super(machineID, decisionSupportEngine);
        super.initialiseSensors(CAP_FEED_MACHINE_SENSORS);
        
        
    }
    
    @Override
    public void calculateMachineStatus() {
        
        /*  Decision support funtion logic for machine 1 */
        
        /*
         *  Test 1: 
         *  if sensor 1 is triggered, sensor 2 should trigger within 4 seconds 
         *      amber <6< red
         *
         *  Test 2:
         *  if sensor 2 is trigerred sensor 3 should trigger within 0.5 second
         *      amber <1< red
         *
         *  Test 3:
         *  if sensor 3 is triggered sensor 4 should trigger within 1 second if sensor 1 count is > 1
         *      amber <2< red
         */
        
        test = 3;
        if (super.getSensor(SENSORID[2]).getTriggerCount()+1 >= super.getSensor(SENSORID[3]).getTriggerCount()){
            tests[test-1] = statusFlag.GREEN;
        } else {
            tests[test-1] = statusFlag.RED;
        }
        
        /*  Test 4:
         *  sensor 3 count should always be less than or equal to sensor 2 count
         *      red <-1...0 >= red
         */
        
        test = 4;
        if (super.getSensor(SENSORID[2]).getTriggerCount()+1 >= super.getSensor(SENSORID[3]).getTriggerCount()){
            tests[test-1] = statusFlag.GREEN;
        } else {
            tests[test-1] = statusFlag.RED;
        }
        
        /*  Test 5:
         *  sensor 4 count should always be less than or equal to sensor 3 count
         *      > red
         */
        
        test = 5;
        if (super.getSensor(SENSORID[3]).getTriggerCount()+1 >= super.getSensor(SENSORID[4]).getTriggerCount()){
            tests[test-1] = statusFlag.GREEN;
        } else {
            tests[test-1] = statusFlag.RED;
        }
        
        /*
         *  Test 6:
         *  sensor 5 should always be between 4000 and 5000
         *      red <= 3500 <= amber <= 4000 ... 5000 => amber => 5500 => red
         */
        
        test = 6;
        if (super.getSensor(SENSORID[4]).getSensorData() >= 4000 && super.getSensor(SENSORID[4]).getSensorData() <= 5000){
            tests[test-1] = statusFlag.GREEN;
        } else if(super.getSensor(SENSORID[4]).getSensorData() >= 3500 && super.getSensor(SENSORID[4]).getSensorData() <= 5500){
            tests[test-1] = statusFlag.AMBER;
        } else {
            tests[test-1] = statusFlag.RED;
        }
  
    }
}
