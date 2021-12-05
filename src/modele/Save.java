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
 * classe permettant de sauvegarder dans un fichier externe une partie déjà commencé
 * @author vishn
 */
public class Save {
    /**
     * correspond au numéro du niveau
     */
    private int numNiveau;
    /**
     * correspond au score
     */
    private int score;
    /**
     * correspond au temps
     */
    private int temps;
    File file = new File("save.txt");
    
    
    public Save(){
        
    }
    
    /**
     * permet d'écraser ou créer les données de sauvegarde dans le fichier externe save.txt
     * @param numNiveau correspond au numéro du niveau de la partie chargé
     * @param score correspond au score de la partie chargé
     * @param temps correspond au temps de la partie chargé
     */
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
    
    /**
     * permet de lire les données de sauvegarde dans le fichier externe save.txt
     */
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
    
    
    
    /**
     * permet de convertir une donnée numérique dans un format adapté pour le fichier externe exemple : on passe 12 à 0012
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
     * retourne le numéro de niveau
     * @return correspond au numéro de niveau
     */
    public int getNumNiveau(){
        return numNiveau;
    }
    
    /**
     * retourne le score
     * @return correspond au score
     */
    public int getScore(){
        return score;
    }
    
    /**
     * retourne le temps 
     * @return correspond au temps
     */
    public int getTemps(){
        return temps;
    }
    
    /**
     * modifie le numéro du niveau
     * @param numNiveau correspond à la nouvelle valeur du numéro du niveau
     */
    public void setNumNiveau(int numNiveau){
         this.numNiveau = numNiveau;
    }
    
    /**
     * modifie le score
     * @param score correspond à la nouvelle valeur du score
     */
    public void setScore(int score){
         this.score = score;
    }
    /**
     * modifie le temps 
     * @param temps correspond à la nouvelle valeur du temps
     */
    public void setTemps(int temps){
         this.temps = temps;
    }
    
    
    
}
