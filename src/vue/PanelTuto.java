/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import controleur.Controleur;
import java.awt.*;    
import javax.swing.*;   
import java.awt.event.*;  
import modele.Data;

/**
 *
 * @author vishn
 */
public class PanelTuto extends JPanel implements Data{
    
    JLabel label1 = new JLabel("", JLabel.CENTER);
    JLabel label2 = new JLabel("Page 2 du tuto", JLabel.CENTER);
    JLabel label3 = new JLabel("Page 3 du tuto", JLabel.CENTER);
    JLabel label4 = new JLabel("Page 4 du tuto", JLabel.CENTER);
    
    JButton boutonPremier = new JButton("<<");
    JButton boutonPrecedent = new JButton("<");
    JButton boutonSuivant = new JButton(">");
    JButton boutonDernier = new JButton(">>");
    
    JButton boutonMenu = new JButton("MENU");
    
    JLabel labels [] = {label1, label2, label3, label4};
    
    //JButton boutons [] = {boutonPremier, boutonPrecedent, boutonSuivant, boutonDernier};
    JButton boutons [] = { boutonPrecedent, boutonMenu, boutonSuivant};
    Font fontBouton = new Font(fontPolice, Font.BOLD, 40);
    
    CardLayout cardLayout;
    JPanel panelMilieu;
    JPanel panelBas;

    
    public PanelTuto(){
        panelMilieu = new JPanel();
        panelBas = new JPanel(new GridLayout(1,3));
        
        //panelMilieu
        cardLayout = new CardLayout();
        
        panelMilieu.setLayout(new GridLayout(1,5));
        panelMilieu.setBackground(COLOR_SNOW);
        label1.setIcon(new ImageIcon(getClass().getResource("/img/exemple_img.png")));
        label2.setIcon(new ImageIcon(getClass().getResource("/img/ice_n.png")));
        label3.setIcon(new ImageIcon(getClass().getResource("/img/ice_n.png")));
        label4.setIcon(new ImageIcon(getClass().getResource("/img/ice_n.png")));
        panelMilieu.add(label1,"a");
        panelMilieu.add(label2, "b");
        panelMilieu.add(label3, "c");
        panelMilieu.add(label4, "d");

        panelMilieu.setLayout(cardLayout);
        
        //panelBas
        JPanel panelBasMilieu = new JPanel(new GridLayout(1,3));
        for(JButton bouton: boutons ) {
            bouton.setBorder(BorderFactory.createLineBorder(COLOR_ICE,4, true));
            bouton.setBackground(Data.COLOR_SNOW);
            bouton.setForeground(COLOR_ICE);
            bouton.setPreferredSize(new Dimension(20,50));
            bouton.setFocusable(false);
            bouton.setFont(fontBouton);
            panelBas.add(bouton, BorderLayout.CENTER);
        }
        
        /*
        for(JLabel label : labels){
            panelMilieu.add(label);
        }
        */
        
        
        setLayout(new BorderLayout());
        this.add(panelMilieu, BorderLayout.CENTER);
        this.add(panelBas, BorderLayout.SOUTH);
        
     
    }
    
     /**
     * permet de mettre sur écoute les composants de la classe PanelTuto
     * 
     * @param controleur correspond à la classe gérant tous les évènements de l'application (déplacement, bouton,...)
     */
    public void enregistreEcouteur(Controleur controleur) {
        boutonPremier.addActionListener(controleur);
        boutonPrecedent.addActionListener(controleur);
        boutonSuivant.addActionListener(controleur);
        boutonDernier.addActionListener(controleur);
        boutonMenu.addActionListener(controleur);
   
    }
    
    public void premier(){
        System.out.println("ici");
        cardLayout.first(panelMilieu);
    }
    public void precedent(){
        cardLayout.previous(panelMilieu);
    }
    public void suivant(){
        cardLayout.next(panelMilieu);
    }
    public void dernier(){
        cardLayout.last(panelMilieu);
    }
    /*
    public void affiche(){
        cardLayout.show(panelMilieu,"a");
    }
    */
}
