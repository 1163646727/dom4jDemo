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
	 * 传进来对象进行解析当前对象中的值
	 * @param fileName xml文件
	 */
	@SuppressWarnings("unchecked")
	public void readerFile(String fileName){
		//创建爱你SAXReader对象
		SAXReader reader=new SAXReader();
		try {
			//通过SAXReader对象读取xml文件存放到Document中
			Document document=reader.read(new File(fileName));
			//获取所有的根节点
			Element rootElement=document.getRootElement();
			Iterator it=rootElement.elementIterator();
			System.out.println(rootElement.getName());
			//循环出xml文件中的所有的内容
			while(it.hasNext()){
				Element element=(Element) it.next();
				String nodeName=element.getName();
				Attribute attr = element.attribute("id");
				System.out.println("	"+nodeName+"   属性："+attr.getText());//循环打印出所有的根节点
				Iterator iter=element.elementIterator();
				
				//循环所有的子节点
				while(iter.hasNext()){
					//将所有的子节点存放到 element中
					Element childEle=(Element) iter.next();
					//获取所有的节点的文本
					String text=childEle.getText();
					//打印出所有的子节点
					System.out.println("		"+text);
				}
			}
			//循环出所有的根节点
			System.out.println("--------------根节点下的子节点名称-----------------");
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
