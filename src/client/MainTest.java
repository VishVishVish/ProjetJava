/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import modele.*;
import java.util.Scanner;

   import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author vishn
 */

 

public class MainTest extends JFrame implements Data{
 
 public static void  main(String[] args) throws Exception{
     
     
     Save save = new Save();
     
     save.lire();
     
     System.out.println(save.getNumNiveau() + " " + save.getScore() + " " + save.getTemps());
     
     save.ecrire(2, 12, 789);
     
     save.lire();
     
     System.out.println(save.getNumNiveau() + " " + save.getScore() + " " + save.getTemps());
     
     //Scores scores = new Scores();
     //scores.addScore("ALED", 456, 12);
     //String [] score = scores.max();
     //System.out.println(score[0]+" " + score[1]+" "+score[2]);
     
     
     
     
     
     /*
    ArrayList<String> array = new ArrayList<>(); //contient pseudo, score, temp des joueurs ayant fini une partie
    
    File file = new File("save.txt");
    FileInputStream fis;             
    FileOutputStream fos;    
    
    try
    {
      // Le fichier d'entrée
      //fis = new FileInputStream("save.txt");   
      Scanner scanner = new Scanner(file);  
      
      //renvoie true s'il y a une autre ligne à lire
      while(scanner.hasNextLine())
      {
        //System.out.println(scanner.nextLine());
        String str = scanner.nextLine();
        //System.out.println(str);
        array.add(str);
      }
      scanner.close();    
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
    String str2 = array.get(0);
    
    String pseudo = "";
    String score = "";
    
    for(int i = 0; i<4; i++ ) {
        pseudo += Character.toString(str2.charAt(i));
    }
    for(int j = 4; j<8; j++ ) {
        score += Character.toString(str2.charAt(j));
    }
    
    System.out.println(pseudo);
    System.out.println(Integer.parseInt(score) );
         
         */
         
         
         //ListeFontes list = new ListeFontes();
         
         //monstre.grilleChar = grille.getGrilleChar();
         
         
         
         /*
         monstre.setPosition(grille);
         grille.affichageGrille();
         for(int i = 0; i<10; i++) {
         Scanner scanner = new Scanner(System.in);
         int nombre = scanner.nextInt();
         grille.setCase(monstre);
         grille.affichageGrille();
         }*/
         
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
