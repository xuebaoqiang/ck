package com.pojo;

public class ClassInFo {
	
	private int Id;
	private String ClassName;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public ClassInFo(int id, String className) {
		super();
		Id = id;
		ClassName = className;
	}
	public ClassInFo() {
		super();
	}
	@Override
	public String toString() {
		return "ClassInFo [Id=" + Id + ", ClassName=" + ClassName + "]";
	}
	
	
}
