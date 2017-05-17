/*
 * Phidias Burnell (s2066815)
 * Christopher James Bell (s3243530)
 * Programming Project Assignment - CPT331
 */

package decision.support.system.view;

import decision.support.system.controller.PlatformDisplayMachine03Controller;
import static decision.support.system.model.interfaces.DistributingMachine.TESTS;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class PlatformDisplayMachine03 extends JPanel{
    
    
    private final static int NO_OF_SENSORS = 5;
    private final static int NO_OF_TESTS = TESTS.length;
    
    private final PlatformDisplayMachine03Controller controller;
    private final PlatformView platformView;
    
    //Set all of the visible objects in the GUI
    private final JLabel machineNameHeading = new JLabel("Machine Name: ");
    private final JLabel machineName = new JLabel("none");
    private final JLabel machineNumberHeading = new JLabel("Machine Number: ");
    private final JLabel machineNumber = new JLabel("none");
    private final JLabel sensorHeading = new JLabel("Sensors");
    private final JLabel scenarioHeading = new JLabel("Scenarios");
    
    public static final String BACK = "BACK";
    private JButton back;
    
    private final JLabel[] sensorLabel = new JLabel[NO_OF_SENSORS];
    private final JLabel[][] sensor = new JLabel[NO_OF_SENSORS][NO_OF_TESTS];
    private final JLabel[] testLabel = new JLabel[NO_OF_TESTS];
    private final JLabel[] test = new JLabel[NO_OF_TESTS];
    
    public PlatformDisplayMachine03(PlatformView platformView) {
        this.platformView = platformView;
        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        this.setLayout(layout);
        this.controller = new PlatformDisplayMachine03Controller(this);
        
        this.back = new JButton(BACK);
        this.back.setActionCommand(BACK);
        back.setPreferredSize(new Dimension(100, 30));
        this.add(this.back);
        this.back.addActionListener(controller);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK);
          
        for (int i = 0; i < NO_OF_SENSORS; i++){
            sensorLabel[i] = new JLabel(String.valueOf(i + 1));
            sensorLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            sensorLabel[i].setVerticalAlignment(SwingConstants.CENTER);
            
            for (int t = 0; t < NO_OF_TESTS; t++){
                sensor[i][t] = new JLabel("-");
                sensor[i][t].setHorizontalAlignment(SwingConstants.CENTER);
                sensor[i][t].setVerticalAlignment(SwingConstants.CENTER);
                sensor[i][t].setBorder(border);
                sensor[i][t].setOpaque(true);
                sensor[i][t].setBackground(Color.BLACK);
                sensor[i][t].setForeground(Color.BLACK);
            }
        }
        
        for (int i = 0; i < NO_OF_TESTS; i++){
            testLabel[i] = new JLabel(String.valueOf(i + 1));
            testLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            testLabel[i].setVerticalAlignment(SwingConstants.CENTER);
            test[i] = new JLabel(TESTS[i]);
            test[i].setHorizontalAlignment(SwingConstants.CENTER);
            test[i].setVerticalAlignment(SwingConstants.CENTER);
            test[i].setOpaque(true);
        }
        
        //Used GroupLayout to control the layout of the GUI
        //GroupLayout requires both horizontal and vertical positioning
        
        //Horizontal positioning
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(machineNameHeading)
                    .addComponent(machineNumberHeading)
                    .addComponent(back))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(machineName)
                    .addComponent(machineNumber)
                    .addComponent(scenarioHeading))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(testLabel[0],10,10,50)
                    .addComponent(testLabel[1],10,10,50)
                    .addComponent(testLabel[2],10,10,50)
                    .addComponent(testLabel[3],10,10,50)
                    .addComponent(testLabel[4],10,10,50)
                    .addComponent(testLabel[5],10,10,50))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)        
                    .addComponent(sensorHeading)
                    .addComponent(sensorLabel[0],10,10,50)
                    .addComponent(sensor[0][0],10,10,50)
                    .addComponent(sensor[0][1],10,10,50)
                    .addComponent(sensor[0][2],10,10,50)
                    .addComponent(sensor[0][3],10,10,50)
                    .addComponent(sensor[0][4],10,10,50)
                    .addComponent(sensor[0][5],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sensorLabel[1],10,10,50)
                    .addComponent(sensor[1][0],10,10,50)
                    .addComponent(sensor[1][1],10,10,50)
                    .addComponent(sensor[1][2],10,10,50)
                    .addComponent(sensor[1][3],10,10,50)
                    .addComponent(sensor[1][4],10,10,50)
                    .addComponent(sensor[1][5],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sensorLabel[2],10,10,50)
                    .addComponent(sensor[2][0],10,10,50)
                    .addComponent(sensor[2][1],10,10,50)
                    .addComponent(sensor[2][2],10,10,50)
                    .addComponent(sensor[2][3],10,10,50)
                    .addComponent(sensor[2][4],10,10,50)
                    .addComponent(sensor[2][5],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sensorLabel[3],10,10,50)
                    .addComponent(sensor[3][0],10,10,50)
                    .addComponent(sensor[3][1],10,10,50)
                    .addComponent(sensor[3][2],10,10,50)
                    .addComponent(sensor[3][3],10,10,50)
                    .addComponent(sensor[3][4],10,10,50)
                    .addComponent(sensor[3][5],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sensorLabel[4],10,10,50)
                    .addComponent(sensor[4][0],10,10,50)
                    .addComponent(sensor[4][1],10,10,50)
                    .addComponent(sensor[4][2],10,10,50)
                    .addComponent(sensor[4][3],10,10,50)
                    .addComponent(sensor[4][4],10,10,50)
                    .addComponent(sensor[4][5],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(test[0])
                    .addComponent(test[1])
                    .addComponent(test[2])
                    .addComponent(test[3])
                    .addComponent(test[4])
                    .addComponent(test[5]))))          
        );
        
        //Vertical positioning
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(machineNameHeading)
                .addComponent(machineName))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(machineNumberHeading) 
                .addComponent(machineNumber))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(50))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)    
                .addComponent(sensorHeading))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE) 
                .addComponent(scenarioHeading)
                .addComponent(sensorLabel[0])
                .addComponent(sensorLabel[1])
                .addComponent(sensorLabel[2])
                .addComponent(sensorLabel[3])
                .addComponent(sensorLabel[4]))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(testLabel[0])
                .addComponent(sensor[0][0])
                .addComponent(sensor[1][0])
                .addComponent(sensor[2][0])
                .addComponent(sensor[3][0])
                .addComponent(sensor[4][0])
                .addComponent(test[0]))
             
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(testLabel[1])
                .addComponent(sensor[0][1])
                .addComponent(sensor[1][1])
                .addComponent(sensor[2][1])
                .addComponent(sensor[3][1])
                .addComponent(sensor[4][1])
                .addComponent(test[1]))
             
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(testLabel[2])
                .addComponent(sensor[0][2])
                .addComponent(sensor[1][2])
                .addComponent(sensor[2][2])
                .addComponent(sensor[3][2])
                .addComponent(sensor[4][2])
                .addComponent(test[2]))
         
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(testLabel[3])
                .addComponent(sensor[0][3])
                .addComponent(sensor[1][3])
                .addComponent(sensor[2][3])
                .addComponent(sensor[3][3])
                .addComponent(sensor[4][3])
                .addComponent(test[3]))
 
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(testLabel[4])
                .addComponent(sensor[0][4])
                .addComponent(sensor[1][4])
                .addComponent(sensor[2][4])
                .addComponent(sensor[3][4])
                .addComponent(sensor[4][4])
                .addComponent(test[4]))
   
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(testLabel[5])
                .addComponent(sensor[0][5])
                .addComponent(sensor[1][5])
                .addComponent(sensor[2][5])
                .addComponent(sensor[3][5])
                .addComponent(sensor[4][5])
                .addComponent(test[5]))  
           
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(50))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(back))
        );
        
        this.sensor[0][0].setBackground(Color.WHITE);
        this.sensor[1][1].setBackground(Color.WHITE);
        this.sensor[2][1].setBackground(Color.WHITE);
        this.sensor[0][2].setBackground(Color.WHITE);
        this.sensor[0][3].setBackground(Color.WHITE);
        this.sensor[3][3].setBackground(Color.WHITE);
        this.sensor[4][4].setBackground(Color.WHITE);
        this.sensor[2][5].setBackground(Color.WHITE);
        
        this.machineName.setText(platformView.getDecisionSupportEngine().getMachine("03").getMachineName());
        this.machineNumber.setText(platformView.getDecisionSupportEngine().getMachine("03").getMachineID());
    }
    
    public PlatformView getMainView(){
        return this.platformView;
    }
    
    public void updateView(String machineName, String machineNumber, String[] sensor, String[] test) {
        this.machineName.setText(machineName);
        this.machineNumber.setText(machineNumber);
        for (int s = 0; s < sensor.length; s++){
            for (int t = 0; t < NO_OF_TESTS; t++){
                this.sensor[s][t].setText(sensor[s]);
            }
        }
        
        for (int t = 0; t < NO_OF_TESTS; t++){
            if(test[t]=="GREEN"){
                this.test[t].setBackground(Color.GREEN);
            } else if(test[t]=="AMBER"){
                this.test[t].setBackground(Color.ORANGE);
            }  else {
                this.test[t].setBackground(Color.RED);
            }
                    
        }
        
    }
}
