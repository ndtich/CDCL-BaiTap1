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
public class TFIDF {

    public ArrayList<String> termFrequency(ArrayList<String> input, int round) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> features = getFeaturesList(input);
        //Tong so van ban
        int d = input.size();
        String srtFeatures = "";
        for(String feature:features){
            System.out.println(feature);
            srtFeatures += feature + " ";
        } 
        System.out.println(srtFeatures);
        result.add(srtFeatures);
        
        for(String line: input){
            String strFrequency = "";
            
                    for(String feature:features){
                            double tf = (double)wordCount(feature,line)/(double)wordCountMax(feature,input);
                            double idf = Math.log10((double)d/(double)lineCount(feature,input));
                               double tdidf=tf*idf;
                            strFrequency += (Double.toString(roundAvoid(tdidf,round))+ " ");
                        } 
                
            result.add(strFrequency);
        }
        return result;

    }

    // Đếm số lần xuất hiện của 1 từ trong 1 dòng
    public int wordCount(String word, String paragraph) {
        String arrayWord[] = paragraph.split(" ");
        int count = 0;

        for (String tempWord : arrayWord) {
            if (tempWord.equals(word))
                count++;
        }
        return count;
    }

    // Số lần xuất hiện nhiều nhất của 1 từ trong các dòng
    public int wordCountMax(String word, ArrayList<String> Lines) {
        int max = 0;
        for (String line : Lines) {
            int count = wordCount(word, line);
            if (count > max)
                max = count;
        }
        return max;
    }
    
    
    // Số lần xuất hiện nhiều nhất của 1 từ trong các dòng
    public int lineCount(String word, ArrayList<String> Lines) {
        int result = 0;
        for (String line : Lines) {
            int count = wordCount(word, line);
            if (count > 0)
               result++;
        
        }
        return result;
    }

    // lấy danh sách các đặc trưng
    public ArrayList<String> getFeaturesList(ArrayList<String> input) {
        ArrayList<String> features = new ArrayList<>();

        for (String line : input) {
            String arrayWord[] = line.split(" ");
            for (String feature : arrayWord) {
                if (!features.contains(feature))
                    features.add(feature);
            }
        }

        return features;

    }
      private double roundAvoid(double value, int places) {
    double scale = Math.pow(10, places);
    return Math.round(value * scale) / scale;
}
}
