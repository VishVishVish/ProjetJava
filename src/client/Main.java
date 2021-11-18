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
        //PanelGrille panelGrille = new PanelGrille(); 
        Fenetre fenetre = new Fenetre();
        
        
        //Grille grille = new Grille(0);
        //grille.affichageGrille();
        /*
        Monstre monstre = new Monstre(1,1,'M');
        Thread t = new Thread(monstre);
        t.start();
        monstre.setPosition(grille);
        panelNiveau.setGrille(grille);
*/
        //fenetre.setContentPane(panelTuto);
        //panelTuto.affiche();
        
        panelNiveau.setNiveau(0);
        
        fenetre.setContentPane(panelMenu);
        //fenetre.pack();
        //System.out.println(fenetre.getHeight());
        Controleur controleur = new Controleur(panelMenu, panelNiveau, panelTuto, fenetre);
        
        
        
       
        
    }
    
}
