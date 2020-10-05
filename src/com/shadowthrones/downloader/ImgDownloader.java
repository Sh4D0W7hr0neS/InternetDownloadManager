package com.shadowthrones.downloader;

import com.shadowthrones.logger.Logger;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javafx.scene.control.TextField;

public class ImgDownloader extends Downloader {
	public static void download(TextField urlfield, TextField dirfield, TextField namefield) {
		//Resolve text field data into string.
		resolve(urlfield, dirfield, namefield);
		
		int counter = 0;
		
		//Get connection.
		Document doc = DownUtil.getConnection(website); 
		
		//Find all images.
		Elements images = doc.getElementsByTag("img");
	    
		//Get name for each image and download. 
		for(Element image : images) {
	    	String url = image.absUrl("src");
	    	String name = DownUtil.getName(url);
		    DownUtil.download(url, name, dir);    
		    counter++;
	    }
	    
	    //Acknowledge downloads.
	    Logger.log(counter + " Images Downloaded Successfully");
	    end.setContentText(counter + " Images Downloaded Successfully");
	    end.show();
	}
}
