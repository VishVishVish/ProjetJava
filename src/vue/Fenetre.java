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
import modele.Data;

/**
 * correspond à la fenêtre de jeu comprenant les différents panels sous forme de page de jeu
 * @author vishn
 */
public class Fenetre extends JFrame implements Data{
    
    public Fenetre(){
        super("FINN-ECE");

        this.setIconImage(new ImageIcon(getClass().getResource("/img/perso.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//stop l'application lors de la fermeture de la fenêtre
        
        this.setSize(new Dimension(1488,947));
        this.setLocation(200, 50); //place la fenêtre lors de son affichage
        //this.setContentPane(new PanelNiveau());
        //pack();
        setVisible(true);  
    }
    /**
     * permet de mettre sur écoute la fenêtre
     * 
     * @param controleur correspond à la classe gérant tous les évènements de l'application (déplacement, bouton,...)
     */
     public void enregistreEcouteur(Controleur controleur) {
        this.addKeyListener(controleur);
    }
    
     /**
      * modifie le contenue de la fenêtre 
      * @param container nouveau contenue de la fenêtre
      */
    public void setFenetre(Container container){
        
        this.setContentPane(container);
        this.setVisible(true);
        //this.repaint();
   
    }
    
}
