package com.shadowthrones.ui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.shadowthrones.downloader.ImgDownloader;
import com.shadowthrones.downloader.PageDownloader;
import com.shadowthrones.downloader.VidDownloader;
import com.shadowthrones.logger.Logger;
import org.idm.downloader.*;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.idm.logger.*;

public class Input extends Application {
	@Override
	public void start (Stage start) {
		try {
			
			//Create grid with 3 columns length 250.
			GridPane gridPane = Util.getGrid(3, 250);
			
			//Create Grid Elements.
			Text headText = new Text("Internet Download Manager");
			Text urlText = new Text("Website Url: ");
			Text dirText = new Text("Download Directory: ");
			Text nameText = new Text("File Name: ");
			Text note = new Text(" *default download directory is in your work folder\n **name of file is optional\n ***olds log are in your workspace");
			TextField urlField = new TextField();
			TextField  dirField = new TextField ();
			TextField nameField = new TextField();
			Button docDown = new Button("Download Document");
			Button imgDown = new Button("Download Images");
			Button vidDown = new Button("Download Videos");
			Button log = new Button("Show log");
			Button browse = new Button("Browse");
			
			//Add CSS selector classes.
			urlText.getStyleClass().add("text");
			dirText.getStyleClass().add("text");
			nameText.getStyleClass().add("text");
			note.getStyleClass().add("note");
			gridPane.getStyleClass().add("grid");
			headText.getStyleClass().add("header");
		
			//Add elements to grid.
		    gridPane.add(headText, 0, 0, 3, 1);
			gridPane.add(urlText, 0, 1);
			gridPane.add(urlField, 1, 1, 2, 1);
			gridPane.add(dirText, 0, 2);
			gridPane.add(dirField, 1, 2, 1, 1);
			gridPane.add(browse, 2, 2, 1, 1);
			gridPane.add(nameText, 0, 3);
			gridPane.add(nameField, 1, 3, 1, 1);
			gridPane.add(docDown, 0, 4);
			gridPane.add(imgDown, 1, 4);
			gridPane.add(vidDown, 2, 4);
			gridPane.add(log, 1, 5);
			gridPane.add(note,0, 6, 3, 1);
			
			//Set Main pane properties. 
			gridPane.setPadding(new Insets(20, 20, 20, 20)); 
		    gridPane.setVgap(5); 
		    gridPane.setHgap(5); 
		    gridPane.setAlignment(Pos.CENTER); 
			
		    //Align elements and set margins.
			GridPane.setHalignment(headText, HPos.CENTER); 
			GridPane.setHalignment(docDown, HPos.CENTER); 
			GridPane.setHalignment(imgDown, HPos.CENTER); 
			GridPane.setHalignment(vidDown, HPos.CENTER); 
			GridPane.setHalignment(log, HPos.CENTER); 
			
			GridPane.setMargin(headText, new Insets(0, 0, 25, 0));
			GridPane.setMargin(docDown, new Insets(20, 0, 10, 0));
			GridPane.setMargin(vidDown, new Insets(20, 0, 10, 0));
			GridPane.setMargin(imgDown, new Insets(20, 0, 10, 0));
			GridPane.setMargin(log, new Insets(0, 0, 10, 0));
			
			//Add button actions.
			docDown.setOnAction(event -> PageDownloader.download(urlField, dirField, nameField));
			imgDown.setOnAction(event -> ImgDownloader.download(urlField, dirField, nameField));
			vidDown.setOnAction(event -> VidDownloader.download(urlField, dirField, nameField));
			log.setOnAction(event -> {
				try {
					Desktop.getDesktop().edit(Logger.f1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Unable to open log file");
				}
			});
			
			//Create Directory Chooser
			DirectoryChooser dirchoose = new DirectoryChooser();
			browse.setOnAction(event -> {
				File dir = dirchoose.showDialog(start);
				dirField.setText(dir.getAbsolutePath());
			});
			
			//Create scene and launch.
			Scene scene = new Scene(gridPane);
			scene.getStylesheets().add("com/shadowthrones/ui/style.css");
			start.setTitle("Internet Download Manager");
			start.setScene(scene);
			start.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
