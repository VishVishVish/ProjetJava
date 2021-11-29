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
import modele.Chrono;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.Monstre;
import modele.Save;
import modele.Scores;
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
    PanelVictoire panelVictoire;
    
    //package modele
    Grille grille;
    Personnage perso;
    Chrono chrono;
    Save save;
    Scores scores;

    Monstre monstre = new Monstre(Data.POS_MONSTRE[0][0],Data.POS_MONSTRE[0][1],'M');
    //Thread threadMonstre = new Thread(monstre);
    //Thread monstre2 = new Thread();
    Monstre monstre2 = new Monstre(5,5,'M');
    
    //variables de la classe Controleur
    boolean boolRefresh = false;
    Thread refreshGrille; //permet de refresh la grille du niveau
    int intRefreshGrille = 50; //durée entre chaque refresh
    
    int score = 0;
    

    /**
     * Constructeur de la classe controleur permet de coordonnées les actions/réactions du jeu 
     * @param panelMenu correspond au panel du menu principal du jeu 
     * @param panelNiveau correspond au panel des niveaux du jeu
     * @param fenetre correspond à la fenêtre du jeu
     */
    public Controleur(PanelMenu panelMenu, PanelNiveau panelNiveau, PanelScore panelScore,  PanelTuto panelTuto, PanelVictoire panelVictoire, Fenetre fenetre){
        this.panelMenu = panelMenu;
        this.panelNiveau = panelNiveau;
        this.panelGrille = panelNiveau.getPanelGrille();
        this.grille = panelGrille.getGrille();
        this.perso = panelNiveau.getPersonnage();
        this.fenetre = fenetre;
        this.panelTuto = panelTuto;
        this.panelScore = panelScore;
        this.panelVictoire = panelVictoire;
        
        this.panelMenu.enregistreEcouteur(this);
        this.panelNiveau.enregistreEcouteur(this);
        this.panelTuto.enregistreEcouteur(this);
        this.panelScore.enregistreEcouteur(this);
        this.panelVictoire.enregistreEcouteur(this);
        this.fenetre.enregistreEcouteur(this);
 
        save = new Save();
        scores = new Scores();
        chrono = new Chrono();
        chrono.start();
        
        //chrono.pause();
  
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
/***PANELMENU***/
            case "NOUVELLE PARTIE":
                panelNiveau.setNiveau(5);
                perso = panelNiveau.getPersonnage();
                fenetre.setFenetre(panelNiveau);
                boolRefresh = true;
                chrono.setTemps(0);
                score = 0;
                refreshGrille = new Thread(this);
                refreshGrille.start();
               
                panelNiveau.setGrille(grille);
                
                //on lance le chrono
                break;
            case "CONTINUER":
                save.lire();
                panelNiveau.setNiveau(save.getNumNiveau());
                perso = panelNiveau.getPersonnage();
                fenetre.setFenetre(panelNiveau);
                boolRefresh = true;
                chrono.setTemps(save.getTemps());
                refreshGrille = new Thread(this);
                refreshGrille.start();
                
                break;
            case "SCORE":
                scores.lire();
                panelScore.setListeScores(scores);
                //panelScore.setListeScores(new Scores());
                fenetre.setFenetre(panelScore);
                break;
            case "BONUS":
                break;
            case "RÈGLES":
                fenetre.setFenetre(panelTuto);     
                break;
            case "MENU":
                System.out.println("ect");
                fenetre.setFenetre(panelMenu);     
                break;
            case "QUITTER":
                System.exit(0); //pour fermer l'application
            case "RESET":
                panelNiveau.resetNiveau();
                panelNiveau.setGrille(grille);
                perso = panelNiveau.getPersonnage();
                //chrono.setTemps(panelNiveau.getTemps());
                score = panelNiveau.getScore(); 
                break;
            case "SAUVEGARDER ET QUITTER":
                boolRefresh = false;
                System.out.println("save fait");
                save.setTemps(chrono.getTemps());
                panelNiveau.setTemps(chrono.getTemps());
                save.ecrire(panelNiveau.getNumNiveau(), panelNiveau.getScore(), panelNiveau.getTemps());
                fenetre.setFenetre(panelMenu);     
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
/***PANELVICTOIRE***/
            case "VALIDER ET QUITTER": 
                panelVictoire.setNom();
                //Scores sc = new Scores();
                
                scores.addScore(panelVictoire.getNom(), panelNiveau.getScore(), panelNiveau.getTemps());
                panelScore.setListeScores(scores);
                fenetre.requestFocus();
                fenetre.setFenetre(panelMenu);
                break;
            default:
                System.out.println("evt detecté mais non traité");
                break;  
        }
        
        /*
        if(perso.getCaseGrille()==Data.EXIT) // permet de passer au niveau suivant lorsque            
            prochainNiveau();*/
          
    }
    
    public void prochainNiveau(){
        int niveau = panelNiveau.getNumNiveau()+1;
        panelNiveau.setTemps(chrono.getTemps());
        panelNiveau.setScore(score);
        switch (niveau) {
            case 1://passage au niveau 1
                panelNiveau.setNiveau(niveau);
                perso = panelNiveau.getPersonnage();
                break;
            case 2://passage au niveau 2
                panelNiveau.setNiveau(niveau);
                perso = panelNiveau.getPersonnage();
                break;
            case 3://passage au niveau 3
                panelNiveau.setNiveau(niveau);
                perso = panelNiveau.getPersonnage();
                break;
            case 4://passage au niveau 4
                panelNiveau.setNiveau(niveau);
                perso = panelNiveau.getPersonnage();
                break;
            case 5://passage au niveau 5
                panelNiveau.setNiveau(niveau);
                perso = panelNiveau.getPersonnage();
                System.out.println("niveau 5 nous ajoutons les monstres");
                monstre = new Monstre(Data.POS_MONSTRE[0][0],Data.POS_MONSTRE[0][1],'M');
                monstre.setGrilleChar(grille.getGrilleChar());
                grille.setGrilleChar(monstre.getGrilleChar());
                monstre.start();
                break;
            default://tous les niveaux on été terminé
                boolRefresh = false;
                monstre.boolActif = false;
                
                panelNiveau.setScore(score);
                panelNiveau.setTemps(chrono.getTemps());
                
                panelVictoire.setLabelScore(panelNiveau.getScore());
                panelVictoire.setLabelTemps(panelNiveau.getTemps());
                
                fenetre.setFenetre(panelVictoire);
                perso.setCaseGrille(ICE_N);
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
                
                break;
            case KeyEvent.VK_DOWN:  
            case KeyEvent.VK_S:
            case KeyEvent.VK_2:
                perso.deplacementBas(); 
                grille.setGrilleChar(perso.newPosition(grille));
                //panelNiveau.setGrille(grille); 
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
            case KeyEvent.VK_6:
                perso.deplacementDroite();
                grille.setGrilleChar(perso.newPosition(grille));
                //panelNiveau.setGrille(grille); 
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
            case KeyEvent.VK_4:    
                perso.deplacementGauche();
                grille.setGrilleChar(perso.newPosition(grille));
                //panelNiveau.setGrille(grille); 
                break;
            default : 
                break;
        }
        
        if(perso.getCaseGrille()==Data.EXIT)
            prochainNiveau();
        //panelNiveau.setGrille(grille);

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
            
            
            if(perso.boolDeplacement) {
                score+=10;
                perso.boolDeplacement = false;
            }
            
            //System.out.println(score);
            panelNiveau.setAffichagePanelControle(score,chrono.getTemps());
            try {
                Thread.sleep(intRefreshGrille);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
        
       
    }
}
