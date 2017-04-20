/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import decision.support.system.model.interfaces.Machine;
import decision.support.system.model.interfaces.Sensor;
import java.util.Date;

/**
 *
 * @author Phidias Burnell
 */
public class SensorImpl implements Sensor{
    
    String sensorID;
    int sensorData;
    Date timeStamp;
    sensorType type;
    int sensorCount;
    Machine machine;
    
    
    public SensorImpl(String sensorID, sensorType type) {
        this.sensorID = sensorID;
        this.type = type;
        sensorCount = 0;
    }
    
    @Override
    public void setSensor(int sensorData,  Date timeStamp) {
        this.sensorData = sensorData;
        this.timeStamp = timeStamp;
        if (type == sensorType.BINARY) {
            sensorCount += 1;
        }
    }
    
    @Override
    public String getSensorID() {
        return sensorID;
    }
    
    @Override
    public int getSensorData() {
        return sensorData;
    }
    
    @Override
    public Date getTimeStamp() {
        return timeStamp;
    }

    @Override
    public sensorType getType() {
        return type;
    }

    @Override
    public int getTriggerCount() {
        return sensorCount;
    }

    
}
