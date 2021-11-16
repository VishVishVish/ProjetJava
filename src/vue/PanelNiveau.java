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
    
    
    

    Grille grille;
   
    Personnage perso;
    
    
    PanelGrille panelGrille;
    PanelControle panelControle;
        
    public PanelNiveau(){
        grille = new Grille();
        panelControle = new PanelControle();
        setNiveau(numNiveau);
        panelGrille = new PanelGrille(grille);
 
        setLayout(new BorderLayout());
        
        this.add(panelGrille, BorderLayout.CENTER);
        this.add(panelControle, BorderLayout.EAST);    
    }
    
    public void enregistreEcouteur(Controleur controleur) {
        panelControle.enregistreEcouteur(controleur);
    }
    
    public void setGrille(Grille grille){
        panelGrille.removeAll();
        panelGrille.setGrille(grille);
        panelGrille.revalidate();
        //panelMilieu.repaint();
    }
    
    public void setNiveau(int numNiveau){
        this.numNiveau = numNiveau;
        grille.setGrilleChar(Data.LEVELS[this.numNiveau]);   
        int posX = Data.POS_PERSO[this.numNiveau][0];
        int posY = Data.POS_PERSO[this.numNiveau][1];
        perso = new Personnage(posX,posY,Data.PERSO);
        grille.setGrilleChar(perso.setPosition(grille)); 
        panelControle.setNumNiveau(numNiveau);
        panelControle.setLabelNiveau();    
    }
    
    public void resetNiveau(){
        grille.setGrilleChar(Data.LEVELS[this.numNiveau]);   
        int posX = Data.POS_PERSO[this.numNiveau][0];
        int posY = Data.POS_PERSO[this.numNiveau][1];
        perso = new Personnage(posX,posY,Data.PERSO);
        grille.setGrilleChar(perso.setPosition(grille)); 
    }

    public PanelGrille getPanelGrille(){
        return panelGrille;
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
    
    
    
    public int getNumNiveau(){
        return numNiveau;
    }
    
    public void setNumNiveau(int numNiveau){
        this.numNiveau = numNiveau;
    }
    
    public PanelControle getPanelControle(){
        return panelControle;
    }
    
    public void setPanelControle( PanelControle panelControle){
        this.panelControle = panelControle;
    }
   
}
