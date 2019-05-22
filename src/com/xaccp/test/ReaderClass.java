package com.xaccp.test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.xaccp.dom.SelectXml;


public class ReaderClass {
	/**
	 * ������������н�����ǰ�����е�ֵ
	 * @param fileName xml�ļ�
	 */
	@SuppressWarnings("unchecked")
	public void readerFile(String fileName){
		//��������SAXReader����
		SAXReader reader=new SAXReader();
		try {
			//ͨ��SAXReader�����ȡxml�ļ���ŵ�Document��
			Document document=reader.read(new File(fileName));
			//��ȡ���еĸ��ڵ�
			Element rootElement=document.getRootElement();
			Iterator it=rootElement.elementIterator();
			System.out.println(rootElement.getName());
			//ѭ����xml�ļ��е����е�����
			while(it.hasNext()){
				Element element=(Element) it.next();
				String nodeName=element.getName();
				Attribute attr = element.attribute("id");
				System.out.println("	"+nodeName+"   ���ԣ�"+attr.getText());//ѭ����ӡ�����еĸ��ڵ�
				Iterator iter=element.elementIterator();
				
				//ѭ�����е��ӽڵ�
				while(iter.hasNext()){
					//�����е��ӽڵ��ŵ� element��
					Element childEle=(Element) iter.next();
					//��ȡ���еĽڵ���ı�
					String text=childEle.getText();
					//��ӡ�����е��ӽڵ�
					System.out.println("		"+text);
				}
			}
			//ѭ�������еĸ��ڵ�
			System.out.println("--------------���ڵ��µ��ӽڵ�����-----------------");
			for(Iterator it1=rootElement.elementIterator();it1.hasNext();){
                Element element = (Element) it1.next();
                String nodeName=element.getName();
                System.out.println(nodeName);
            }
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReaderClass reader=new ReaderClass();
		
		reader.readerFile("stuInfo.xml"); 
		SelectXml select =new SelectXml();
		List list=select.getClassData();
		System.out.println(list.get(1));
	}
}
