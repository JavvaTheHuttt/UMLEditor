package application;

//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class objectMaker<E>{
	double frameX = 800;
	double frameY = 400;
	double r, s, t;
	Color color;
	double orgSceneX, orgSceneY;
	E e;
	
	
	//Constructor to initialize object
	public objectMaker()
	{
	}
	
	/**
	 * 
	 * @param var (Specific string)
	 * @param r	(Double value for size of object)
	 * @param s (Double value for size of object)
	 * @param t (Double value for size of object)
	 * @param color (Color to be set for object)
	 * Sets the attributes to the global variables to be used later.
	 * 
	 */
	public void setAttributes(String var, double r, double s, double t, Color color)
	{
		if (var == "arrow") 
		{
			this.r = r;
			this.s = s;
			this.t = t;
			this.color = color;
		}
	}
	
	/**
	 * 
	 * @param var (String)
	 * Sets the size of the object and enables it to be
	 * moved by a mouse click and drag.
	 * @returns newly created object and its location
	 * 			as it is dragged.
	 */
	@SuppressWarnings("unchecked")
	public E createObject(String var) {
		
		
		if(var == "arrow") 
		{
			e = (E)new Polygon();
			((Polygon) e).getPoints().addAll(new Double[]{
						0.0, 0.0,
						10.0, r,
						s, t });
			((Shape) e).setFill(color);
			((Node) e).setCursor(Cursor.HAND);
		}
		
		else if (var == "diamond") {
			
			e = (E)new Polygon();
			((Polygon) e).getPoints().addAll(new Double[]{
						-5.0, 5.0,
						-20.0, r,
						t, s, 
						s , t});
			((Shape) e).setFill(color);
			((Node) e).setCursor(Cursor.HAND);
		}
	
		else
		{
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
	        if (var == "arrow" || var == "diamond")
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