package com.xaccp.dom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class SelectXml {

	@SuppressWarnings("unchecked")
	public List getClassData() {
		// ����list����
		List classList = new ArrayList();
		// ����saxReader����
		SAXReader reader = new SAXReader();
		try {
			// ����ͨ��document �����ȡxml����
			String path = this.getClass().getResource("/").getPath();
			System.out.println("��ǰ�ļ�·��--"+path);
			Document document = reader.read(path+"stuInfo.xml");
			// ��ȡ���ڵ�
			Element rootElement = document.getRootElement();
			// ѭ�����ڵ�
			Iterator it = rootElement.elementIterator();
			while (it.hasNext()) {
				Element childEle = (Element) it.next();
				String nodeName = childEle.getName();
				Attribute attr = childEle.attribute("id");
				classList.add(attr.getText());
				
				//�õ��ӽڵ���ӽڵ�ĵ�һ���ڵ㡣�����ǰ༶��  --stuinfo.xml�￴
				//Iterator iter=childEle.elementIterator();
				//Element ele=(Element) iter.next();
				//String text=ele.getText();
				//classList.add(text);
				
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classList;
	}

	@SuppressWarnings("unchecked") //�Ƿ��а༶�µ�ĳ��ѧ��
	public int selectIsNull(String className, String name) {
		// ����0˵�������ڣ�����1˵������
		int result = 0;
		SAXReader reader = new SAXReader();
		try {
			String path = this.getClass().getResource("/").getPath();
			Document document = reader.read(path+"stuInfo.xml");
			Element rootElement = document.getRootElement();
			Iterator it = rootElement.elementIterator();
			while (it.hasNext()) {
				Element element = (Element) it.next();
				String nodeName = element.getName();
				String nodeAttr = element.attribute("id").getText();
				if (nodeAttr.equalsIgnoreCase(className)) {
					Iterator iter = element.elementIterator();
					while (iter.hasNext()) {
						Element childEle = (Element) iter.next();
						String stuName = childEle.getText();
						Attribute attr = childEle.attribute("id");
						System.out.println(attr);
						if(attr!=null){
							String attrName = attr.getText();
							if("name".equals(attrName)){
								if (stuName.equals(name)) {
									result = 1;
									break;
								}
							}
						}
					}
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
