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
import javax.swing.JRadioButton;
import modele.Data;
import static modele.Data.COLOR_BLUE;
import static modele.Data.COLOR_SNOW;
import static modele.Data.fontPolice;

/**
 *
 * @author vishn
 */
public class PanelBonus extends JPanel implements Data{
    JLabel labelTitre = new JLabel("PAGE BONUS", JLabel.CENTER);
    public JRadioButton radioBouton = new JRadioButton("Activer affichage console");
    JButton boutonMenu = new JButton("MENU");
    
    Font fontTitre = new Font(fontPolice, Font.BOLD, 100);
    Font fontLabel = new Font(fontPolice, Font.BOLD, 30);
    
    
    public PanelBonus(){
        JPanel panelHaut = new JPanel();
        JPanel panelMilieu = new JPanel();
        JPanel panelBas = new JPanel();
        
        //panelHaut 
        labelTitre.setFont(fontTitre);
        labelTitre.setForeground(Color.WHITE);
        //labelTitre.setPreferredSize(new Dimension(1000, 250));
        panelHaut.setBackground(COLOR_BLUE);
        panelHaut.add(labelTitre);
        
        //panelMilieu
        radioBouton.setBorder(BorderFactory.createLineBorder(COLOR_SNOW,4, true));
        radioBouton.setBackground(Data.COLOR_ICE);
        radioBouton.setForeground(Color.WHITE);
        radioBouton.setFont(fontLabel);
        //radioBouton.setPreferredSize(new Dimension(100,50));
        radioBouton.setFocusable(false);
        
        //radioBouton.setIcon(new Icon());
        panelMilieu.add(radioBouton);
        panelMilieu.setBackground(COLOR_BACK);
        
        
        
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
        boutonMenu.addActionListener(controleur);
        radioBouton.addActionListener(controleur);
    }
    
}
