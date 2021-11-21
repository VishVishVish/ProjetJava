/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vishn
 */
public class Chrono implements Runnable {
  
    private int temps;
    Thread threadChrono;
    boolean boolActif; 
    
    public Chrono () {
        temps = 0;
        threadChrono = new Thread(this);
        boolActif = true;
    }
    
    public void start(){
        threadChrono.start();   
    }
    
    public void pause(){
        boolActif = false; 
    }
    public void restart(){
        boolActif = true; 
    }
    
    

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
    
    public int getTemps(){
        return temps;
    }
    
    public void setTemps(int temps){
        this.temps = temps;  
    }
    
    
    public static void main(String [] args){
        Chrono chrono = new Chrono();
        chrono.start();
        chrono.pause();
        //chrono.restart();
         
    }
}

    
    
    

    


 
        
        

        
 
    

