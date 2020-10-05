import com.shadowthrones.logger.Logger;
import com.shadowthrones.ui.Input;

import javafx.application.Application;


public class Main{
	public static void main(String args[]) {
		//Create log file.
		Logger.createLog();
		
		//launch UI.
		Application.launch(Input.class, args);
	}
}
