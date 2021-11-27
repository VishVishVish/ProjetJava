/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author vishn
 */
public class PanelVictoire extends JPanel {
    JLabel labelTitre = new JLabel("Félicitation bouffon");
    JTextArea textArea = new JTextArea();
    JButton boutonMenu = new JButton("MENU");
    
    public PanelVictoire() {
        
        boutonMenu.setFocusable(false);
        this.add(labelTitre);
        this.add(textArea);
        this.add(boutonMenu);
    }
    
    /**
     * permet de mettre sur écoute les composants de la classe PanelVictoire
     * 
     * @param controleur correspond à la classe gérant tous les évènements de l'application (déplacement, bouton,...)
     */
    public void enregistreEcouteur(Controleur controleur) {
        boutonMenu.addActionListener(controleur);
    }
        
}
