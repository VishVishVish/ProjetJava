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
    JButton boutonMenu = new JButton("MENU");
    Font fontLabel = new Font(fontPolice, Font.BOLD, 30);
    
    public PanelBonus(){
        JPanel panelHaut = new JPanel();
        JPanel panelMilieu = new JPanel();
        JPanel panelBas = new JPanel();
        
        //panelHaut 
        panelHaut.add(labelTitre);
        
        boutonMenu.setBorder(BorderFactory.createLineBorder(COLOR_SNOW,4, true));
        boutonMenu.setBackground(Data.COLOR_ICE);
        boutonMenu.setForeground(Color.WHITE);
        boutonMenu.setFont(fontLabel);
        boutonMenu.setPreferredSize(new Dimension(100,50));
        boutonMenu.setFocusable(false);
        
        
        //panelBas
        panelBas.setBackground(COLOR_BLUE);
        panelBas.add(boutonMenu);
        
        this.setLayout(new BorderLayout());
        this.add(panelHaut, BorderLayout.NORTH);
        this.add(panelBas, BorderLayout.SOUTH);
    }
    
    /**
     * permet de mettre sur écoute les composants de la classe PanelBonus
     * 
     * @param controleur correspond à la classe gérant tous les évènements de l'application (déplacement, bouton,...)
     */
    public void enregistreEcouteur(Controleur controleur) {
        boutonMenu.addActionListener(controleur);
    }
    
}
