/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.model.interfaces;

import decision.support.system.model.interfaces.Machine.statusFlag;

public interface DSECallback {
    
    
    
    public void sensorInitialisation(DecisionSupportEngine engine);
    
    public void sensorUpdate(Sensor sensor, DecisionSupportEngine engine);
    
    public void testUpdate(DecisionSupportEngine engine, Machine machine, statusFlag[] tests);
}
