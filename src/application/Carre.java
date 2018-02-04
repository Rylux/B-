/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import modele.Content;

/**
 *
 * @author Leroy
 */

//Correspond � un carr� dans le quadrillage 10*10
//Sert � l'affichage et gestion des clics

public class Carre extends Parent{
    private Boolean playerSide; //1=appartient au plateau avec les bateaux du joueur, 0=appartient au plateau avec les tirs vers l'adversaire
    int ligne;
    int colonne;
    
    public Carre(Boolean player, Content contenu, int colonne, int ligne){
    	this.playerSide=player;
    	this.ligne=ligne;
    	this.colonne=colonne;
    	
        Rectangle fondCarre = new Rectangle(0,0,50,50);
        getChildren().add(fondCarre);     
        majCarre(contenu);
    }
    
    public void majCarre(Content contenu)
    {
    	Rectangle fondCarre = new Rectangle(0,0,50,50);
		fondCarre.setFill(Color.LIGHTBLUE);
		fondCarre.setStroke(Color.BLACK);
		
		this.getChildren().removeAll();
      
		switch(contenu) {
 		case boat:
 			fondCarre.setFill(Color.WHITE);
 			this.getChildren().add(fondCarre); 
 			break;
 		case boat_hit:
 			fondCarre.setFill(Color.GREY);
 			this.getChildren().add(fondCarre); 
 			break;
 		case boat_range:
 			fondCarre.setStroke(Color.RED);
 			this.setOnMouseEntered(new EventHandler<MouseEvent>(){
 	            public void handle(MouseEvent me){
 	                fondCarre.setFill(Color.GREY);
 	                fondCarre.setStroke(Color.RED);
 	            }
 	        });

 	        this.setOnMouseExited(new EventHandler<MouseEvent>(){
 	            public void handle(MouseEvent me){
 	                fondCarre.setFill(Color.LIGHTBLUE);
 	                fondCarre.setStroke(Color.RED);
 	            }
 	        }); 
 	        this.getChildren().add(fondCarre); 
 			break;
 		case hit:
 			Line line1 = new Line(5, 5, 45, 45);
 		    line1.setStroke(Color.BLACK);
	    	Line line2 = new Line(45, 5, 5, 45);
		    line2.setStroke(Color.BLACK);
 		    this.getChildren().add(fondCarre); 
 		    this.getChildren().add(line1);
 		    this.getChildren().add(line2);
 			break;
 		case miss:
 			Circle circle1 = new Circle(25, 25, 20);
 			this.getChildren().add(fondCarre); 
 			this.getChildren().add(circle1); 
 			break;
 		case sea:
 			fondCarre.setFill(Color.LIGHTBLUE);
 			this.setOnMouseEntered(new EventHandler<MouseEvent>(){
 	            public void handle(MouseEvent me){
 	                fondCarre.setFill(Color.GREY);
 	                fondCarre.setStroke(Color.BLACK);
 	            }
 	        });

 	        this.setOnMouseExited(new EventHandler<MouseEvent>(){
 	            public void handle(MouseEvent me){
 	                fondCarre.setFill(Color.LIGHTBLUE);
 	                fondCarre.setStroke(Color.BLACK);
 	            }
 	        }); 
 	        this.getChildren().add(fondCarre); 
 			break;
 		default:
 			break;
        }
		
		//this.getChildren().add(fondCarre); 
    }
    
    public int getColonne() {
		return colonne;
	}
    
	public int getLigne() {
		return ligne;
	}
    
    public Boolean getPlayerSide() {
    	return playerSide;
    }    
}   
    

