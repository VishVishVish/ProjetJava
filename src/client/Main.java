package client;
import vue.*;
import controleur.Controleur;
import modele.Grille;
import modele.Monstre;

/**
 *Permet de lancer le programme en utilisant les différentes classes du projet
 * @author Vishnou Peroumalnaikar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PanelMenu panelMenu = new PanelMenu(); 
        PanelNiveau panelNiveau = new PanelNiveau(); 
        PanelTuto panelTuto = new PanelTuto();
        PanelScore panelScore = new PanelScore();
        PanelVictoire panelVictoire = new PanelVictoire();
        //PanelGrille panelGrille = new PanelGrille(); 
        Fenetre fenetre = new Fenetre();

        fenetre.setContentPane(panelMenu);
        //fenetre.pack();
        //System.out.println(fenetre.getWidth() + " "+ fenetre.getHeight());
        Controleur controleur = new Controleur(panelMenu, panelNiveau, panelScore, panelTuto, panelVictoire, fenetre);
        
        
        
       
        
    }
    
}
