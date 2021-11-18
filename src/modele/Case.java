/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author vishn
 */
public abstract class Case {
    /**
     * correspond à la position X de la case de la grille
     */
    protected int posX; 
    /**
     * correspond à la position Y de la case de la grille
     */
    protected int posY; 
    /**
     * correspond au symbole qu'on visualise dans la grille lors de l'affichage dans la console
     */
    protected char caractere;
        
   /**
    * constructeur de la classe Case, représente le contenu possible d'une case de la grille du niveau
    * @param posX correspond à la ligne de la case 
    * @param posY correspond à la colonne de la case
    * @param caractere corrspond au caractère affiché dans la console lors de l'affichage de la case
    */
    public Case(int posX, int posY, char caractere){
        this.posX = posX;
        this.posY = posY;
        this.caractere = caractere;
    }
    
   /**
    * retourne la position X de la case 
    * 
    * @return corresond à la position X de la case dans la grille du niveau 
    */
    public int getX(){
        return this.posX;
    }
    
    /**
    * retourne la position Y de la case 
    * 
    * @return correspond à la position Y de la case dans la grille du niveau 
    */
    public int getY(){
        return this.posY;
    }
    /**
     * retourne le caractere de la case qu'on peut visualiser lors de l'affichage de la grille dans la console
     * 
     * @return correspond au caractere représentant la case
     */
    public char getCaractere(){
        return this.caractere;
    }
    
    /**
     * modifie la position X de la case 
     * 
     * @param x corresond à la nouvelle position X de la case    
     */
    public void setX(int x){
        this.posX = x;
    }
    /**
     * modifie la position X de la case 
     * @param y corresond à la nouvelle position X de la case    
     */
    public void setY(int y){
        this.posY = y;
    }
    /**
     * modifie le caractere de la case 
     * 
     * @param caractere correspond au nouveau caractere de la case  
     */
    public void setCaractere(char caractere){
        this.caractere = caractere;
    }
    
    

    
}
