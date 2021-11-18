/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vishn
 */
public class Monstre extends Case implements Runnable, Data{
    
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
    private char caseGrille;
    
    boolean gauche_droite = true ;
    
    char [][] grilleChar; 
    
   
   
   
    public Monstre(int posX, int posY, char caractere){
        super(posX, posY, caractere);
        this.newPosX = posX;
        this.newPosY = posY;
    }
    
    @Override
    public void run(){
      
        
    }
    
    
   public char[][] newPosition(Grille grilleNiveau){
       boolean boolActif = true;
         //droite = true, gauche = false
        //Grille grille = new Grille(0);
        char grilleChar [][] = grilleNiveau.getGrilleChar();
            if(gauche_droite){
                if(grilleChar[newPosX][newPosY] == ICE_N || grilleChar[newPosX][newPosY] == WATER || grilleChar[newPosX][newPosY] == PERSO) {
                    grilleChar[posX][posY] = caseGrille; // on replace le caractère de la case ou était placé le monstre
                    caseGrille = grilleChar[newPosX][newPosY];
                    grilleChar[newPosX][newPosY] = caractere; // on remplace le caratere de la grille dans le niveau
                   //la nouvelle position devient la position actif du monstre
                    posX = newPosX;
                    posY = newPosY;
                    deplacementDroite();
               }
                else{
                    gauche_droite = false;
                    newPosX = posX;
                    newPosY = posY;
                    deplacementGauche();
                }

            }
            else { // déplacement vers la gauche
                if(grilleChar[newPosX][newPosY] == ICE_N || grilleChar[newPosX][newPosY] == WATER || grilleChar[newPosX][newPosY] == PERSO) {
                    grilleChar[posX][posY] = caseGrille; // on replace le caractère de la case ou était placé le monstre
                    caseGrille = grilleChar[newPosX][newPosY];
                    grilleChar[newPosX][newPosY] = caractere; // on remplace le caratere de la grille dans le niveau
                   //la nouvelle position devient la position actif du monstre
                    posX = newPosX;
                    posY = newPosY;
                    deplacementGauche();  
               }
                else{ //on change le sens de déplacement du personnage
                    gauche_droite = true;
                    newPosX = posX;
                    newPosY = posY;
                    deplacementDroite();
                }                         
            }
                //grille.affichageGrille();
            return grilleChar;

   }
    
    public char[][] setPosition(Grille grilleNiveau){
        char[][] grille = grilleNiveau.getGrilleChar();
        caseGrille = grille[posX][posY];
        grille[posX][posY] = caractere;
        return grille;
    }
     
    public void deplacementHaut(){
        this.newPosX--; 
    }
    public void deplacementDroite(){
        this.newPosY++;
    }
    public void deplacementGauche(){
        this.newPosY--;
    }
    public void deplacementBas(){
        this.newPosX++;
    }
    
    public int getNewX(){
        return this.newPosX;
    }
    
    public int getNewY(){
        return this.newPosY;
    }
    
    public char getCaseGrille(){
        return this.caseGrille;
    }
    
    public void setNewX(int x){
        this.newPosX = x;
    }
    
    public void setNewY(int y){
        this.newPosY = y;
    }
    
    public void setCaseGrille(char caseGrille){
        this.caseGrille = caseGrille;
    }
    
}
