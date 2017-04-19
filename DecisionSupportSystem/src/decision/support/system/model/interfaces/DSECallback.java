/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model.interfaces;

import decision.support.system.model.DecisionSupportEngine;

/**
 *
 * @author Phidias Burnell
 */
public interface DSECallback {
    
    public void gameResult(DecisionSupportEngine engine);
}
