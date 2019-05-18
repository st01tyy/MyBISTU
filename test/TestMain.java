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

import com.alibaba.fastjson.JSONObject;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

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
        // System.out.println(resultString);
        return resultString;  
    }  
	public static void main(String[] args) throws FileNotFoundException 
	{
		
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("xh", "2017011402");
//		param.put("password", "2017011402");
//		String str = doPost("https://www.bistu520.cn:8080", param);
//		Data data = JSONObject.parseObject("{\"grade\": [[\"程序设计基础(C语言)\", \"4.00\", \"99\", \"5.0\"], [\"大学生安全知识教育\", \"4.00\", \"优秀\", \"1\"], [\"大学生心理健康\", \"4.00\", \"95\", \"2.0\"], [\"大学体育(1)\", \"3.00\", \"82\", \"1.0\"], [\"大学英语(1)\", \"2.00\", \"79\", \"4.0\"], [\"大学英语听说实验课\", \"3.00\", \"88\", \"2.0\"], [\"高等数学A(1)\", \"4.00\", \"97\", \"6.0\"], [\"计算机导论\", \"3.00\", \"85\", \"2.0\"], [\"人力资源管理\", \"3.00\", \"82\", \"2.0\"], [\"思想道德修养与法律基础\", \"4.00\", \"90\", \"3.0\"], [\"线性代数A\", \"4.00\", \"94\", \"3.0\"], [\"Python编程\", \"3.00\", \"83\", \"2.0\"], [\"程序设计实践（C++）\", \"3.00\", \"88\", \"2.0\"], [\"创新创业（通识课）\", \"4.00\", \"97\", \"3.0\"], [\"大数据概论\", \"2.00\", \"76\", \"2.0\"], [\"大学生职业规划\", \"4.00\", \"96\", \"1.0\"], [\"大学体育(2)\", \"3.00\", \"87\", \"1.0\"], [\"大学物理A(1)\", \"2.00\", \"71\", \"3.5\"], [\"大学英语(2)\", \"2.00\", \"75\", \"4.0\"], [\"高等数学A(2)\", \"1.00\", \"68\", \"5.0\"], [\"机器学习\", \"3.00\", \"80\", \"2.0\"], [\"军训\", \"4.00\", \"优秀\", \"2\"], [\"离散数学（1）\", \"3.00\", \"88\", \"4.0\"], [\"面向对象技术(C++)\", \"4.00\", \"91\", \"3.5\"], [\"人机交互设计\", \"4.00\", \"91\", \"1.0\"], [\"物理实验A（1）\", \"3.00\", \"良好\", \"2.0\"], [\"物理学史\", \"4.00\", \"98\", \"2.0\"], [\"英美文化概论（英文授课）（通识课）\", \"4.00\", \"92\", \"1.5\"], [\"影视艺术欣赏\", \"3.00\", \"85\", \"1.5\"], [\"Java程序设计\", \"4.00\", \"97\", \"2.0\"], [\"创业基础（通识课）\", \"4.00\", \"93\", \"3.0\"], [\"大数据平台技术实践\", \"4.00\", \"96\", \"1.5\"], [\"大学体育（3）\", \"4.00\", \"92\", \"1.0\"], [\"大学物理A(2)\", \"4.00\", \"100\", \"3.0\"], [\"大学英语(3)\", \"3.00\", \"80\", \"4.0\"], [\"概率论与数理统计A\", \"4.00\", \"91\", \"3.0\"], [\"计算机电路基础\", \"3.00\", \"84\", \"4.0\"], [\"军事理论\", \"4.00\", \"98\", \"2.0\"], [\"马克思主义基本原理概论\", \"3.00\", \"84\", \"3.0\"], [\"数据采集\", \"3.00\", \"88\", \"1.5\"], [\"数据结构（JAVA）\", \"4.00\", \"91\", \"4.5\"], [\"物理实验A（2）\", \"3.00\", \"良好\", \"1.5\"], [\"形势与政策课(1)\", \"3.00\", \"88\", \"1.0\"], [\"云计算导论\", \"4.00\", \"91\", \"2\"], [\"中西文化比较(通识课)\", \"4.00\", \"97\", \"2.0\"], [\"专业发展概论\", \"3.00\", \"80\", \"1.0\"]], \"credit\": 1, \"GPA\": \"3.30\", \"user_token\": [\"2017011398\", \"mcy200091\"], \"timetable\": [[[], [{\"name\": \"中国近现代史纲要\", \"teacher\": \"石桂芳\", \"room\": \"2-2-111(原103)\", \"begin\": \"1\", \"end\": \"11\", \"isDan\": 1, \"length\": 2}], [{\"name\": \"计算机组成原理\", \"teacher\": \"沈美娥\", \"room\": \"2-3-六阶梯\", \"begin\": \"1\", \"end\": \"9\", \"isDan\": 0, \"length\": 2}, {\"name\": \"计算机组成原理\", \"teacher\": \"沈美娥\", \"room\": \"2-3-六阶梯\", \"begin\": \"11\", \"end\": \"18\", \"isDan\": 0, \"length\": 2}], [{\"name\": \"计算机网络\", \"teacher\": \"陈昕\", \"room\": \"2-1-三阶梯\", \"begin\": \"6\", \"end\": \"6\", \"isDan\": 2, \"length\": 2}, {\"name\": \"计算机网络\", \"teacher\": \"陈昕\", \"room\": \"2-1-三阶梯\", \"begin\": \"8\", \"end\": \"18\", \"isDan\": 0, \"length\": 2}, {\"name\": \"计算机网络\", \"teacher\": \"陈昕\", \"room\": \"2-1-三阶梯\", \"begin\": \"1\", \"end\": \"4\", \"isDan\": 0, \"length\": 2}], [{\"name\": \"计算机组成原理\", \"teacher\": \"沈美娥\", \"room\": \"2-3-七阶梯\", \"begin\": \"7\", \"end\": \"8\", \"isDan\": 0, \"length\": 2}, {\"name\": \"计算机网络\", \"teacher\": \"陈昕\", \"room\": \"2-1-三阶梯\", \"begin\": \"13\", \"end\": \"14\", \"isDan\": 0, \"length\": 2}, {\"name\": \"计算机组成原理\", \"teacher\": \"沈美娥\", \"room\": \"2-3-七阶梯\", \"begin\": \"1\", \"end\": \"5\", \"isDan\": 0, \"length\": 2}, {\"name\": \"计算机网络\", \"teacher\": \"陈昕\", \"room\": \"2-1-三阶梯\", \"begin\": \"16\", \"end\": \"17\", \"isDan\": 0, \"length\": 2}], [], []], [[{\"name\": \"Linux系统实践\", \"teacher\": \"路旭强\", \"room\": \"2-中心-C\", \"begin\": \"1\", \"end\": \"10\", \"isDan\": 0, \"length\": 3}, {\"name\": \"Linux系统实践\", \"teacher\": \"路旭强\", \"room\": \"2-中心-C\", \"begin\": \"11\", \"end\": \"11\", \"isDan\": 1, \"length\": 2}], [{\"name\": \"数据库原理与应用\", \"teacher\": \"何玉洁\", \"room\": \"2-中心-C\", \"begin\": \"1\", \"end\": \"12\", \"isDan\": 0, \"length\": 3}, {\"name\": \"数据库原理与应用\", \"teacher\": \"何玉洁\", \"room\": \"2-中心-C\", \"begin\": \"13\", \"end\": \"14\", \"isDan\": 0, \"length\": 2}], [{\"name\": \"数字媒体艺术与技术\", \"teacher\": \"景智\", \"room\": \"2-1-一阶梯\", \"begin\": \"1\", \"end\": \"8\", \"isDan\": 0, \"length\": 3}], [], [], [], []], [[], [{\"name\": \"乒乓球(体育4)\", \"teacher\": \"刘春萍\", \"room\": \"2-操场2\", \"begin\": \"1\", \"end\": \"16\", \"isDan\": 0, \"length\": 2}], [], [{\"name\": \"中国近现代史纲要\", \"teacher\": \"石桂芳\", \"room\": \"2-2-411(原405)\", \"begin\": \"1\", \"end\": \"18\", \"isDan\": 0, \"length\": 2}], [], [], []], [[], [{\"name\": \"形势与政策课(2)\", \"teacher\": \"韩聪钰\", \"room\": \"2-2-411(原405)\", \"begin\": \"3\", \"end\": \"10\", \"isDan\": 0, \"length\": 2}], [{\"name\": \"专业英语\", \"teacher\": \"冯雪\", \"room\": \"2-3-五阶梯\", \"begin\": \"11\", \"end\": \"18\", \"isDan\": 0, \"length\": 2}, {\"name\": \"专业英语\", \"teacher\": \"冯雪\", \"room\": \"2-3-五阶梯\", \"begin\": \"1\", \"end\": \"8\", \"isDan\": 0, \"length\": 2}], [\"算法设计与分析\", \"专业必修\", \"周四第8,9节{第1-12周}\", \"范艳芳\", \"2-2-411(原405)\", \"2019年06月03日(09:50-11:50)\", \"2-3-六阶梯\"], [], [], []], [[], [{\"name\": \"高级JAVA程序设计\", \"teacher\": \"徐莉\", \"room\": \"2-2-407\", \"begin\": \"1\", \"end\": \"8\", \"isDan\": 0, \"length\": 2}], [], [], [], [], []]], \"name\": \"马长银\", \"major\": \"计算机科学与技术\", \"State_Code\": \"200\"}", Data.class);
//		String[][] arr = data.getGrade();
//		for(int a=0; a < arr.length; a++)
//		{
//			for(int b=0; b < arr[a].length; b++)
//			{
//				System.out.print(arr[a][b]+" ");
//			}
//			System.out.println();
//		}
//		
//		
//		PrintWriter w = new PrintWriter(new File("./test.txt"));
//		w.write(str);
//		w.close();
	}
}
