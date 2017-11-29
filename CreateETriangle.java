package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class CreateETriangle {

	public Button display(Pane pane, Double frameX, Double frameY) 
	{
		Button empty_triangle = new Button("Association");
		
		//Button listener to create a new association arrow
		empty_triangle.setOnAction(new EventHandler<ActionEvent>()
		{
			 @Override
		       public void handle(ActionEvent e) 
		       {
		    	  objectMaker<Polygon> q = new objectMaker<Polygon>();
		    	  q.setAttributes("arrow", 25, 25, 5, Color.TRANSPARENT);
			  	  Polygon t = (Polygon) q.createObject("arrow");
			  	  t.setStrokeWidth(2);
			  	  t.setStroke(Color.BLACK);
		    	  t.relocate(frameX, frameY);
		    	  pane.getChildren().addAll(t);
		       }	 
		});
		
		return empty_triangle;
	}

}
