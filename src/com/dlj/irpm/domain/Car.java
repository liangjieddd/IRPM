package com.dlj.irpm.domain;

public class Car implements java.io.Serializable {
	
	private Integer id;			// id
	private String name;	// 区号
	private float value;	// 价格
	private String status;		// 售出状态
	public Car() {
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
		return "Car [id=" + id + ", name=" + name + ", value=" + value + ", status=" + status + "]";
	}
	
	

}
