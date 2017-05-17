/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.controller;

import decision.support.system.view.PlatformDisplayMachine04;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlatformDisplayMachine04Controller implements ActionListener {
    private final PlatformDisplayMachine04 platformDisplayMachine;
    
    public PlatformDisplayMachine04Controller(PlatformDisplayMachine04 platformDisplayMachine) {
        this.platformDisplayMachine = platformDisplayMachine;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand() == PlatformDisplayMachine04.BACK){
            platformDisplayMachine.getMainView().setPlatformDisplayPanel();
        }
    }
}
