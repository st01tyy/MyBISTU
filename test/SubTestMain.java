package test;

import com.jfoenix.controls.JFXButton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui.MainPane;
import ui.SimpleGradePane;

public class SubTestMain extends Application{

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {

		FXMLLoader loader = new FXMLLoader(TestMain.class.getResource("/fxml/single_grade.fxml"));
		VBox vbox = loader.load();
		SimpleGradePane controller = loader.getController();
		controller.initialize("2", "3");
		arg0.setScene(new Scene(vbox, vbox.getPrefWidth(), vbox.getPrefHeight()));
		arg0.show();
		
	}

}
