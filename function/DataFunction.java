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
	public static void login(String id, String pw)
	{
		Map<String, String> param = new HashMap<String, String>();
		param.put("xh", id);
		param.put("password", pw);
		String str = doPost("https://www.bistu520.cn:8080", param);
		System.out.println(str);
		//Data data = JSONObject.parseObject(str, Data.class);
		
	}
	private static String doPost(String url, Map<String, String> param) 
	{  
        CloseableHttpClient httpClient = HttpClients.createDefault();  
        CloseableHttpResponse response = null;  
        String resultString = "";  
        try 
        {  
            HttpPost httpPost = new HttpPost(url); 
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(60000)
                    .setConnectTimeout(60000)
                    .setConnectionRequestTimeout(60000)
                    .build();
            httpPost.setConfig(requestConfig); 
            if (param != null) 
            {  
                List<NameValuePair> paramList = new ArrayList<>();  
                for (String key : param.keySet()) 
                {  
                    paramList.add(new BasicNameValuePair(key, param.get(key)));  
                }   
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);  
                httpPost.setEntity(entity);  
            }  
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            //System.out.println(resultString);
        } 
        catch (Exception e) 
        {  
            e.printStackTrace();  
        } 
        finally 
        {  
            try 
            {  
                response.close();  
            } catch (IOException e) 
            {  
                e.printStackTrace();  
            }  
        }  
        return resultString;  
    }  
}
