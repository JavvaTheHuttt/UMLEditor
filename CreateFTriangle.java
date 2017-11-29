package application;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class CreateFTriangle {

	public Button display(Pane pane, Double frameX, Double frameY) 
	{
		Button filled_triangle = new Button("Composite");
		
		//Button listener to create a new composition arrow
		filled_triangle.setOnAction(new EventHandler<ActionEvent>()
		{
		       @Override
		       public void handle(ActionEvent e) 
		       {
		    	  objectMaker<Polygon> q = new objectMaker<Polygon>();
		    	  q.setAttributes("arrow", 25, 25, 5, Color.BLACK);
			  	  Polygon t = (Polygon) q.createObject("arrow");
		    	  t.relocate(frameX, frameY);
		    	  pane.getChildren().addAll(t);
		       }		 
		});
		
		return filled_triangle;
	}

}
