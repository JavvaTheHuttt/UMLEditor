package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
//import javafx.scene.transform.Rotate;

public class CreateETriangle {

	public Button display(Pane pane, Double frameX, Double frameY, String string) 
	{
		Button empty_triangle;
		
		
		if(string == "dash")
		{
			empty_triangle = new Button("Dependency");
		}
		else 
		{
			empty_triangle = new Button("Association");
		}
		
		//Button listener to create a new association arrow
		empty_triangle.setOnAction(new EventHandler<ActionEvent>()
		{
			 @Override
		       public void handle(ActionEvent e) 
		       {
		    	  objectMaker<Polygon> q = new objectMaker<Polygon>();
		    	  q.setAttributes("arrow", 25, 25, 5, Color.TRANSPARENT);
			  	  Polygon t = (Polygon) q.createObject("arrow");
			  	//  t.getTransforms().add(new Rotate(30, 50, 30));
			  	  t.setStrokeWidth(2);
			  	  t.setStroke(Color.BLACK);
		    	  t.relocate(frameX, frameY);
		    	  pane.getChildren().addAll(t);
		    	  Ball c = new Ball(frameX + 5, frameY + 5, 10);
			  	  c.setFill(Color.BLACK);
			  	  pane.getChildren().addAll(c);
			  	  ConnectD connection = new ConnectD(t, c);
			  	  if(string == "dash")
			  	  	{
			  		  connection.getStrokeDashArray().addAll(25d, 10d);
			  	  	}
			  	  pane.getChildren().addAll(connection);
		       }	 
		});
		
		return empty_triangle;
	}

}
