/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.controller;

import decision.support.system.view.PlatformDisplayMachine03;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlatformDisplayMachine03Controller implements ActionListener {
    private final PlatformDisplayMachine03 platformDisplayMachine;
    
    public PlatformDisplayMachine03Controller(PlatformDisplayMachine03 platformDisplayMachine) {
        this.platformDisplayMachine = platformDisplayMachine;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand() == PlatformDisplayMachine03.BACK){
            platformDisplayMachine.getMainView().setPlatformDisplayPanel();
        }
    }
}
