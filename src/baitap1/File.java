/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Anh Tu
 */
public class File {



public void write(String path, ArrayList<String> listLines)  throws Exception{
    
        try {
        FileWriter writer = new FileWriter(path);
        BufferedWriter buffer = new BufferedWriter(writer);
        for (String line: listLines) {
        	
        	
            buffer.write(line);
            
            buffer.newLine();
        }
        buffer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
}

public ArrayList<String> read(String path)  throws Exception {
    
   ArrayList<String> listLines = new ArrayList<String>();
     String thisLine = null;
    FileReader reader  = new FileReader(path);
        BufferedReader buffer = new BufferedReader(reader);
              try {
      
         
         while ((thisLine = buffer.readLine()) != null) {
            listLines.add(thisLine);
         }       
      } catch(Exception e) {
         e.printStackTrace();
      }
        buffer.close();
        reader.close();
        
        return listLines;

}



}
