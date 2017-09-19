package application;
	
import javafx.application.Application;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;



public class Main extends Application{
	
	Stage window;
	BorderPane layout;
	
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) 
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
			
			leftMenu.getChildren().addAll(square, rectangle, circle, triangle, line);
			
			/*********************************************************************************
			 * 
			 * 		Grid Pane
			 * 
			 *********************************************************************************/
			
			//GridPane grid = new GridPane();
			//grid.setPadding(new Insets(20, 10, 10, 10));
			//grid.setVgap(8);
			//grid.setHgap(10);
			
			
			layout = new BorderPane();
			layout.setTop(menuBar);
			layout.setLeft(leftMenu);
			
			
			
			/*
			ChoiceBox<String> box = new ChoiceBox<>();
			box.setValue("File");
			fileMenu.getItems().add("File");
			box.getItems().add("New");
			box.getItems().add("Open File");
			box.getItems().add("Save");
			box.getItems().add("Print");
			box.getItems().add("Close");
			
			BorderPane barderpane = new BorderPane();
			BorderPane.setTop(box);
			BorderPane.setLeft();
			BorderPane.setRight();
			*/
			
			
			
			//StackPane layout = new StackPane();
			Scene scene = new Scene(layout,1750,1000);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			window.setScene(scene);
			window.show();
			
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	
}
