package application;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TopMenu {
	
	private Desktop desktop = Desktop.getDesktop();

	
	public MenuBar display(Stage primaryStage, FileChooser fileChooser, TextArea textArea) 
	{
		
		fileChooserDesign(fileChooser);
		
				//menu list
				Menu fileMenu = new Menu("_File");
				Menu editMenu = new Menu("_Edit");
				Menu searchMenu = new Menu("_Search");
				Menu projectMenu = new Menu("_Project");
				Menu helpMenu = new Menu("_Help");
				
				/******************************
				 * 
				 * Functionality of the FILE menu
				 *
				 *******************************/
				
				//creating menu items for the File Menu
				MenuItem newProject = new MenuItem("New Project", null);
				MenuItem openFile = new MenuItem("Open File", null);
				MenuItem rename = new MenuItem("Rename", null);
				MenuItem save = new MenuItem("Save File", null);
				MenuItem close = new MenuItem("Close");
				close.setOnAction(e -> System.exit(0));
				
				
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
				
				//adding items to search menu
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
				    	  
				    	  String title = "Properties";
				    	  String header = "Properties";
				    	  String string = "Version: Java the Hutt Release (1.3.0)\r\n"
				    			  + "Build id: 12102017-4200\r\n"
				    			  + "Construction Date: September 24th, 2017";
				    	  
				    	  AlertBox a = new AlertBox();
				    	  a.display(title, header, string);
				    	 
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
				    	  
				    	  String title = "Welcome";
				    	  String header = "Welcome to Java the Hutt UML Editor!";
				    	  String string = "We have poured our blood, sweat and tears into this masterpiece,\r\n"
				    			  + "so please take your time and look around our site.\r\n"
				    			  + "We hope you enjoy your stay";
				    	  
				    	  AlertBox a = new AlertBox();
				    	  a.display(title, header, string);
				    	  
				      }
				    });
				
				help.setOnAction(new EventHandler<ActionEvent>() 
				{
				      public void handle(ActionEvent event) 
				      {
				    	  
				    	  String title = "Help";
				    	  String header = "Need a little guidance?";
				    	  String string = "Please refer to this online referance provided to you by none other\r\n"  
				    	  		+ "than the Crude Construction Inc.\r\n" 
				    	  		+ "https://youtu.be/yfSLuEj99d0\"";
				    	  
				    	  AlertBox a = new AlertBox();
				    	  a.display(title, header, string);
				    	 
				      }
				    });
				
				tips.setOnAction(new EventHandler<ActionEvent>() 
				{
				      public void handle(ActionEvent event) 
				      {
				    	  
				    	  
				    	  String title = "Tips and Tricks";
				    	  String header = "Here are a few tips and tricks to get you through\r\n "
					        		+ "that case of the Mondays";
				    	  String string = "Alt + f will open the File Menu\r\n"  
				    	  			    + "Alt + e will open the Edit Menu\r\n" 
				    	  			    + "Alt + s will open the Search Menu\r\n"  
				    	  			    + "Alt + p will open the Project Menu\r\n" 
				    	  			    + "Alt + h will open the Help Menu\r\n";
				    	  
				    	  AlertBox a = new AlertBox();
				    	  a.display(title, header, string);
				    	
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
					
				    	 
				      }
				    });
				
				updates.setOnAction(new EventHandler<ActionEvent>() 
				{
				      public void handle(ActionEvent event) 
				      {
				    	  
				    	  String title = "Updates";
				    	  String header = "Lets check to see if you are up-to-date";
				    	  String string = "This version is currently up to date!";
				    	  
				    	  AlertBox a = new AlertBox();
				    	  a.display(title, header, string);
			
				      }
				    });
				
				about.setOnAction(new EventHandler<ActionEvent>() 
				{
				      public void handle(ActionEvent event) 
				      {
				    	  String title = "About";
				    	  String header = "Java The Hutt UML editor was constructed by a small group of masterminds.\r\n" 
				    	  		      		+ "Their dedication and perseverance created this great work, for great works are performed \r\n" 
				    	  		       		+ "not by strength, but by perseverance.";
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
				    	  AlertBox a = new AlertBox();
				    	  a.display(title, header, s);
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
				
				return menuBar;
	}

	
	/*
	 * opens a file
	 */
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
	
	/*
	 * prints text to the screen
	 */
	 private void printLog(TextArea textArea, List<File> files) {
	        if (files == null || files.isEmpty()) {
	            return;
	        }
	        for (File file : files) {
	            textArea.appendText(file.getAbsolutePath() + "\n");
	        }
	    }
	 
	 /*
	  * Saves a txt file by writing a string
	  */
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
	 
	 /*
	  * The design for the function Open File button. User can choose between a variety of 
	  * extensions. The primary option to open the file is user.home
	  */
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
	
	
}
