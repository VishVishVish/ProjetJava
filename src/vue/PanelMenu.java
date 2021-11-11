/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import modele.Data;
import controleur.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * panel correspondant au menu principal du jeu
 * @author Vishnou Peroumalnaikar
 */
public class PanelMenu extends JPanel{
    
    JLabel titre = new JLabel("Titre du jeu", JLabel.CENTER);
    JButton start = new JButton("START");
    JButton continu = new JButton("CONTINUE");
    JButton score = new JButton("SCORE");
    JButton bonus = new JButton("BONUS");
    JButton rules = new JButton("RULES");
    JButton exit = new JButton("EXIT");
    
    //Font fontBouton = Data.fontBouton;
    Font fontBouton = new Font("Serif", Font.BOLD, 20);
    /**
     * constructeur de PanelMenu correspondant au menu principal du jeu
     */
    public PanelMenu () {
        
        //on modifie la police, taille des textes des JLabels et des JButtons
        titre.setFont(new Font("Serif", Font.BOLD, 50));
        start.setFont(fontBouton);
        continu.setFont(fontBouton);
        score.setFont(fontBouton);
        bonus.setFont(fontBouton);
        rules.setFont(fontBouton);
        exit.setFont(fontBouton);
        
        //on enleve le focus des boutons sinon le keylistener ne marche plus si on appuie sur un bouton 
        start.setFocusable(false);
        continu.setFocusable(false);
        score.setFocusable(false);
        bonus.setFocusable(false);
        rules.setFocusable(false);
        exit.setFocusable(false);
        
        //on créer un mnemonic sur les boutons du menu
        start.setMnemonic('T');
        
        JPanel panel = new JPanel(new GridBagLayout());
     
        //panel.setPreferredSize(new Dimension(100,200));
        panel.setBackground(new Color(128,255,255));
        
        GridBagConstraints gbc = new GridBagConstraints();//on instancie la contrainte
        
        //bouton start    
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(start,gbc);
        
        //bouton continue
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;  
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(continu,gbc);
        
        //bouton score
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;  
        gbc.fill = GridBagConstraints.NONE;
        panel.add(score,gbc);
        
        //bouton bonus
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(bonus,gbc);
        
        //bouton rules
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(rules,gbc);
        
        //bouton exit
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(exit,gbc);
        
 
        setLayout(new BorderLayout());
        this.add(titre,BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);
        
    }

    /**
     * permet de mettre sur écoute les composants de la classe PanelMenu
     * 
     * @param controleur correspond à la classe gérant tous les évènements de l'application (déplacement, bouton,...)
     */
    public void enregistreEcouteur(Controleur controleur) {
        start.addActionListener(controleur);
        continu.addActionListener(controleur);
        score.addActionListener(controleur);
        bonus.addActionListener(controleur);
        rules.addActionListener(controleur);
        exit.addActionListener(controleur);
    }


    
    
}
