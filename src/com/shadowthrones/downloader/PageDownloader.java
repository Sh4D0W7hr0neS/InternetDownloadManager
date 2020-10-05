package com.shadowthrones.downloader;

import javafx.scene.control.TextField;

public class PageDownloader extends Downloader {
	public static void download(TextField urlfield, TextField dirfield, TextField namefield) {
		//Resolve text field data into string.
		resolve(urlfield, dirfield, namefield);
        
		//Get connection.
		DownUtil.getConnection(website); 
        
		//change format to HTML.
		name = name + ".html";
	    
		//Download.
		DownUtil.download(website, name, dir);
	    
		//Acknowledge downloads.
		end.setContentText("Page Download Successfull");
	    end.show();
	}
}
