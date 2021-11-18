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
import java.util.Timer;
import java.util.TimerTask;
import modele.Data;
import modele.Grille;
import modele.Personnage;
import java.util.Timer;
import java.util.TimerTask;
import modele.Monstre;
import vue.*;

/**
 *
 * @author vishn
 */
public class Controleur implements Runnable, ActionListener, KeyListener, Data{
    
    PanelMenu panelMenu;
    PanelNiveau panelNiveau;
    PanelGrille panelGrille;
    PanelTuto panelTuto;
   
    Grille grille;
    
   
    Personnage perso;
    Fenetre fenetre;
    
    
    Monstre monstre = new Monstre(1,1,'M');
    Thread t = new Thread(monstre);
    
    
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
    public void run(){
        Thread p = new Thread(this);
        p.start();
        System.out.println("ookk");
         
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
/***PANELMENU***/
            case "NOUVELLE PARTIE":
                fenetre.setFenetre(panelNiveau);
                t.start();
                Timer chrono = new Timer();
                chrono.schedule(new TimerTask(){
                
                    @Override
                    public void run(){
                        //System.out.println("Temps :" + panelNiveau.getTemps());
                        //panelNiveau.setTemps(panelNiveau.getTemps()+1);
                        PanelControle pan = panelNiveau.getPanelControle();
                        pan.setTemps(pan.getTemps()+1);
                        pan.setLabelTemps();
                        panelNiveau.setPanelControle(pan);
                        
                        //partie monstre
                
                        if( monstre.getCaseGrille()== PERSO) {
                            panelNiveau.resetNiveau();
                            panelNiveau.setGrille(grille);
                            perso = panelNiveau.getPersonnage();
                            
                            monstre.setCaseGrille(ICE_N);
                        }
                        grille.setGrilleChar(monstre.newPosition(grille));   
                        
                        panelNiveau.setGrille(grille);
                        
                    }
                },1000,1000);
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
                grille.setGrilleChar(perso.newPosition(grille));
               
            case KeyEvent.VK_DOWN:  
            case KeyEvent.VK_S:
            case KeyEvent.VK_2:
                perso.deplacementBas(); 
                grille.setGrilleChar(perso.newPosition(grille));
               
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
            case KeyEvent.VK_6:
                perso.deplacementDroite();
                grille.setGrilleChar(perso.newPosition(grille));
               
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
            case KeyEvent.VK_4:    
                perso.deplacementGauche();
               grille.setGrilleChar(perso.newPosition(grille));
                break;
            default : 
                break;
        }
        
       
        
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
