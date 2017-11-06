package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;



public class Main extends Application{
	Circle q;
	Stage window;
	BorderPane layout;
	double frameX = 800;
	double frameY = 400;
	double orgSceneX, orgSceneY;
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)  throws Exception
	{
		try {
			window = primaryStage;
			window.setTitle("UML Editor by Java the Hut");
			
			
			/**************************************************************************
			 * 
			 * 		Top Menu
			 * 
			 **************************************************************************/
			
			//menu list
			Menu fileMenu = new Menu("_File");
			Menu editMenu = new Menu("_Edit");
			Menu searchMenu = new Menu("_Search");
			Menu projectMenu = new Menu("_Project");
			Menu helpMenu = new Menu("_Help");
			
			
			//file menu items
			fileMenu.getItems().add(new MenuItem("New Project"));
			fileMenu.getItems().add(new MenuItem("Open File"));
			fileMenu.getItems().add(new MenuItem("Rename"));
			fileMenu.getItems().add(new SeparatorMenuItem());
			fileMenu.getItems().add(new MenuItem("Save"));
			fileMenu.getItems().add(new SeparatorMenuItem());
			MenuItem close = new MenuItem("Close");
			fileMenu.getItems().add(close);
			close.setOnAction(e -> System.exit(0));
			
			//edit menu items
			editMenu.getItems().add(new MenuItem("Undo"));
			editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(new MenuItem("Cut"));
			editMenu.getItems().add(new MenuItem("Copy"));
			editMenu.getItems().add(new MenuItem("Paste"));
			editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(new MenuItem("Delete"));
			editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(new MenuItem("Find/Replace"));
			
			//search menu items 
			searchMenu.getItems().add(new MenuItem("Search..."));
			searchMenu.getItems().add(new MenuItem("File..."));
			searchMenu.getItems().add(new SeparatorMenuItem());
			searchMenu.getItems().add(new MenuItem("References"));
			searchMenu.getItems().add(new MenuItem("Implementations"));
			
			//project menu items
			projectMenu.getItems().add(new MenuItem("Open Project"));
			projectMenu.getItems().add(new MenuItem("Close Project"));
			projectMenu.getItems().add(new SeparatorMenuItem());
			
			MenuItem buildProject = new MenuItem("Build Project");
			buildProject.setDisable(true);
			projectMenu.getItems().add(buildProject);
			
			projectMenu.getItems().add(new SeparatorMenuItem());
			projectMenu.getItems().add(new MenuItem("Properties"));
			
			//help menu items
			helpMenu.getItems().add(new MenuItem("Welcome"));
			helpMenu.getItems().add(new SeparatorMenuItem());
			helpMenu.getItems().add(new MenuItem("Help Contents"));
			helpMenu.getItems().add(new SeparatorMenuItem());
			helpMenu.getItems().add(new MenuItem("Tips and Tricks"));
			helpMenu.getItems().add(new SeparatorMenuItem());
			helpMenu.getItems().add(new MenuItem("Check for Updates"));
			helpMenu.getItems().add(new SeparatorMenuItem());
			helpMenu.getItems().add(new MenuItem("About"));
			
			
			//adds menus and drop down files to the top of the page
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(fileMenu, editMenu, searchMenu, projectMenu, helpMenu);
			
			
			
			/*********************************************************************************
			 *
			 * 		Left Menu
			 * 
			 *********************************************************************************/
			
			VBox leftMenu = new VBox();
			Button square = new Button("Square");
			Button rectangle = new Button("Rectangle");
			Button circle = new Button("Circle");
			Button triangle = new Button("Triangle");
			Button line = new Button("Line");
			
			leftMenu.getChildren().addAll(square, rectangle, circle, triangle, line);
			
			
			
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
			
		    
			
			circle.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  Circle q = createCircle(frameX, frameY, 50.0, Color.BLUE);
			    	  pane.getChildren().addAll(q);
			       }		 
			});
			
			rectangle.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  Rectangle r = createRectangle(200, 100, Color.RED);
			    	  r.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(r);
			       }		 
			});
			
			square.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  Rectangle s = createRectangle(100, 100, Color.GREEN);
			    	  s.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(s);
			       }		 
			});
			
			triangle.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  Polygon t = createTriangle(150, 150, 150, Color.ORANGE);
			    	  t.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(t);
			       }		 
			});
			
			line.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  Line l = createLine(150, 150, Color.BLACK);
			    	  l.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(l);
			       }		 
			});
			
			textBox.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  TextField tb = createText(150, 150, Color.BLACK);
			    	  tb.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(tb);
			       }		 
			});
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
		
		public Circle createCircle(double x, double y, double r, Color color) {
		    Circle circle = new Circle(x, y, r, color);
		
		    circle.setCursor(Cursor.HAND);
		
		    circle.setOnMousePressed((t) -> 
		    {
		      orgSceneX = t.getSceneX();
		      orgSceneY = t.getSceneY();
		
		      Circle c = (Circle) (t.getSource());
		      c.toFront();
		    });
		    circle.setOnMouseDragged((t) -> 
		    {
		        double offsetX = t.getSceneX() - orgSceneX;
		        double offsetY = t.getSceneY() - orgSceneY;
		
		        Circle c = (Circle) (t.getSource());
		
		        c.setCenterX(c.getCenterX() + offsetX);
		        c.setCenterY(c.getCenterY() + offsetY);
		
		        orgSceneX = t.getSceneX();
		        orgSceneY = t.getSceneY();
		      });
		      	return circle;
		    }
		
		public Rectangle createRectangle(double x, double y, Color color) {
		    Rectangle rect = new Rectangle(x, y, color);
		
		    rect.setCursor(Cursor.HAND);
		
		    rect.setOnMousePressed((t) -> 
		    {
		      orgSceneX = t.getSceneX();
		      orgSceneY = t.getSceneY();
		
		      Rectangle r = (Rectangle) (t.getSource());
		      r.toFront();
		    });
		    rect.setOnMouseDragged((t) -> 
		    {
		        double offsetX = t.getSceneX() - orgSceneX;
		        double offsetY = t.getSceneY() - orgSceneY;
		
		        Rectangle r = (Rectangle) (t.getSource());
		
		        r.setX(r.getX() + offsetX);
		        r.setY(r.getY() + offsetY);
		
		        orgSceneX = t.getSceneX();
		        orgSceneY = t.getSceneY();
		      });
		      	return rect;
		    }
		public Polygon createTriangle(double x, double y, double z, Color color) {
		    Polygon triangle = new Polygon();
		    triangle.getPoints().addAll(new Double[]{
		    	    0.0, 0.0,
		    	    10.0, x,
		    	    y, z });
		    triangle.setFill(color);
		    triangle.setCursor(Cursor.HAND);
		
		    triangle.setOnMousePressed((t) -> 
		    {
		      orgSceneX = t.getSceneX();
		      orgSceneY = t.getSceneY();
		
		      Polygon p = (Polygon) (t.getSource());
		      p.toFront();
		    });
		    triangle.setOnMouseDragged((t) -> 
		    {
		        double offsetX = t.getSceneX() - orgSceneX;
		        double offsetY = t.getSceneY() - orgSceneY;
		
		        Polygon p = (Polygon) (t.getSource());
		
		        p.setLayoutX(p.getLayoutX() + offsetX);
		        p.setLayoutY(p.getLayoutY() + offsetY);
		
		        orgSceneX = t.getSceneX();
		        orgSceneY = t.getSceneY();
		      });
		      	return triangle;
		    }
		public Line createLine(double x, double y, Color color) 
		{
		    Line line = new Line(0, 0, 200, 300);
		
		    line.setCursor(Cursor.HAND);
		
		    line.setOnMousePressed((t) -> 
		    {
		      orgSceneX = t.getSceneX();
		      orgSceneY = t.getSceneY();
		
		      Line r = (Line) (t.getSource());
		      r.toFront();
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
		
		public TextField createText(double x, double y, Color color) 
		{
		    TextField textBox = new TextField(); 
		
		    textBox.setCursor(Cursor.HAND);
		
		    textBox.setOnMousePressed((t) -> 
		    {
		      orgSceneX = t.getSceneX();
		      orgSceneY = t.getSceneY();
		
		      TextField tb = (TextField) (t.getSource());
		      tb.toFront();
		    });
		    
		    textBox.setOnMouseDragged((t) -> 
		    {
		        double offsetX = t.getSceneX() - orgSceneX;
		        double offsetY = t.getSceneY() - orgSceneY;
		
		        TextField l = (TextField) (t.getSource());
		
		        l.setLayoutX(l.getLayoutX() + offsetX);
		        l.setLayoutY(l.getLayoutY() + offsetY);
		
		        orgSceneX = t.getSceneX();
		        orgSceneY = t.getSceneY();
		      });
		      	return textBox;
		    }

}



}
