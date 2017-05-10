/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.view;

import decision.support.system.controller.PlatformToolbarController;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Phidias Burnell
 */
public class PlatformToolbar extends JPanel{
    
    public static final String START = "START";
    public static final String STOP = "STOP";
    
    private JButton startDecisionEngine;
    private JButton stopDecisionEngine;
    private PlatformToolbarController controller;
    private final PlatformView platformView;
    
    public PlatformToolbar(PlatformView platformView) {
        
        this.setBackground(Color.DARK_GRAY);
        this.platformView = platformView;
        this.controller = new PlatformToolbarController(this);
        
        //Simple toolbar with two buttons
        this.startDecisionEngine = new JButton(START);
        this.startDecisionEngine.setActionCommand(START);
        startDecisionEngine.setPreferredSize(new Dimension(100, 30));
        this.add(this.startDecisionEngine);
        this.startDecisionEngine.addActionListener(controller);
        
        this.stopDecisionEngine = new JButton(STOP);
        this.stopDecisionEngine.setActionCommand(STOP);
        stopDecisionEngine.setPreferredSize(new Dimension(100, 30));
        this.add(this.stopDecisionEngine);
        this.stopDecisionEngine.addActionListener(controller);
       
        setStartButton(true);
        setStopButton(false);
    }
     
    public void setStartButton(boolean set) {
        this.startDecisionEngine.setEnabled(set);
    }
    
     public void setStopButton(boolean set) {
        this.stopDecisionEngine.setEnabled(set);
    }
     
     public PlatformView getPlatformView(){
        return this.platformView;
    }
}
