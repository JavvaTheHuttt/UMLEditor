package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class textBox {

	public Button display(Pane pane, double frameX, double frameY)
	{
		Button box = new Button("Text Box");
		
		//Button listener to create a new class box
		box.setOnAction(new EventHandler<ActionEvent>()
		{
		       @Override
		       public void handle(ActionEvent e) 
		       {
		    	   	createTextBox cb = new createTextBox();
					HBox group = (HBox) cb.display(frameX, frameY);
					pane.getChildren().addAll(group);
		       }		 
		});
		
		return box;
	}
}
