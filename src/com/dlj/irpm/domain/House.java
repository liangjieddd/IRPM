package com.dlj.irpm.domain;

public class House implements java.io.Serializable{
	
	private Integer id; // id
	private String name;//房号
	private float area; // 建筑面积
	private float value; // 总价值
	private String status; // 售出状态
	public House() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", name=" + name + ", area=" + area + ", value=" + value + ", status=" + status
				+ "]";
	}

}
