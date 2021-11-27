/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vishn
 */
public class Scores {
    
    ArrayList<String[]> listeScore = new ArrayList<>();
    ArrayList<String[]> classement = new ArrayList<>();
    

    //File file = new File(in);
    
    
    public Scores()  {
        
        //InputStream in = this.getClass().getResourceAsStream("/score.txt");
        File file = new File("score.txt");
        
        Scanner scanner;
        try {
            scanner = new Scanner(file);
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
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for(int i = 0; i<5; i++) {
            String [] scoreMax = this.max();
            classement.add(scoreMax);
            listeScore.remove(scoreMax);
        }
    }
    
    public void addScore(String nom, int score, int temps) {
        
        if(nom.length() != 4){
            if(nom.length()>4) {
                nom = String.valueOf(nom.charAt(0) + nom.charAt(1) + nom.charAt(2) + nom.charAt(3) ); 
            }
            else {
                nom = "----";
            }
        }
        
        
            
        String newScore = nom + convertNumberToString(score) + convertNumberToString(temps);
        
 
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("score.txt", true)));
            out.println(newScore);
            out.close();
        } catch (IOException e) {
        
        }
    }
    
    
    public String convertNumberToString(int number){
        String string;
        if(number>9999)
            string = "9999";
        else if(number>999)
            string = String.valueOf(number);
        else if (number>99)
            string = "0" + String.valueOf(number);
        else if (number>9)
            string = "00" + String.valueOf(number);
        else if (number>=0)
            string = "000" + String.valueOf(number);
        else {
            System.out.println("error conversion number to string");
            string = "0000";
        }
        
        return string;
            
        
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