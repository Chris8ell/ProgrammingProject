/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.controller;

import decision.support.system.view.PlatformToolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlatformToolbarController implements ActionListener{
    private PlatformToolbar platformToolbar;
        
    public PlatformToolbarController(PlatformToolbar platformToolbar) {
        this.platformToolbar = platformToolbar;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand() == PlatformToolbar.START){
            platformToolbar.getPlatformView().getPlatformController().startDecisionSupportSystem();
            platformToolbar.setStartButton(false);
            platformToolbar.setStopButton(true);
        }
        
        if (ae.getActionCommand() == PlatformToolbar.STOP){
            platformToolbar.getPlatformView().getPlatformController().stopDecisionSupportSystem();
            platformToolbar.setStartButton(true);
            platformToolbar.setStopButton(false);
        }
    }
}
