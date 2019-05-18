package function;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Current;
import ui.MainPane;

public class InterfaceFunction 
{
	public static void startApp(Stage stage)
	{
		setMainPane();
		stage.setScene(new Scene(Current.mainPane, Current.mainPane.getPrefWidth(), Current.mainPane.getPrefHeight()));
		stage.setTitle("MyBISTU");
		stage.show();
	}
	public static void setMainPane()
	{
		FXMLLoader loader = new FXMLLoader(InterfaceFunction.class.getResource("/fxml/main.fxml"));
		try 
		{
			VBox mainPane = loader.load();
			MainPane controller = loader.getController();
			controller.initialize();
			Current.mainPane = mainPane;
			Current.mainPaneController = controller;
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
