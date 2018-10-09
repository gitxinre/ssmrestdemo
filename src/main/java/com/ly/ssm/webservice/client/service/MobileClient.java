package com.ly.ssm.webservice.client.service;

import com.ly.ssm.webservice.client.servercode.mobilecodews.MobileCodeWSSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;

/**
 * @author Administrator
 */
public class MobileClient {
    public static void main(String[] args) throws IOException {
        //创建WSDL的URL，注意不是服务地址
        URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");

        //创建服务名称
        //1.namespaceURI - 命名空间地址 (wsdl文档中的targetNamespace)
        //2.localPart - 服务视图名  (wsdl文档中服务名称，例如<wsdl:service name="MobileCodeWS">)
        QName qname = new QName("http://WebXml.com.cn/", "MobileCodeWS");

        //创建服务视图
        //参数解释：
        //1.wsdlDocumentLocation - wsdl地址
        //2.serviceName - 服务名称
        Service service = Service.create(url, qname);
        //获取服务实现类
        //参数解释:serviceEndpointInterface - 服务端口(wsdl文档中服务端口的name属性，例如<wsdl:port name="MobileCodeWSSoap" binding="tns:MobileCodeWSSoap">)
        MobileCodeWSSoap mobileCodeWSSoap = service.getPort(MobileCodeWSSoap.class);
        //调用查询方法
        String result = mobileCodeWSSoap.getMobileCodeInfo("13716917491", "");
        System.out.println(result);
    }
}
