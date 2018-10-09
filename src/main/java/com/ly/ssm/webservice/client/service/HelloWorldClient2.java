package com.ly.ssm.webservice.client.service;

import com.ly.ssm.webservice.client.servercode.HelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * service编程调用方式
 *      注意：
 *      1、该种方式可以自定义关键元素，方便以后维护，是一种标准的开发方式；
 *      2、这种方式同样需要wsimport生成客户端代码,只不过仅需要将服务接口类引入即可，
 *         例如如果需要<wsdl:port name="MobileCodeWSSoap" binding="tns:MobileCodeWSSoap">端口服务，
 *         则需要将生成的MobileCodeWSSoap.class类引入；
 *
 * @author Administrator
 */
public class HelloWorldClient2 {
    public static void main(String[] args) throws MalformedURLException {
        //创建WSDL的URL，注意不是服务地址
        URL url = new URL("http://localhost:8081/helloWorld?wsdl");

        //创建服务名称
        //1.namespaceURI - 命名空间地址 (wsdl文档中的targetNamespace)
        //2.localPart - 服务视图名  (wsdl文档中服务名称，例如<wsdl:service name="MobileCodeWS">)
        QName qName = new QName("http://impl.service.server.webservice.ssm.ly.com/", "HelloWorld");

        //创建服务视图
        //参数解释：
        //1.wsdlDocumentLocation - wsdl地址
        //2.serviceName - 服务名称
        Service service = Service.create(url, qName);

        //获取服务实现类
        //参数解释:serviceEndpointInterface - 服务端口(wsdl文档中服务端口的name属性，例如<wsdl:port name="MobileCodeWSSoap" binding="tns:MobileCodeWSSoap">)
        HelloWorld helloWorld = service.getPort(HelloWorld.class);
        String yf = helloWorld.sayHi("yf");
        System.out.println("fl = " + yf);
    }
}
