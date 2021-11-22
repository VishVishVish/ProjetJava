/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author vishn
 */
public class Scores {
    
    ArrayList<String[]> listeScore = new ArrayList<>();
    ArrayList<String[]> classement = new ArrayList<>();
    File file = new File("score.txt");
    
    
    public Scores()  {
        
        try {

            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNextLine()) {
            
                String strScore = scanner.nextLine();
                String pseudo = "";
                String score = "";
                String temps = "";
                
                for(int i = 0; i<4; i++ ) 
                    pseudo += Character.toString(strScore.charAt(i));
                
                for(int j = 4; j<8; j++ ) 
                    score += Character.toString(strScore.charAt(j));
                    
                for(int k = 8; k<12; k++ ) 
                    temps += Character.toString(strScore.charAt(k));
                
                String [] ligne  = {pseudo,score,temps}; 
                listeScore.add(ligne);
            }
            scanner.close();    
        }
        catch(IOException e){e.printStackTrace();}
        
        for(int i = 0; i<5; i++) {
            String [] scoreMax = this.max();
            classement.add(scoreMax);
            listeScore.remove(scoreMax);
        }
    }
    
    public String[] getClassement(int i){
        return classement.get(i);
    }
    public ArrayList<String[]> getClassement(){
        return classement;
    }
    
    public String[] max(){
                 
        String [] scoreMax = listeScore.get(0);
     
        for(int i = 0; i<listeScore.size(); i++){   
            if(Integer.parseInt(scoreMax[1])<Integer.parseInt(listeScore.get(i)[1])){
               scoreMax = listeScore.get(i);
       
            }
        }
        
        return scoreMax;
            
    }
    
   
    
    public ArrayList<String[]> getListeScore(){
        return listeScore;
    }
    
    public void setListeScore(ArrayList<String[]> listeScore){
        this.listeScore =  listeScore;
    }
    
    
}
