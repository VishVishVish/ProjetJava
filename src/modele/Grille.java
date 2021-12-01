/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.util.Arrays;
import javax.swing.JLabel;

/**
 * Création de la grille du niveau 
 * @author Vishnou Peroumalnaikar
 */
public class Grille implements Data{
    //Data Data = new Data();
    
    /**
     * correspond au nombre de ligne de la grille, la valeur par défaut est 15
     */
    private int nbrLigne; 
    /**
     * correspond au nombre de colonne de la grille, la valeur par défaut est 19
     */
    private int nbrColonne;
    /**
     * correspond à la grille du niveau en version console
     */
    private char grilleChar [][] = new char[15][19];
    
    /**
     * créé une grille de niveau avec les valeurs par défaut (ligne = 15, colonne = 19)
     */
    public Grille(){
        this.nbrLigne = 15;
        this.nbrColonne = 19;
        this.grilleChar = new char [nbrLigne][nbrColonne]; 
    }
    
    /**
     * créé une grille avec un nombre de ligne et de colonne définit en paramètre
     * @param nbrLigne correspond au nombre de ligne de la grille 
     * @param nbrColonne correspoond au nombre de colonne de la grille
     */
    public Grille(int nbrLigne, int nbrColonne){
        this.nbrLigne = nbrLigne;
        this.nbrColonne = nbrColonne;
        this.grilleChar = new char [15][19];
    }
    
    /**
     * créé une grille du niveau déjà existant dans la classe Data
     * @param niveau correspond au niveau du jeu définit dans la classe Data
     */
    public Grille(int niveau){
        //System.out.println(LEVELS[niveau].length);
        for (int i = 0; i < LEVELS[niveau].length; i++){
            this.grilleChar[i] = Arrays.copyOf(LEVELS[niveau][i], LEVELS[niveau][i].length);
        }
        this.nbrLigne = 15;
        this.nbrColonne = 19;
    }
   
    /**
     * permet de remplir le tableau représentant la grille par un caratère donné
     * 
     * @param caractere représente le caractère initialisant la grille entière
     */
    public void initGrille(char caractere){
        for(int li = 0; li<this.nbrLigne;li++){
            for(int co = 0; co<this.nbrColonne;co++){
                grilleChar[li][co] = caractere;
            }
        }
    }
    
    public void resetGrille(char grille [][]){
        
        grilleChar = new char[15][19];
        for(int li = 0 ; li<15 ; li++){
            for(int co = 0 ; co<19; co++){
                char c = grille[li][co];
                //this.grilleChar[li][co] = new char[grille[li][co]];
            }
        }
    }
    
    public Monstre setMonstre(Monstre monstre){
        //monstre.newPosition(this.grilleChar);
        
        return monstre;
    }
    
    /**
     * permet d'afficher la grille du niveau dans la console
     */
     public void affichageGrille(){
        String str1 = "-";
        for(int i = 0; i<nbrColonne;i++){
            str1 += "----";
        }
        for(int i = 0; i<nbrLigne;i++){
            System.out.println(str1);
            
            String str2 = "| ";
            for(int j = 0; j<nbrColonne;j++){
                str2 += grilleChar[i][j] + " | "; 
            }
            System.out.println(str2);
        }
        System.out.println(str1);      
    }
     /**
      * retourne la grille de niveau 
      * @return correspond à la grille du niveau
      */
     public char [][] getGrilleChar(){
         return grilleChar;
     }
     
     /**
      * modifie la grille du niveau 
      * @param grille correspond à la grille du niveau
      */
     public void setGrilleChar(char grille [][]){
        this.nbrLigne = grille.length;
        this.nbrColonne = grille[0].length;
         for (int i = 0; i < nbrLigne; i++) {
            this.grilleChar[i] = Arrays.copyOf(grille[i], grille[i].length);
        }
        //this.grilleChar = grille; 
     }
     
     
     
     /**
      * modifie la case d'une grille du niveau
      * @param posX correspond à la ligne choisi 
      * @param posY correspond à la colonne choisi
      * @param caseChar correspond au caractère contenu danq la case de la grille du niveau
      */
     public void setCase(int posX, int posY, char caseChar ){
         grilleChar[posX][posY] = caseChar;
     }
     
     /**
      * permet de placer le contenue d'une case dans une des cases de la grille du niveau
      * @param newCase correspond au contenue d'une case à placé dans la grille du niveau 
      */
     public void setCase(Case newCase){
         grilleChar[newCase.getX()][newCase.getY()] = newCase.getCaractere();
     }
     
     
     /**
      * retourne le nombre de ligne de la grille du niveau
      * @return correspond au nombre de ligne de la grille du niveau
      */
     public int getNbrLigne(){
         return nbrLigne;
     }
     /**
      * retourne le nombre de colonne de la grille du niveau 
      * @return correspond au nombre de colonne de la grille du niveau 
      */
     public int getNbrColonne(){
         return nbrColonne;
     }
   
}
