/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.model;

import static decision.support.system.model.interfaces.CapFeedingMachine.SENSORID;
import decision.support.system.model.interfaces.DSECallback;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import decision.support.system.model.interfaces.Machine;
import decision.support.system.model.interfaces.Sensor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MachineImpl implements Machine{
    
    private final String machineID;
    private final String machineName;
    private final DecisionSupportEngine decisionSupportEngine;
    private final statusFlag tests[];
    private final Map <String, Sensor> sensors = new ConcurrentHashMap <>();

    public MachineImpl(String machineID, String machineName, DecisionSupportEngine decisionSupportEngine, int sensorQty) {
        this.machineID = machineID;
        this.machineName = machineName;
        this.decisionSupportEngine = decisionSupportEngine;
        this.tests = new statusFlag[sensorQty];
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
    public statusFlag[] calculateMachineStatus() {
        return tests;
    }

    @Override
    public String getMachineID() {
        return machineID;
    }
    
    @Override
    public String getMachineName() {
        return machineName;
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
    
    public statusFlag[] getTestArray() {
        return tests;
    }
}
