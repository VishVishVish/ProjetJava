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
    PanelControle panelControle;
    Grille grille;
    
   
    Personnage perso;
    Fenetre fenetre;
    /**
     * Constructeur de la classe controleur permet de coordonnées les actions/réactions du jeu 
     * @param panelMenu correspond au panel du menu principal du jeu 
     * @param panelNiveau correspond au panel des niveaux du jeu
     * @param fenetre correspond à la fenêtre du jeu
     */
    public Controleur(PanelMenu panelMenu, PanelNiveau panelNiveau, Fenetre fenetre){
        this.panelMenu = panelMenu;
        this.panelNiveau = panelNiveau;
        this.panelGrille = panelNiveau.getPanelGrille();
        this.grille = panelGrille.getGrille();
        this.perso = panelNiveau.getPersonnage();
        this.fenetre = fenetre;
        
        this.panelMenu.enregistreEcouteur(this);
        this.panelNiveau.enregistreEcouteur(this);
        this.fenetre.enregistreEcouteur(this);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "START":
                fenetre.setFenetre(panelNiveau);     
                break;
            case "CONTINUE":
                break;
            case "SCORE":
                break;
            case "BONUS":
                break;
            case "RULES":
                break;
            case "EXIT":
                System.exit(0); //pour fermer l'application
            case "RESET":
                int niveau = 1;
                grille = new Grille(niveau);           
                int posX = Data.POS_PERSO[niveau][0];
                int posY = Data.POS_PERSO[niveau][1];
                perso = new Personnage(posX,posY,Data.PERSO);       
                grille.setGrilleChar(perso.setPosition(grille));            
                panelNiveau.setGrille(grille);     
                
                
                break;
            case "\u25B2":
                System.out.println("deplacement haut effectué");
                perso.deplacementHaut();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille);            
                break;
            case "\u25BA":
                System.out.println("deplacement droite effectué");
                perso.deplacementDroite();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille);        
                break;
            case "\u25BC":
                System.out.println("deplacement bas effectué");
                perso.deplacementBas();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille);        
                //panelNiveau.revalidate(); 
                break;
            case "\u25C4":
                System.out.println("deplacement gauche effectué");
                perso.deplacementGauche();
                grille.setGrilleChar(perso.newPosition(grille));
                panelNiveau.setGrille(grille);        
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
            //System.out.println("fin niveau"); // le personnage est sur une case exit 
            int niveau = panelNiveau.getNumNiveau()+1; //PAS TOUCHER
            panelNiveau.setNumNiveau(niveau);           
            grille = new Grille(niveau);           
            int posX = Data.POS_PERSO[niveau][0];
            int posY = Data.POS_PERSO[niveau][1];
            perso = new Personnage(posX,posY,Data.PERSO);       
            grille.setGrilleChar(perso.setPosition(grille));            
            panelNiveau.setGrille(grille);     
            
        } 
        panelNiveau.setGrille(grille);        
        panelNiveau.revalidate();
        
        //grille.affichageGrille();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //System.out.println("key released");
    }
}
