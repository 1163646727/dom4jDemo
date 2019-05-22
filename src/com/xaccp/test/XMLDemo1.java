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
 * DOM4J����XML�ļ�
 */
public class XMLDemo1 {

    public static void main(String[] args) throws DocumentException{
        /** 1.����һ����ȡXML�ļ��Ķ��� ����ָ��XML�ļ���������
         *  ���XML�ļ���ʵ���Ǵ����ϵ�һ�������ļ�,����Ҫ�������JAVA�Ķ���
         *  ����֪��JAVA�Ķ����Ǵ����ڴ��е�,�������Ǿ���Ҫ������Ĵ����ϵ������õ��ڴ���
         *  ��ô����������Ҫ���ļ��������õ��ڴ���,Ȼ�����ڴ��н��д���
         */
        SAXReader reader = new SAXReader();
        
        //ͨ��SAXReader�����ȡxml�ļ���ŵ�Document��
         Document doc = reader.read(new File("demo01.xml")); 

         /**
          * �õ�XML������֮����������Ҫ��ȡxml�ĸ�Ԫ��,��ͨ����Ԫ�ض�ȡ��Ԫ��,�ٶ�ȡԪ�ص������ֵ
          */
         /**
          * 4.��ȡ��Ԫ�� 
          * ע�⣺������ʱ����import org.dom4j.Element;
          */
         Element root = doc.getRootElement();
         System.out.println(root.getName()); //��ȡ��Ԫ�ص����� companys

        /**
         * 5.ͨ����Ԫ�ػ�ȡ��Ԫ�صĵ�����
         * ���룺
         * import java.util.Iterator;��
         * import org.dom4j.Attribute;��
         */
         Iterator<Element> it = root.elementIterator();
         while(it.hasNext()){
             Element e = it.next();//��ȡ��Ԫ��
             System.out.println(e.getName());

             // ��ȡ����ֵ������һ�� ͨ��Ԫ�ض����ȡԪ������ֵ
             //String id = e.attributeValue("id"); //��ȡ����id��ֵ ע����XML���õ����������ݶ���String����
             // System.out.println(id);
             // ��ȡԪ�ص����� ������
             Attribute idAttr = e.attribute("id");
             String id = idAttr.getValue();
             System.out.println(id);

             //ͨ��Ԫ�ض����ȡ��Ԫ�ض���
             Element nameElement = e.element("name");
             //��ȡԪ���е��ı�����
             String name = nameElement.getText();
             System.out.println(name); //���A���B���C����D
             //��ȡ��˾��ַ
             Element addressElement = e.element("address");
             String address = addressElement.getText();
             System.out.println(address);


             //��װ����
             Company company = new Company();
             company.setId(Integer.parseInt(id));
             company.setName(name);
             company.setAddress(address);
             System.out.println(company); 
             /**
              * Company [id=1001, name=���A, address=�㶫����]
              * Company [id=1002, name=���B, address=�㶫����]
              * Company [id=1003, name=���C, address=����]
              * Company [id=1006, name=�̵�D, address=�Ϻ�]
              */
         }   
    }
}