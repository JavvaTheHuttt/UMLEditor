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
		    	   /*
		    	  objectMaker<Circle> q = new objectMaker<Circle>(); 
		    	  q.setAttributes("arrow", 25, 25, 5, Color.TRANSPARENT);
		    	  Circle c = (Circle) q.createObject("circle");
		    	  c.setStrokeWidth(2);
		    	  c.setStroke(Color.BLACK);
		    	  c.relocate(frameX, frameY);
		    	  pane.getChildren().addAll(c);
		    	  */
		    	   
		    	   Circle c = circleCreator(frameX, frameY, 25.0, Color.TRANSPARENT);
		    	   c.setStrokeWidth(2);
		    	   c.setStroke(Color.BLACK);
		    	   c.relocate(frameX, frameY);
		    	   pane.getChildren().addAll(c);
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
