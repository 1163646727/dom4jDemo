package com.xaccp.test;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * DOM4J解析XML   XPath应用
 * 
 */
public class XMLDemo2 {

    public static void main(String[] args) throws DocumentException {
        //1、 创建一个读取XML文件的对象  用来读取指向XML文件的输入流
        SAXReader reader = new SAXReader();     
     
        //通过SAXReader对象读取xml文件存放到Document中
        Document doc = reader.read(new File("demo01.xml")); 
        Element root = doc.getRootElement();

        //根据"/"路径获取元素
        List<Element> list = root.selectNodes("/companys/company/name");
        System.out.println(list.size());
        for (Element element : list) {
            System.out.println("name元素的值是:"+element.getText());
        }       
        //根据"//"路径获取元素
        List<Element> list1 = root.selectNodes("//name");
        System.out.println(list1.size());
        for (Element element : list1) {
            System.out.println("name元素的值是:"+element.getText());
            /**
             * name元素的值是:万科A
               name元素的值是:恒大B
               name元素的值是:金地C
               name元素的值是:绿地D
             */
        }       
        //根据 ".."获取父元素,根据 "."获取当前元素,
        Element companyEle = root.element("company");
        //System.out.println(companyEle.attributeValue("id"));
        Element fat = (Element) companyEle.selectSingleNode("..");//Node
        //Element fat = (Element) companyEle.selectSingleNode(".");//Node
        System.out.println("父节点"+fat.getName());//companys  
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //根据"@"获取属性
        List<Attribute> list2 = root.selectNodes("//company//@id");
        System.out.println(list2.size()); //4
        for (Attribute attribute : list2) {
            System.out.print(attribute.getValue()+" ");//1001 1002 1003 1006 
        }
    }
}