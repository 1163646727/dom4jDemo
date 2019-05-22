package com.xaccp.test;

import java.util.ArrayList;
import java.util.List;

import com.xaccp.dom.CreateXml;
import com.xaccp.entity.StuInfo;

public class Dom4jTest {
	public static void main(String[] args) {
		
	
		List list = new ArrayList();
		
		List<StuInfo> stuList = new ArrayList<StuInfo>();
		StuInfo info = new StuInfo();
		info.setAge(12);
		info.setClassName("一班");
		info.setName("张三");
		info.setSex("男");
		StuInfo info1 = new StuInfo();
		info1.setAge(12);
		info1.setClassName("2班");
		info1.setName("呵呵");
		info1.setSex("女");
		StuInfo info2 = new StuInfo();
		info2.setAge(12);
		info2.setClassName("3班");
		info2.setName("嘿嘿");
		info2.setSex("男");
		StuInfo info3 = new StuInfo();
		info3.setAge(12);
		info3.setClassName("3班");
		info3.setName("caca");
		info3.setSex("男");
		StuInfo info4 = new StuInfo();
		info4.setAge(12);
		info4.setClassName("4班");
		info4.setName("嘻嘻");
		info4.setSex("女");
		stuList.add(info);
		stuList.add(info1);
		stuList.add(info2);
		stuList.add(info3);
		stuList.add(info4);
		for (int i = 0; i < stuList.size(); i++) {
			StuInfo in  =stuList.get(i);
			String[] str={in.getClassName(),in.getName(),in.getSex()};
			list.add(str);
		}
		CreateXml create=new CreateXml();
		int result=create.createXmlFile("stuInfo.xml",stuList);
		if(result==1){
			System.out.println("创建成功");
		}else{
			System.out.println("创建失败");
		}
	}
}

