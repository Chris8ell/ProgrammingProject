/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.controller;

import decision.support.system.view.PlatformDisplayPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlatformDisplayPanelController implements ActionListener {
    private final PlatformDisplayPanel platformDisplayPanel;
    
    public PlatformDisplayPanelController(PlatformDisplayPanel platformDisplayPanel) {
        this.platformDisplayPanel = platformDisplayPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand() == PlatformDisplayPanel.MACHINE03){
            platformDisplayPanel.getMainView().setPlatformDisplayMachine03();
        }
        
        if (ae.getActionCommand() == PlatformDisplayPanel.MACHINE04){
            platformDisplayPanel.getMainView().setPlatformDisplayMachine04();
        }
    }
}
