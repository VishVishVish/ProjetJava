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
public class Brique extends Case implements Data{
    
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
     * constructeur de la classe Brique 
     * @param x correspond à la coordonnées X de la brique dans la grille du niveau
     * @param y correspond à la coordonnées Y de la brique dans la grille du niveau
     * @param caractere correspond au symbole affiché dans la console
     */
    public Brique(int x, int y, char caractere){
        super(x, y, caractere);
        this.newPosX = posX;
        this.newPosY = posY;
        this.caseGrille = '.';
    }
    
    /**
     * permet le déplacement de la brique dans la grille du niveau en fonction du personnage 
     * @param grilleChar correspond à la grille de caractère représentant le niveau dans la console
     * @param perso correspond au personnage 
     * @return retourne la grille du caractère modifié 
     */
    public char[][] newPosition(char[][] grilleChar, Personnage perso ){

        System.out.println(perso.direction);
        
        switch (perso.direction) { //permet de savoir de quelle côté le personnage pousse la brique
            case 0:
                deplacementHaut();
                break;
            case 1:
                deplacementDroite();
                break;
            case 2:
                deplacementBas();
                break;
            case 3:
                deplacementGauche();
                break;
            default:
                break;
        }

        grilleChar[newPosX][newPosY] = caractere;
        
        posX = newPosX;
        posY = newPosY;
        
        
        return grilleChar;
    }
    
    /*
    public boolean boolCase(char[][] grilleChar, Personnage perso ){
        if(perso.direction == 0){
            if(grilleChar[posX+1][posY] == '.'){
                System.out.println("brisiihih");
                return true;
            }
        }
        else if(perso.direction == 0){
            if(grilleChar[posX][posY] == '.'){
                System.out.println("brisiihih");
                return true;
            }
        }
        
        //AJOUTER LIGNE ICI IMPORTANT 
        return false;    
      
    }*/
    
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
    
    public int convertPersoNumber(Personnage perso) {
        if(perso.posX<perso.getNewX()) //personnage pousse la brique par le bas
            return 2;
        else if(perso.posX>perso.getNewX()) //personnage pousse la brique par le haut 
            return 0;
        else if(perso.posY<perso.getNewY()) //personnage pousse la brique par la droite
            return 1;
        else if(perso.posY>perso.getNewY()) //personnage pousse la brique par la gauche
            return 3;
        else
            System.out.println("erreur déplacement brique");
            return -1;
    }
    
    
    /**
     * permet de déplacer la brique vers le haut 
     */
    public void deplacementHaut(){
        this.newPosX--; 
    }
    
    /**
     * permet de déplacer la brique vers la droite
     */
    public void deplacementDroite(){
        this.newPosY++;
    }
    
    /**
     * permet de déplacer la brique vers le gauche
     */
    public void deplacementGauche(){
        this.newPosY--;
    }
    /**
     * permet de déplacer la brique vers le bas
     */
    public void deplacementBas(){
        this.newPosX++;
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
    
}
