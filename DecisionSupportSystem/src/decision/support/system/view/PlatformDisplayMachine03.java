/*
 *
 */

package decision.support.system.view;

import decision.support.system.controller.PlatformDisplayMachine03Controller;
import decision.support.system.controller.PlatformDisplayPanelController;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PlatformDisplayMachine03 extends JPanel{
    
    
    private final static int NO_OF_SENSORS = 5;
    private final static int NO_OF_TESTS = 6;
    
    private final PlatformDisplayMachine03Controller controller;
    private final PlatformView platformView;
    
    //Set all of the visible objects in the GUI
    private final JLabel machineNameHeading = new JLabel("Machine Name: ");
    private final JLabel machineName = new JLabel("Machine 1");
    private final JLabel machineNumberHeading = new JLabel("Machine Number: ");
    private final JLabel machineNumber = new JLabel("none");
    private final JLabel sensorHeading = new JLabel("Sensor:");
    private final JLabel testHeading = new JLabel("Test:");
    
    public static final String BACK = "BACK";
    private JButton back;
    
    private final JLabel[] sensorLabel = new JLabel[NO_OF_SENSORS];
    private final JLabel[] sensor = new JLabel[NO_OF_SENSORS];
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
        
        for (int i = 0; i < NO_OF_SENSORS; i++){
            sensorLabel[i] = new JLabel(String.valueOf(i + 1));
            sensorLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            sensorLabel[i].setVerticalAlignment(SwingConstants.CENTER);
            sensor[i] = new JLabel("-");
            sensor[i].setHorizontalAlignment(SwingConstants.CENTER);
            sensor[i].setVerticalAlignment(SwingConstants.CENTER);
        }
        
        for (int i = 0; i < NO_OF_TESTS; i++){
            testLabel[i] = new JLabel(String.valueOf(i + 1));
            testLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            testLabel[i].setVerticalAlignment(SwingConstants.CENTER);
            test[i] = new JLabel("-");
            test[i].setHorizontalAlignment(SwingConstants.CENTER);
            test[i].setVerticalAlignment(SwingConstants.CENTER);
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
                    .addComponent(sensorHeading)
                    .addComponent(testHeading)
                    .addComponent(back))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(50))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(machineName)
                    .addComponent(machineNumber)
                    .addComponent(sensorLabel[0],10,10,50)
                    .addComponent(sensor[0],10,10,50)
                    .addComponent(testLabel[0],10,10,50)
                    .addComponent(test[0],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sensorLabel[1],10,10,50)
                    .addComponent(sensor[1],10,10,50)
                    .addComponent(testLabel[1],10,10,50)
                    .addComponent(test[1],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sensorLabel[2],10,10,50)
                    .addComponent(sensor[2],10,10,50)
                    .addComponent(testLabel[2],10,10,50)
                    .addComponent(test[2],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sensorLabel[3],10,10,50)
                    .addComponent(sensor[3],10,10,50)
                    .addComponent(testLabel[3],10,10,50)
                    .addComponent(test[3],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sensorLabel[4],10,10,50)
                    .addComponent(sensor[4],10,10,50)
                    .addComponent(testLabel[4],10,10,50)
                    .addComponent(test[4],10,10,50))  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(10))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(testLabel[5],10,10,50)
                    .addComponent(test[5],10,10,50))))          
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
                .addComponent(sensorHeading)
                .addComponent(sensorLabel[0])
                .addComponent(sensorLabel[1])
                .addComponent(sensorLabel[2])
                .addComponent(sensorLabel[3])
                .addComponent(sensorLabel[4]))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(sensor[0])
                .addComponent(sensor[1])
                .addComponent(sensor[2])
                .addComponent(sensor[3])
                .addComponent(sensor[4]))
             .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(50))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(testHeading)
                .addComponent(testLabel[0])
                .addComponent(testLabel[1])
                .addComponent(testLabel[2])
                .addComponent(testLabel[3])
                .addComponent(testLabel[4])
                .addComponent(testLabel[5]))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(test[0])
                .addComponent(test[1])
                .addComponent(test[2])
                .addComponent(test[3])
                .addComponent(test[4])
                .addComponent(test[5]))
           
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(50))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(back))
        );
    }
    
    public PlatformView getMainView(){
        return this.platformView;
    }
    
    public void updateView(String machineName, String machineNumber, String[] sensor, String[] test) {
        this.machineName.setText(machineName);
        this.machineNumber.setText(machineNumber);
        for (int i = 0; i < sensor.length; i++){
            this.sensor[i].setText(sensor[i]);
        }
        for (int i = 0; i < test.length; i++){
            this.test[i].setText(test[i]);
        }
    }
}
