/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modele.Score;

/**
 *
 * @author vishn
 */
public class PanelScore extends JPanel {
    JPanel panelHaut;
    JPanel panelMilieu;
    JPanel panelBas;
    
    Score listeScore;
    
    JLabel labelTitre = new JLabel("SCORE CLASSEMENT", JLabel.CENTER);
    JButton boutonMenu = new JButton("MENU");
    
    public PanelScore(){
        panelHaut = new JPanel();
        panelMilieu = new JPanel();
        panelBas = new JPanel();
        
        //panelHaut
        panelHaut.add(labelTitre);
        
        //panelMilieu
        listeScore = new Score();               
        int nbrLigne = listeScore.getListeScore().size();
        GridLayout gridLayout = new GridLayout(nbrLigne,3);
        panelMilieu.setLayout(gridLayout);
        
        for(int i = 0; i<nbrLigne; i++) {
            for(int j = 0; j<3; j++){
                JLabel label = new JLabel(listeScore.get(i)[j], JLabel.CENTER);
                panelMilieu.add(label);
            }  
        }
        
        //panelBas
        boutonMenu.setFocusable(false);
        panelBas.add(boutonMenu);
            
        this.setLayout(new BorderLayout());
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
    
}
