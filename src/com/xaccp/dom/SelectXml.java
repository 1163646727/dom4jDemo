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
		// 创建list对象
		List classList = new ArrayList();
		// 创建saxReader对象
		SAXReader reader = new SAXReader();
		try {
			// 首先通过document 对象读取xml对象
			String path = this.getClass().getResource("/").getPath();
			System.out.println("当前文件路径--"+path);
			Document document = reader.read(path+"stuInfo.xml");
			// 获取根节点
			Element rootElement = document.getRootElement();
			// 循环根节点
			Iterator it = rootElement.elementIterator();
			while (it.hasNext()) {
				Element childEle = (Element) it.next();
				String nodeName = childEle.getName();
				Attribute attr = childEle.attribute("id");
				classList.add(attr.getText());
				
				//拿到子节点的子节点的第一个节点。。就是班级号  --stuinfo.xml里看
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

	@SuppressWarnings("unchecked") //是否有班级下的某个学生
	public int selectIsNull(String className, String name) {
		// 返回0说明不存在，返回1说明存在
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
