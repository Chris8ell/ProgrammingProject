/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.controller;

import decision.support.system.view.PlatformDisplayMachine04;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Phidias Burnell
 */
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
