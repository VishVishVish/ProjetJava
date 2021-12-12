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
    private int pause = 500; 
    
    /**
     * permet de rendre actif le monstre
     */
    public boolean boolActif;
    
    /**
     * thread du monstre
     */
    private Thread threadMonstre;
    
    /**
     * grille du niveau
     */
    private char [][] grilleChar; 

    /**
     * constructeur de la classe Monstre
     * @param posX correspond à la coordonnée X
     * @param posY correspond à la coordonnée Y
     * @param caractere correspond au symbole représenté du monstre 
     * @param typeMonstre correspond au type du monstre (0 pour gauche droite, 1 pour haut bas)
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
    
    /**
     * permet de reset le monstre 
     * @param posX correspond à la coordonnées X 
     * @param posY correspond à la coordonnées Y
     */
    public void reset(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.newPosX = posX;
        this.newPosY = posY;
        this.caseGrille = '.';
        this.boolDirection = true;
    }
    
    /**
     * permet de rendre actif le monstre
     */
    public void start(){
        boolActif = true;    
    }
    
    
    public void pause(){
        threadMonstre.start();
    }
    
    /**
     * méthode run du monstre
     */
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
    
   /**
    * permet de déplacer le monstre de gauche à droite 
    * @param grilleChar correspond à la grille du niveau 
    * @return correspond à la grille du niveau qui à été modifié par le monstre
    */ 
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
   
   /**
    * permet de déplacer le monstre de haut en bas 
    * @param grilleChar correspond à la grille du niveau 
    * @return correspond à la grille du niveau qui à été modifié par le monstre
    */ 
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
   
   /**
    * permet de définir la position du monstre dans la grille
    * @param grilleNiveau
    * @return 
    */
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
    
    /**
     * permet de faire un déplacemnt vers le haut
     */ 
    public void deplacementHaut(){
        this.newPosX--; 
    }
    
    /**permet de faire un déplacement vers la droite**/
    public void deplacementDroite(){
        this.newPosY++;
    }
    
    /**
     * permet de faire un déplacement vers la gauche
     */
    public void deplacementGauche(){
        this.newPosY--;
    }
    
    /**
     * permet de faire un déplacement vers le bas
     */
    public void deplacementBas(){
        this.newPosX++;
    }
    
    /**
     * retourne la futur position de X
     * @return correspond à la futur position X
     */
    public int getNewX(){
        return this.newPosX;
    }
    
    /**
     * retourne la futur position de Y
     * @return correspond à la futur position Y
     */
    public int getNewY(){
        return this.newPosY;
    }
    
    /**
     * retourne la case ou est placé le monstre
     * @return 
     */
    public char getCaseGrille(){
        return this.caseGrille;
    }
    
    /**
     * modifie la futur position X du monstre 
     * @param x correspond à la nouvelle futur position X
     */
    public void setNewX(int x){
        this.newPosX = x;
    }
    
    /**
     * modifie la futur position Y du monstre
     * @param y corresond à la nouvelle futur position Y
     */
    public void setNewY(int y){
        this.newPosY = y;
    }
    
    /**
     * modifie la case ou est placé le monstre
     * @param caseGrille correspond à la nouvelle case ou est placé le monstre
     */
    public void setCaseGrille(char caseGrille){
        this.caseGrille = caseGrille;
    }
    
}
