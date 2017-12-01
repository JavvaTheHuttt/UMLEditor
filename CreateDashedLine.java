package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class CreateDashedLine {
	
	double orgSceneX, orgSceneY;

	public Button display(Pane pane, Double frameX, Double frameY) 
	{
		Button dashed_line = new Button("Dashed Line");
		
		dashed_line.setOnAction(new EventHandler<ActionEvent>()
		{
		       @Override
		       public void handle(ActionEvent e) 
		       {
		    	  
		    	  Ball c1 = new Ball(frameX, frameY, 10);
		    	   	c1.setFill(Color.BLACK);
		    	   	pane.getChildren().addAll(c1);
		    	   	Ball c2 = new Ball(frameX + 5, frameY + 5, 10);
		    	   	c2.setFill(Color.BLACK);
		    	   	pane.getChildren().addAll(c2);
			    	Connection connection = new Connection(c1, c2);
			    	connection.getStrokeDashArray().addAll(25d, 10d);
			    	pane.getChildren().addAll(connection); 
		       }	
		       
		});
		
		return dashed_line;
	
	}
	
}