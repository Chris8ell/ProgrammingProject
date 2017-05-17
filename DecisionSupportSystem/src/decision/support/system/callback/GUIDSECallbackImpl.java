/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.callback;

import decision.support.system.controller.PlatformController;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import decision.support.system.model.interfaces.Machine;
import decision.support.system.model.interfaces.Machine.statusFlag;
import decision.support.system.model.interfaces.Sensor;

public class GUIDSECallbackImpl extends DSECallbackImpl{
    
    private final PlatformController platformController;
    
    public GUIDSECallbackImpl(PlatformController platformController) {
        this.platformController = platformController;
    }
    
    @Override
    public void sensorInitialisation(DecisionSupportEngine engine) {
        
    }
    
    @Override
    public void sensorUpdate(Sensor sensor, DecisionSupportEngine engine){
         
    }
     
    @Override
    public void testUpdate(DecisionSupportEngine engine, Machine machine, statusFlag[] tests) {
        this.platformController.updatePlatformDisplayPanel(engine, machine, tests);
    }
            
}
