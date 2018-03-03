/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap1;

import java.util.ArrayList;

/**
 *
 * @author Anh Tu
 */
public class BaiTap1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

    File file = new File();
    Process process = new Process();
    String path = "testout.txt";
    String inputPath = "testin.txt";
    String stopwordPath = "stopword.txt";
    
    ArrayList<String> listStopWord = new ArrayList<String>();
    ArrayList<String> listLines = new ArrayList<String>();
    
    // read data
    listStopWord= file.read(stopwordPath);
    listLines = file.read(inputPath);
    
    // process  
    listLines = process.removeRegex(listLines);
    listLines = process.removeStopWord(listLines, listStopWord);
    listLines = process.upperToLowerDeleteSpace(listLines);
    
    // write to file
    file.write(path, listLines);

    }
    
    
}
