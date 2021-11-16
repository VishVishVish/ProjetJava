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
 *
 * @author vishn
 */



public interface Data {
    
    
    /*CARACTERE CHAR DES CASES DE LA GRILLE*/
    public char PERSO = '&';
    public char BLOCK = 'B';
    public char WATER = 'x';
    public char ICE_N = '.'; // banquise normal, N pour normal
    public char ICE_S = 'o'; // banquise epais, S pour strong 
    public char EXIT = 'S';
    
    public ImageIcon TEST = new ImageIcon("img/test.png");
    public ImageIcon IMG_PERSO = new ImageIcon("img/perso.png");
    public ImageIcon IMG_BLOCK = new ImageIcon("img/block.png");
    public ImageIcon IMG_WATER = new ImageIcon("img/water.png");
    public ImageIcon IMG_ICE_N = new ImageIcon("img/ice_n.png");
    public ImageIcon IMG_ICE_S = new ImageIcon("img/ice_s.png");
    public ImageIcon IMG_EXIT = new ImageIcon();
    
    public Color COLOR_SNOW = new Color(174,255,255);
    public Color COLOR_ICE = new Color(5,100,255);
    public Color COLOR_BLUE = new Color(0,68,181);
    public Color COLOR_BACK = new Color(58,220,254);
    
    String fontPolice = "Agency FB";
    
                     
   public char LEVEL_5 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//1
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//2                             
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//3  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//4  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//5  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//6  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//7  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//8  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//9  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//10  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//11  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,EXIT ,ICE_N,ICE_N,BLOCK},//12  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//13  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//14                                 
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}};//15
   
   
   public char LEVEL_4 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//1
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//2                             
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//3  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//4  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//5  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//6  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//7  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//8  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//9  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//10  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//11  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,EXIT ,ICE_N,ICE_N,BLOCK},//12  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//13  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//14                                 
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}};//15
   
   
   public char LEVEL_3 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//1
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//2                             
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//3  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//4  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//5  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//6  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//7  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//8  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//9  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//10  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//11  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,EXIT ,ICE_N,ICE_N,BLOCK},//12  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//13  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//14                                 
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}};//15
   
   
   public char LEVEL_2 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//1
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//2                             
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//3  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//4  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//5  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//6  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//7  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//8  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,BLOCK,BLOCK,ICE_S,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//9  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//10  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//11  
                               {BLOCK,ICE_N,ICE_N,ICE_N,EXIT ,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//12  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//13  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//14                                 
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}};//15
   
   
   public char LEVEL_1 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//1
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//2                             
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//3  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_S,ICE_N,ICE_N,BLOCK},//4  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//5  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//6  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_S,ICE_S,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//7  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//8  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//9  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//10  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//11  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,EXIT ,ICE_N,ICE_N,BLOCK},//12  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//13  
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//14                                 
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}};//15
        
    
   public char LEVEL_0 [][] = { //0     1     2     3     4     5     6     7     8     9    10    11    12    13    14    15    16    17    18
                               {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},//1
                               {BLOCK,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,ICE_N,BLOCK},//2                             
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
    
   
    char LEVELS [][][] = {LEVEL_0,LEVEL_1,LEVEL_2,LEVEL_3,LEVEL_4,LEVEL_5 };
    
 
    /*position du perso dans la grille de chaque niveau*/
    int POS_PERSO [][] = {{1,1},{1,1},{1,2},{1,3},{1,1},{1,1}};
    
    public static Font fontBouton = new Font("Serif", Font.BOLD, 20); //correspond à la font des boutons du menu principal
}
