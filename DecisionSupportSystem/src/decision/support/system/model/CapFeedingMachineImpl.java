/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.model;

import decision.support.system.model.interfaces.CapFeedingMachine;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import java.util.ArrayList;
import java.util.Date;

public class CapFeedingMachineImpl extends MachineImpl implements CapFeedingMachine {
    
    int test;
    ArrayList<Date> sensorOneTime = new ArrayList<Date>();
    ArrayList<Date> sensorTwoTime = new ArrayList<Date>();
    boolean sensorTestOne = false;
    boolean sensorTestTwo = false;
    
    public CapFeedingMachineImpl(String machineID, DecisionSupportEngine decisionSupportEngine) {
        super(machineID, MACHINE_NAME, decisionSupportEngine, NUMBER_OF_TESTS);
        super.initialiseSensors(CAP_FEED_MACHINE_SENSORS);
    }
    
    @Override
    public statusFlag[] calculateMachineStatus() {
   
        /*  Decision support funtion logic for machine 1 */
        
        /*
         *  Test 1: 
         *  if sensor 1 is triggered, sensor 2 should trigger within 4 seconds 
         *      amber <6< red
         */
        Date currentTime = new Date();
        test = 1;
        super.getTestArray()[test-1] = statusFlag.GREEN;
        
        if (super.getSensor("01").getSensorData()==1)
            if(sensorOneTime.isEmpty()){
                sensorOneTime.add(super.getSensor("01").getTimeStamp());
                sensorTestOne = true;
            } else if (0 != super.getSensor("01").getTimeStamp().getTime()-sensorOneTime.get(sensorOneTime.size()-1).getTime()){
                sensorOneTime.add(super.getSensor("01").getTimeStamp());
                sensorTestOne = true;
            }
        
        if (super.getSensor("02").getSensorData()==0 && sensorTestOne == true){
            long seconds = (currentTime.getTime()-sensorOneTime.get(0).getTime())/1000;
            if (seconds>1){
                super.getTestArray()[test-1] = statusFlag.AMBER;
            }else if (seconds>2){
                super.getTestArray()[test-1] = statusFlag.RED;
            } else {
                super.getTestArray()[test-1] = statusFlag.GREEN;
            }
        } else if  (super.getSensor("02").getSensorData()==1){
            sensorOneTime.clear();
            sensorTestOne = false;
            super.getTestArray()[test-1] = statusFlag.GREEN;
        }
        
        /*
         *  Test 2:
         *  if sensor 2 is trigerred sensor 3 should trigger within 0.5 second
         *      amber <1< red
         */
        
        test = 2;
        super.getTestArray()[test-1] = statusFlag.GREEN;
        
        if (super.getSensor("02").getSensorData()==1)
            if(sensorTwoTime.isEmpty()){
                sensorTwoTime.add(super.getSensor("02").getTimeStamp());
                sensorTestTwo = true;
            } else if (0 != super.getSensor("02").getTimeStamp().getTime()-sensorTwoTime.get(sensorTwoTime.size()-1).getTime()){
                sensorTwoTime.add(super.getSensor("02").getTimeStamp());
                sensorTestTwo = true;
            }
        
        if (super.getSensor("03").getSensorData()==0 && sensorTestTwo == true){
            long seconds = (currentTime.getTime()-sensorTwoTime.get(0).getTime())%1000;
            if (seconds>0.05){
                super.getTestArray()[test-1] = statusFlag.AMBER;
            }else if (seconds>0.1){
                super.getTestArray()[test-1] = statusFlag.RED;
            } else {
                super.getTestArray()[test-1] = statusFlag.GREEN;
            }
        } else if  (super.getSensor("03").getSensorData()==1){
            sensorTwoTime.clear();
            sensorTestTwo = false;
            super.getTestArray()[test-1] = statusFlag.GREEN;
        }        
        
        /*
         *  Test 3:
         *  if sensor 3 is triggered sensor 4 should trigger within 1 second if sensor 1 count is > 1
         *      amber <2< red
         */
        
        test = 3;
        if (super.getSensor(SENSORID[2]).getTriggerCount()+1 >= super.getSensor(SENSORID[3]).getTriggerCount()){
            super.getTestArray()[test-1] = statusFlag.GREEN;
        } else {
            super.getTestArray()[test-1] = statusFlag.RED;
        }
        
        /*  Test 4:
         *  sensor 3 count should always be less than or equal to sensor 2 count
         *      red <-1...0 >= red
         */
        
        test = 4;
        if (super.getSensor(SENSORID[2]).getTriggerCount()+1 >= super.getSensor(SENSORID[3]).getTriggerCount()){
            super.getTestArray()[test-1] = statusFlag.GREEN;
        } else {
            super.getTestArray()[test-1] = statusFlag.RED;
        }
        
        /*  Test 5:
         *  sensor 4 count should always be less than or equal to sensor 3 count
         *      > red
         */
        
        test = 5;
        if (super.getSensor(SENSORID[3]).getTriggerCount()+1 >= super.getSensor(SENSORID[4]).getTriggerCount()){
            super.getTestArray()[test-1] = statusFlag.GREEN;
        } else {
            super.getTestArray()[test-1] = statusFlag.RED;
        }
        
        /*
         *  Test 6:
         *  sensor 5 should always be between 4000 and 5000
         *      red <= 3500 <= amber <= 4000 ... 5000 => amber => 5500 => red
         */
        
        test = 6;
        if (super.getSensor(SENSORID[4]).getSensorData() >= 4000 && super.getSensor(SENSORID[4]).getSensorData() <= 5000){
            super.getTestArray()[test-1] = statusFlag.GREEN;
        } else if(super.getSensor(SENSORID[4]).getSensorData() >= 3500 && super.getSensor(SENSORID[4]).getSensorData() <= 5500){
            super.getTestArray()[test-1] = statusFlag.AMBER;
        } else {
            super.getTestArray()[test-1] = statusFlag.RED;
        }
 
        return super.getTestArray();
    }
}
