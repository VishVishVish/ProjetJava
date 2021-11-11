/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import controleur.Controleur;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author vishn
 */
public class Fenetre extends JFrame {
    
    public Fenetre(){
        super("Fenêtre de jeu");
        setSize(1000,700);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//stop l'application lors de la fermeture de la fenêtre
        //setLayout(new BorderLayout());
        
        //setFocusable(false);
        //this.setLayout(null);
        
        this.setLocation(600, 50); //place la fenêtre lors de son affichage
       
        setVisible(true);
        
    }
    
     public void enregistreEcouteur(Controleur controleur) {
        this.addKeyListener(controleur);
    }
    
    public void setFenetre(Container container){
        
        this.setContentPane(container);
        this.setVisible(true);
        //this.repaint();
        
        
        
    }
    
}
