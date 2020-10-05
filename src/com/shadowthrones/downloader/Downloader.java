package com.shadowthrones.downloader;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

class Downloader {
	
	//Create variables to store data.
	static String website, dir, name;
	
	//Create Alert element.
	static Alert alert = new Alert(AlertType.ERROR);
	static Alert end = new Alert(AlertType.INFORMATION);
	
	
	
	static void resolve(TextField urlfield, TextField dirfield, TextField namefield) {
        
		
		alert.setHeaderText("Critical Error!");
		end.setHeaderText("Success!");
		
        //Check if URL field is empty.
		try {
			if(urlfield.getText().trim().isEmpty() == false) {
				website = urlfield.getText();;	
			}
			else {
				NullField e = new NullField();
				throw e;
			}
		}
		catch(NullField e) {
			System.out.println("No Url Entered!");
			alert.setContentText("No Url Entered!");
			alert.show();
		}
		
		//Check if download location is empty.
		try {
			if(dirfield.getText().trim().isEmpty() == false) {
				dir = dirfield.getText() + "/" ;
			}
			else {
				NullField e = new NullField();
				throw e;
			}
		}
		catch(NullField e) {
			
			//Default download directory,if user doesn't provide 
			dir = ".\\downloads\\";
		}
		
		//check if name is empty.
		try {
			if(dirfield.getText().trim().isEmpty() == false) {
				name = namefield.getText();
			}
			else {
				NullField e = new NullField();
				throw e;
			}
		}
		catch(NullField e) {
			//Get unique name,if user doesn't provide 
			name = DownUtil.getName(urlfield.getText());
			
		}
		
	}		
}
