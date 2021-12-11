/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * correspond au chronomètre d'une partie 
 * @author vishn
 */
public class Chrono implements Runnable {
    
    /**
     * correspond au temps
     */
    private int temps;
    
    /**
     * thread du chronomètre
     */
    Thread threadChrono;
    
    /**
     * permet de rendre actif le chronomètre
     */
    boolean boolActif; 
    
    /**
     * constructeur de la classe Chrono
     */
    public Chrono () {
        temps = 0;
        threadChrono = new Thread(this);
        boolActif = true;
    }
    
    /**
     * permet de lancer le chronomètre
     */
    public void start(){
        threadChrono.start();   
    }
    
    /**
     * permet de mettre en pause le chronomètre
     */
    public void pause(){
        boolActif = false; 
    }
    
    /**
     * permet de continuer le chronomètre
     */
    public void restart(){
        boolActif = true; 
    }
        
    /**
     * permet d'incrémenter le temps de +1 toutes les 1 secondes 
     */
    @Override
    public void run(){
        while(boolActif){
            
            try {
            Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Chrono.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println(temps);
            temps++;
            
        }   
    }
    
    /**
     * retourne le temps 
     * @return correspond au temps
     */
    public int getTemps(){
        return temps;
    }
    
    /**
     * modifie le temps 
     * @param temps correspond au nouveau temps 
     */
    public void setTemps(int temps){
        this.temps = temps;  
    }
    
 
}

    
    
    

    


 
        
        

        
 
    

