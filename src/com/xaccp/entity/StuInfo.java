package com.xaccp.entity;

public class StuInfo {
	
	private String name;
	private String sex;
	private int age;
	private String className;
	
	public StuInfo() {
		super();
	}

	public StuInfo(String name, String sex, int age, String className) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.className = className;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
