/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.support.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author phidi
 */



public class MainSystem {
 
    private String sensor1;
    private String sensor2;
    private String sensor3;
    private int x = 1;
    private String folder = "C:\\temp_start\\";
    
    public MainSystem() {
        sensor1 = "None";
        sensor2 = "None";
        sensor3 = "None";
    }
     
    public void openRepository() throws IOException{
      
        try {
            
            String fileName = "";
            File actual = new File(folder);
            for(long x = 0; x < 999999999; x = x + 1) {
            }
            
            if (actual.list().length > 0) {
                for( File f : actual.listFiles()){
                    if ((fileName.compareTo(f.getName()) == 1) || (fileName.equals(""))) {
                        fileName = f.getName();
                    }
                }

                BufferedReader file;

                file = new BufferedReader (new FileReader (folder + fileName));
                String fileLine = file.readLine();
                String[] splitFileLine;

                // loop through each line of the file and parse data based on ; delimiter
                while (fileLine != null) {
                    splitFileLine = fileLine.split(";");
                    sensor1 = splitFileLine[0];
                    sensor2 = splitFileLine[1];
                    sensor3 = splitFileLine[2];

                    fileLine = file.readLine();

                }
                file.close();
                System.out.println(folder + fileName + "File");
                Files.delete(Paths.get(folder + fileName));
            }
        
        }
                
        catch(Exception e){
            System.out.println("No data was loaded from " + e.getMessage());
            System.out.println();
        }

    }
           
    
    public String getSensorData1() {
        
        return sensor1;
    }
    
    public String getSensorData2() {
        
        return sensor2;
    }
    
    public String getSensorData3() {
        
        return sensor3;
    }
}
