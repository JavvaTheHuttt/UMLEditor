package application;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class createCircle {
	
	double orgSceneX, orgSceneY;
	
	public Button display(Pane pane, Double frameX, Double frameY) 
	{
		Button circle = new Button("Interface");
		circle.setOnAction(new EventHandler<ActionEvent>()
		{
		       @Override
		       public void handle(ActionEvent e) 
		       {
		    	   
		    	   Circle t = circleCreator(frameX, frameY, 25.0, Color.TRANSPARENT);
		    	   t.setStrokeWidth(2);
		    	   t.setStroke(Color.BLACK);
		    	   t.relocate(frameX, frameY);
		    	   pane.getChildren().addAll(t);
		    	   
		    	   Ball c = new Ball(frameX + 5, frameY + 5, 10);
		    	   c.setFill(Color.BLACK);
		    	   pane.getChildren().addAll(c);
		    	   link connection = new link(t, c);
		    	   pane.getChildren().addAll(connection);
		       }		 
		});
		
		return circle;
	}

	public Circle circleCreator(double x, double y, double r, Color color)
	{
	    Circle circle = new Circle(x, y, r, color);
	
	    circle.setCursor(Cursor.HAND);
	
	    circle.setOnMousePressed((t) -> 
	    {
	      orgSceneX = t.getSceneX();
	      orgSceneY = t.getSceneY();
	
	      Circle c = (Circle) (t.getSource());
	      c.toFront();
	    });
	    
	    circle.setOnMouseDragged((t) -> 
	    {
	        double offsetX = t.getSceneX() - orgSceneX;
	        double offsetY = t.getSceneY() - orgSceneY;
	
	        Circle c = (Circle) (t.getSource());
	
	        c.setCenterX(c.getCenterX() + offsetX);
	        c.setCenterY(c.getCenterY() + offsetY);
	
	        orgSceneX = t.getSceneX();
	        orgSceneY = t.getSceneY();
	      });
	      	return circle;
	    }
}
