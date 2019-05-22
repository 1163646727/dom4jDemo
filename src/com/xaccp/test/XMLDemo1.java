package com.xaccp.test;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.xaccp.entity.Company;

/**
 * DOM4J解析XML文件
 */
public class XMLDemo1 {

    public static void main(String[] args) throws DocumentException{
        /** 1.创建一个读取XML文件的对象 用来指向XML文件的输入流
         *  这个XML文件其实就是磁盘上的一个物理文件,我需要将它变成JAVA的对象
         *  我们知道JAVA的对象是存在内存中的,所以我们就是要将物理的磁盘上的数据拿到内存中
         *  那么首先我们是要将文件的内容拿到内存中,然后再内存中进行处理
         */
        SAXReader reader = new SAXReader();
        
        //通过SAXReader对象读取xml文件存放到Document中
         Document doc = reader.read(new File("demo01.xml")); 

         /**
          * 拿到XML的内容之后，首先我们要读取xml的根元素,再通过根元素读取子元素,再读取元素点里面的值
          */
         /**
          * 4.获取根元素 
          * 注意：导包的时候导入import org.dom4j.Element;
          */
         Element root = doc.getRootElement();
         System.out.println(root.getName()); //获取根元素的名字 companys

        /**
         * 5.通过根元素获取子元素的迭代器
         * 导入：
         * import java.util.Iterator;包
         * import org.dom4j.Attribute;包
         */
         Iterator<Element> it = root.elementIterator();
         while(it.hasNext()){
             Element e = it.next();//获取子元素
             System.out.println(e.getName());

             // 获取属性值：方法一： 通过元素对象获取元素属性值
             //String id = e.attributeValue("id"); //获取属性id的值 注意在XML中拿到的所有数据都是String类型
             // System.out.println(id);
             // 获取元素的属性 方法二
             Attribute idAttr = e.attribute("id");
             String id = idAttr.getValue();
             System.out.println(id);

             //通过元素对象获取子元素对象
             Element nameElement = e.element("name");
             //获取元素中的文本内容
             String name = nameElement.getText();
             System.out.println(name); //万科A恒大B金地C招商D
             //获取公司地址
             Element addressElement = e.element("address");
             String address = addressElement.getText();
             System.out.println(address);


             //封装对象
             Company company = new Company();
             company.setId(Integer.parseInt(id));
             company.setName(name);
             company.setAddress(address);
             System.out.println(company); 
             /**
              * Company [id=1001, name=万科A, address=广东深圳]
              * Company [id=1002, name=恒大B, address=广东广州]
              * Company [id=1003, name=金地C, address=北京]
              * Company [id=1006, name=绿地D, address=上海]
              */
         }   
    }
}