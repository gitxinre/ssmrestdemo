package com.ly.ssm.webservice.client.service;

/**
 * 1、生成客户端调用方式
 *
 *      注意：该种方式使用简单，但一些关键的元素在代码生成时写死到生成代码中，不方便维护，所以仅用于测试。
 *      a、Wsimport命令介绍
 *          Wsimport就是jdk（1.6版本之后）提供的的一个工具，他的作用就是根据WSDL地址生成客户端代码；
 *          Wsimport位置JAVA_HOME/bin
 *          Wsimport常用的参数：
 *          -s，生成java文件的
 *          -d，生成class文件的，默认的参数
 *          -p，指定包名的，如果不加该参数，默认包名就是wsdl文档中的命名空间的倒序；
 *          Wsimport仅支持SOAP1.1客户端的生成；
 *      b、调用公网手机号归属地查询服务
 *          第一步：wsimport生成客户端代码
 *          wsimport -p cn.itcast.mobile -s . http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl
 *          第二步：阅读使用说明书（wsdl文档），使用生成的客户端代码调用服务端
 *
 * @author Administrator
 */
public class HelloWorldClient1 {
}
