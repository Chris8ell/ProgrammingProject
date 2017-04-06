/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionsupportsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author phidi
 */

public class DataCollection implements MqttCallback{
 
    private String[] sensor;
    private String folder = "";
    private String fileName = "";
    MqttClient client=new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());

    public DataCollection(int numSensors) throws MqttException {
        //sensor = "None";
        sensor = new String[numSensors];
        
        //startSubscriber(topic);

        //BufferedReader file;
/*
        try {
            file = new BufferedReader (new FileReader ("config.txt"));
            folder = file.readLine();
            file.close(); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }
    
    public void startSubscriber(String channel) throws MqttException {

        System.out.println("== START SUBSCRIBER ==");

        client.setCallback(this);
        client.connect();
        //System.out.println(channels[0]);
        client.subscribe(channel);
        
    }
    
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        //System.out.println(new String (mqttMessage.getPayload()));
        //System.out.println(getClass().getMethod("messageReceived", String.class, byte[].class));
        String tempString;
        String[] splitLine;
        tempString = new String(mqttMessage.getPayload());
        splitLine = tempString.split(";");
        sensor[Integer.parseInt(splitLine[0].substring(splitLine[0].length()))-1]=splitLine[1];    

    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    } 
        
    public void openFileRepository() throws IOException{
        
        BufferedReader file;
        
        try {
            
            fileName = "";

            File actual = new File(folder);

            for(long x = 0; x < 999999999; x = x + 1) {
            }
            
            if (actual.list().length > 0) {
                for( File f : actual.listFiles()){
                    if ((fileName.compareTo(f.getName()) == 1) || (fileName.equals(""))) {
                        fileName = f.getName();
                    }
                }

                file = new BufferedReader (new FileReader (folder + fileName));
                String fileLine = file.readLine();
                String[] splitFileLine;

                // loop through each line of the file and parse data based on ; delimiter
                while (fileLine != null) {
                    splitFileLine = fileLine.split(";");
                    sensor[0] = splitFileLine[0];
                    
                    fileLine = file.readLine();

                }
                file.close();
                //System.out.println(folder + fileName + "File");
                Files.delete(Paths.get(folder + fileName));
            }
        }
                
        catch(Exception e){
            System.out.println("No data was loaded from " + e.getMessage());
            System.out.println();
        }
    }
    
    public void closeSubscriber() throws MqttException {
        client.disconnect();
    }
    
    public String[] getSensorData() {
        return sensor;
    }
    
}
