/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modele.Data;
import static modele.Data.COLOR_BLUE;
import static modele.Data.COLOR_SNOW;
import static modele.Data.fontPolice;

/**
 *
 * @author vishn
 */
public class PanelBonus extends JPanel{
    JLabel labelTitre = new JLabel("PAGE BONUS", JLabel.CENTER);
    JLabel labelChoix = new JLabel("CHOIX DE VOTRE SKIN", JLabel.CENTER);
    
    JButton bouton1 = new JButton("1");
    JButton bouton2 = new JButton("2");
    JButton bouton3 = new JButton("3");
    JButton boutons [] = {bouton1, bouton2, bouton3}; 
    
    JButton boutonMenu = new JButton("MENU");
    Font fontLabel = new Font(fontPolice, Font.BOLD, 30);
    
    public PanelBonus(){
        JPanel panelHaut = new JPanel();
        JPanel panelMilieu = new JPanel(new GridBagLayout());
        JPanel panelBas = new JPanel();
        
        //panelHaut 
        panelHaut.add(labelTitre);
        
        //panelMilieu
        bouton2.setFocusable(false);
        GridBagConstraints gbc = new GridBagConstraints();//on instancie la contrainte
        gbc.insets = new Insets( 10, 10, 10, 10 );
        
        //bouton nouvelle partie   
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(bouton1,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        //gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(bouton2,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        //gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(bouton3,gbc);
        
       
        
        
        //panelBas
        boutonMenu.setBorder(BorderFactory.createLineBorder(COLOR_SNOW,4, true));
        boutonMenu.setBackground(Data.COLOR_ICE);
        boutonMenu.setForeground(Color.WHITE);
        boutonMenu.setFont(fontLabel);
        boutonMenu.setPreferredSize(new Dimension(100,50));
        boutonMenu.setFocusable(false);
        panelBas.setBackground(COLOR_BLUE);
        panelBas.add(boutonMenu);
        
        this.setLayout(new BorderLayout());
        this.add(panelHaut, BorderLayout.NORTH);
        this.add(panelMilieu, BorderLayout.CENTER);
        this.add(panelBas, BorderLayout.SOUTH);
    }
    
    /**
     * permet de mettre sur écoute les composants de la classe PanelBonus
     * 
     * @param controleur correspond à la classe gérant tous les évènements de l'application (déplacement, bouton,...)
     */
    public void enregistreEcouteur(Controleur controleur) {
        bouton1.addActionListener(controleur);
        bouton2.addActionListener(controleur);
        bouton3.addActionListener(controleur);
        boutonMenu.addActionListener(controleur);
    }
    
}
