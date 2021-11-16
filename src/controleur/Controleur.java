/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modele.Data;
import modele.Grille;
import modele.Personnage;
import vue.*;

/**
 *
 * @author vishn
 */
public class Controleur implements ActionListener, KeyListener, Data{
    
    PanelMenu panelMenu;
    PanelNiveau panelNiveau;
    PanelGrille panelGrille;
    PanelTuto panelTuto;
   
    Grille grille;
    
   
    Personnage perso;
    Fenetre fenetre;
    /**
     * Constructeur de la classe controleur permet de coordonnées les actions/réactions du jeu 
     * @param panelMenu correspond au panel du menu principal du jeu 
     * @param panelNiveau correspond au panel des niveaux du jeu
     * @param fenetre correspond à la fenêtre du jeu
     */
    public Controleur(PanelMenu panelMenu, PanelNiveau panelNiveau, PanelTuto panelTuto, Fenetre fenetre){
        this.panelMenu = panelMenu;
        this.panelNiveau = panelNiveau;
        this.panelGrille = panelNiveau.getPanelGrille();
        this.grille = panelGrille.getGrille();
        this.perso = panelNiveau.getPersonnage();
        this.fenetre = fenetre;
        this.panelTuto = panelTuto;
        
        this.panelMenu.enregistreEcouteur(this);
        this.panelNiveau.enregistreEcouteur(this);
        this.panelTuto.enregistreEcouteur(this);
        this.fenetre.enregistreEcouteur(this);
  
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
/***PANELMENU***/
            case "NOUVELLE PARTIE":
                fenetre.setFenetre(panelNiveau);     
                break;
            case "CONTINUER":
                break;
            case "SCORE":
                break;
            case "BONUS":
                break;
            case "RÈGLES":
                fenetre.setFenetre(panelTuto);     
                break;
            case "QUITTER":
                System.exit(0); //pour fermer l'application
            case "RESET":
                panelNiveau.resetNiveau();
                panelNiveau.setGrille(grille);
                perso = panelNiveau.getPersonnage();
                break;
/***PANELNIVEAU***/
            case "\u25B2": //déplacement haut    
                perso.deplacementHaut();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille);            
                break;
            case "\u25BA": //déplacement droite 
                perso.deplacementDroite();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille);        
                break;
            case "\u25BC": //déplacement bas
                perso.deplacementBas();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille);        
                //panelNiveau.revalidate(); 
                break;
            case "\u25C4": //déplacement gauche 
                perso.deplacementGauche();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille);        
                break;
/***PANELTUTO***/
            case "<<": 
                panelTuto.premier();
                break;
            case "<": 
                panelTuto.precedent();
                break;
            case ">": 
                panelTuto.suivant();
                break;
            case ">>": 
                panelTuto.dernier();
                break;
            default:
                System.out.println("evt detecté mais non traité");
                break;  
        }
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent key) {
        switch( key.getKeyCode() ) {
            
            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
            case KeyEvent.VK_8:    
                perso.deplacementHaut();
                /**/
                //panelNiveau.setScore(panelNiveau.getScore()+10);  
                break;
            case KeyEvent.VK_DOWN:  
            case KeyEvent.VK_S:
            case KeyEvent.VK_2:
                perso.deplacementBas();               
                //panelNiveau.setScore(panelNiveau.getScore()+10);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
            case KeyEvent.VK_6:
                perso.deplacementDroite();
               // panelNiveau.setScore(panelNiveau.getScore()+10);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
            case KeyEvent.VK_4:    
                perso.deplacementGauche();
                //panelNiveau.setScore(panelNiveau.getScore()+10);
                break;
            }
        grille.setGrilleChar(perso.newPosition(grille));
        
        if(perso.getCaseGrille()==Data.EXIT){ // permet de passer au niveau suivant lorsque            
            panelNiveau.setNiveau(panelNiveau.getNumNiveau()+1);
            perso = panelNiveau.getPersonnage();             
        } 
        panelNiveau.setGrille(grille);        
   
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //System.out.println("key released");
    }
}
