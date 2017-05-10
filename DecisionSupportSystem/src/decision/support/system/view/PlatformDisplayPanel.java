/*
 *
 */

package decision.support.system.view;

import decision.support.system.controller.PlatformDisplayPanelController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlatformDisplayPanel extends JPanel{
    
    
    private final PlatformDisplayPanelController controller;
    private final PlatformView platformView;
    BufferedImage leftArrow;
            
    public static final String MACHINE01 = "MACHINE01";
    public static final String MACHINE02 = "MACHINE02";
    public static final String MACHINE03 = "MACHINE03";
    public static final String MACHINE04 = "MACHINE04";
    public static final String MACHINE05 = "MACHINE05";
    public static final String MACHINE06 = "MACHINE06";
        
    private JButton machine01;
    private JButton machine02;
    private JButton machine03;
    private JButton machine04;
    private JButton machine05;
    private JButton machine06;
    
    private JLabel lArrow;
    
    public PlatformDisplayPanel(PlatformView platformView) {
        this.platformView = platformView;
        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        this.setLayout(layout);
        this.controller = new PlatformDisplayPanelController(this);
        
        this.machine01 = new JButton(MACHINE01);
        this.machine01.setActionCommand(MACHINE01);
        machine01.setPreferredSize(new Dimension(100, 30));
        this.add(this.machine01);
        this.machine01.addActionListener(controller);
        this.machine01.setBackground(Color.GREEN);
        
        this.machine02 = new JButton(MACHINE02);
        this.machine02.setActionCommand(MACHINE02);
        machine02.setPreferredSize(new Dimension(100, 30));
        this.add(this.machine02);
        this.machine02.addActionListener(controller);
        this.machine02.setBackground(Color.GREEN);
        
        this.machine03 = new JButton(MACHINE03);
        this.machine03.setActionCommand(MACHINE03);
        machine03.setPreferredSize(new Dimension(100, 30));
        this.add(this.machine03);
        this.machine03.addActionListener(controller);
        this.machine03.setBackground(Color.GREEN);
        
        this.machine04 = new JButton(MACHINE04);
        this.machine04.setActionCommand(MACHINE04);
        machine04.setPreferredSize(new Dimension(100, 30));
        this.add(this.machine04);
        this.machine04.addActionListener(controller);
        this.machine04.setBackground(Color.GREEN);
        
        this.machine05 = new JButton(MACHINE05);
        this.machine05.setActionCommand(MACHINE05);
        machine05.setPreferredSize(new Dimension(100, 30));
        this.add(this.machine05);
        this.machine05.addActionListener(controller);
        this.machine05.setBackground(Color.GREEN);
        
        this.machine06 = new JButton(MACHINE06);
        this.machine06.setActionCommand(MACHINE06);
        machine06.setPreferredSize(new Dimension(100, 30));
        this.add(this.machine06);
        this.machine06.addActionListener(controller);
        this.machine06.setBackground(Color.GREEN);
        
       /*
        try {
            leftArrow = ImageIO.read(new File("LeftArrow.png"));
            lArrow = new JLabel(new ImageIcon(leftArrow));
        } catch (IOException ex) {
            Logger.getLogger(PlatformDisplayPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
         */   
 
        
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(50))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(machine01)
                .addComponent(machine06))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                //.addComponent(lArrow)
                .addGap(50))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(machine02)
                .addComponent(machine05))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(50))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(machine03)
                .addComponent(machine04))
         );
        
         layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addGap(50))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(machine01)
                .addComponent(machine02)
                .addComponent(machine03))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addGap(50))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(machine04)
                .addComponent(machine05)
                .addComponent(machine06))
            );
                        
        
    }
    
    public PlatformView getMainView(){
        return this.platformView;
    }
    
    public void updateView(String machineName, String machineNumber, String[] sensor, String[] test) {
        this.machine02.setBackground(Color.GREEN);
    }
}
