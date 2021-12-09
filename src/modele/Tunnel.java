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
public class Tunnel extends Case implements Data{
    
    private int newPosX;
    private int newPosY;
    
    public Tunnel(int posX, int posY, int newPosX, int newPosY, char caractere) {
        super(posX, posY, caractere);
        this.newPosX = newPosX;
        this.newPosY = newPosY;
    }
    
     public int getNewX(){
        return this.newPosX;
    }
    
    public int getNewY(){
        return this.newPosY;
    }
    
    public void setNewX(int x){
        this.newPosX = x;
    }
    
    public void setNewY(int y){
        this.newPosY = y;
    }
    
    
    
}
