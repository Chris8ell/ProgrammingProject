/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import decision.support.system.model.interfaces.Sensor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Phidias Burnell
 */
public class CapFeedingMachine extends MachineImpl {
    private Map <String, Sensor> sensors = new ConcurrentHashMap <String, Sensor>();
    
    public CapFeedingMachine(String machineID) {
        super(machineID);
    }
    
}
