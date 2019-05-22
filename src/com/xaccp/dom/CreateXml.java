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
		// ����0��ʾ����ʧ�ܣ�����1��ʾ�����ɹ�
 		int result = 0;
		// ����Xml�ļ����ȴ���Document����
		Document document = DocumentHelper.createDocument();
		// ����Element�����������ļ��еĽڵ�
		// �������ڵ�
		Element schoolElement = document.addElement("rows");
		// ����һ��ע��
		schoolElement.addComment("dhtmls��ʽxml");
		for (int i =0;i<list.size();i++) {
			StuInfo info = list.get(i);
			// ����row�ڵ�
			Element classElement1 = schoolElement.addElement("row"); //ѭ������
			// ��row�������
			classElement1.addAttribute("id", ""+i+""); //idѭ��
			String [] s = {info.getClassName(),info.getName(),info.getSex()} ;
		
			for(int x=0;x<s.length;x++){
				// ����row���ӽ�㡪���ڵ�
				Element studentElement1_1 = classElement1.addElement("cell");//ѭ��
				// ��cell�������ֵ
				studentElement1_1.setText(s[x]);	
			}
		}
		// �ĵ��������ģ����б����ʽ��ת��
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		// ���ļ�д��
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
