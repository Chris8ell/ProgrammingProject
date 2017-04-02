/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionsupportsystem;

/**
 *
 * @author phidi
 */
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SimpleMqttCallBack implements MqttCallback {
    String message;
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        //System.out.println("Message received:\t"+ new String(mqttMessage.getPayload()) );
        message = new String(mqttMessage.getPayload());
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }
    
    public String getMessage(){
        return message;
    }
}
