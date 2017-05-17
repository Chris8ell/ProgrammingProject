/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.model;

import decision.support.system.model.interfaces.DecisionSupportEngine;
import java.util.Date;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class DataCollection implements MqttCallback{
 
    //private final String[] sensor;
    private String folder = "";
    private String fileName = "";
    private String[] channel;
    private int qos;
    
    MemoryPersistence dataStore = new MemoryPersistence();
    MqttConnectOptions connOpts = new MqttConnectOptions();
    MqttClient client=new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    //MqttAsyncClient client=new MqttAsyncClient("tcp://localhost:1883", MqttClient.generateClientId(),dataStore);
    
    DecisionSupportEngine decisionSupportEngine;

    public DataCollection(int numSensors, DecisionSupportEngine decisionSupportEngine) throws MqttException {
        this.decisionSupportEngine = decisionSupportEngine;
        connOpts.setCleanSession(true);
    }
    
    public void startSubscriber(String[] channel) throws MqttException {
        this.channel = channel;
        
        
        client.setCallback(this);
        client.connect(connOpts);
        try {
            client.subscribe(this.channel);
        } catch (MqttException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getReasonCode());
        }

    }
    
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

        String tempString;
        String[] splitLine, machineNumber;
        tempString = new String(mqttMessage.getPayload());
        
        machineNumber = s.split("/");
        splitLine = tempString.split(":");  
        Date timestamp = new Date();
        
        try{
             decisionSupportEngine.addDataToSensors(
                     machineNumber[1], 
                     splitLine[0].replaceAll("\\s+",""), 
                     Integer.valueOf(splitLine[1].replaceAll("\\s+","")), 
                     timestamp);
             
        }catch (NumberFormatException e) {
            e.getMessage();
            e.getLocalizedMessage();
        }
    }

    
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    } 
    
    public void closeSubscriber() throws MqttException {
        client.disconnect();
    }
}
