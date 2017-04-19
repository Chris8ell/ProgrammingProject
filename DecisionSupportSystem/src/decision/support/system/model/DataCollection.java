/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system.model;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
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
 
    private String[] sensor;
    private String folder = "";
    private String fileName = "";
    MqttClient client=new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());

    public DataCollection(int numSensors) throws MqttException {
        sensor = new String[numSensors];
    }
    
    public void startSubscriber(String channel) throws MqttException {
        System.out.println(channel);
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
        sensor[Integer.parseInt(splitLine[0].substring(splitLine[0].length()-1))-1]=splitLine[1];
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    } 
    
    public void closeSubscriber() throws MqttException {
        client.disconnect();
    }
    
    public String[] getSensorData() {
        return sensor;
    }
}
