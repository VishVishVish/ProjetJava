package client;
import vue.*;
import controleur.Controleur;

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
        //PanelGrille panelGrille = new PanelGrille(); 
        Fenetre fenetre = new Fenetre();
        
        fenetre.setContentPane(panelMenu);
        Controleur controleur = new Controleur(panelMenu, panelNiveau, fenetre);
        
        
        
    }
    
}
