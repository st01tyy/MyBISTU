package function;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

import core.Data;
import javafx.scene.Scene;
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
