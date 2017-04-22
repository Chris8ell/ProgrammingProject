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
    private PlatformToolbar platformToolbar;
    
    public PlatformView(DecisionSupportEngine decisionSupportEngine) throws MqttException{
        super ("Decision Support Engine");
        this.decisionSupportEngine = decisionSupportEngine;
        this.platformController = new PlatformController(this);
        initView();
    }
    
    private void initView(){
        this.setBounds(250, 250, 800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.platformToolbar = new PlatformToolbar(this);
        this.platformDisplayPanel = new PlatformDisplayPanel(this);
        //this.gameMenu = new GameMenu(this);
                
        this.add(this.platformToolbar, BorderLayout.NORTH);
        this.add(this.platformDisplayPanel, BorderLayout.CENTER);
        //this.setJMenuBar(this.gameMenu);
    }
    
    public DecisionSupportEngine getDecisionSupportEngine(){
        return this.decisionSupportEngine;
    }
    
    public PlatformDisplayPanel getPlatformDisplayPanel(){
        return platformDisplayPanel;
    }
    

    public PlatformController getPlatformController(){
        return this.platformController;
    }
}
