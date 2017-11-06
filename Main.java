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
	 /*
	 public void cut() {
		  
		  TextField focusedTF = getFocusedTextField();

		  String text = focusedTF.getSelectedText();
		  
		  ClipboardContent content = new ClipboardContent();
		  content.putString(text);
		  systemClipboard.setContent(content);
		  
		  IndexRange range = focusedTF.getSelection();
		  String origText = focusedTF.getText();
		  String firstPart = StringUtils.substring( origText, 0, range.getStart() );
		  String lastPart = StringUtils.substring( origText, range.getEnd(), StringUtils.length(origText) );
		  focusedTF.setText( firstPart + lastPart );
		  
		  focusedTF.positionCaret( range.getStart() );

		 }
	 
	 
	 /*
	 private void scrollBar(Stage window) {
		 ScrollPane scroll = new ScrollPane();
		 
		 scroll.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		 scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		 
		 scroll.vvalueProperty().addListener(new ChangeListener<Number>() {
			    public void changed(ObservableValue<? extends Number> ov,
			        Number old_val, Number new_val) {
			            window.setLayoutY(-new_val.doubleValue());
			        }
			});
	 }
	*/
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
		    
		    //scroll bar 
		    //scrollBar(window);
		    
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
			//newProject.setOnAction(e -> window.setScene(newScene));
			
			/*
		    newProject.setOnAction(new EventHandler<ActionEvent>() {
		      public void handle(ActionEvent event) {
		    	  
		    	  
		    	  
		    	 /* textArea.clear();
		    	  TabPane tabPane = new TabPane();

		          BorderPane borderPane = new BorderPane();
		          for (int i = 0; i < 5; i++) {
		              Tab tab = new Tab();
		              tab.setText("Tab" + i);
		              HBox hbox = new HBox();
		              hbox.getChildren().add(new Label("Tab" + i));
		              hbox.setAlignment(Pos.CENTER);
		              tab.setContent(hbox);
		              tabPane.getTabs().add(tab);
		          }
		          // bind to take available space
		          borderPane.prefHeightProperty().bind(window.heightProperty());
		          borderPane.prefWidthProperty().bind(window.widthProperty());
		          borderPane.setCenter(tabPane);
		          root.getChildren().add(borderPane);
		          
		    	  
		    	  try{
		              FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Demo.fxml"));
		              Parent root1 = (Parent) fxmlLoader.load();
		              Stage stage = new Stage();
		              stage.initModality(Modality.APPLICATION_MODAL);
		              stage.initStyle(StageStyle.UNDECORATED);
		              stage.setTitle("ABC");
		              stage.setScene(new Scene(root1));  
		              stage.show();
		              } 
		    	  catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					*/
		   // }
		    //});
			
			
			
			
			
			//opens an existing project
			MenuItem openFile = new MenuItem("Open File", null);
		    openFile.setOnAction(new EventHandler<ActionEvent>() {
		      public void handle(ActionEvent event) {
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
		    MenuItem rename = new MenuItem("Rename", null);
		    rename.setOnAction(new EventHandler<ActionEvent>() {
		      public void handle(ActionEvent event) {
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
		    
		    //Saves a project
		    MenuItem save = new MenuItem("Save File", null);
		    save.setOnAction(new EventHandler<ActionEvent>() {
		      public void handle(ActionEvent event) {
		    	  FileChooser fileChooser = new FileChooser();
		          fileChooser.setTitle("Save File");
		          
		          //Set extension filter
	              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	              fileChooser.getExtensionFilters().add(extFilter);
		          
		          File file = fileChooser.showSaveDialog(primaryStage);
		            if (file != null) {
		                SaveFile("Enter File Name", file);
						//Files.copy(file.toPath(), file.toPath());
		            }
		      }
		    });
		    
		    //close
		    MenuItem close = new MenuItem("Close");
			//fileMenu.getItems().add(close);
			close.setOnAction(e -> System.exit(0));
			
			fileMenu.getItems().add(newProject);
		    fileMenu.getItems().add(openFile);
		    fileMenu.getItems().add(rename);
		    fileMenu.getItems().add(new SeparatorMenuItem());
		    fileMenu.getItems().add(save);
		    fileMenu.getItems().add(new SeparatorMenuItem());
		    fileMenu.getItems().add(close);
		    
		    //file menu items
			//fileMenu.getItems().add(new MenuItem("New Project"));
			//fileMenu.getItems().add(new MenuItem("Open File"));
			//fileMenu.getItems().add(new MenuItem("Rename"));
			//fileMenu.getItems().add(new SeparatorMenuItem());
			//fileMenu.getItems().add(new MenuItem("Save"));
			//fileMenu.getItems().add(new SeparatorMenuItem());
			//fileMenu.getItems().add(new MenuItem("Close"));
			
			
			/******************************
			 * Functionality of the EDIT menu
			 * ---will be rearranged after all functions are working
			 *******************************/
			
			
			MenuItem undo = new MenuItem("Undo", null);
			
			MenuItem cut = new MenuItem("Cut", null);
			cut.setOnAction(new EventHandler<ActionEvent>() {
			      public void handle(ActionEvent event) {
			    	  //cut();
			      }
			});
			MenuItem copy = new MenuItem("Copy", null);
			MenuItem paste = new MenuItem("Paste", null);
			
			
			editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(cut);
			editMenu.getItems().add(copy);
			editMenu.getItems().add(paste);
			editMenu.getItems().add(new SeparatorMenuItem());
			
			
			//edit menu items
			editMenu.getItems().add(new MenuItem("Undo"));
			//editMenu.getItems().add(new SeparatorMenuItem());
			//editMenu.getItems().add(new MenuItem("Cut"));
			//editMenu.getItems().add(new MenuItem("Copy"));
			//editMenu.getItems().add(new MenuItem("Paste"));
			//editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(new MenuItem("Delete"));
			editMenu.getItems().add(new SeparatorMenuItem());
			editMenu.getItems().add(new MenuItem("Find/Replace"));
			
			//search menu items 
			searchMenu.getItems().add(new MenuItem("Search..."));
			searchMenu.getItems().add(new MenuItem("File..."));
			searchMenu.getItems().add(new SeparatorMenuItem());
			searchMenu.getItems().add(new MenuItem("References"));
			searchMenu.getItems().add(new MenuItem("Implementations"));
			
			
			/******************************
			 * Functionality of the PROJECT menu
			 * ---will be rearranged after all functions are working
			 *******************************/
			
			MenuItem openProject = new MenuItem("Open Project", null);
		    openProject.setOnAction(new EventHandler<ActionEvent>() {
		      public void handle(ActionEvent event) {
		    	  textArea.clear();
	                File file = fileChooser.showOpenDialog(primaryStage);
	                if (file != null) {
	                    openFile(file);
	                    List<File> files = Arrays.asList(file);
	                    printLog(textArea, files);
	                }
		      }
		    });
			
		    MenuItem closeProject = new MenuItem("Close Project");
			close.setOnAction(e -> System.exit(0));
			
			
			projectMenu.getItems().add(openProject);
		    projectMenu.getItems().add(closeProject);
		    projectMenu.getItems().add(new SeparatorMenuItem());
			
			MenuItem buildProject = new MenuItem("Build Project");
			buildProject.setDisable(true);
			projectMenu.getItems().add(buildProject);
			
			projectMenu.getItems().add(new SeparatorMenuItem());
			MenuItem properties = new MenuItem("Properties");
			//properties.setOnAction(e -> AlertBox.display("Properties", "HERE ARE THE PROPERTIES"));
			//projectMenu.getItems().add(new MenuItem("Properties"));
			
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
			Button triangle = new Button("Open Triangle");
			Button triangleFilled = new Button("Filled Triangle");
			Button line = new Button("Line");
			Button dashedLine = new Button("Dashed Line");
			
			leftMenu.getChildren().addAll(square, rectangle, circle, triangle, triangleFilled, line, dashedLine);
			
			
			
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
	
			//action for NEW PROJECT in the file menu
			//----had to be moved for layout purposes
			newProject.setOnAction(new EventHandler<ActionEvent>() {
			      public void handle(ActionEvent event) {
			    	  Scene newScene = new Scene(layout, 1752, 1000);
						//newScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						//window.setScene(newScene);
						//window.show();
		                
			      }
			    });
			
			
			VBox group = new VBox(8);
			TextField text1 = new TextField();
			text1.setPrefHeight(30);
			TextField text2 = new TextField();
			text2.setPrefHeight(80);
			TextField text3 = new TextField();
			text3.setPrefHeight(80);
			group.setLayoutX(frameX);
			group.setLayoutY(frameY);
			group.setPadding(new Insets(50, 5, 5, 5));
			group.setBackground(new Background(new BackgroundFill(Color.web("#C0C0C0"), CornerRadii.EMPTY, Insets.EMPTY)));
			group.getChildren().addAll(text1, text2, text3);
			pane.getChildren().addAll(group);
		    
		    group.setOnMousePressed((t) -> 
		    {
		      orgSceneX = t.getSceneX();
		      orgSceneY = t.getSceneY();
		
		      VBox g = (VBox) (t.getSource());
		      g.toFront();
		    });
		    group.setOnMouseDragged((t) -> 
		    {
		        double offsetX = t.getSceneX() - orgSceneX;
		        double offsetY = t.getSceneY() - orgSceneY;
		
		        VBox g = (VBox) (t.getSource());
		        
		        g.setLayoutX(g.getLayoutX() + offsetX);
		        g.setLayoutY(g.getLayoutY() + offsetY);
		
		        orgSceneX = t.getSceneX();
		        orgSceneY = t.getSceneY();
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
			    	  q.setAttributes(3, 150, 150, 150, Color.IVORY);
				  	  Polygon t = (Polygon) q.createObject(3);
			    	  t.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(t);
			       }		 
			});
			
			triangleFilled.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  objectMaker<Polygon> q = new objectMaker<Polygon>();
			    	  q.setAttributes(3, 60, 40, 60, Color.BLACK);
				  	  Polygon s = (Polygon) q.createObject(3);
			    	  s.relocate(frameX, frameY);
			    	  pane.getChildren().addAll(s);
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
		
			dashedLine.setOnAction(new EventHandler<ActionEvent>()
			{
			       @Override
			       public void handle(ActionEvent e) 
			       {
			    	  Line l = createDashedLine(150, 150, Color.BLACK);
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
	
		
		public Line createDashedLine(double x, double y, Color color) {
		    Line line = new Line(20, 80, 270, 80);
		    line.getStrokeDashArray().addAll(25d,10d);
		
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
