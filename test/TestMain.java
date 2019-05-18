package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestMain 
{
	public static String doPost(String url, Map<String, String> param) {  
        // 创建Httpclient对象  
        CloseableHttpClient httpClient = HttpClients.createDefault();  
        CloseableHttpResponse response = null;  
        String resultString = "";  
        try {  
            // 创建Http Post请求  
            HttpPost httpPost = new HttpPost(url); 
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(60000)
                    .setConnectTimeout(60000)
                    .setConnectionRequestTimeout(60000)
                    .build();
            httpPost.setConfig(requestConfig);
            // 创建参数列表  
            if (param != null) {  
                List<NameValuePair> paramList = new ArrayList<>();  
                for (String key : param.keySet()) {  
                    paramList.add(new BasicNameValuePair(key, param.get(key)));  
                }  
                // 模拟表单  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);  
                httpPost.setEntity(entity);  
            }  
            // 执行http请求  
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(resultString);
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                response.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        System.out.println(resultString);
        return resultString;  
    }  
	public static void main(String[] args) throws FileNotFoundException 
	{
		String url = "https://www.bistu520.cn:8080";
		Map<String, String> param = new HashMap<String, String>();
		param.put("xh", "2017011398");
		param.put("password", "mcy200091");
		String str = doPost(url, param);
		PrintWriter w = new PrintWriter(new File("./test.txt"));
		w.write(str);
		w.close();
	}
}
