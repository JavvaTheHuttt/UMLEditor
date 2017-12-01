package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class CreateFDiamond {

	public Button display(Pane pane, Double frameX, Double frameY) 
	{
		Button filled_diamond = new Button("Composition");
		
		//Button listener to create a new aggregation
		filled_diamond.setOnAction(new EventHandler<ActionEvent>()
		{
		       @Override
		       public void handle(ActionEvent e) 
		       {
		    	  
		    	  objectMaker<Polygon> q = new objectMaker<Polygon>();
		    	  q.setAttributes("arrow", 25, 25, 5, Color.BLACK);
			  	  Polygon t = (Polygon) q.createObject("diamond");
			  	  t.relocate(frameX, frameY);
			  	  pane.getChildren().addAll(t);
			  	  Ball c = new Ball(frameX + 5, frameY + 5, 10);
			  	  c.setFill(Color.BLACK);
			  	  pane.getChildren().addAll(c);
			  	  ConnectD connection = new ConnectD(t, c);
			  	  pane.getChildren().addAll(connection);
			
		       }		 
		});
		
		return filled_diamond;
	}

}
