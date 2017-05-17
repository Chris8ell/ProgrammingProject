/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.view;

import decision.support.system.callback.DSECallbackImpl;
import decision.support.system.model.CapFeedingMachineImpl;
import decision.support.system.model.DataCollection;
import decision.support.system.model.DecisionSupportEngineImpl;
import static decision.support.system.model.interfaces.CapFeedingMachine.SENSORID;
import decision.support.system.model.interfaces.DecisionSupportEngine;
import decision.support.system.model.interfaces.Machine;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;

public class CommandView {
    
    private static final Scanner sc = new Scanner(System.in);
    private static boolean exit = false;
    private static int machines = 1;
    private static int sensors = 5;
    private static Logger logger = Logger.getLogger("CommandView");
    private static final DecisionSupportEngine decisionSupportEngine = new DecisionSupportEngineImpl();
    private static String[] machineNumber = new String[] {"03", "04"};
    private static String[] machineTopics = new String[] {"festo/03", "festo/04"};
    
  
    public static void main(String args[]) throws IOException, InterruptedException, MqttException {
        
        
        decisionSupportEngine.addEngineCallback(new DSECallbackImpl());
        Machine machines[] = new Machine[] { new CapFeedingMachineImpl(machineNumber[0], decisionSupportEngine)};
        
        for (Machine machine : machines) {
			decisionSupportEngine.addMachine(machine);}
        
        for (Machine machine : decisionSupportEngine.getAllMachineSetup())
                                logger.log(Level.INFO, machine.toString());
        
        DataCollection dataCollection = new DataCollection(SENSORID.length, decisionSupportEngine);
        
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
                    
                        //clearScreen();
                        //printMenu();
                        //System.out.println();
                    
                    /*try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CommandView.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
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
                        if (subCount == 0){
                            
                            dataCollection.startSubscriber(machineTopics);
                        }

                        break;

                    case 'B':
                        try {
                            dataCollection.closeSubscriber();
                        } catch (MqttException e){
                            break;
                        }
                        break;

                    case 'X':
                        System.out.println("Exiting the program...");
                        try {
                            dataCollection.closeSubscriber();
                        } catch (MqttException e){
                            break;
                        }
                        break;

                  default:
                     System.out.println("Error - invalid selection!");
               }
            }
            System.out.println();
            
            clearScreen();
            
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
            //System.out.print("\f");
            System.out.print("\033\143");
        }
    }

}
