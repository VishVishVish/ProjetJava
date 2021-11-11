/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import modele.Grille;
import modele.Data;
import controleur.*;
import java.awt.*;
import javax.swing.*;


/**
 *
 * @author vishn
 */
public class PanelGrille extends JPanel implements Data {

    GridLayout gridLayout;
    Grille grille;
    
    public PanelGrille(Grille grille){
       this.grille = grille; 
       gridLayout = new GridLayout(grille.getNbrLigne(),grille.getNbrColonne());
       
       
       //gridLayout.setHgap(1);
       //gridLayout.setVgap(1);
       
       this.setLayout(gridLayout); 
       
       
       for(int li = 0; li<grille.getNbrLigne();li++){
            for(int co = 0; co<grille.getNbrColonne();co++){
                JLabel labelCaseGrille = convertToJLabel(grille.getGrille()[li][co]);
                //labelCaseGrille.setSize(50,50);
                
              
                this.add(labelCaseGrille);
                //this.add(this.convertToJLabel(grille.getGrille()[li][co]));
            }
        }  
    }
    
   
    
    public JLabel convertToJLabel(char caractere){
        JLabel label = new JLabel(); 
        switch(caractere){
            case Data.ICE_N :
                label.setBackground(Color.WHITE);
                break;
            case Data.WATER :
                label.setBackground(Color.BLUE);
                break;    
            case Data.BLOCK :
                label.setBackground(Color.BLACK);
                break;    
            case Data.PERSO :
                //label.setBackground(Color.RED);
                label.setIcon(Data.IMG_PERSO);
                break;
            case Data.ICE_S :
                label.setBackground(Color.GRAY);
                break;
            case Data.EXIT :
                label.setBackground(Color.GREEN);
                break;    
            default:
                label.setBackground(Color.YELLOW);
                break;
        }
        label.setOpaque(true);
        return label;
    }
    
    public void setGrille(Grille grille){
        this.grille = grille;
        
        this.removeAll();
        for(int li = 0; li<grille.getNbrLigne();li++){
            for(int co = 0; co<grille.getNbrColonne();co++){
                 this.add(this.convertToJLabel(grille.getGrille()[li][co]));
            }
        }   
    }
    
    public Grille getGrille(){
        return grille;
    }
 

   
    
     
}
