package com.dlj.irpm.domain;

public class Pet implements java.io.Serializable {

	private Integer id; // 编号
	private float value;// 总价
	private String mon;// 月份
	private String status;// 缴纳状态
	private java.util.Date createDate; // 发布日期
	private House house; // 使用房屋
	public Pet() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", value=" + value + ", mon=" + mon + ", status=" + status + ", createDate="
				+ createDate + ", house=" + house + "]";
	}
	
	
}
