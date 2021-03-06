/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
/**
 * regroupe la conception des niveaux, les couleurs, la police, la positions des monstres, des personnages dans chaque niveaux
 * @author Vishnou Peroumalnaikar, Alexis Libeaud
 */


public interface Data {
    
    
    /*CARACTERE CHAR DES CASES DE LA GRILLE*/
    /**correspond au personnage**/
    public char PERSO = '&';
    /**correspond à un mur statique**/
    public char BLOCK = 'B';
    /**correspond à de l'eau**/
    public char WATER = 'x';
    /**correspond à de l'eau utilisé pour le décor**/
    public char XATER = 'y';
    /**banquise normal, N pour normal**/
    public char ICE_N = '.';
    /**banquise epais, S pour strong **/
    public char ICE_S = 'o';
    /**correspond à la case de sortie pour le personnage **/
    public char EXIT  = 'S';
    /**correspond au monstre**/
    public char MNSTR = 'M';
    /**correspond à la potion de legerete**/
    public char POT_L = 'L';
    /**correspond à la brique**/
    public char TUNNE = 'T';
    /**correspond à la brique**/
    public char BRICK = 'b';
    /**correspond à la tondeuse**/
    public char TONDE = 'd'; 
    
    /*SPRITE DU JEU, IMAGES CONTENUE DANS LE DOSSIER IMG DU PROJET*/
    //public ImageIcon TEST = new ImageIcon("img/test.png");
    //public ImageIcon IMG_PERSO = new ImageIcon("img/perso.png");

    /*
    public ImageIcon IMG_MONSTRE = new ImageIcon("img/monstre_test.png");
    public ImageIcon IMG_BLOCK = new ImageIcon("img/block.png");
    public ImageIcon IMG_WATER = new ImageIcon("img/water.png");
    public ImageIcon IMG_ICE_N = new ImageIcon("img/ice_n.png");
    public ImageIcon IMG_ICE_S = new ImageIcon("img/ice_s.png");
    public ImageIcon IMG_EXIT = new ImageIcon();
    public ImageIcon IMG_POT_L = new ImageIcon();*/
    
    /*COULEURS UTILISE POUR L'IHM*/
    
    public Color COLOR_SNOW = new Color(174,255,255);
    public Color COLOR_ICE = new Color(5,100,255);
    public Color COLOR_BLUE = new Color(0,68,181);
    public Color COLOR_BACK = new Color(58,220,254);
    
    /**POLICE**/
    String fontPolice = "Agency FB";
    
    boolean boolRefresh = false;
   
