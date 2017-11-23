
package application;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class AlertBox {

		public void display(String title, String header, String message)
		{
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle(title);
	        alert.setHeaderText(header);
	        alert.setContentText(message);
	        alert.show();
		}
	

}
