/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.driver;

import decision.support.system.view.PlatformView;
import decision.support.system.model.DecisionSupportEngineImpl;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author Phidias Burnell
 */
public class GraphicalInterfaceDriver {
    private static final DecisionSupportEngine decisionSupportEngine = new DecisionSupportEngineImpl();
    
    public static void main(String[] args) throws MqttException{
        SwingUtilities.invokeLater(() -> {
            PlatformView view;
            try {
                view = new PlatformView(decisionSupportEngine);
                view.setVisible(true);
            } catch (MqttException ex) {
                ex.printStackTrace();
            }
            
        });
    }
}
