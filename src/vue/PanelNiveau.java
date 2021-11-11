/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import controleur.Controleur;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import modele.*;


/**
 *
 * @author vishn
 */
public class PanelNiveau extends JPanel implements Data{
    //Data Data = new Data();
    
    private int score = 0;
    private int numNiveau = 1;
    
    
    JLabel labelTitre = new JLabel("Niveau du jeu" + numNiveau, JLabel.CENTER);
    JLabel labelTemps = new JLabel("Temps : 00:00");
    JLabel labelScore = new JLabel("Score :" + score);
    
    boolean finNiveau;

    Grille grille;
    Personnage perso;
    
    JPanel panelHaut;
    PanelGrille panelMilieu;
    JPanel panelBas;
    
    JButton boutonReset = new JButton("RESET");
    
    public PanelNiveau(){
        grille = new Grille();
        finNiveau = false;
        boutonReset.setFocusable(false);
        
        //on modifie la grille du niveau
        grille.setGrilleChar(Data.LEVELS[numNiveau]);
        
        int posX = Data.POS_PERSO[numNiveau][0];
        int posY = Data.POS_PERSO[numNiveau][1];
        perso = new Personnage(posX,posY,Data.PERSO);// à changer
        grille.setGrilleChar(perso.setPosition(grille));
        /*
        grille.initGrille('.');
        grille.setGrille(perso.setPosition(grille));
        grille.setCase(5,5,Data.BLOCK);
        grille.setCase(5,6,Data.BLOCK);
        grille.setCase(5,7,Data.BLOCK);
        grille.setCase(13,13,Data.EXIT);*/
        
        panelHaut = new JPanel(new BorderLayout());
        panelMilieu = new PanelGrille(grille);
        panelBas = new JPanel(new BorderLayout());
        
        //on ajoute des couleurs de fond
        panelHaut.setBackground(Color.cyan);
        panelMilieu.setBackground(Color.GRAY);
        panelBas.setBackground(Color.cyan);
        
        
        //On configure la partie haut su niveau contenant le temps, le titre et le score 
        panelHaut.add(labelTemps, BorderLayout.WEST);
        panelHaut.add(labelTitre, BorderLayout.CENTER);
        panelHaut.add(labelScore, BorderLayout.EAST);


        //On configure la partie du bas du niveau contenant le bouton pause
        panelBas.add(boutonReset, BorderLayout.LINE_START);
        
        setLayout(new BorderLayout());
        
        this.add(panelHaut, BorderLayout.NORTH);
        this.add(panelMilieu, BorderLayout.CENTER);
        this.add(panelBas, BorderLayout.SOUTH);    
    }
    
    
    public void enregistreEcouteur(Controleur controleur) {
        //this.addKeyListener(controleur);
        boutonReset.addActionListener(controleur);
    }
    
    public void setGrille(Grille grille){
        panelMilieu.removeAll();
        panelMilieu.setGrille(grille);
        panelMilieu.revalidate();
        //panelMilieu.repaint();
    }
    
    
    
    public PanelGrille getPanelGrille(){
        return panelMilieu;
    }
    
    public Personnage getPersonnage(){
        return perso;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;    
    }
    
    public boolean getFinNiveau(){
        return finNiveau;
    }
    
    public void setFinNiveau(boolean finNiveau){
        this.finNiveau = finNiveau;
    }
    
    public int getNumNiveau(){
        return numNiveau;
    }
    
    public void setNumNiveau(int numNiveau){
        this.numNiveau = numNiveau;
    }
   
}
