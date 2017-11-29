package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class CreateLine {
	
	double orgSceneX, orgSceneY;

	public Button display(Pane pane, Double frameX, Double frameY) 
	{
		Button line = new Button("Line");
		
		//Button listener to create a new line
		line.setOnAction(new EventHandler<ActionEvent>()
		{
		       @Override
		       public void handle(ActionEvent e) 
		       {
		    	  Line l = lineCreator();
		    	  l.relocate(frameX, frameY);
		    	  pane.getChildren().addAll(l);
		       }	
		       
		});
		
		return line;
	}
	
	/**
	 * 
	 * @returns a newly created Line, its location 
	 *			and listens for a mouse click and drag
	 * 			to move its location.
	 */
	public Line lineCreator() 
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

}
