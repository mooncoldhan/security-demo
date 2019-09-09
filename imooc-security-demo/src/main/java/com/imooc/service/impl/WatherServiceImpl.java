package com.imooc.service.impl;

import com.imooc.service.WatherService;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Title: WatherServiceImpl
 * @ProjectName imooc-security
 * @Description: TODO
 * @date 2019/9/911:42
 */
@Service
public class WatherServiceImpl implements WatherService {


    private static final String SERVICES_HOST = "www.webxml.com.cn";// 主机
    private static final String WEATHER_SERVICES_URL = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/";
    // 获取天气
    private static final String WEATHER_QUERY_URL = WEATHER_SERVICES_URL	+ "getWeather?theUserID=&theCityCode=";

    @Override
    public List<String> getWeathers(int cityCode) {
        //定义一个集合装载添加数据
        List<String> weatherList = new ArrayList<String>();
        /*获取xml文档对象*/
        Document document;
        /*获取解析工厂*/
        DocumentBuilderFactory documentBF = DocumentBuilderFactory.newInstance();
        //设定命名空间
        documentBF.setNamespaceAware(true);
        try {
            //初始xml工厂
            DocumentBuilder db = documentBF.newDocumentBuilder();
            //获取天气数据接口返回的数据
            URL urlObj = new URL(WEATHER_QUERY_URL+ cityCode);
            // 打开连接
            URLConnection urlConn = urlObj.openConnection();
            // 通过地址访问主机,设置请求代理
            urlConn.setRequestProperty("Host", SERVICES_HOST);
            //开始连接
            urlConn.connect();
            //读取
            InputStream inputStream = urlConn.getInputStream();
            //开始解析
            document = db.parse(inputStream);
            //解析string节点
            NodeList nl = document.getElementsByTagName("string");
            System.out.println(nl);
            int len = nl.getLength();
            for (int i = 0; i < len; i++) {
                Node n = nl.item(i);//获取每一个string节点
                String weather = n.getFirstChild().getNodeValue();
                weatherList.add(weather);
            }
            inputStream.close();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherList;
    }
}
