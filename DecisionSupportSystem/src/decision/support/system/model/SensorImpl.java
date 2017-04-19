/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import decision.support.system.model.interfaces.Sensor;
import java.sql.Time;

/**
 *
 * @author Phidias Burnell
 */
public class SensorImpl implements Sensor{
    
    String sensorID;
    int sensorData;
    Time timeStamp;
    sensorType type;
    int sensorCount;
    
    
    public void SensorImpl(String sensorID, sensorType type) {
        this.sensorID = sensorID;
        this.type = type;
        sensorCount = 0;
    }
    
    @Override
    public void setSensor(int sensorData,  Time timeStamp) {
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
    public Time getTimeStamp() {
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
