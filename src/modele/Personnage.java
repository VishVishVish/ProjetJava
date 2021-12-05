/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Vishnou Peroumalnaikar
 */
public class Personnage extends Case implements Data {
    
    /**
    * correspond à la nouvelle position X du personnage 
    */
    private int newPosX; 
    /**
    * correspond à la nouvelle position X du personnage 
    */
    private int newPosY;
    /**
     * correspond au caractere ou est placé le personnage
     */
    private char caseGrille = '.';
    
    public int direction;
    
    /**
     * permet de savoir si le personnage s'est déplacé, utile pour le rajout de points dans le score
     */
    public boolean boolDeplacement = false;
    
    int potionLeger = 0;
    
    
    public Personnage(){
        super(0, 0, PERSO);
        this.newPosX = 0;
        this.newPosY = 0;
    }
   
    /**
     * constructeur de la classe Personnage
     * @param posX correspond à la nouvelle position X du personnage dans la grille du niveau
     * @param posY correspond à la nouvelle position Y du personnage dans la grille du niveau
     * @param caractere correspond au caractère du personnage qu'il affiche dans la grille de caractère dans la console
     */
    public Personnage(int posX, int posY, char caractere){
        super(posX, posY, caractere);
        this.newPosX = posX;
        this.newPosY = posY;
    }
    
    /**
     * permet de modifier la position du personnage dans la grille en prenant en compte les conséquences nécessaires
     * @param grille correspond à la grille du niveau
     * @return retourne la grille de caractère du niveau modifié
     */
    public char[][] newPosition(Grille grille){
        
        char grilleChar [][] = grille.getGrilleChar();
        
        if(grilleChar[newPosX][newPosY]==Data.WATER || grilleChar[newPosX][newPosY]==Data.BLOCK){ //bloque le chemin si on veut passer sur l'eau ou un mur
            newPosX = posX;
            newPosY = posY;
            return grilleChar;
        }
        
        if (potionLeger<=0) {
            if(caseGrille == Data.ICE_N)//si banquise normal on remplace par de l'eau
                grilleChar[posX][posY] = Data.WATER;
            else if(caseGrille == Data.ICE_S)//si banquise epaisse on remplace par une banquise normal
                grilleChar[posX][posY] = Data.ICE_N;
        }
        else {
            potionLeger--;
            grilleChar[posX][posY] = caseGrille;
        }
        caseGrille = grilleChar[newPosX][newPosY]; //on recupère le symbole ou est placé le personnage
        if(caseGrille == Data.POT_L){
            potionLeger = 20;
            caseGrille = Data.WATER;
           
        }
        
        
        
        boolDeplacement = true;
        
        //on place la nouvelle position du personnage dans le tableau 
        grilleChar[newPosX][newPosY] = caractere;
        
        //la nouvelle position devient la position actif du personnage
        posX = newPosX;
        posY = newPosY;

        return grilleChar;
    }
    
    /**
     * permet de placer la position du personnage dans la grille 
     * @param grilleNiveau correspond à la grille du niveau
     * @return retourne la grille de caractère du niveau modifié
     */
    public char[][] setPosition(Grille grilleNiveau){
        char[][] grille = grilleNiveau.getGrilleChar();
        caseGrille = grille[posX][posY];
        grille[posX][posY] = caractere;
        return grille;
    }
    
    /**
     * permet de modifier les coordonnées du personnage permettant de faire un déplacement vers le haut dans la grille
     */
    public void deplacementHaut(){
        this.newPosX--; 
        this.direction=0;
    }
    /**
     * permet de modifier les coordonnées du personnage permettant de faire un déplacement vers la droite dans la grille
     */
    public void deplacementDroite(){
        this.newPosY++;
        this.direction=1;
    }
    /**
     * permet de modifier les coordonnées du personnage permettant de faire un déplacement vers la gauche dans la grille
     */
    public void deplacementGauche(){
        this.newPosY--;
        this.direction=3;
    }
    /**
     * permet de modifier les coordonnées du personnage permettant de faire un déplacement vers le bas dans la grille
     */
    public void deplacementBas(){
        this.newPosX++;
        this.direction=2;
    }
    
    /**
     * retourne la futur position X du personnage 
     * @return retourne la futur position X du personnage 
     */
    public int getNewX(){
        return this.newPosX;
    }
    /**
     * retourne la futur position Y du personnage 
     * @return retourne la futur position Y du personnage 
     */
    public int getNewY(){
        return this.newPosY;
    }
    /**
     * retourne la case de la grille ou est posé le personnage 
     * @return retourne la case de la grille ou est posé le personnage 
     */
    public char getCaseGrille(){
        return this.caseGrille;
    }
    
    /**
     * modifie la futur position X du personnage 
     * @param x correspond à la futur position X du personnage 
     */
    public void setNewX(int x){
        this.newPosX = x;
    }
    /**
     * modifie la futur position Y du personnage 
     * @param y correspond à la futur position Y du personnage 
     */
    public void setNewY(int y){
        this.newPosY = y;
    }
    /**
     * modifie la case de la grille ou est placé le personnage
     * @param caseGrille correspond à la nouvelle case de la grille ou est placé le personnage
     */
    public void setCaseGrille(char caseGrille){
        this.caseGrille = caseGrille;
    }
   
}
