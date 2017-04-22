/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import decision.support.system.callback.DSECallbackImpl;
import decision.support.system.model.interfaces.DSECallback;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import decision.support.system.model.interfaces.Machine;
import decision.support.system.model.interfaces.Machine.statusFlag;
import decision.support.system.model.interfaces.Sensor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author Phidias Burnell
 */
public class DecisionSupportEngineImpl implements DecisionSupportEngine {
    
    DSECallback dseCallback;
    DataCollection dataCollection;
    private Map <String, Machine> machines = new ConcurrentHashMap <>();
    private Set <DSECallback> callbacks = Collections.newSetFromMap
        (new ConcurrentHashMap<>());
       
    @Override
    public void initiateDataCollection(int sensors) throws MqttException{
        dataCollection = new DataCollection(sensors, this);
    }
    
    @Override
    public void addEngineCallback(DSECallback dseCallback) {
        this.callbacks.add(dseCallback);
    }
    
    @Override
    public void addMachine(Machine machine) {
        this.machines.put(machine.getMachineID(), machine);
    }
    
    @Override
    public String[] calculateMachineStatus() {
        String[] test = new String[6];
        return test;
    }
    
    @Override
    public Machine getMachine(String id) {
        return this.machines.get(id);
    }
    
    @Override
    public Collection<Machine> getAllMachineSetup() {
        return Collections.unmodifiableCollection(new ArrayList<>(this.machines.values()));
    }
    
    @Override
    public Set<DSECallback> getCallBack(){        
         return callbacks;
    }
    
    @Override
    public void addDataToSensors (String machineID, String sensorID, int sensorData, Date timestamp){   
        this.getMachine(machineID).getSensor(sensorID).setSensor(sensorData, timestamp);
        
        try {
            statusFlag tests[] = new statusFlag[6];
            tests = this.getMachine(machineID).calculateMachineStatus();
            for (DSECallback callback : callbacks){
            callback.testUpdate(this, this.getMachine(machineID), this.getMachine(machineID).calculateMachineStatus());
        }
        } catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            e.getStackTrace();
        }
    }
}
