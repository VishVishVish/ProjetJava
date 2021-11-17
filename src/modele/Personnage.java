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
    private char caseGrille; 
   
    public Personnage(int posX, int posY, char caractere){
        super(posX, posY, caractere);
        this.newPosX = posX;
        this.newPosY = posY;
    }
    int Statut_L=0;
    
    
    public char[][] newPosition(Grille grille){
        
        char grilleChar [][] = grille.getGrilleChar();
        
        if(grilleChar[newPosX][newPosY]==Data.WATER || grilleChar[newPosX][newPosY]==Data.BLOCK){ //bloque le chemin si on veut passer sur l'eau
            newPosX = posX;
            newPosY = posY;
            return grilleChar;
        }
        
        
        if(caseGrille == Data.POT_L)//si potion leger on remplace par une banquise
            {grilleChar[posX][posY] = Data.ICE_N;
            Statut_L =7;
            
            }
        
            if (Statut_L ==0) { 
                if(caseGrille == Data.ICE_N)//si banquise normal on remplace par de l'eau
                    grilleChar[posX][posY] = Data.WATER;      
                else if(caseGrille == Data.ICE_S)//si banquise epaisse on remplace par une banquise normal
                    grilleChar[posX][posY] = Data.ICE_N;
                               }
        else 
            Statut_L--;
        
        
      
        caseGrille = grilleChar[newPosX][newPosY]; //on recupère le symbole ou est placé le personnage
        
       
        //on place la nouvelle position du personnage dans le tableau 
        grilleChar[newPosX][newPosY] = caractere;
        
        //la nouvelle position devient la position actif du personnage
        posX = newPosX;
        posY = newPosY;

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
