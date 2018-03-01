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
        // TODO code application logic here
    File file = new File();
    String path = "C:\\Users\\Anh Tu\\Desktop\\testout.txt";
    String inputPath = "C:\\Users\\Anh Tu\\Desktop\\testin.txt";
    
    

    ArrayList<String> listLines = new ArrayList<String>();
    
    listLines = file.read(inputPath);
    file.write(path, listLines);

    }
    
    
}
