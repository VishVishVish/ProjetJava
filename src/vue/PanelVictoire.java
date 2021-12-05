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
import javax.swing.JTextField;
import modele.Data;
import static modele.Data.COLOR_ICE;

/**
 * correspond à la page de victoire 
 * @author vishn
 */
public class PanelVictoire extends JPanel {
    
    String nom = "----";
    
    JLabel labelTitre = new JLabel("Félicitations !", JLabel.CENTER);
    JLabel labelSaisirNom = new JLabel("SAISIR VOTRE NOM:");
    JTextField textField = new JTextField("");
    JLabel labelStrScore = new JLabel("SCORE:", JLabel.CENTER);
    JLabel labelStrTemps = new JLabel("TEMPS:");
    JLabel labelScore = new JLabel("0000");
    JLabel labelTemps = new JLabel("0000");
    
    JLabel labels [] = {labelSaisirNom, labelStrScore, labelScore, labelStrTemps ,labelTemps}; 
    
    
    JButton boutonValider = new JButton("VALIDER ET QUITTER");
    
    Font fontTitre = new Font(Data.fontPolice, Font.BOLD, 100);
    Font fontLabel = new Font(Data.fontPolice, Font.BOLD, 50);
    Font fontBouton = new Font(Data.fontPolice, Font.BOLD, 30);
    
    /**
     * constructeur de la page de victoire
     */
    public PanelVictoire() {
        JPanel panelHaut = new JPanel();
        JPanel panelMilieu = new JPanel(new GridBagLayout());
        
        //panelHaut
        panelHaut.setLayout(new BorderLayout());
        panelHaut.add(labelTitre);
        panelHaut.setBackground(Data.COLOR_BLUE);
        labelTitre.setFont(fontTitre);
        labelTitre.setForeground(Color.WHITE);
        

        //panelMileu
        panelMilieu.setBackground(Data.COLOR_BACK);
        //textfield qui permet de saisir le nom
        textField.setPreferredSize(new Dimension(200,50));
        textField.setBorder(BorderFactory.createLineBorder(COLOR_ICE,4, true));
        textField.setForeground(COLOR_ICE);
        textField.setFont(fontBouton);
        
        //customization des labels 
        for(JLabel label : labels){
            label.setFont(fontLabel);
            label.setForeground(Data.COLOR_ICE);
        }
        
        //customization du bouton valider et quitter
        
        boutonValider.setFocusable(false);
        boutonValider.setBorder(BorderFactory.createLineBorder(COLOR_ICE,4, true));
        boutonValider.setBackground(Data.COLOR_SNOW);
        boutonValider.setForeground(COLOR_ICE);
        boutonValider.setFont(fontBouton);
        boutonValider.setPreferredSize(new Dimension(200,50));
        
        //panelMilieu.setBackground(COLOR_BACK);
        
        GridBagConstraints gbc = new GridBagConstraints();//on instancie la contrainte
        gbc.insets = new Insets( 10, 10, 10, 10 );
        
        //label saisir votre nom  
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(labelSaisirNom,gbc);
        
        //label saisir votre nom  
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(textField,gbc);
        
        //label du texte SCORE: 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(labelStrScore,gbc);
        
        
        //label du score 
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(labelScore,gbc);
        
        //label du texte "TEMPS:" 
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(labelStrTemps,gbc);
        
        
        //label du temps
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(labelTemps,gbc);
        
        //bouton VALIDER ET QUITTER
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelMilieu.add(boutonValider,gbc);
        
        
        this.setLayout(new BorderLayout());
        this.add(panelHaut, BorderLayout.NORTH);
        this.add(panelMilieu, BorderLayout.CENTER);
    }
    
    /**
     * permet de mettre sur écoute les composants de la classe PanelVictoire
     * 
     * @param controleur correspond à la classe gérant tous les évènements de l'application (déplacement, bouton,...)
     */
    public void enregistreEcouteur(Controleur controleur) {
        boutonValider.addActionListener(controleur);
    }

    public void setFocusableBouton(boolean bool) {
        boutonValider.setFocusable(bool);
    }
    
    /**
     * permet de modifier le label de score
     * @param score correspond au nouveau score
     */
    public void setLabelScore(int score){
        this.labelScore.setText(String.valueOf(score));
    }
    /**
     * permet de modifier la label temps 
     * @param temps corrspond au nouveau temps
     */
    public void setLabelTemps(int temps){
        this.labelTemps.setText(String.valueOf(temps));
    }
    /**
     * retourne le nom de la personne 
     * @return correspond au nom de la personne 
     */
    public String getNom(){
        return this.nom;
    }
    /**
     * initialise le nom de l'utilisateur avec le nom inscrit dans la zone de texte 
     */
    public void setNom(){
        this.nom = textField.getText();
    }
        
}
