/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.controller;

import decision.support.system.view.PlatformToolbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Phidias Burnell
 */
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
