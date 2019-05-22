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
 * DOM4J����XML   XPathӦ��
 * 
 */
public class XMLDemo2 {

    public static void main(String[] args) throws DocumentException {
        //1�� ����һ����ȡXML�ļ��Ķ���  ������ȡָ��XML�ļ���������
        SAXReader reader = new SAXReader();     
     
        //ͨ��SAXReader�����ȡxml�ļ���ŵ�Document��
        Document doc = reader.read(new File("demo01.xml")); 
        Element root = doc.getRootElement();

        //����"/"·����ȡԪ��
        List<Element> list = root.selectNodes("/companys/company/name");
        System.out.println(list.size());
        for (Element element : list) {
            System.out.println("nameԪ�ص�ֵ��:"+element.getText());
        }       
        //����"//"·����ȡԪ��
        List<Element> list1 = root.selectNodes("//name");
        System.out.println(list1.size());
        for (Element element : list1) {
            System.out.println("nameԪ�ص�ֵ��:"+element.getText());
            /**
             * nameԪ�ص�ֵ��:���A
               nameԪ�ص�ֵ��:���B
               nameԪ�ص�ֵ��:���C
               nameԪ�ص�ֵ��:�̵�D
             */
        }       
        //���� ".."��ȡ��Ԫ��,���� "."��ȡ��ǰԪ��,
        Element companyEle = root.element("company");
        //System.out.println(companyEle.attributeValue("id"));
        Element fat = (Element) companyEle.selectSingleNode("..");//Node
        //Element fat = (Element) companyEle.selectSingleNode(".");//Node
        System.out.println("���ڵ�"+fat.getName());//companys  
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //����"@"��ȡ����
        List<Attribute> list2 = root.selectNodes("//company//@id");
        System.out.println(list2.size()); //4
        for (Attribute attribute : list2) {
            System.out.print(attribute.getValue()+" ");//1001 1002 1003 1006 
        }
    }
}