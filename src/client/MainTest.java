/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import modele.*;

   import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.JFrame;
/**
 *
 * @author vishn
 */

 

public class MainTest extends JFrame implements Data{
 
 public static void  main(String[] args) {
     
   //ListeFontes list = new ListeFontes(); 
   
   
   int tab1[] = {1,2,3};
   int tab2[];
   
   tab2 = tab1;
   
   tab2[0] = 99;
   
   for(int i = 0;i<3;i++)
       System.out.println(tab1[i]);
   
  //Créer JFrame
  //JFrame jframe = new JFrame("redimensionnement JFrame");
  //jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //Modifier la dimension de JFrame
  //jframe.setPreferredSize(new Dimension(300, 200));
  //Centrer JFrame
  //jframe.setLocationRelativeTo(null);
  //jframe.setVisible(true);
   //int intArray[][] = {{12,15, 17},{1,2}}; // define an array copyArray to copy contents of intArray 
   //int copyArray[] = new int[intArray.length]; // copy contents of intArray to copyArray for (int i=0; i
   
  /*
  Grille grille = new Grille(1);
  grille.affichageGrille();
  Personnage perso = new Personnage(1,1,Data.PERSO);
  grille.setGrilleChar(perso.setPosition(grille));
  grille.affichageGrille();
  perso.deplacementDroite();
  grille.setGrilleChar(perso.newPosition(grille));
  perso.deplacementDroite();
  grille.setGrilleChar(perso.newPosition(grille));
  perso.deplacementDroite();
  grille.setGrilleChar(perso.newPosition(grille));
  grille.affichageGrille();
  
  grille = new Grille(1);
  grille.affichageGrille();
  */
  /*
  perso = new Personnage(1,1,Data.PERSO);
  grille.setGrilleChar(perso.setPosition(grille));
  grille.affichageGrille();*/
  
  
  /*
    char tab1 [] [] = Data.LEVEL_1;
    char tab2 [] [] = new char[15][19] ;  
    Grille grille = new Grille(1);
    grille.affichageGrille();
    char [][] test = grille.getGrilleChar();
    test[1][1] = 'T'; 
    grille.setGrilleChar(test);
    grille.affichageGrille();
    
    grille = new Grille(1);
    grille.affichageGrille();*/
    //System.arraycopy(tab1,  0, tab2,  0,  2) ;
    //System.arraycopy(tab1, 0, tab2, 0, tab2.length-1);
    
    //tab2 = tab1;
    //tab2[0][0] = 'G';
    /*
    for (int i = 0; i < tab1.length; i++) {
        tab2[i] = Arrays.copyOf(tab1[i], tab1[i].length);
    }
    tab2[0][0] = 'h';
    tab1[0][1] = 'P';
    
    System.out.println("\ntab2");
    for(int i = 0; i<tab2.length; i++){
        for(int j = 0; j<tab2[i].length; j++){
        System.out.println(tab2[i][j]);
        }
    }
    System.out.println("\ntab1 " + tab1.length + " "+ tab1[0].length);
    for( int i2 = 0; i2<tab1.length; i2++){
        for(int j2 = 0; j2<tab1[i2].length; j2++){
            System.out.println(tab1[i2][j2]);
        }
        
    }*/
    


 }

}
