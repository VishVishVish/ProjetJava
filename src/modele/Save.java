/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vishn
 */
public class Save {
    private int numNiveau;
    private int score;
    private int temps;
    File file = new File("save.txt");
    
    
    public Save(){
        
    }
    
    public void ecrire(int numNiveau, int score, int temps){
        this.numNiveau = numNiveau;
        this.score = score;
        this.temps= temps;
        
        String strSave = numNiveau + convertNumberToString(score) + convertNumberToString(temps);
        try {
            FileWriter fw  = new FileWriter("save.txt", false);
            fw.write(strSave);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void lire(){
         try {

            Scanner scanner = new Scanner(file);
            
             
            
            String strSave= scanner.nextLine();

            //String strNumNiveau = "";
            String strScore = "";
            String strTemps = "";

            int i = 0; 
            numNiveau = Integer.parseInt(Character.toString(strSave.charAt(i)));

            for(i = 1; i<5; i++ ) 
                strScore += Character.toString(strSave.charAt(i));

            score = Integer.parseInt(strScore);

            for(i= 5; i<9; i++ ) 
                strTemps += Character.toString(strSave.charAt(i));

            temps = Integer.parseInt(strTemps);
                

            scanner.close();    
        }
        catch(IOException e){e.printStackTrace();}
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
    
    public int getNumNiveau(){
        return numNiveau;
    }
    public int getScore(){
        return score;
    }
    public int getTemps(){
        return temps;
    }
    
    public void setNumNiveau(int numNiveau){
         this.numNiveau = numNiveau;
    }
    public void setScore(int score){
         this.score = score;
    }
    public void setTemps(int temps){
         this.temps = temps;
    }
    
    
    
}
