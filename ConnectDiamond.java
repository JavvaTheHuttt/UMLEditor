package application;


import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

 class ConnectD extends Line 
{
    public ConnectD(Polygon startBall, Ball endBall) 
    {
        startXProperty().bind(startBall.layoutXProperty());
        startYProperty().bind(startBall.layoutYProperty());        
        endXProperty().bind(endBall.centerXProperty());
        endYProperty().bind(endBall.centerYProperty());        
    }
}