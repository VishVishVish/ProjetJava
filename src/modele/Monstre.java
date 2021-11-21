/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Arrays;
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
    
    private boolean gauche_droite = true ; //le monstre commence à se déplacer vers la droite
    
    public boolean refresh; //permet au controleur si on doit actualiser le panelNiveau
    
    int pause = 1000; //correspond à la vitesse de déplacement du monstre en ms, 
    
    public boolean boolActif;
    
    Thread threadMonstre;
    
    private char [][] grilleChar; 
    
   
   
   
    public Monstre(int posX, int posY, char caractere){
        super(posX, posY, caractere);
        this.newPosX = posX;
        this.newPosY = posY;
        this.caseGrille = '.';//il commence sur une case banquise fragile (ICE_N)
        refresh = false;
        boolActif = false;
        threadMonstre = new Thread(this);
        threadMonstre.start();
        
    }
    
    public void reset(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.newPosX = posX;
        this.newPosY = posY;
        this.caseGrille = '.';
    }
    
    public void start(){
        boolActif = true;
        
        
    }
    
    public void pause(){
        threadMonstre.start();
    }
    
    @Override
    public void run(){
        while(boolActif) {
            
            if(grilleChar != null) 
                this.setGrilleChar(this.newPosition(grilleChar));
            try {
                Thread.sleep(pause);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Monstre.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       }     
    }
    
    
   public char[][] newPosition(char[][] grilleChar){
        //char grilleChar [][] = grilleNiveau.getGrilleChar();
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
            refresh = true;
                //grille.affichageGrille();
            return grilleChar;
   }
   
    public char[][] setPosition(Grille grilleNiveau){
        char[][] grille = grilleNiveau.getGrilleChar();
        caseGrille = grille[posX][posY];
        grille[posX][posY] = caractere;
        return grille;
    }
   
   /**
      * modifie la grille du niveau 
      * @param grille correspond à une copie de la grille actif du niveau 
      */
     public void setGrilleChar(char grille [][]){
         /*
         System.out.println("------------" + grille.length);
         for (int i = 0; i < grille.length-1; i++) {
            this.grilleChar[i] = Arrays.copyOf(grille[i], grille[i].length);
        }*/
         
         this.grilleChar = grille;
     }
     
      /**
      * retourne la grille de niveau 
      * @return correspond à la grille du niveau
      */
     public char [][] getGrilleChar(){
         return grilleChar;
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
