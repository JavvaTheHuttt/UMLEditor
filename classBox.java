package application;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class classBox {

	double frameX = 800;
	double frameY = 400;
	double orgSceneX, orgSceneY;
	
	//Constructor to initialize object
	public classBox() 
	{
		
	}
	
	/**
	 * 
	 * @returns a newly created VBox to be set as
	 * 			a new class box, its location and 
	 * 			listens for a mouse click and drag
	 * 			to move its location.
	 */
	public VBox createBox()
	{
		VBox group = new VBox(8);
		TextArea text1 = new TextArea();
		text1.setPrefHeight(50);
		text1.setPrefWidth(250);
		text1.setText("Name");
		text1.setWrapText(true);
		TextArea text2 = new TextArea();
		text2.setPrefHeight(100);
		text2.setPrefWidth(250);
		text2.setText("Attributes");
		text2.setWrapText(true);
		TextArea text3 = new TextArea();
		text3.setPrefHeight(100);
		text3.setPrefWidth(250);
		text3.setText("Operations");
		text3.setWrapText(true);
		group.setLayoutX(frameX);
		group.setLayoutY(frameY);
		group.setPadding(new Insets(25, 5, 5, 5));
		group.setBackground(new Background(new BackgroundFill(Color.web("#C0C0C0"), CornerRadii.EMPTY, Insets.EMPTY)));
		group.getChildren().addAll(text1, text2, text3);
		
		group.setOnMousePressed((t) -> 
	    {
	      orgSceneX = t.getSceneX();
	      orgSceneY = t.getSceneY();
	      
	     // group.setPrefWidth(group.getWidth() + 100); 
    	  //group.setPrefHeight(group.getHeight() + 100);
	
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
	    return group;
	}

}
