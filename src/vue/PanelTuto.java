/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import controleur.Controleur;
import java.awt.*;    
import javax.swing.*;   
import modele.Data;

/**
 * correspond à la page de tutoriel expliquant les différentes informations 
 * @author vishn
 */
public class PanelTuto extends JPanel implements Data{
    
    JLabel label1 = new JLabel("", JLabel.CENTER);
    JLabel label2 = new JLabel("", JLabel.CENTER);
    JLabel label3 = new JLabel("", JLabel.CENTER);
    JLabel label4 = new JLabel("", JLabel.CENTER);
    
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

    /**
     * constructeur de la classe PanelTuto
     */
    public PanelTuto(){
        panelMilieu = new JPanel();
        panelBas = new JPanel(new GridLayout(1,3));
        
        //panelMilieu
        cardLayout = new CardLayout();
        
        panelMilieu.setLayout(new GridLayout(1,5));
        panelMilieu.setBackground(COLOR_BLUE);
        label1.setIcon(new ImageIcon(getClass().getResource("/img/page_1.png")));
        label2.setIcon(new ImageIcon(getClass().getResource("/img/page_2.png")));
        label3.setIcon(new ImageIcon(getClass().getResource("/img/page_3.png")));
        label4.setIcon(new ImageIcon(getClass().getResource("/img/ice_n.png")));
        
        label1.setOpaque(true);
        label2.setOpaque(true);
        label3.setOpaque(true);
        label4.setOpaque(true);
        
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
    
    /**
     * permet de renvoyer la première page du tuto  
     */
    public void premier(){
        cardLayout.first(panelMilieu);
    }
    
    /**
     * permet de renvoyer la page précedente du tuto 
     */
    public void precedent(){
        cardLayout.previous(panelMilieu);
    }
    
    /**
     * permet de renvoyer la page suivante 
     */
    public void suivant(){
        cardLayout.next(panelMilieu);
    }
    /**
     * permet de renvoyer la dernière page du turo
     */
    public void dernier(){
        cardLayout.last(panelMilieu);
    }
    /*
    public void affiche(){
        cardLayout.show(panelMilieu,"a");
    }
    */
}
