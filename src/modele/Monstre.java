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
    
    /**
     * permet de modifier la direction du monstre dans le sens opposé, il commence par défaut vers la droite ou par la gauche 
     */
    private boolean boolDirection = true ; 
    
    /**
     * correspond au type de monstre
     */
    private int typeMonstre; 
    
    //public boolean refresh; //permet au controleur si on doit actualiser le panelNiveau
    
    /**
     * correspond à la vitesse de déplacement du monstre en ms
     */
    int pause = 500; 
    
    /**
     * permet de rendre actif le monstre
     */
    public boolean boolActif;
    
    /**
     * thread du monstre
     */
    Thread threadMonstre;
    
    /**
     * grille du niveau
     */
    private char [][] grilleChar; 

    /**
     * constructeur de la classe Monstre
     * @param posX correspond à la coordonnée X
     * @param posY correspond à la coordonnée Y
     * @param caractere
     * @param typeMonstre 
     */
    public Monstre(int posX, int posY, char caractere, int typeMonstre){
        super(posX, posY, caractere);
        this.newPosX = posX;
        this.newPosY = posY;
        this.caseGrille = '.';//il commence sur une case banquise fragile (ICE_N)
        this.typeMonstre = typeMonstre; 
        //refresh = false;
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
        this.boolDirection = true;
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
                if(typeMonstre == 0)
                    this.setGrilleChar(this.newPositionGaucheDroite(grilleChar));
                else if (typeMonstre == 1)
                    this.setGrilleChar(this.newPositionHautBas(grilleChar));
            try {
                Thread.sleep(pause);
            } catch (InterruptedException ex) {
                //Logger.getLogger(Monstre.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       }     
    }
    
    
   public char[][] newPositionGaucheDroite(char[][] grilleChar){
        //char grilleChar [][] = grilleNiveau.getGrilleChar();
            if(boolDirection){
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
                    boolDirection = false;
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
                    boolDirection = true;
                    newPosX = posX;
                    newPosY = posY;
                    deplacementDroite();
                }                         
            }
            //refresh = true;
                //grille.affichageGrille();
            return grilleChar;
   }
   public char[][] newPositionHautBas(char[][] grilleChar){
        //char grilleChar [][] = grilleNiveau.getGrilleChar();
            if(boolDirection){
                if(grilleChar[newPosX][newPosY] == ICE_N || grilleChar[newPosX][newPosY] == WATER || grilleChar[newPosX][newPosY] == PERSO) {
                    grilleChar[posX][posY] = caseGrille; // on replace le caractère de la case ou était placé le monstre
                    caseGrille = grilleChar[newPosX][newPosY];
                    grilleChar[newPosX][newPosY] = caractere; // on remplace le caratere de la grille dans le niveau
                   //la nouvelle position devient la position actif du monstre
                    posX = newPosX;
                    posY = newPosY;
                    deplacementHaut();
               }
                else{
                    boolDirection = false;
                    newPosX = posX;
                    newPosY = posY;
                    deplacementBas();
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
                    deplacementBas();  
               }
                else{ //on change le sens de déplacement du personnage
                    boolDirection = true;
                    newPosX = posX;
                    newPosY = posY;
                    deplacementHaut();
                }                         
            }
            //refresh = true;
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
