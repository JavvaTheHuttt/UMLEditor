package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class createBox {



	public Button display(Pane pane)
	{
		Button box = new Button("Class Box");
		
		//Button listener to create a new class box
		box.setOnAction(new EventHandler<ActionEvent>()
		{
		       @Override
		       public void handle(ActionEvent e) 
		       {
		    	   	classBox cb = new classBox();
					VBox group = (VBox) cb.createBox();
					pane.getChildren().addAll(group);
		       }		 
		});
		
		return box;
	}
}
