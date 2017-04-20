/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model.interfaces;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author Phidias Burnell
 */
public interface DecisionSupportEngine {
    
    /**
     *
     * @param sensors
     * @throws MqttException
     */
    public void initiateDataCollection(int sensors) throws MqttException;
     
    /**
     *
     * @param dseCallback
     */
    public void addEngineCallback(DSECallback dseCallback);
    
    /**
     *
     * @param machine
     */
    public void addMachine(Machine machine);
    
    /**
     *
     * @return
     */
    public String[] calculateMachineStatus();
    
    /**
     *
     * @return
     */
    public Collection<Machine> getAllMachineSetup();
    
    /**
     *
     * @param id
     * @return
     */
    public Machine getMachine(String id);
    
    /**
     *
     * @return
     */
    public Set<DSECallback> getCallBack();
    
    /**
     *
     * @param machineID
     * @param sensorID
     * @param sensorData
     * @param timestamp
     */
    public void addDataToSensors (String machineID, String sensorID, int sensorData, Date timestamp);
    
}
