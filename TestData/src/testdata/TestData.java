/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestData {

    private static final String FOLDER = "C:\\temp_start\\";
       
     public static void main(String args[]) throws IOException {
        long fileSequenceNumber = 0;   
        PrintWriter file;
        Random r = new Random();
        int d1, d2, d3;
        
        for(long x = 0; x < 10000; x = x + 1) {
            
            file = new PrintWriter (new FileWriter (FOLDER+"data"+fileSequenceNumber+".txt"));
            
            d1 = r.nextInt((100 - 1) + 1) + 1;
            d2 = r.nextInt((100 - 1) + 1) + 1;
            d3 = r.nextInt((100 - 1) + 1) + 1;
            
            file.println(d1 + ";" + d2 + ";" + d3);
        
            file.close();
            
            fileSequenceNumber += 1;
        } 
    }
}
