/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import modele.*;

   import java.awt.Dimension;
import javax.swing.JFrame;
/**
 *
 * @author vishn
 */

 

public class MainTest extends JFrame{
 
 public static void  main(String[] args) {
  //Créer JFrame
  JFrame jframe = new JFrame("redimensionnement JFrame");
  jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //Modifier la dimension de JFrame
  jframe.setPreferredSize(new Dimension(300, 200));
  //Centrer JFrame
  jframe.setLocationRelativeTo(null);
  jframe.setVisible(true);
 }

}
