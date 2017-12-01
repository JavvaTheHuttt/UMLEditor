package application;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class createTextBox {

	double orgSceneX, orgSceneY;
	
	
	public HBox display(Double frameX, Double frameY)
	{
		HBox group = new HBox();
		TextArea text1 = new TextArea();
		text1.setPrefHeight(20);
		text1.setPrefWidth(100);
		text1.setText("Enter Text");
		text1.setWrapText(true);
		group.setLayoutX(frameX);
		group.setLayoutY(frameY);
		group.setBorder(null);
		group.setPadding(new Insets(5, 5, 5, 5));
		group.setBackground(new Background(new BackgroundFill(Color.web("#C0C0C0"), CornerRadii.EMPTY, Insets.EMPTY)));
		group.getChildren().addAll(text1);
		
		group.setOnMousePressed((t) -> 
	    {
	      orgSceneX = t.getSceneX();
	      orgSceneY = t.getSceneY();
	      
	     // group.setPrefWidth(group.getWidth() + 100); 
    	  //group.setPrefHeight(group.getHeight() + 100);
	
	      HBox g = (HBox) (t.getSource());
	      g.toFront();
	    });
	    group.setOnMouseDragged((t) -> 
	    {
	        double offsetX = t.getSceneX() - orgSceneX;
	        double offsetY = t.getSceneY() - orgSceneY;
	
	        HBox g = (HBox) (t.getSource());
	        
	        g.setLayoutX(g.getLayoutX() + offsetX);
	        g.setLayoutY(g.getLayoutY() + offsetY);
	
	        orgSceneX = t.getSceneX();
	        orgSceneY = t.getSceneY();
	      });
	    
	    return group;
	}


}
