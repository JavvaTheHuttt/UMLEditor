package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import application.objectMaker;
import application.classBox;

public class Main extends Application{
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
			window.setTitle("Java the Hutt");
			
			
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
			Button empty_triangle = new Button("Association");
			Button filled_triangle = new Button("Composite");
			Button line = new Button("Line");
			Button box = new Button("Class Box");
			leftMenu.getChildren().addAll(empty_triangle, filled_triangle, line, box);
			
			
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
			    	  q.setAttributes("arrow", 50, 50, 15, Color.GRAY);
				  	  Polygon t = (Polygon) q.createObject("arrow");
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
		public Line createLine() {
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
