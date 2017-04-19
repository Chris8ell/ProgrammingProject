/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import decision.support.system.model.interfaces.Machine;
import decision.support.system.model.interfaces.Sensor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Phidias Burnell
 */
public class MachineImpl implements Machine{
    
    private String machineID;
    public String[] sensorArray;
    
    private Map <String, Sensor> sensors = new ConcurrentHashMap <String, Sensor>();

    public MachineImpl(String machineID) {
        this.machineID = machineID;
    }

    @Override
    public void addSensor(Sensor sensor) {
         this.sensors.put(sensor.getSensorID(), sensor);
    }

    @Override
    public String[] calculateMachineStatus() {
        return sensorArray;
    }

    @Override
    public String getMachineID() {
        return machineID;
    }
    
}
