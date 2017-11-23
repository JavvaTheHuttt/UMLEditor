package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

import javafx.stage.FileChooser;
import application.objectMaker;



public class Main extends Application{
	Circle q;
	static Stage window;
	BorderPane layout;
	double frameX = 800;
	double frameY = 400;
	double orgSceneX, orgSceneY;
	Node temp;
	//private Desktop desktop = Desktop.getDesktop();
	
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
			 * 		Left Menu
			 * 
			 *********************************************************************************/
			
		    //LeftMenu l = new LeftMenu();
		    //VBox leftMenu = l.display();
		    
			VBox leftMenu = new VBox(10);
			Button empty_triangle = new Button("Association");
			Button filled_triangle = new Button("Composite");
			Button line = new Button("Line");
			Button dashed_line = new Button("Dashed Line");
			Button box = new Button("Class Box");
			
			leftMenu.getChildren().addAll(empty_triangle, filled_triangle, line, dashed_line, box);
			leftMenu.setId("left_menu");
			
			
			
			
			/*********************************************************************************
			 * 
			 * 		Pane
			 * 
			 *********************************************************************************/
			
			Pane pane = new Pane();
			
			
			
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
	
			
			//Button listener to create a new class box
			box.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	   	classBox cb = new classBox();
						VBox group = (VBox) cb.createBox();
						pane.getChildren().addAll(group);
			       }		 
			});
			
			//Button listener to create a new association arrow
			empty_triangle.setOnAction(new EventHandler<ActionEvent>()
			{
				 @Override
			       public void handle(ActionEvent e) 
			       {
			    	  objectMaker<Polygon> q = new objectMaker<Polygon>();
			    	  q.setAttributes("arrow", 50, 50, 15, Color.TRANSPARENT);
				  	  Polygon t = (Polygon) q.createObject("arrow");
				  	  t.setStrokeWidth(2);
				  	  t.setStroke(Color.BLACK);
			    	  t.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(t);
			       }	 
			});
			
			//Button listener to create a new composition arrow
			filled_triangle.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  objectMaker<Polygon> q = new objectMaker<Polygon>();
			    	  q.setAttributes("arrow", 50, 50, 15, Color.BLACK);
				  	  Polygon t = (Polygon) q.createObject("arrow");
			    	  t.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(t);
			       }		 
			});
			
			//Button listener to create a new line
			line.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  Line l = createLine();
			    	  l.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(l);
			       }	
			       
			});
			
			//Button listener to create a new dashed line
			dashed_line.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  Line l = createDashedLine();
			    	  l.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(l);
			       }	
			       
			});
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
		/**
		 * 
		 * @returns a newly created Line, its location 
		 *			and listens for a mouse click and drag
		 * 			to move its location.
		 */
		public Line createLine() 
		{
		    Line line = new Line(0, 0, 200, 300);
		
		    line.setCursor(Cursor.HAND);
		
		    line.setOnMousePressed((t) -> 
		    {
		      orgSceneX = t.getSceneX();
		      orgSceneY = t.getSceneY();
		
		      Line l = (Line) (t.getSource());
		      l.toFront();
		    });
		    line.setOnMouseDragged((t) -> 
		    {
		        double offsetX = t.getSceneX() - orgSceneX;
		        double offsetY = t.getSceneY() - orgSceneY;
		
		        Line l = (Line) (t.getSource());
		
		        l.setLayoutX(l.getLayoutX() + offsetX);
		        l.setLayoutY(l.getLayoutY() + offsetY);
		
		        orgSceneX = t.getSceneX();
		        orgSceneY = t.getSceneY();
		      });
		      	return line;
		    }
		    
		/**
		 * 
		 * @returns a newly created Dashed Line, its location 
		 *			and listens for a mouse click and drag
		 * 			to move its location.
		 */
		public Line createDashedLine() 
		{
			Line dash_line = new Line(20, 80, 270, 80);
			dash_line.getStrokeDashArray().addAll(25d,10d);
		
			dash_line.setCursor(Cursor.HAND);
		
			dash_line.setOnMousePressed((t) -> 
		    {
		      orgSceneX = t.getSceneX();
		      orgSceneY = t.getSceneY();
		
		      Line l = (Line) (t.getSource());
		      l.toFront();
		    });
			dash_line.setOnMouseDragged((t) -> 
		    {
		        double offsetX = t.getSceneX() - orgSceneX;
		        double offsetY = t.getSceneY() - orgSceneY;
		
		        Line l = (Line) (t.getSource());
		
		        l.setLayoutX(l.getLayoutX() + offsetX);
		        l.setLayoutY(l.getLayoutY() + offsetY);
		
		        orgSceneX = t.getSceneX();
		        orgSceneY = t.getSceneY();
		      });
		      	return dash_line;
		    }
		
}

