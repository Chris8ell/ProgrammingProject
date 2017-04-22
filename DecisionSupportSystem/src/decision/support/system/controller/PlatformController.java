/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.controller;

import decision.support.system.callback.GUIDSECallbackImpl;
import decision.support.system.model.CapFeedingMachineImpl;
import decision.support.system.model.DataCollection;
import static decision.support.system.model.interfaces.CapFeedingMachine.SENSORID;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import decision.support.system.model.interfaces.Machine;
import decision.support.system.model.interfaces.Machine.statusFlag;
import decision.support.system.model.interfaces.Sensor;
import decision.support.system.view.PlatformView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author Phidias Burnell
 */
public class PlatformController {
    private final PlatformView platformView;
    private final DecisionSupportEngine decisionSupportEngine;
    private static String[] machineNumber = new String[] {"machine01"};
    private static DataCollection dataCollection;
    
    public PlatformController(PlatformView platformView) throws MqttException{
        this.platformView = platformView;
        this.decisionSupportEngine = platformView.getDecisionSupportEngine();
        this.decisionSupportEngine.addEngineCallback(new GUIDSECallbackImpl(this));
        Machine machines[] = new Machine[] { new CapFeedingMachineImpl(machineNumber[0], decisionSupportEngine)};
        for (Machine machine : machines) {
			decisionSupportEngine.addMachine(machine);}
        
        dataCollection = new DataCollection(SENSORID.length, decisionSupportEngine);

    }
    
    public void startDecisionSupportSystem() {
        
        new Thread() {
            
            //rolls the player using defaults from customer interface
            @Override
            public void run() {
                try {
                    PlatformController.dataCollection.startSubscriber(machineNumber[0]);
                } catch (MqttException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();
    }
    
    public void stopDecisionSupportSystem() {
        try{
            dataCollection.closeSubscriber();
        }catch (MqttException ex){
            ex.printStackTrace();
        }
    }
    
    
    public void updatePlatformDisplayPanel(DecisionSupportEngine engine, Machine machine, statusFlag[] tests){
        String[] test = new String[tests.length];
        for(int i = 0; i < tests.length; i++){
            if (tests[i] != null){
                test[i] = tests[i].toString();
            }
            
        }
        
        List<String> sensorKeys = new ArrayList<String>(machine.getSensors().keySet());
        String[] sensor = new String[sensorKeys.size()];
        
        for (int i = 0; i < sensorKeys.size(); i++){
            sensor[i] = Integer.toString(machine.getSensor(sensorKeys.get(i)).getSensorData());
        }
            
 
        this.platformView.getPlatformDisplayPanel().updateView(machine.getMachineID(), machine.getMachineID(), sensor, test);
    }
}
