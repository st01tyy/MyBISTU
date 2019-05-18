package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SubTestMain extends Application{

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {

		FXMLLoader loader = new FXMLLoader(TestMain.class.getResource("/fxml/main.fxml"));
		VBox vbox = loader.load();
		arg0.setScene(new Scene(vbox, vbox.getPrefWidth(), vbox.getPrefHeight()));
		arg0.show();
		
	}

}
