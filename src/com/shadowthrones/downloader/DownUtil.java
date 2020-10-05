package com.shadowthrones.downloader;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import com.shadowthrones.logger.Logger;

class DownUtil{
	static Alert alert = new Alert(AlertType.INFORMATION);
	
	//Utility method to get connection. 
	static Document getConnection(String website) {
		//Jsoup element that store a webpage.
		Document doc = null;
		
		//Connect using Jsoup and log result.
		try {
			doc = Jsoup.connect(website).get();
			String log = "Connection Succeful, Website name:" + doc.title();
			Logger.log(log);
		}
		catch(IOException e) {
			System.out.println("Connection Unsucceful");
			alert.setContentText("Unable to get get Connection!");
			alert.show();
			Logger.log("Connection Unsucceful");
		}
		return doc;
	}
	
	//Utility method to get unique name for file.
	static String getName(String url) {
		//Find index of last '/' in URL.
		int lastindex = url.lastIndexOf("/");
	    
		//find substring from found index till end.
		String name = (url.substring(lastindex+1));
	    
		//log unique name.
		Logger.log("File with name " + name + " found at URL:" + url);
		return name;
	}
	
	//Utility method to start download.
	static void download(String url, String name, String dir) {
		try {
			URL link = new URL(url);
		    File f1 = new File(name);
			
			InputStream in = link.openStream();
		    OutputStream out = new BufferedOutputStream(new FileOutputStream(dir + f1));
		    int i;
		    while((i = in.read()) != -1) {
			    out.write(i);
		    }
		
		    //Close i/o streams 
		    in.close();
		    out.close();
		    
		    Logger.log("Download Successful");
		}
		catch(IOException e) {
			System.out.println("Unable to Download");
			alert.setContentText("Unable to get get Download!");
			alert.show();
			Logger.log("Download Unuccessful");
		}
	}
	
}