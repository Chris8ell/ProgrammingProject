/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.controller;

import decision.support.system.view.PlatformDisplayMachine03;
import decision.support.system.view.PlatformDisplayPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Phidias Burnell
 */
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
