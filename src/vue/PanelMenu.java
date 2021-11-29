/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import modele.Data;
import controleur.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * panel correspondant au menu principal du jeu
 * @author Vishnou Peroumalnaikar
 */
public class PanelMenu extends JPanel implements Data{
    
    JLabel labelTitre = new JLabel("FINN-ECE", JLabel.CENTER);
    JButton boutonNouvellePartie = new JButton("NOUVELLE PARTIE");
    JButton boutonContinuer = new JButton("CONTINUER");
    JButton boutonScore = new JButton("SCORE");
    JButton boutonBonus = new JButton("BONUS");
    JButton boutonRegles = new JButton("RÈGLES");
    JButton boutonSortie = new JButton("QUITTER");
    
    JButton [] boutons = {boutonNouvellePartie, boutonContinuer, boutonScore, boutonBonus, boutonRegles, boutonSortie};
   
    Font fontTitre = new Font(fontPolice, Font.BOLD, 160);
    Font fontBouton1 = new Font(fontPolice, Font.BOLD, 40);
    Font fontBouton2 = new Font(fontPolice, Font.BOLD, 25);
    /**
     * constructeur de PanelMenu correspondant au menu principal du jeu
     */
    public PanelMenu () {
        //on personnalise le label du titre du jeu   
        labelTitre.setFont(fontTitre);
        labelTitre.setForeground(Color.WHITE);
        labelTitre.setPreferredSize(new Dimension(1000, 250));
        //labelTitre.setBackground(Data.COLOR_ICE);
        
        
        //on modifie la police, taille des textes des JLabels et des JButtons
        for (JButton bouton : boutons) {
            bouton.setBorder(BorderFactory.createLineBorder(COLOR_ICE,4, true));
            bouton.setBackground(Data.COLOR_SNOW);
            bouton.setForeground(COLOR_ICE);
            bouton.setPreferredSize(new Dimension(100,100));
            bouton.setFocusable(false);
        }
      
        boutonNouvellePartie.setFont(fontBouton1);
        boutonContinuer.setFont(fontBouton1);
        boutonScore.setFont(fontBouton2);
        boutonBonus.setFont(fontBouton2);
        boutonRegles.setFont(fontBouton2);
        boutonSortie.setFont(fontBouton1);
        
       
        JPanel panelMilieu = new JPanel(new GridBagLayout());
     
        //panelMilieu.setBackground(new Color(128,255,255));
        panelMilieu.setBackground(COLOR_BACK);
        
        GridBagConstraints gbc = new GridBagConstraints();//on instancie la contrainte
        gbc.insets = new Insets( 10, 10, 10, 10 );
        
        //bouton nouvelle partie   
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(boutonNouvellePartie,gbc);
        
        //bouton continuer
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;  
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(boutonContinuer,gbc);
        
        //bouton score
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;  
        gbc.fill = GridBagConstraints.NONE;
        panelMilieu.add(boutonScore,gbc);
        
        //bouton bonus
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelMilieu.add(boutonBonus,gbc);
        
        //bouton règles
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelMilieu.add(boutonRegles,gbc);
        
        //bouton sortie
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(boutonSortie,gbc);

        setLayout(new BorderLayout());
        setBackground(COLOR_BLUE);
        this.add(labelTitre,BorderLayout.NORTH);
        this.add(panelMilieu,BorderLayout.CENTER);
        
    }

    /**
     * permet de mettre sur écoute les composants de la classe PanelMenu
     * 
     * @param controleur correspond à la classe gérant tous les évènements de l'application (déplacement, bouton,...)
     */
    public void enregistreEcouteur(Controleur controleur) {
        boutonNouvellePartie.addActionListener(controleur);
        boutonContinuer.addActionListener(controleur);
        boutonScore.addActionListener(controleur);
        boutonBonus.addActionListener(controleur);
        boutonRegles.addActionListener(controleur);
        boutonSortie.addActionListener(controleur);
    }


    
    
}
