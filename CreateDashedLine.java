package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

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
		    	  Line l = dashedLineCreator();
		    	  l.relocate(frameX, frameY);
		    	  pane.getChildren().addAll(l);
		       }	
		       
		});
		
		return dashed_line;
	
	}
	
	/**
	 * 
	 * @returns a newly created Dashed Line, its location 
	 *			and listens for a mouse click and drag
	 * 			to move its location.
	 */
	public Line dashedLineCreator() 
	{
		Line dash_line = new Line(20, 80, 270, 80);
		dash_line.getStrokeDashArray().addAll(25d,10d);
	
		dash_line.setCursor(Cursor.HAND);
	
		dash_line.setOnMousePressed((t) -> 
	    {
	      orgSceneX = t.getSceneX();
	      orgSceneY = t.getSceneY();
	
	      Line l = (Line) (t.getSource());
	      l.toFront();
	    });
		dash_line.setOnMouseDragged((t) -> 
	    {
	        double offsetX = t.getSceneX() - orgSceneX;
	        double offsetY = t.getSceneY() - orgSceneY;
	
	        Line l = (Line) (t.getSource());
	
	        l.setLayoutX(l.getLayoutX() + offsetX);
	        l.setLayoutY(l.getLayoutY() + offsetY);
	
	        orgSceneX = t.getSceneX();
	        orgSceneY = t.getSceneY();
	      });
	      	return dash_line;
	    }

}
