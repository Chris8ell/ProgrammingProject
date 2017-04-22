/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model.interfaces;

import decision.support.system.model.interfaces.Machine.statusFlag;


/**
 *
 * @author Phidias Burnell
 */
public interface DSECallback {
    
    
    
    public void sensorInitialisation(DecisionSupportEngine engine);
    
    public void sensorUpdate(Sensor sensor, DecisionSupportEngine engine);
    
    public void testUpdate(DecisionSupportEngine engine, Machine machine, statusFlag[] tests);
}
