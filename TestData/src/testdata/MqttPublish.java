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

public class MqttPublish {
    
    
    private static String topic;
    private static int qos = 2;
    private static String broker1 = "tcp://localhost:1883";
    private static String broker2 = "tcp://localhost:1883";
    private static String broker3 = "tcp://localhost:1883";
    private static String clientId = "JavaSample";
    public static MqttClient newClient1, newClient2;
    
    public static void main(String[] args) throws InterruptedException, MqttException{

        Thread t1, t2, t3;
         
        t1 = new Thread(new Runnable(){
                
                int x = 0;
                @Override
                
                public void run() {
                    newClient1 = openPublisher("Machine1", newClient1, broker1);
                    String[] sensors = {"sensor_1", "sensor_2", "sensor_3"};
                    runnableRun(sensors, newClient1);
                }
            });
/*
            t2 = new Thread(new Runnable(){
                MqttClient newClient2;
                int x = 0;
                @Override
                public void run() {
                    newClient1 = openPublisher("Machine1", newClient1, broker1);
                    String[] sensors = {"sensor_1", "sensor_2", "sensor_3"};
                    runnableRun(sensors, newClient1);
                }
            });

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
            t1.start();
//            t2.start();
 //           t3.start();
    }
    
    public static void runnableRun(String[] sensorName, MqttClient client){
        
        for(long x = 0;x<100000;x=x+1){
           try {
                TimeUnit.MILLISECONDS.sleep(500);
                for (int i=0; i < sensorName.length; i++){
                    TimeUnit.MILLISECONDS.sleep(500);
                    publishMessage(sensorName[i] + ": " + x, client);
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