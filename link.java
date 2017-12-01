package application;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

 class link extends Line
 {

	public link(Circle startBall, Ball endBall) 
	{
		 	startXProperty().bind(startBall.centerXProperty());
	        startYProperty().bind(startBall.centerYProperty());        
	        endXProperty().bind(endBall.centerXProperty());
	        endYProperty().bind(endBall.centerYProperty()); 
	}

}
