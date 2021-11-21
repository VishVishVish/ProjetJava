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
import javax.swing.border.Border;
import modele.*;
/**
 *
 * @author vishn
 */
public class PanelControle extends JPanel implements Data{
    
    int numNiveau;
    int score;
    int temps;

    JLabel labelNiveau;
    JLabel labelTemps;
    JLabel labelScore;
    
    JButton boutonHaut = new JButton("\u25B2");
    JButton boutonDroite = new JButton("\u25BA");
    JButton boutonBas = new JButton("\u25BC");
    JButton boutonGauche = new JButton("\u25C4");
    
    JButton [] boutons = {boutonHaut, boutonDroite, boutonBas, boutonGauche}; // tableau regroupant l'ensemble des boutons de déplacemant
    
    JButton boutonReset = new JButton("RESET");
    JButton boutonSave = new JButton("SAVE");
    JButton boutonMenu = new JButton("MENU");
        
    Font fontLabel = new Font(fontPolice, Font.BOLD, 50);
    Font font = new Font("Serif", Font.BOLD, 40);

    
    public PanelControle(){
        numNiveau = 1;
        score = 0;
        temps = 0;
        
         labelNiveau = new JLabel("NIVEAU " + numNiveau, JLabel.CENTER);
         labelTemps = new JLabel("TEMPS : " + temps, JLabel.CENTER);
         labelScore = new JLabel("SCORE : " + score, JLabel.CENTER);
         
         labelNiveau.setFont(fontLabel);
         labelTemps.setFont(fontLabel);
         labelScore.setFont(fontLabel);
         
         labelNiveau.setForeground(Color.WHITE);
         labelTemps.setForeground(Color.WHITE);
         labelScore.setForeground(Color.WHITE);
         
        //On personalise les boutons de déplacements
        for (JButton bouton : boutons) {
            bouton.setFont(font);
            bouton.setBorder(BorderFactory.createLineBorder(COLOR_ICE,4, true));
            bouton.setBackground(Data.COLOR_SNOW);
            bouton.setForeground(COLOR_ICE);
            bouton.setPreferredSize(new Dimension(90,90));
            bouton.setFocusable(false);
        }
        boutonReset.setFocusable(false);
         
        setLayout(new BorderLayout());
        //this.setBackground(Color.cyan);
        
        //on créé les panels qu'on va ajouter au panelControle
        JPanel panelHaut = new JPanel(new GridLayout(3,1));
        JPanel panelMilieu = new JPanel(new GridBagLayout());
        JPanel panelBas = new JPanel(new GridLayout(3,1));
        
        //on ajoute des couleurs de fond au panels 
        panelHaut.setBackground(Data.COLOR_BLUE);
        panelHaut.setPreferredSize(new Dimension(50,230));
        //panelHaut.setBorder(BorderFactory.createLineBorder(COLOR_SNOW,7, true));
        panelMilieu.setBackground(COLOR_BACK);
        panelBas.setBackground(Color.BLUE);
        
        //panelHaut//
        panelHaut.add(labelNiveau);
        panelHaut.add(labelTemps);
        panelHaut.add(labelScore);
        
        //panelMilieu//
        GridBagConstraints gbc = new GridBagConstraints();//on instancie la contrainte
        gbc.insets = new Insets( 0, 10, 0, 10 );
        gbc.gridx = 1;
        gbc.gridy = 0;       
        panelMilieu.add(boutonHaut,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelMilieu.add(boutonGauche,gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        panelMilieu.add(boutonDroite,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelMilieu.add(boutonBas,gbc);
        
        //panelBas//
        panelBas.add(boutonReset, BorderLayout.LINE_START);
        panelBas.add(boutonSave, BorderLayout.CENTER);
        panelBas.add(boutonMenu, BorderLayout.LINE_END);
        
        //On ajoute le panel dans le panelControle
        this.add(panelHaut, BorderLayout.NORTH);
        this.add(panelMilieu, BorderLayout.CENTER);
        this.add(panelBas, BorderLayout.SOUTH);
    }
    
    /**
     * permet de mettre sur écoute les composants de la classe PanelControle
     * 
     * @param controleur correspond à la classe gérant tous les évènements de l'application (déplacement, bouton,...)
     */
    public void enregistreEcouteur(Controleur controleur) {
        boutonHaut.addActionListener(controleur);
        boutonDroite.addActionListener(controleur);
        boutonGauche.addActionListener(controleur);
        boutonBas.addActionListener(controleur);
        boutonReset.addActionListener(controleur);
        boutonMenu.addActionListener(controleur);
        boutonSave.addActionListener(controleur);
    }
    
    public void setNumNiveau(int numNiveau){
        this.numNiveau = numNiveau;        
    }
    
    public void setLabelNiveau(){
        this.labelNiveau.setText("NIVEAU " + numNiveau);
    }
    
    public int getTemps(){
        return temps;
    }
    
    public void setTemps(int temps){
        this.temps = temps;    
    }
    
   public void setLabelTemps(){
        this.labelTemps.setText("TEMPS : " + temps);
    }
    
    
}
