package com.shadowthrones.ui;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

class Util{
	//Utility method to create a Grid.
	static GridPane getGrid(int col, int colsize) {
		GridPane gridPane = new GridPane();
		for (int i = 0; i < col; i++) {
	         ColumnConstraints column = new ColumnConstraints(colsize);
	         gridPane.getColumnConstraints().add(column);
	     }
		return gridPane;
	}
}
