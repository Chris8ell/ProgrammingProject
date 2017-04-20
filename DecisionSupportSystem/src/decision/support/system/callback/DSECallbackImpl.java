/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decision.support.system.callback;

import decision.support.system.model.interfaces.DSECallback;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import decision.support.system.model.interfaces.Sensor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSECallbackImpl implements DSECallback{
    
    protected static final Logger logger = Logger.getLogger("DecisionSupport");
    
    @Override
    public void sensorInitialisation(DecisionSupportEngine engine) {
        logger.log(Level.INFO, "Machine: " + engine.getAllMachineSetup());
    }
    
     public void sensorUpdate(Sensor sensor, DecisionSupportEngine engine){
         logger.log(Level.INFO, "Sensor:" + sensor.getSensorID()+", Type:"+sensor.getType()+", Time:"+sensor.getTimeStamp()+", Data:"+sensor.getSensorData());
     }
            
}
