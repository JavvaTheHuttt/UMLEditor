package application;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Cursor;
import javafx.scene.Group;
//import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ScrollBar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Desktop;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import application.objectMaker;



public class Main extends Application{
	Circle q;
	static Stage window;
	BorderPane layout;
	double frameX = 800;
	double frameY = 400;
	double orgSceneX, orgSceneY;
	Node temp;
	private Desktop desktop = Desktop.getDesktop();
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	private void openFile(File file) {
        try 
        {
            this.desktop.open(file);
        } 
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
	
	 private void printLog(TextArea textArea, List<File> files) {
	        if (files == null || files.isEmpty()) {
	            return;
	        }
	        for (File file : files) {
	            textArea.appendText(file.getAbsolutePath() + "\n");
	        }
	    }
	 
	 private void SaveFile(String string, File file){
	        try {
	            FileWriter fileWriter = null;
	             
	            fileWriter = new FileWriter(file);
	            fileWriter.write(string);
	            fileWriter.close();
	        } catch (IOException ex) {
	            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	        }
	         
	    }
	 
	 private void fileChooserDesign(FileChooser fileChooser) {
	        // Set title for FileChooser
	        fileChooser.setTitle("Select File");
	 
	        // Set Initial Directory
	        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
	        
	        // Add Extension Filters
	        fileChooser.getExtensionFilters().addAll(//
	        new FileChooser.ExtensionFilter("All Files", "*.*"), //
	        new FileChooser.ExtensionFilter("DOC", "*.doc"),
	        new FileChooser.ExtensionFilter("TXT", "*.txt"),
	        new FileChooser.ExtensionFilter("EXC", "*.exc"),
	        new FileChooser.ExtensionFilter("JPG", "*.jpg"), //
	        new FileChooser.ExtensionFilter("PNG", "*.png"));
	    }
	 
	 private TextField getFocusedTextField() {
		  TextField[] cut = new TextField[] {};
		  for(TextField text : cut) {
		   if( text.isFocused() ) {
		    return text;
		   }
		  }
		  return null;  
		 }

	
	@Override
	public void start(Stage primaryStage)  throws Exception
	{
		try {
			window = primaryStage;
			window.setTitle("Wayne's World");
			
			//fileChooser for opening, saving, renaming etc the file
			final FileChooser fileChooser = new FileChooser();
			fileChooserDesign(fileChooser);
			   
		    TextArea textArea = new TextArea();
		    textArea.setMinHeight(70);
		    
		    
		    //new project/tab
		    Group root = new Group();
			
			
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
			
			/******************************
			 * Functionality of the FILE menu
			 * ---will be rearranged after all functions are working
			 *******************************/
			
		
			MenuItem newProject = new MenuItem("New Project", null);
			
			
			// Listener to open an existing project
		    openFile.setOnAction(new EventHandler<ActionEvent>() 
		    {
		      public void handle(ActionEvent event) 
		      {
		    	  textArea.clear();
	                File file = fileChooser.showOpenDialog(primaryStage);
	                if (file != null) {
	                    openFile(file);
	                    List<File> files = Arrays.asList(file);
	                    printLog(textArea, files);
	                }
		      }
		    });
		    
		    //renames an already saved project
		    rename.setOnAction(new EventHandler<ActionEvent>()
		    {
		      public void handle(ActionEvent event) 
		      {
		    	  File oldName = new File("C:/s.txt");
		    	  File newName = new File("C:/d.txt");

		    	  if (oldName.renameTo(newName)) 
		    	  {
		    	      System.out.println("renamed");
		    	  } 
		    	  else 
		    	  {
		    	      System.out.println("Error");
		    	  }
		      }
		    });
		    
		    //listener to save a project
		    save.setOnAction(new EventHandler<ActionEvent>() 
		    {
		      public void handle(ActionEvent event) 
		      {
		    	  FileChooser fileChooser = new FileChooser();
		          fileChooser.setTitle("Save File");
		          
		          //Set extension filter
	              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	              fileChooser.getExtensionFilters().add(extFilter);
		          
		          File file = fileChooser.showSaveDialog(primaryStage);
		            if (file != null) {
		                SaveFile("Enter File Name", file);
		            }
		      }
		    });
			
		    //adding items to the File Menu
			fileMenu.getItems().add(newProject);
		    fileMenu.getItems().add(openFile);
		    fileMenu.getItems().add(rename);
		    fileMenu.getItems().add(new SeparatorMenuItem());
		    fileMenu.getItems().add(save);
		    fileMenu.getItems().add(new SeparatorMenuItem());
		    fileMenu.getItems().add(close);
			
			
			/******************************
			 * 
			 * Functionality of the EDIT menu
			 *
			 *******************************/
			
			//creating menu items for the Edit Menu
			MenuItem undo = new MenuItem("Undo", null);
			MenuItem cut = new MenuItem("Cut", null);
			MenuItem copy = new MenuItem("Copy", null);
			MenuItem paste = new MenuItem("Paste", null);
			MenuItem delete = new MenuItem("Delete", null);
			MenuItem find = new MenuItem("Find/Replace", null);
			
			//adding items to the Edit Menu
			editMenu.getItems().add(undo);
			editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(cut);
			editMenu.getItems().add(copy);
			editMenu.getItems().add(paste);
			editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(delete);
			editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(find);
			
			
			/******************************
			 * 
			 * Functionality of the SEARCH menu
			 *
			 *******************************/
			
			//creating menu items for Search Menu
			MenuItem search = new MenuItem("Search...", null);
			MenuItem fileInfo = new MenuItem("File...", null);
			MenuItem ref = new MenuItem("References", null);
			MenuItem imp = new MenuItem("Implementations", null);
			
			//adding items to seaerch menu
			searchMenu.getItems().add(search);
			searchMenu.getItems().add(fileInfo);
			searchMenu.getItems().add(new SeparatorMenuItem());
			searchMenu.getItems().add(ref);
			searchMenu.getItems().add(imp);
			
			
			
			/******************************
			 * 
			 * Functionality of the PROJECT menu
			 * 
			 *******************************/
			
			//creating menu items for Project Menu
			MenuItem openProject = new MenuItem("Open Project", null);
			MenuItem closeProject = new MenuItem("Close Project", null);
			close.setOnAction(e -> System.exit(0));
			
			MenuItem buildProject = new MenuItem("Build Project");
			buildProject.setDisable(true);
			
			MenuItem properties = new MenuItem("Properties");
			
			// Listener to open a project
		    openProject.setOnAction(new EventHandler<ActionEvent>() 
		    {
		      public void handle(ActionEvent event) 
		      {
		    	  textArea.clear();
	                File file = fileChooser.showOpenDialog(primaryStage);
	                if (file != null) {
	                    openFile(file);
	                    List<File> files = Arrays.asList(file);
	                    printLog(textArea, files);
	                }
		      }
		    });
		    
		    properties.setOnAction(new EventHandler<ActionEvent>() 
		    {
			      public void handle(ActionEvent event) 
			      {
			    	  Alert alert = new Alert(AlertType.INFORMATION);
				        alert.setTitle("Properties");
				        alert.setHeaderText("Properties");
				        String s = "Version: Java the Hutt Release (1.3.0)\r\n" 
				        		+ "Build id: 12102017-4200\r\n"
				        		+ "Construction Date: September 24th, 2017";
				        alert.setContentText(s);
				        alert.show();
			    	 
			      }
			    });
			
			//adding items to Project Menu
			projectMenu.getItems().add(openProject);
		    projectMenu.getItems().add(closeProject);
		    projectMenu.getItems().add(new SeparatorMenuItem());
			projectMenu.getItems().add(buildProject);
			projectMenu.getItems().add(new SeparatorMenuItem());
			projectMenu.getItems().add(properties);

			
			/******************************
			 * 
			 * Functionality of the HELP menu
			 * 
			 *******************************/
			
			//creating menu items for Help Menu
			MenuItem welcome = new MenuItem("Welcome", null);
			MenuItem help = new MenuItem("Help Contents", null);
			MenuItem tips = new MenuItem("Tips and Tricks", null);
			MenuItem updates = new MenuItem("Check for Updates", null);
			MenuItem about = new MenuItem("About", null);
			
			welcome.setOnAction(new EventHandler<ActionEvent>() 
			{
			      public void handle(ActionEvent event) 
			      {
			    	  Alert alert = new Alert(AlertType.INFORMATION);
				        alert.setTitle("Welcome");
				        alert.setHeaderText("Welcome to Java the Hutt UML Editor!");
				        String s = "We have poured our blood, sweat and tears into this masterpiece,"
				        		+ "so please take your time and look around our site.\r\n"
				        		+ "We hope you enjoy your stay";
				        alert.setContentText(s);
				        alert.show();
			    	 
			      }
			    });
			
			help.setOnAction(new EventHandler<ActionEvent>() 
			{
			      public void handle(ActionEvent event) 
			      {
			    	  Alert alert = new Alert(AlertType.INFORMATION);
				        alert.setTitle("Help");
				        alert.setHeaderText("Need a little guidance? ");
				        String s = "Please refer to this online referance provided to you by none other\r\n"
				        		+ "than the Crude Construction Inc.\r\n"
				        		+ "https://youtu.be/yfSLuEj99d0";
				        alert.setContentText(s);
				        alert.show();
			    	 
			      }
			    });
			
			tips.setOnAction(new EventHandler<ActionEvent>() 
			{
			      public void handle(ActionEvent event) 
			      {
			    	  Alert alert = new Alert(AlertType.INFORMATION);
				        alert.setTitle("Tips and Tricks ");
				        alert.setHeaderText("Here are a few tips and tricks to get you through\r\n "
				        		+ "that case of the Mondays");
				        /*
				        VBox vb = new VBox(10);
				        ButtonType tricky = new ButtonType("Tricky?", ButtonBar.ButtonData.OTHER);
				        tricky.setOnAction(new EventHandler<ActionEvent>() 
				        {
				        	
				        	@Override
						      public void handle(ActionEvent event) 
				        	{
						    	  
						    	  Alert alertBox = new Alert(AlertType.INFORMATION);
							        alertBox.setTitle("Tricky Tricky Tricky");
							        alertBox.setHeaderText(null);
							        String string = "This speech is my recital, I think it's very vital\r\n" + 
							        		"To rock (A rhyme), that's right (On time)\r\n" + 
							        		"It's Tricky is the title, here we go\r\n" + 
							        		"It's Tricky to rock a rhyme, to rock a rhyme that's right on time\r\n" + 
							        		"It's Tricky, it's Tricky (Tricky) Tricky (Tricky)";
							        alertBox.setContentText(string);
							        alertBox.show();
						    	 
						      }
						    });
						    */
				        String s = "Alt + f will open the File Menu\r\n"
				        		+ "Alt + e will open the Edit Menu\r\n"
				        		+ "Alt + s will open the Search Menu\r\n"
				        		+ "Alt + p will open the Project Menu\r\n"
				        		+ "Alt + h will open the Help Menu\r\n";
				       // vb.getChildren().addAll(button);
				        alert.setContentText(s);
				        alert.show();
			    	 
			      }
			    });
			
			updates.setOnAction(new EventHandler<ActionEvent>() 
			{
			      public void handle(ActionEvent event) 
			      {
			    	  Alert alert = new Alert(AlertType.INFORMATION);
				        alert.setTitle("Updates");
				        alert.setHeaderText("Lets check to see if you are up-to-date");
				        String s = "This version is currently up to date!";
				        alert.setContentText(s);
				        
				        alert.show();
			    	 
			      }
			    });
			
			about.setOnAction(new EventHandler<ActionEvent>() 
			{
			      public void handle(ActionEvent event) 
			      {
			    	  Alert alert = new Alert(AlertType.INFORMATION);
				        alert.setTitle("About");
				        alert.setHeaderText("Java The Hutt UML editor was constructed by a small group of masterminds.\r\n"
				        		+ "Their dedication and perseverance created this great work, for great works are performed \r\n"
				        		+ "not by strength, but by perseverance. ");
				        String s = "Version: Java the Hutt Release (1.3.0)\r\n" + 
				        		"Build id: 12102017-4200\r\n" + 
				        		"(c) Copyright Java the Hutt contributors and others 2017.\r\n"
				        		+ "All rights reserved. Java the Hutt and the Java the Hutt logo are trademarks \r\n"
				        		+ "of the Crude Construction Foundation, Inc.,\r\n"
				        		+ "https://youtu.be/Gs069dndIYk. The Java The Hutt logo \r\n"
				        		+ "cannot be altered without The Hutt Member's permission. \r\n"
				        		+ "Java The Hutt logos are not provided for use under trademark guidelines, https://youtu.be/y4NUZJMCJ20.\r\n"
				        		+ "Java The Hutt is a  trademark or registered trademark of Crude Construction and/or its affiliates.\r\n" 
				        		+ "Other names may be trademarks of their respective owners." ;
				        alert.setContentText(s);
				        
				        alert.show();
			    	 
			      }
			    });
			
			//adding items to the Help Menu
			helpMenu.getItems().add(welcome);
			helpMenu.getItems().add(new SeparatorMenuItem());
		    helpMenu.getItems().add(help);
		    helpMenu.getItems().add(new SeparatorMenuItem());
			helpMenu.getItems().add(tips);
			helpMenu.getItems().add(new SeparatorMenuItem());
			helpMenu.getItems().add(updates);
			helpMenu.getItems().add(new SeparatorMenuItem());
			helpMenu.getItems().add(about);
			
			
			//adds menus and drop down files to the top of the page
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(fileMenu, editMenu, searchMenu, projectMenu, helpMenu);
			menuBar.setId("menu_bar");
			
			
			/*********************************************************************************
			 *
			 * 		Left Menu
			 * 
			 *********************************************************************************/
			
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
