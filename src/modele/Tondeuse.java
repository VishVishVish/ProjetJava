 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;



/**
 *
 * @author laurentdavenne
 */
public class Tondeuse extends Case implements Data{
    /**
    * correspond à la nouvelle position X du personnage ECEMAN
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
     * permet de savoir s'il faut refresh la grille 
     */
    public boolean refresh; //permet au controleur si on doit actualiser le panelNiveau
    
    /**
     * correspond au score 
     */
    private int score;

    
    /**
     * la grille du niveau 
     */
    private char [][] grilleChar; 

    /**
     * constructeur de la classe Monstre
     * @param posX correspond à la ligne dans la grille du niveau
     * @param posY correspond à la colonne dans la grille du niveau 
     * @param caractere correspond au caractere du pesonnage dans le niveau 
     * 
     */
    public Tondeuse(int posX, int posY, char caractere){
        super(posX, posY, caractere);
        this.newPosX = posX;
        this.newPosY = posY;
        this.caseGrille = '.';//il commence sur une case banquise fragile (ICE_N)
        refresh = false;
       
        
    }
    /**
     * permet de reset le monsttre 
     * @param posX correspond à la nouvelle ligne de la tondeuse 
     * @param posY correspond à la nouvelle colonne de la tondeuse 
     */
    public void reset(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.newPosX = posX;
        this.newPosY = posY;
        this.caseGrille = '.';
        //this.boolDirection = true;
    }
    
  
            
     
    
    /**
     * permet de modifier la position de la tondeuse 
     * @param grilleChar correspond à la grille de caractère 
     * @param perso correspond au personnage 
     * @return correspond à la grille qui à été modifié par la tondeuse 
     */
    public char[][] newPosition(char[][] grilleChar, Personnage perso ){
        
        boolean bool = true;
        while(bool){
            if(grilleChar[newPosX][newPosY] == Data.ICE_N)
                grilleChar[newPosX][newPosY] = Data.WATER;
            else if(grilleChar[newPosX][newPosY] == Data.ICE_S)
                grilleChar[newPosX][newPosY] = Data.ICE_N;
            
            switch (perso.direction) { //permet de savoir de quelle côté le personnage pousse la brique
                
                case 0:
                    if(grilleChar[newPosX-1][newPosY] == Data.ICE_N || grilleChar[newPosX-1][newPosY]== Data.ICE_S)
                        deplacementHaut();
                    else
                        bool = false;
                    break;
                case 1:
                    if(grilleChar[newPosX][newPosY+1] == Data.ICE_N || grilleChar[newPosX][newPosY+1]== Data.ICE_S)
                        deplacementDroite();
                    else
                        bool = false;
                    break;
                case 2:
                    if(grilleChar[newPosX+1][newPosY] == Data.ICE_N || grilleChar[newPosX+1][newPosY]== Data.ICE_S)
                        deplacementBas();
                    else
                        bool = false;
                    break;
                case 3:
                    if(grilleChar[newPosX][newPosY-1] == Data.ICE_N || grilleChar[newPosX][newPosY-1]== Data.ICE_S)
                        deplacementGauche();
                    else
                        bool = false;
                    break;
                default:
                    break;
                    
                    
            }
        }
        

        //grilleChar[posX][posY] = '.';
        grilleChar[newPosX][newPosY] = caractere;

        return grilleChar;
    }
   
   /**
    * permet de se placer dans la grille du niveau
    * @param grilleNiveau correspond à la grille du niveau
    * @return retourne la grille du niveau 
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
     * permet d'effectuer un déplacement vers le haut
     */
    public void deplacementHaut(){
        this.newPosX--; 
    }
    
    /**
     * permet d'effectuer un déplacement vers la droite 
     */
    public void deplacementDroite(){
        this.newPosY++;
    }
    
    /**
     * permet d'effectuer un déplacement vers la gauche 
     */
    public void deplacementGauche(){
        this.newPosY--;
    }
    
    /**
     * permet d'effectuer un déplacement vers le bas 
     */
    public void deplacementBas(){
        this.newPosX++;
    }
    
    /**
     * retourne la futur coordonnées X de la tondeuse 
     * @return correspond à la futur coordonnées X de la tondeuse 
     */
    public int getNewX(){
        return this.newPosX;
    }
    
    /**
     * retourne la futur coordonnées Y de la tondeuse 
     * @return correspond à la futur coordonnées Y de la tondeuse
     */
    public int getNewY(){
        return this.newPosY;
    }
    
    /**
     * retourne la case ou est posé la tondeuse 
     * @return correspond à la case ou est placé la tondeuse 
     */
    public char getCaseGrille(){
        return this.caseGrille;
    }
    
    /**
     * modifie la futur coordonnée X de la tondeuse 
     * @param x coorespond à la futur coordonnée X de la tondeuse 
     */
    public void setNewX(int x){
        this.newPosX = x;
    }
    
    /**
     * modifie la futur coordonnées Y de la tondeuse 
     * @param y coorespond à la futur coordonnée Y de la tondeuse
     */
    public void setNewY(int y){
        this.newPosY = y;
    }
    
    /**
     * modifie la case ou est placé la tondeuse 
     * @param caseGrille correspond à la case ou est placé la tondeuse
     */
    public void setCaseGrille(char caseGrille){
        this.caseGrille = caseGrille;
    }
    
    /**
     * retourne le score obtenue par la tondeuse 
     * @return coorespond au score 
     */
    public int getScore() {
        return score;
    }
    
    /**
     * modifie le score 
     * @param score correspond au score
     */
    public void setScore(int score) {
        this.score = score;
    }
    
}