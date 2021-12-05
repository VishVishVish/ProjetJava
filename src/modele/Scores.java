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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * classe s'occupant des scores à la fin d'une partie 
 * @author vishn
 */
public class Scores {
    
    ArrayList<String[]> listeScore = new ArrayList<>();
    ArrayList<String[]> classement = new ArrayList<>();
    File file = new File("score.txt");

    public Scores()  {
        
        //InputStream in = this.getClass().getResourceAsStream("/score.txt");
        
        
        this.lire();
    }
    
    public void lire() {
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
 
        for( int i = 0; i<5; i++) {
            String [] scoreMax = this.max();
            classement.add(scoreMax);
            listeScore.remove(scoreMax);
        }
    }
    
    public void addScore(String nom, int score, int temps) {
        
        if(nom.length() != 4){
            if(nom.length()>4) {
                System.out.println("string = " + nom);
                nom = String.valueOf(nom.charAt(0)) + String.valueOf(nom.charAt(1)) + String.valueOf(nom.charAt(2)) + String.valueOf(nom.charAt(3)); 
                System.out.println("string = " + nom);
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
    
    /**
     * permet de convertir une donnée numérique dans un format adapté pour le fichier externe exemple : on passe de 12 à     0012
     * @param number correspond à une valeur numérique tel que le temps ou le score
     * @return une chaine de 4 caractères représentant la valeur numérique
     */
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
    
    /**
     * 
     * @param i
     * @return 
     */
    public String[] getClassement(int i){
        return classement.get(i);
    }
    /**
     * retourne le classement 
     * @return corresond le classemnt 
     */
    public ArrayList<String[]> getClassement(){
        return classement;
    }
    
    /**
     * retourne le meilleure score de la liste des scores 
     * @return correspond au meilleure score de la liste des scores
     */
    public String[] max(){
        if(listeScore.size()<=0) {
            String [] scoreVide = {"    ", "    ", "    "}; 
            return scoreVide;
        }
             
        String [] scoreMax = listeScore.get(0);
     
        for(int i = 0; i<listeScore.size(); i++){   
            if(Integer.parseInt(scoreMax[1])<Integer.parseInt(listeScore.get(i)[1])){
               scoreMax = listeScore.get(i);
       
            }
        }  
        return scoreMax;            
    }
    
   
    /**
     * retourne la liste des scores 
     * @return correspond à la liste des scores
     */
    public ArrayList<String[]> getListeScore(){
        return listeScore;
    }
    
    /**
     * modifie la liste des scores
     * @param listeScore correspond à la nouvelle liste des scores 
     */
    public void setListeScore(ArrayList<String[]> listeScore){
        this.listeScore =  listeScore;
    }
    
    
}
