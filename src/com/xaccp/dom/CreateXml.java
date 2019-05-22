package com.xaccp.dom;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.xaccp.entity.StuInfo;

public class CreateXml {
	public int createXmlFile(String fileName,List<StuInfo> list) {
		// 返回0表示创建失败，返回1表示创建成功
 		int result = 0;
		// 创建Xml文件首先创建Document对象
		Document document = DocumentHelper.createDocument();
		// 创建Element对象来创建文件中的节点
		// 创建根节点
		Element schoolElement = document.addElement("rows");
		// 加入一行注释
		schoolElement.addComment("dhtmls格式xml");
		for (int i =0;i<list.size();i++) {
			StuInfo info = list.get(i);
			// 创建row节点
			Element classElement1 = schoolElement.addElement("row"); //循环出来
			// 给row添加属性
			classElement1.addAttribute("id", ""+i+""); //id循环
			String [] s = {info.getClassName(),info.getName(),info.getSex()} ;
		
			for(int x=0;x<s.length;x++){
				// 创建row的子结点——节点
				Element studentElement1_1 = classElement1.addElement("cell");//循环
				// 给cell添加属性值
				studentElement1_1.setText(s[x]);	
			}
		}
		// 文档中有中文，进行编码格式的转换
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		// 将文件写出
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(fileName), format);
			writer.write(document);
			writer.close();
			result = 1;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
