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
                JLabel labelCaseGrille = convertToImage(grille.getGrilleChar()[li][co]);
                this.add(labelCaseGrille);
                
            }
        }  
    }
    
   
    
    public JLabel convertToImage(char caractere){
        JLabel label = new JLabel(); 
        
        switch(caractere){
            case Data.ICE_N :
                label.setIcon(new ImageIcon(getClass().getResource("/img/ice_n.png")));
                break;
            case Data.WATER :
                label.setIcon(new ImageIcon(getClass().getResource("/img/water.png")));
                break;    
            case Data.XATER :
                label.setIcon(new ImageIcon(getClass().getResource("/img/water2.png")));
                break;    
            case Data.BLOCK :
                label.setIcon(new ImageIcon(getClass().getResource("/img/block.png")));
                break;    
            case Data.PERSO :
                label.setIcon(new ImageIcon(getClass().getResource("/img/perso.png")));
                break;
            case Data.ICE_S :
                label.setIcon(new ImageIcon(getClass().getResource("/img/ice_s.png")));
                break;
            case Data.EXIT :
                label.setIcon(new ImageIcon(getClass().getResource("/img/exit.png")));
                break;    
            case Data.MNSTR :
                label.setIcon(new ImageIcon(getClass().getResource("/img/monstre.png")));
                break;    
            case Data.TUNNE :
                label.setIcon(new ImageIcon(getClass().getResource("/img/tunnel.png")));
                break;    
            case Data.TONDE :
                label.setIcon(new ImageIcon(getClass().getResource("/img/tondeuse.png")));
                break;    
            case Data.BRICK :
                label.setIcon(new ImageIcon(getClass().getResource("/img/brique.png")));
                break;    
            case Data.POT_L :
                label.setIcon(new ImageIcon(getClass().getResource("/img/potion.png")));
                break;    
            default:
                label.setIcon(new ImageIcon(getClass().getResource("/img/default.png")));
                break;
        }
        label.setOpaque(true);
        
        //label.setSize(new Dimension(100,100));
        return label;
    }
    /*
    public JLabel convertToJLabel(char caractere){
        JLabel label = new JLabel(); 
        switch(caractere){
            case Data.ICE_N :
                //label.setBackground(Color.WHITE);
                label.setIcon(Data.IMG_ICE_N);
                break;
            case Data.WATER :
                label.setIcon(Data.IMG_WATER);
                //label.setBackground(Color.BLUE);
                break;    
            case Data.BLOCK :
                //label.setBackground(Color.BLACK);
                label.setIcon(Data.IMG_BLOCK);
                break;    
            case Data.PERSO :
                //label.setBackground(Color.RED);
                //label.setIcon(Data.IMG_PERSO);
                label.setIcon(new ImageIcon(getClass().getResource("/img/perso.png")));
                break;
            case Data.ICE_S :
                //label.setBackground(Color.GRAY);
                label.setIcon(Data.IMG_ICE_S);
                break;
            case Data.EXIT :
                label.setBackground(Color.GREEN);
                break;    
            case Data.MNSTR :
                label.setIcon(Data.IMG_MONSTRE);
                //label.setBackground(Color.PINK);
                break;    
            default:
                label.setBackground(Color.YELLOW);
                break;
        }
        label.setOpaque(true);
        
        //label.setSize(new Dimension(100,100));
        return label;
    }*/
    
    public void setGrille(Grille grille){
        this.grille = grille;
        
        //this.removeAll();
        for(int li = 0; li<grille.getNbrLigne();li++){
            for(int co = 0; co<grille.getNbrColonne();co++){
                 this.add(this.convertToImage(grille.getGrilleChar()[li][co]));
                 //this.revalidate();
            }
            
        }   
    }
    
    public Grille getGrille(){
        return grille;
    }
 

   
    
     
}
