/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decision.support.system.callback;

import decision.support.system.model.interfaces.DSECallback;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import decision.support.system.model.interfaces.Machine;
import decision.support.system.model.interfaces.Machine.statusFlag;
import decision.support.system.model.interfaces.Sensor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSECallbackImpl implements DSECallback{
    
    protected static final Logger logger = Logger.getLogger("DecisionSupport");
    
    @Override
    public void sensorInitialisation(DecisionSupportEngine engine) {
        logger.log(Level.INFO, "Machine: " + engine.getAllMachineSetup());
    }
    
    @Override
    public void sensorUpdate(Sensor sensor, DecisionSupportEngine engine){
         logger.log(Level.INFO, "Sensor:" + sensor.getSensorID()+", Type:"+sensor.getType()+", Time:"+sensor.getTimeStamp()+", Data:"+sensor.getSensorData());
     }
     
    @Override
    public void testUpdate(DecisionSupportEngine engine, Machine machine, statusFlag[] tests) {
         
         logger.log(Level.INFO, "Machine: " + machine.getMachineID() + 
                 ", Sensors: 1 - " + machine.getSensor("01").getSensorData() + 
                 " : 2 - " + machine.getSensor("02").getSensorData() +
                 " : 3 - " + machine.getSensor("03").getSensorData() +
                 " : 4 - " + machine.getSensor("04").getSensorData() +
                 " : 5 - " + machine.getSensor("05").getSensorData() +
                 ", Tests: 4 - " + tests[4-1].toString() +
                 " : 5 - " + tests[5-1].toString() +
                 " : 6 - " + tests[6-1].toString() 
                 );
     }
            
}
