package application;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class objectMaker<E>{
	double frameX;
	double frameY;
	double r, s, t;
	Color color;
	double orgSceneX, orgSceneY;
	
	public objectMaker()
	{
		frameX = 800;
		frameY = 400;
	}
	
	public void setAttributes(int var, double r, double s, double t, Color color)
	{
		if (var == 1)
		{
			this.r = r;
			this.color = color;
		}
		else if (var == 2)
		{
			this.r = r;
			this.s = s;
			this.color = color;
		}
		else if (var == 3) 
		{
			this.r = r;
			this.s = s;
			this.t = t;
			this.color = color;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public E createObject(int var) {
		E e;
		if (var == 1)
		{
	    e = (E) new Circle(frameX, frameY, r, color);
	    ((Node) e).setCursor(Cursor.HAND);
		}
		else if(var == 2) 
		{
		e = (E)new Rectangle(r, s, color);
	    ((Node) e).setCursor(Cursor.HAND);
		}
		else if(var == 3) 
		{
		e = (E)new Polygon();
		((Polygon) e).getPoints().addAll(new Double[]{
		    	    0.0, 0.0,
		    	    10.0, r,
		    	    s, t });
		((Shape) e).setFill(color);
	    ((Node) e).setCursor(Cursor.HAND);
		}
		else if(var == 4) 
		{
		e = (E)new Rectangle(frameX, frameY, color);
	    ((Node) e).setCursor(Cursor.HAND);
		}
		else {
			e = null;
		}
	
	    ((Node) e).setOnMousePressed((t) -> 
	    {
	      orgSceneX = t.getSceneX();
	      orgSceneY = t.getSceneY();
	
	      E c = (E) (t.getSource());
	      ((Node) c).toFront();
	    });
	    ((Node) e).setOnMouseDragged((t) -> 
	    {
	        double offsetX = t.getSceneX() - orgSceneX;
	        double offsetY = t.getSceneY() - orgSceneY;
	
	        E c = (E) (t.getSource());
	        if (var == 1)
	        {
	        	((Circle) c).setCenterX(((Circle) c).getCenterX() + offsetX);
	        	((Circle) c).setCenterY(((Circle) c).getCenterY() + offsetY);
	        }
	        if (var == 2)
	        {
	        	((Rectangle) c).setX(((Rectangle) c).getX() + offsetX);
	        	((Rectangle) c).setY(((Rectangle) c).getY() + offsetY);
	        }
	        if (var == 3)
	        {
	        	((Polygon) c).setLayoutX(((Polygon) c).getLayoutX() + offsetX);
	        	((Polygon) c).setLayoutY(((Polygon) c).getLayoutY() + offsetY);
	        }
	
	        orgSceneX = t.getSceneX();
	        orgSceneY = t.getSceneY();
	      });
	      	return e;
	    }

	
}
