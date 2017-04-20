/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import decision.support.system.model.interfaces.CapFeedingMachine;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import decision.support.system.model.interfaces.Sensor;
import decision.support.system.model.interfaces.Sensor.sensorType;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Phidias Burnell
 */
public class CapFeedingMachineImpl extends MachineImpl implements CapFeedingMachine {
      
    public CapFeedingMachineImpl(String machineID, DecisionSupportEngine decisionSupportEngine) {
        super(machineID, decisionSupportEngine);
        super.initialiseSensors(CAP_FEED_MACHINE_SENSORS);
    }
    
    @Override
    public void calculateMachineStatus() {
        //add in decision support funtion logic
        
        /* if sensor 1 is triggered sensor 
        
        
        
        
        */
        

        for (int i = 0; i < CAP_FEED_MACHINE_SENSORS.length; i++){
            //Object[] sensorData = new Object[] {, 1, "String"};
            //listTest.add(sensorData);
            System.out.println(CAP_FEED_MACHINE_SENSORS[i]);
        }

        
        //return arr;
    }
}
