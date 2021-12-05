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
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modele.Data;
import static modele.Data.COLOR_ICE;
import static modele.Data.fontPolice;
import modele.Scores;

/**
 *
 * @author vishn
 */
public class PanelScore extends JPanel implements Data{
    JPanel panelHaut;
    JPanel panelMilieu;
    JPanel panelBas;
    
    Scores listeScores;
    
    JLabel labelTitre = new JLabel("SCORE CLASSEMENT", JLabel.CENTER);
    
    JLabel labelClassement = new JLabel("CLASSEMENT", JLabel.CENTER);
    JLabel labelNom = new JLabel("NOM", JLabel.CENTER);
    JLabel labelScore = new JLabel("SCORE", JLabel.CENTER);
    JLabel labelTemps = new JLabel("TEMPS", JLabel.CENTER);
    
    JLabel [] labels = {labelClassement, labelNom, labelScore, labelTemps}; 
    
    JButton boutonMenu = new JButton("MENU");
    
    Font fontLabelTitre = new Font(fontPolice, Font.BOLD, 100);
    Font fontLabelCategorie = new Font(fontPolice, Font.BOLD, 40);
    Font fontLabel = new Font(fontPolice, Font.BOLD, 30);
    
    public PanelScore(){
        panelHaut = new JPanel();
        panelMilieu = new JPanel();
        panelBas = new JPanel();
        
        //panelHaut
        labelTitre.setFont(fontLabelTitre); 
        labelTitre.setForeground(Color.WHITE);
        panelHaut.setBackground(Data.COLOR_BLUE);
        panelHaut.add(labelTitre);
        
        //panelMilieu
        panelMilieu.setBackground(COLOR_BACK);
        listeScores = new Scores();               
        int nbrLigne = listeScores.getClassement().size();
        GridLayout gridLayout = new GridLayout(nbrLigne+1,4);
        panelMilieu.setLayout(gridLayout);
        
        
        
        for(JLabel label : labels){
            label.setFont(fontLabelCategorie); 
            label.setForeground(Data.COLOR_BLUE);
            
            label.setBorder(BorderFactory.createLineBorder(COLOR_BLUE,8, false));
            panelMilieu.add(label);
        }
        
        
        for(int i = 0; i<nbrLigne; i++) {
            
            JLabel labelNum = new JLabel(String.valueOf(i+1), JLabel.CENTER);
            labelNum.setFont(fontLabelCategorie); 
            labelNum.setForeground(Data.COLOR_ICE);
            if(i%2==0)
                labelNum.setBackground(COLOR_SNOW);
            else 
                labelNum.setBackground(COLOR_BACK);
            //labelNum.setBorder(BorderFactory.createLineBorder(COLOR_BLUE,8, false));
            labelNum.setOpaque(true);
            panelMilieu.add(labelNum);
            
            for(int j = 0; j<3; j++){
                JLabel label = new JLabel(listeScores.getClassement(i)[j], JLabel.CENTER);
                label.setFont(fontLabel); 
                label.setForeground(Data.COLOR_ICE);
                if(i%2==0)
                    label.setBackground(COLOR_SNOW);
                else 
                    label.setBackground(COLOR_BACK);
                label.setOpaque(true);
                panelMilieu.add(label);
            }  
        }
        
        //panelBas
        panelBas.setBackground(COLOR_BLUE);
        boutonMenu.setBorder(BorderFactory.createLineBorder(COLOR_SNOW,4, true));
        boutonMenu.setBackground(Data.COLOR_ICE);
        boutonMenu.setForeground(Color.WHITE);
        boutonMenu.setFont(fontLabel);
        boutonMenu.setPreferredSize(new Dimension(100,50));
        boutonMenu.setFocusable(false);
        panelBas.add(boutonMenu);
            
        this.setLayout(new BorderLayout());
        this.setBackground(Data.COLOR_BACK);
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
        boutonMenu.addActionListener(controleur);
    }
    
    public void setListeScores(Scores listeScores){
        this.listeScores = listeScores;
    }
    
    public Scores getListeScores(){
        return listeScores;
    }
    
}
