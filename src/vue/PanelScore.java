/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author vishn
 */
public class PanelScore extends JPanel {
    JPanel panelHaut;
    JPanel panelMilieu;
    
    JLabel labelTitre = new JLabel("SCORE CLASSEMENT", JLabel.CENTER);
    
    public PanelScore(){
        panelHaut = new JPanel();
        panelMilieu = new JPanel();
        
        
        panelHaut.add(labelTitre);
        
        
        this.setLayout(new BorderLayout());
        this.add(panelHaut, BorderLayout.NORTH);
        this.add(panelMilieu, BorderLayout.CENTER);
    }
    
    
}
