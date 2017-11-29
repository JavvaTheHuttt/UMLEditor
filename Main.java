/*
 * Source Code for Third Iteration
 * Team: Java the Hutt
 * Members: Seth Miller, Dan Sipe, Harry Hawkes and Breanna Caggiano
 * Due: December 8th, 2017
 * Class: Software Engineering: CSCI 420
 * Professor: Dr. David Hutchens
 *  
 */

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;

import javafx.stage.FileChooser;



public class Main extends Application{
	Circle q;
	static Stage window;
	BorderPane layout;
	double frameX = 800;
	double frameY = 400;
	double orgSceneX, orgSceneY;
	Node temp;
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)  throws Exception
	{
		try {
			window = primaryStage;
			window.setTitle("UML Editor by Java the Hutt");
			
			//fileChooser for opening, saving, renaming etc the file
			final FileChooser fileChooser = new FileChooser();
			
			//textArea used for saving
		    TextArea textArea = new TextArea();
		    
			/**************************************************************************
			 * 
			 * 		Top Menu
			 * 
			 **************************************************************************/
		    
		    TopMenu topMenu = new TopMenu();
		    MenuBar menuBar = topMenu.display(window, fileChooser, textArea);
			
		    
			/*********************************************************************************
			 * 
			 * 		Pane
			 * 
			 *********************************************************************************/
		    
		   
		    Pane pane = new Pane();
		    
		    
		    
			/*********************************************************************************
			 *
			 * 		Left Menu
			 * 
			 *********************************************************************************/
			
		    
			VBox leftMenu = new VBox(10);
			CreateETriangle t = new CreateETriangle();
			Button empty_triangle = t.display(pane, frameX, frameY);
			
			CreateFTriangle f = new CreateFTriangle();
			Button filled_triangle = f.display(pane, frameX, frameY);
			
			CreateFDiamond fd = new CreateFDiamond();
			Button diamond = fd.display(pane, frameX, frameY);
			
			CreateEDiamond ed = new CreateEDiamond();
			Button empty_diamond = ed.display(pane, frameX, frameY);
			
			createCircle c = new createCircle();
			Button circle = c.display(pane, frameX, frameY);
					
			CreateLine l = new CreateLine();
			Button line = l.display(pane, frameX, frameY);
			
			CreateDashedLine dl = new CreateDashedLine();
			Button dashed_line = dl.display(pane, frameX, frameY);
	
			createBox b = new createBox();
			Button box = b.display(pane);
			
			
			leftMenu.getChildren().addAll(empty_triangle, filled_triangle, diamond, empty_diamond, circle, line, dashed_line, box);
			leftMenu.setId("left_menu");
			
			
			
			
			/*********************************************************************************
			 * 
			 * 		Project Layout
			 * 
			 *********************************************************************************/
			
			
			layout = new BorderPane();
			layout.setTop(menuBar);
			layout.setLeft(leftMenu);
			layout.setCenter(pane);
			
			
			//StackPane layout = new StackPane();
			Scene scene = new Scene(layout,1750,1000);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.getIcons().add(new Image("javathehut.jpg"));
			window.setScene(scene);
			window.show();

		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
		