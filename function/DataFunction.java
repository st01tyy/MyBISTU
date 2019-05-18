package function;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javafx.stage.Stage;

public class DataFunction 
{
	public static void startApp(Stage stage)
	{
		
		try
		{
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./data.ruben")));
			
		}
		catch
		{
			
		}
	}
}
