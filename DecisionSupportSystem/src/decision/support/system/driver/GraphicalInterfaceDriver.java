/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.driver;

import decision.support.system.view.PlatformView;
import decision.support.system.model.DecisionSupportEngineImpl;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.eclipse.paho.client.mqttv3.MqttException;

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
