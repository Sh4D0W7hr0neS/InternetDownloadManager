package com.shadowthrones.downloader;
import com.shadowthrones.logger.Logger;

import javafx.scene.control.TextField;

public class VidDownloader extends Downloader {
	public static void download(TextField urlfield, TextField dirfield, TextField namefield) {
		//Resolve text field data into string.
		resolve(urlfield, dirfield, namefield);
	
		//Get connection.
		DownUtil.getConnection(website); 
	    
		//Download video.
		DownUtil.download(website, name, dir);
	    
		//Acknowledge downloads.
		Logger.log("Video Download Successfull");
	    end.setContentText("Video Download Successfull");
	}
}
