/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionsupportsystem;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author phidi
 */


public class MainControlCL {
    
    private static final Scanner sc = new Scanner(System.in);

    DataCollection mainSystem; 
    private static boolean exit = false;
    
/*
    public static void main(String args[]) throws IOException, InterruptedException {
        boolean exit = false;
        System.out.println("Start");
        DataCollection mainSystem = new DataCollection(); 
       
        do {

            //System.out.println("Start running");
            mainSystem.openRepository();
            System.out.print(mainSystem.getSensorData1());
            System.out.print(mainSystem.getSensorData2());
            System.out.println(mainSystem.getSensorData3());
        } while (!exit);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
    }
*/    
    public static void main(String args[]) throws IOException, InterruptedException, MqttException {
        
        
        DataCollection [] data = new DataCollection[6];
        for (int x=0;x<6;x++){
            data[x] = new DataCollection();
        }
        
        //String newSet[] = {"sensor_1","sensor_2"};
        //DataCollection data = new DataCollection(newSet);

        
        clearScreen();
        char selection = '\0';
        String userInput;
        int subCount = 0;
        
        Thread thread;
        thread = new Thread(new Runnable() {

            int x = 0;
            @Override
            public void run() {
                do {
                    clearScreen();
                    printMenu();
                    for (int x=0;x<6;x++){
                        System.out.println(data[x].getSensorData());
                    }
                    
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainControlCL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } while (!exit);
            }
        });
        
        do
        {
            printMenu();
            userInput = sc.nextLine();

            System.out.println();

            // validate selection input length
            if (userInput.length() != 1)
            {
               System.out.println("Error - invalid selection!");
            }
            else
            {
                // make selection "case insensitive"
                selection = Character.toUpperCase(userInput.charAt(0));

                // process user's selection
                switch (selection)
                {
                    case 'A':
                        //data.startSubscriber();

                        if (subCount == 0){
                            thread.start();
                            for (;subCount<6;subCount++){
                                data[subCount].startSubscriber("sensor_"+subCount);
                            }
                        }

                        break;

                    case 'B':
                        
                        if (subCount != 0){
                            for (int x = 0;x<6;x++){
                                data[x].closeSubscriber();
                                
                            }
                            exit = true;
                            
                            subCount =0;
                        }
                        break;

                    case 'X':
                        System.out.println("Exiting the program...");
                        break;

                  default:
                     System.out.println("Error - invalid selection!");
               }
            }
            System.out.println();
            
            clearScreen();
            
             
            
            //System.out.println(data.getSensorData());
            
        } while (selection != 'X');


    }
    
    public static void printMenu(){
        // print menu to screen
        System.out.println("*** Decision Support System ***");
        System.out.println();

        System.out.printf("%-25s%s\n", "Start MQTT listners", "A");
        System.out.printf("%-25s%s\n", "Stop", "B");
        System.out.printf("%-25s%s\n", "Exit Program", "X");
        System.out.println();

        // prompt user to enter selection
        System.out.print("Enter selection: ");
    }
    public void activateMessges() throws IOException {
        
       // boolean exit = false;
        
        
        Thread thread;
        thread = new Thread(new Runnable() {
            private volatile boolean exit = false;
            int x = 0;
            @Override
            public void run() {
                
                
                do {
                    try {
                        //System.out.println("Start running");
                        mainSystem.openFileRepository();
                        System.out.println(mainSystem.getSensorData());

                    } catch (IOException ex) {
                        Logger.getLogger(MainControlCL.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } while (!exit);
            }
            
            public void stopRunning(){
                exit = true;
            }
        });
            
        thread.start();   
   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

         

        //System.in.read();
        //stop();

    }
    
    public void stop(){
       // exit = true;
    }
    
    public static void clearScreen(){
        String os = System.getProperty("os.name");
        if (os.contains("Windows"))
        {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        }
        else
        {
            System.out.print("\f");
        }
    }

}
