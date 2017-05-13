/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import decision.support.system.model.interfaces.DecisionSupportEngine;
import java.util.Date;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author Phidias Burnell
 */

public class DataCollection implements MqttCallback{
 
    //private final String[] sensor;
    private String folder = "";
    private String fileName = "";
    private String channel;
    
    MqttClient client=new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    DecisionSupportEngine decisionSupportEngine;

    public DataCollection(int numSensors, DecisionSupportEngine decisionSupportEngine) throws MqttException {
        //this.sensor = new String[numSensors];
        this.decisionSupportEngine = decisionSupportEngine;
    }
    
    public void startSubscriber(String channel) throws MqttException {
        this.channel = channel;
        client.setCallback(this);
        client.connect();
        client.subscribe(channel);
    }
    
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

        String tempString;
        String[] splitLine;
        tempString = new String(mqttMessage.getPayload());
        splitLine = tempString.split(":");  
        Date timestamp = new Date();
        
        System.out.println("Message Arrived");

        try{
             decisionSupportEngine.addDataToSensors(
                     channel, 
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
