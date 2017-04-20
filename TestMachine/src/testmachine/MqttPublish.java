package testmachine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author phidi
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublish {
    
    
    private static String topic;
    private static int qos = 2;
    //private static String broker1 = "tcp://54.66.148.136";
    private static String broker1 = "tcp://localhost:1883";
    private static String broker2 = "tcp://localhost:1883";
    private static String broker3 = "tcp://localhost:1883";
    private static String clientId = "JavaSample";
    public static MqttClient newClient1, newClient2;
    public static int sensor1 = 0, sensor2 = 0, sensor3 = 0, sensor4 = 0;
    
    public static void main(String[] args) throws InterruptedException, MqttException{

        Thread presence, belt, t3;
        newClient1 = openPublisher("machine01", newClient1, broker1);
        
        presence = new Thread(new Runnable(){
                
                int x = 0;
                @Override
                
                public void run() {
                    
                    String[] sensors = {"01", "02", "03","04"};
                    sequenceData(sensors, newClient1);
                }
            });

        belt = new Thread(new Runnable(){
            MqttClient newClient2;
            int x = 0;
            @Override
            public void run() {

                String[] sensors = {"05"};
                motorData(sensors, newClient1);
            }
        });

            /*
            t3 = new Thread(new Runnable(){
                MqttClient newClient3;
                int x = 0;
                @Override
                public void run() {
                    newClient1 = openPublisher("Machine1", newClient1, broker1);
                    String[] sensors = {"sensor_1", "sensor_2", "sensor_3"};
                    runnableRun(sensors, newClient1);
                }
            });
*/
        presence.start();
        belt.start();
 //           t3.start();
            

    }
    
    public static void sequenceData(String[] sensorName, MqttClient client){
        Random r = new Random();
        String[] sensorData = new String[sensorName.length];
        boolean start = false, released = false;
        int Low = 0;
        int High = 2;
        int Result;
        int capCounter = 0;
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date eTimeSensorOne = new Date();
        Date rTimeSensorOne = new Date();
        Date eTimeSensorTwo = new Date();
        Date rTimeSensorTwo = new Date();
        Date currentTime = new Date();
        
        for (int i=0; i < sensorName.length; i++){
            sensorData[i]="0";
        }
        
        for(long x = 0;x<100;x=x+1) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                currentTime = new Date();
                
                if (start == false){
                    for (int i=0; i < sensorName.length; i++){
                        publishMessage(sensorName[i] + ": " + sensorData[i], client);
                        start = true;
                    }
                } else {
                    if (capCounter <=5) {
                        if(sensorData[0].equals("0") && ((currentTime.getTime()-rTimeSensorOne.getTime())/1000) >= 2){
                        sensorData[0]="1";
                        eTimeSensorOne = new Date();
                    }
                    
                    if(sensorData[0].equals("1") && ((currentTime.getTime()-eTimeSensorOne.getTime())/1000) >= 2){
                        sensorData[0]="0";
                        capCounter += 1;
                        if (sensorData[1].equals("1")){
                            rTimeSensorOne = new Date();
                        }
                    }
                    
                        
                    }
         
                    if (capCounter > 0 && ((currentTime.getTime()-rTimeSensorOne.getTime())/1000) >= 5){
                        sensorData[1]="1";
                        eTimeSensorTwo = new Date(); 
                    }
                    
                    if (sensorData[1].equals("1") && sensorData[2].equals("1") && ((currentTime.getTime()-eTimeSensorTwo.getTime())/1000) >= 1){
                        capCounter -= 1;
                        eTimeSensorTwo = new Date();
                        rTimeSensorTwo = new Date();
                        if (capCounter == 0){
                            sensorData[1]="0";
                            eTimeSensorTwo = new Date();
                        }
                        released = true;
                    } else if (sensorData[1].equals("1") && ((currentTime.getTime()-eTimeSensorTwo.getTime())/1000) >= 1) {
                        sensorData[2]="1";
                        capCounter -= 1;
                        eTimeSensorTwo = new Date();
                        if (capCounter == 0){
                            sensorData[1]="0";
                            eTimeSensorTwo = new Date();
                        }
                    }
                    
                    if (released == true && ((currentTime.getTime()-rTimeSensorTwo.getTime())/1000) >= 2){
                        sensorData[3]="1";
                        released = false; 
                    } else if (released == false){
                        sensorData[3]="0";
                    }
                    
                    
                    
                    
                                     
                    System.out.println(capCounter);
                    for (int i=0; i < sensorName.length; i++){
                        publishMessage(sensorName[i] + ":" + sensorData[i], client);
                        start = true;
                    }
                }
                
  /*              
                for (int i=0; i < sensorName.length; i++){
                    Result= r.nextInt(High-Low) + Low;
                    publishMessage(sensorName[i] + ": " + Result, client);
                    publishMessage(String.valueOf(dateFormat.format(timeSensorTwo)), client);
                    publishMessage(String.valueOf((timeSensorTwo.getTime()-timeSensorOne.getTime())/1000), client);
                    timeSensorTwo = new Date();
                }
                
                */
            } catch (InterruptedException | MqttException ex) {
                Logger.getLogger(MqttPublish.class.getName()).log(Level.SEVERE, null, ex);
            }     
        }  
        
        /*        
        for(long x = 0;x<100;x=x+1){
           try {
                TimeUnit.MILLISECONDS.sleep(1000);
                for (int i=0; i < sensorName.length; i++){
                                      
                    Result= r.nextInt(High-Low) + Low;
                    publishMessage(sensorName[i] + ": " + Result, client);
                }
                
            } catch (InterruptedException | MqttException ex) {
                Logger.getLogger(MqttPublish.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
*/ 
        
        try {
            closePublisher(client);
        } catch (MqttException ex) {
            Logger.getLogger(MqttPublish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void motorData(String[] sensorName, MqttClient client){
        Random r = new Random();
        int vLow = 0, low = 4500;
        int vHigh = 3, high = 4600;
        int vResult, result;
        
        for(long x = 0;x<100;x=x+1){
           try {
                TimeUnit.MILLISECONDS.sleep(500);
                for (int i=0; i < sensorName.length; i++){
                    //TimeUnit.MILLISECONDS.sleep(500);
                    
                    vResult= r.nextInt(vHigh-vLow) + vLow;
                    
                    if (vResult == 0){
                        low -= 100;
                        high -= 100;
                    } else if (vResult == 2){
                        low += 100;
                        high += 100;
                    }
                    
                    result = r.nextInt(high-low) + low;
                        
                    publishMessage(sensorName[i] + ":" + result, client);
                }
                
            } catch (InterruptedException | MqttException ex) {
                Logger.getLogger(MqttPublish.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            closePublisher(client);
        } catch (MqttException ex) {
            Logger.getLogger(MqttPublish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static MqttClient openPublisher(String newTopic, MqttClient client, String broker){
        
        topic = newTopic;

        MemoryPersistence persistence = new MemoryPersistence();

        try {
            client = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            client.connect(connOpts);
            System.out.println("Connected");

            //System.exit(0);
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
        
        return client;
    }
    
    public static void publishMessage(String newMessage, MqttClient client) throws MqttException{

        System.out.println("Publishing message: "+newMessage);
        MqttMessage message = new MqttMessage(newMessage.getBytes());
        message.setQos(qos);
        client.publish(topic, message);
        System.out.println("Message published");
    }
    
    public static void closePublisher(MqttClient client) throws MqttException{
        client.disconnect();
        System.out.println("Disconnected");
    }
}