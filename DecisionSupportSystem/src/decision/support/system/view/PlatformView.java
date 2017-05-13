/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.view;

import decision.support.system.controller.PlatformController;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author Phidias Burnell
 */
public class PlatformView extends JFrame{
    
    private final DecisionSupportEngine decisionSupportEngine;
    private final PlatformController platformController;
    private PlatformDisplayPanel platformDisplayPanel;
    private PlatformDisplayMachine03 platformDisplayMachine03;
    private PlatformDisplayMachine04 platformDisplayMachine04;
    private PlatformToolbar platformToolbar;
    
    public PlatformView(DecisionSupportEngine decisionSupportEngine) throws MqttException{
        super ("Decision Support Engine");
        this.decisionSupportEngine = decisionSupportEngine;
        this.platformController = new PlatformController(this);
        initView();
    }
    
    private void initView(){
        
        this.setBounds(250, 250, 1600, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.platformToolbar = new PlatformToolbar(this);
        this.platformDisplayPanel = new PlatformDisplayPanel(this);
        this.platformDisplayMachine03 = new PlatformDisplayMachine03(this);
        this.platformDisplayMachine04 = new PlatformDisplayMachine04(this);
                
        this.add(this.platformToolbar, BorderLayout.NORTH);
        this.add(this.platformDisplayPanel, BorderLayout.CENTER);
        //this.add(this.platformDisplayMachine01, BorderLayout.CENTER);
    }
    
    public DecisionSupportEngine getDecisionSupportEngine(){
        return this.decisionSupportEngine;
    }
    
    public PlatformDisplayPanel getPlatformDisplayPanel(){
        return platformDisplayPanel;
    }
    
    public PlatformDisplayMachine03 getPlatformDisplayMachine03(){
        return platformDisplayMachine03;
    }
    
    public PlatformDisplayMachine04 getPlatformDisplayMachine04(){
        return platformDisplayMachine04;
    }
    
    public void setPlatformDisplayMachine03(){
        this.remove(this.platformDisplayPanel);
        this.add(this.platformDisplayMachine03, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    
     public void setPlatformDisplayMachine04(){
        this.remove(this.platformDisplayPanel);
        this.add(this.platformDisplayMachine04, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
    
    public void setPlatformDisplayPanel(){
        this.remove(this.platformDisplayMachine03);
        this.remove(this.platformDisplayMachine04);
        this.add(this.platformDisplayPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
            
    public PlatformController getPlatformController(){
        return this.platformController;
    }
}
