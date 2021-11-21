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
import modele.Chrono;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Monstre;
import vue.*;

/**
 *
 * @author vishn
 */
public class Controleur implements Runnable, ActionListener, KeyListener, Data{
    
    //les panels du package vue
    Fenetre fenetre;
    PanelMenu panelMenu;
    PanelNiveau panelNiveau;
    PanelGrille panelGrille;
    PanelTuto panelTuto;
    PanelScore panelScore;
    
    //package modele
    Grille grille;
    Personnage perso;
    Chrono chrono;
    
    
    
    Monstre monstre = new Monstre(Data.POS_MONSTRE[0][0],Data.POS_MONSTRE[0][1],'M');
    //Thread threadMonstre = new Thread(monstre);
    //Thread monstre2 = new Thread();
    Monstre monstre2 = new Monstre(5,5,'M');
    
    //variables de la classe Controleur
    boolean boolRefresh = false;
    Thread refreshGrille; //permet de refresh la grille du niveau
    int intRefreshGrille = 500; //durée entre chaque refresh
    

    /**
     * Constructeur de la classe controleur permet de coordonnées les actions/réactions du jeu 
     * @param panelMenu correspond au panel du menu principal du jeu 
     * @param panelNiveau correspond au panel des niveaux du jeu
     * @param fenetre correspond à la fenêtre du jeu
     */
    public Controleur(PanelMenu panelMenu, PanelNiveau panelNiveau, PanelScore panelScore,  PanelTuto panelTuto, Fenetre fenetre){
        this.panelMenu = panelMenu;
        this.panelNiveau = panelNiveau;
        this.panelGrille = panelNiveau.getPanelGrille();
        this.grille = panelGrille.getGrille();
        this.perso = panelNiveau.getPersonnage();
        this.fenetre = fenetre;
        this.panelTuto = panelTuto;
        this.panelScore = panelScore;
        
        this.panelMenu.enregistreEcouteur(this);
        this.panelNiveau.enregistreEcouteur(this);
        this.panelTuto.enregistreEcouteur(this);
        this.panelScore.enregistreEcouteur(this);
        this.fenetre.enregistreEcouteur(this);
        
        
        
        chrono = new Chrono();
        chrono.start();
        //chrono.pause();
  
    }
   
 
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
/***PANELMENU***/
            case "NOUVELLE PARTIE":
                panelNiveau.setNiveau(4);
                perso = panelNiveau.getPersonnage();
                fenetre.setFenetre(panelNiveau);
                boolRefresh = true;
                chrono.setTemps(0);
                refreshGrille = new Thread(this);
                refreshGrille.start();
                //refreshGrille.start();
                panelNiveau.setGrille(grille);
                
                //on lance le chrono
                
                
 
                break;
            case "CONTINUER":
                break;
            case "SCORE":
                fenetre.setFenetre(panelScore);
                break;
            case "BONUS":
                break;
            case "RÈGLES":
                fenetre.setFenetre(panelTuto);     
                break;
            case "MENU":
                fenetre.setFenetre(panelMenu);     
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
        
        if(perso.getCaseGrille()==Data.EXIT) // permet de passer au niveau suivant lorsque            
            prochainNiveau();
        
        
    }
    
    public void prochainNiveau(){
        int niveau = panelNiveau.getNumNiveau()+1;
        
            
            if(niveau==5) {
                panelNiveau.setNiveau(niveau);
                perso = panelNiveau.getPersonnage();
                System.out.println("niveau 5 nous ajoutons les monstres");
                monstre = new Monstre(Data.POS_MONSTRE[0][0],Data.POS_MONSTRE[0][1],'M');
                monstre.setGrilleChar(grille.getGrilleChar());
                grille.setGrilleChar(monstre.getGrilleChar());
                monstre.start();            
            }
            else {
                boolRefresh = false;
                monstre.boolActif = false;
                fenetre.setFenetre(panelMenu);
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
                panelNiveau.setGrille(grille);
                break;
            case KeyEvent.VK_DOWN:  
            case KeyEvent.VK_S:
            case KeyEvent.VK_2:
                perso.deplacementBas(); 
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille); 
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
            case KeyEvent.VK_6:
                perso.deplacementDroite();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille); 
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
            case KeyEvent.VK_4:    
                perso.deplacementGauche();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille); 
                break;
            default : 
                break;
        }
        
       
        
        if(perso.getCaseGrille()==Data.EXIT)
            prochainNiveau();
        panelNiveau.setGrille(grille);

        
   
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //System.out.println("key released");
    }

    @Override
    public void run() {
        
        while(boolRefresh){
            if(monstre.getCaseGrille() == Data.PERSO || monstre2.getCaseGrille() == Data.PERSO || perso.getCaseGrille() == Data.MNSTR){
                panelNiveau.resetNiveau();
                perso = panelNiveau.getPersonnage();
                monstre.reset(Data.POS_MONSTRE[0][0],Data.POS_MONSTRE[0][1]);
            }
          
            panelNiveau.setGrille(grille);
            panelNiveau.setAffichagePanelControle(chrono.getTemps());
            try {
                Thread.sleep(intRefreshGrille);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
       
    }
}
