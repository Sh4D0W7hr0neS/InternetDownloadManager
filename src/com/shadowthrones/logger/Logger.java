package com.shadowthrones.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	//Get date in required format for name of log file.
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss_dd_MM_yyyy");
	
	//create file container with name using date.
	static public String logdir = "logs/" + simpleDateFormat.format(new Date()) + ".txt";
	static public File f1 = new File(logdir);
	
	//Method to create a new log file.
	public static void createLog() {
		 
		try {
			f1.createNewFile();
		}
		catch(IOException e) {
			System.out.println("Unable to create log file");
		}
	}
	
	//Method to update log file using file writer.
	public static void log(String text) {
		try{
			FileWriter fw=new FileWriter(logdir, true);    
	        fw.write(text + "\n");    
	        fw.close();   
		}
		catch(Exception e) {
			System.out.println("Unable to update log file");
		}
	}
}
