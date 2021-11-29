/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static modele.Data.COLOR_BACK;

/**
 *
 * @author vishn
 */
public class PanelVictoire extends JPanel {
    
    String nom = "----";
    
    JLabel labelTitre = new JLabel("Félicitation");
    JLabel labelSaisirNom = new JLabel("Saisir votre nom");
    JTextField textField = new JTextField("");
    JLabel labelStrScore = new JLabel("SCORE:");
    JLabel labelStrTemps = new JLabel("TEMPS:");
    JLabel labelScore = new JLabel("0000");
    JLabel labelTemps = new JLabel("0000");
    
    
    JButton boutonValider = new JButton("VALIDER ET QUITTER");
    
    
    public PanelVictoire() {
        JPanel panelHaut = new JPanel();
        JPanel panelMilieu = new JPanel(new GridBagLayout());
        
        //panelHaut
        panelHaut.setLayout(new BorderLayout());
        panelHaut.add(labelTitre);
        
        
        
       
        
        
        //panelMileu
        boutonValider.setFocusable(false);
        
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
    
    public void setLabelScore(int score){
        this.labelScore.setText(String.valueOf(score));
    }
    public void setLabelTemps(int temps){
        this.labelTemps.setText(String.valueOf(temps));
    }
    
    public String getNom(){
        return this.nom;
    }
    public void setNom(){
        this.nom = textField.getText();
    }
        
}
