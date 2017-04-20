/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import static decision.support.system.model.interfaces.CapFeedingMachine.SENSORID;
import decision.support.system.model.interfaces.DSECallback;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import decision.support.system.model.interfaces.Machine;
import decision.support.system.model.interfaces.Sensor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/**
 *
 * @author Phidias Burnell
 */
public class MachineImpl implements Machine{
    
    private String machineID;
    private DecisionSupportEngine decisionSupportEngine;
    
    private Map <String, Sensor> sensors = new ConcurrentHashMap <String, Sensor>();

    public MachineImpl(String machineID, DecisionSupportEngine decisionSupportEngine) {
        this.machineID = machineID;
        this.decisionSupportEngine = decisionSupportEngine;
    }
    
    @Override
    public void initialiseSensors(String[] sensordata){
        Sensor[] newSensors = new SensorImpl[sensordata.length];

        for (int i = 0; i < sensordata.length; i++){
            String[] split = sensordata[i].split(":");
            
            if (split[1].equals(Sensor.sensorType.BINARY.toString())){
                newSensors[i] = new SensorImpl(split[0], Sensor.sensorType.BINARY);
            } else {
                newSensors[i] = new SensorImpl(split[0], Sensor.sensorType.RANGE);
            }
        }
        
        for (Sensor sensor : newSensors) { addSensor(sensor);}
    }

    @Override
    public void addSensor(Sensor sensor) {
         this.sensors.put(sensor.getSensorID(), sensor);       
    }

    @Override
    public void calculateMachineStatus() {
        //return sensorArray;
    }

    @Override
    public String getMachineID() {
        return machineID;
    }
    
    @Override
    public Sensor getSensor(String id) {
        return this.sensors.get(id);
    }
    
    @Override
    public Map <String, Sensor> getSensors(){        
         return sensors;
    }
    
    @Override
    public String toString(){
        
        String sensorIDs ="";
        for (int i = 0; i < SENSORID.length; i++){
            sensorIDs += " " + getSensor(SENSORID[i]).getSensorID() +"_"+ getSensor(SENSORID[i]).getType();
        }                      
        return "Machine: " + this.machineID + ", Sensors initalised:" + sensorIDs;
    } 
}
