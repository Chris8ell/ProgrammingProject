/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import decision.support.system.model.interfaces.DSECallback;
import decision.support.system.model.interfaces.Machine;
import java.util.Collections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author Phidias Burnell
 */
public class DecisionSupportEngine {
    
    DSECallback dseCallback;
    DataCollection dataCollection;
    private Map <String, Machine> machines = new ConcurrentHashMap <String, Machine>();
    private Set <DSECallback> callbacks = Collections.newSetFromMap
        (new ConcurrentHashMap<DSECallback, Boolean>());
    
    public void initiateDataCollection(int sensors) throws MqttException{
        dataCollection = new DataCollection(sensors);
    }
    
    public void addEngineCallback(DSECallback dseCallback) {
        this.callbacks.add(dseCallback);
    }
    
    public void addMachine(Machine machine) {
        this.machines.put(machine.getMachineID(), machine);
    }
    
    public String[] calculateMachineStatus() {
        return super.sensorArray;
    }
}
