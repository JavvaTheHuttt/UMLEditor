package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import application.objectMaker;
import application.classBox;



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
			window.setTitle("Wayne's World");
			
			
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
			fileMenu.getItems().add(new MenuItem("Close"));
			
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
			Button box = new Button("Class Box");
			
			leftMenu.getChildren().addAll(square, rectangle, circle, triangle, line, box);
			
			
			
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
			window.setScene(scene);
			window.show();
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
		
			circle.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  objectMaker<Circle> q = new objectMaker<Circle>();
			    	  q.setAttributes(1, 50.0, 150.0, 100, Color.GREEN);
			    	  Circle c = (Circle) q.createObject(1);
			    	  pane.getChildren().addAll(c);
			       }		 
			});
			
			rectangle.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  objectMaker<Rectangle> q = new objectMaker<Rectangle>();
			    	  q.setAttributes(2, 50.0, 150.0, 100, Color.RED);
			    	  Rectangle r = (Rectangle) q.createObject(2);
			    	  r.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(r);
			       }		 
			});
			
			square.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  objectMaker<Rectangle> q = new objectMaker<Rectangle>();
			    	  q.setAttributes(2, 100, 100, 100, Color.BLUE);
			    	  Rectangle s = (Rectangle) q.createObject(2);
			    	  s.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(s);
			       }		 
			});
			
			triangle.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  objectMaker<Polygon> q = new objectMaker<Polygon>();
			    	  q.setAttributes(3, 150, 150, 150, Color.ORANGE);
				  	  Polygon t = (Polygon) q.createObject(3);
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
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

		public Line createLine(double x, double y, Color color) {
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
		    
}