    /*NIVEAUX DU JEU RESPECTANT LE CAHIER DES CHARGES*/
    public char LEVEL_5 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {WATER,WATER,WATER,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,WATER,WATER,XATER,WATER,WATER,WATER},//1
                               {WATER,WATER,WATER,WATER,XATER,WATER,BLOCK,ICE_N,ICE_N,MNSTR,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,WATER,WATER,WATER},//2                             
                               {XATER,WATER,WATER,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,XATER,WATER,WATER},//3  
                               {WATER,WATER,WATER,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,XATER,WATER,WATER,WATER,WATER,WATER},//4  
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//5  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//6  
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,WATER,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK},//7  
                               {BLOCK,MNSTR,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//8  
                               {BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//9  
                               {BLOCK,ICE_N,BLOCK,WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK},//10  
                               {BLOCK,ICE_N,BLOCK,XATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,EXIT ,ICE_N,BLOCK},//11  
                               {BLOCK,ICE_N,BLOCK,WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK},//12  
                               {BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK},//13  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//14                                 
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}};//15
   
   
   public char LEVEL_4 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK},//1
                               {BLOCK,EXIT ,BLOCK,TUNNE,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,TUNNE,BLOCK},//2                             
                               {BLOCK,ICE_N,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK},//3  
                               {BLOCK,ICE_N,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK},//4  
                               {BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK},//5  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK},//6  
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK},//7  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//8  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//9  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//10  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK},//11  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//12  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//13  
                               {BLOCK,ICE_N,TUNNE,BLOCK,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,TUNNE,BLOCK},//14                                 
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}};//15
   
   
   public char LEVEL_3 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,WATER,WATER},//1
                               {WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,EXIT ,BLOCK,BLOCK,BLOCK},//2                             
                               {WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,WATER,BLOCK,ICE_N,ICE_N,ICE_S,ICE_N,ICE_N,BLOCK},//3  
                               {WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,BLOCK,ICE_N,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK},//4  
                               {WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,BLOCK,ICE_N,ICE_N,ICE_S,BLOCK,WATER,WATER},//5  
                               {WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,BLOCK,BLOCK,BLOCK,ICE_S,BLOCK,WATER,WATER},//6  
                               {WATER,WATER,WATER,BLOCK,POT_L,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_S,BLOCK,WATER,WATER},//7  
                               {WATER,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_S,BLOCK,WATER,WATER},//8  
                               {WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,ICE_N,BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_S,BLOCK,WATER,WATER},//9  
                               {WATER,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_S,BLOCK,WATER,WATER},//10  
                               {WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_S,BLOCK,WATER,WATER},//11  
                               {WATER,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,BRICK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_S,BLOCK,WATER,WATER},//12  
                               {WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,TONDE,BLOCK,WATER,WATER},//13  
                               {WATER,WATER,WATER,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,WATER,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,BLOCK,WATER,WATER},//14                                 
                               {WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,BLOCK,WATER,WATER}};//15
      public char LEVEL_2 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//1
                               {BLOCK,EXIT ,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK},//2                             
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,ICE_N,BLOCK},//3  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,ICE_N,ICE_S,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_S,ICE_N,ICE_N,BLOCK},//4  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK},//5  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_S,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK,WATER,BLOCK},//6  
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK,WATER,BLOCK},//7  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK,WATER,BLOCK},//8  
                               {BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK,WATER,BLOCK},//9  
                               {BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK,WATER,BLOCK},//10  
                               {BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK},//11  
                               {BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_S,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_S,ICE_N,ICE_N,BLOCK},//12  
                               {BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,BLOCK,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,BLOCK,ICE_N,BLOCK},//13  
                               {BLOCK,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,BLOCK},//14                                 
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}};//15
   
   
   public char LEVEL_1 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER},//1
                               {WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER},//2                             
                               {WATER,XATER,WATER,WATER,WATER,WATER,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,WATER,WATER},//3  
                               {WATER,WATER,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER},//4  
                               {WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,EXIT ,ICE_N,BLOCK,WATER,WATER},//5  
                               {WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER},//6  
                               {WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER},//7  
                               {WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER},//8  
                               {WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER},//9  
                               {WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER},//10  
                               {WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,BLOCK,WATER,WATER},//11  
                               {WATER,WATER,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,WATER,WATER,WATER,WATER},//12  
                               {WATER,WATER,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,WATER,WATER,XATER,WATER},//13  
                               {WATER,WATER,XATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER},//14                                 
                               {WATER,WATER,WATER,WATER,XATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER,WATER}};//15
        
    
   public char LEVEL_0 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//1
                               {BLOCK,ICE_N,BRICK,ICE_N,EXIT ,ICE_N,ICE_N,WATER,ICE_N,WATER,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//2                             
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//3  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//4  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//5  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//6  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//7  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//8  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//9  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//10  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//11  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//12  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//13  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//14                                 
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}};//15
    
    /**regroupe les différents niveaux**/
    char LEVELS [][][] = {LEVEL_0,LEVEL_1,LEVEL_2,LEVEL_3,LEVEL_4,LEVEL_5 };
    
 
    /**regroupe les positions du personage dans la grille de chaque niveau**/
    int POS_PERSO [][] = {{14,4},{11,3},{13,1},{9,9},{13,1},{5,1}};
    
    /**regtoupe les positions des monstres du niveau 5**/
    int POS_MONSTRE [][] = {{1,9},{7,1}};
    
    public static Font fontBouton = new Font("Serif", Font.BOLD, 20); //correspond à la font des boutons du menu principal
}
