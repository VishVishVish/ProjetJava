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
public class Tondeuse extends Case implements Runnable, Data{
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
     * permet de régler la vitesse du monstre
     */
    int pause = 200; //correspond à la vitesse de déplacement du monstre en ms, 
    
    /**
     * permet de rendre actif le monstre
     */
    public boolean boolActif;
    
    /**
     * le thread de la tondeuse
     */
    Thread threadTondeuse;
    
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
        boolActif = false;
        threadTondeuse = new Thread(this);
        threadTondeuse.start();
        
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
     * permet de lancer le monstre
     */
    public void start(){
        boolActif = true;  
    }
    
    /*
    public void pause(){
        threadMonstre.start();
    }*/
    
    /**
     * correspond au run du monstre qu'il effectue en simultanée au main lorqu'il est actif 
     */
    @Override
    public void run(){
        while(boolActif) {
   
            
       }     
    }
    
  
    public char[][] newPosition(char[][] grilleChar, Personnage perso ){

        System.out.println(perso.direction);
        
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