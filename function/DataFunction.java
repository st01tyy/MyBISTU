package function;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import core.Data;
import javafx.stage.Stage;
import main.Current;

public class DataFunction 
{
	public static void startApp(Stage stage)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("./data.ruben")));
			Current.data = (Data)in.readObject();
			if(Current.data != null)
				Current.isLoggedin = true;
			in.close();
		}
		catch(Exception e)
		{
			Current.data = null;
			Current.isLoggedin = false;
		}
		InterfaceFunction.startApp(stage);
	} 
}
