/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdata;

/**
 *
 * @author phidi
 */
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublishSample {

public static void main(String[] args) {
   
    Thread t1, t2, t3;
        t1 = new Thread(new Runnable() {
            int x = 0;
            @Override
            public void run() {
                for(long x = 0;x<100000;x=x+1){
                        openPublisher("Sensor_0: " + x, "sensor_0");
                        System.out.println("Vale of x is " + x);
                }
            }
        });
        
        t2 = new Thread(new Runnable() {
            int x = 0;
            @Override
            public void run() {
                for(long x = 0;x<100000;x=x+1){
                        openPublisher("Sensor_1: " + x, "sensor_1");
                        System.out.println("Vale of x is " + x);
                }
            }
        });
        
        t3 = new Thread(new Runnable() {
            int x = 0;
            @Override
            public void run() {
                for(long x = 0;x<100000;x=x+1){
                        openPublisher("Sensor_2: " + x, "sensor_2");
                        System.out.println("Vale of x is " + x);
                }
            }
        });
    
        t1.start();
        t2.start();
        t3.start();
    
    
    
    
}

public static void openPublisher(String newMessage, String newTopic){

    String topic = newTopic;
    String content = newMessage;
    int qos             = 2;
    String broker       = "tcp://localhost:1883";
    String clientId     = "JavaSample";
    MemoryPersistence persistence = new MemoryPersistence();

    try {
        MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        System.out.println("Connecting to broker: "+broker);
        sampleClient.connect(connOpts);
        System.out.println("Connected");
        System.out.println("Publishing message: "+content);
        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(qos);
        sampleClient.publish(topic, message);
        System.out.println("Message published");
        sampleClient.disconnect();
        System.out.println("Disconnected");
        //System.exit(0);
    } catch(MqttException me) {
        System.out.println("reason "+me.getReasonCode());
        System.out.println("msg "+me.getMessage());
        System.out.println("loc "+me.getLocalizedMessage());
        System.out.println("cause "+me.getCause());
        System.out.println("excep "+me);
        me.printStackTrace();
    }
}
}