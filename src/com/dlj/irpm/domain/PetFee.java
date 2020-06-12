package com.dlj.irpm.domain;

import java.util.Date;

public class PetFee implements java.io.Serializable{

	private Integer id; // id
	private House house; // 房间号
	private float val;// 总费用
	private String month;// 费用月份
	private java.util.Date createDate; // 费用创建日期
	private String status; // 缴纳状态
	public PetFee() {
		super();
	}
	public PetFee(House house, float val, String month, Date createDate, String status) {
		super();
		this.house = house;
		this.val = val;
		this.month = month;
		this.createDate = createDate;
		this.status = status;
	}
	public PetFee(Integer id, House house, float val, String month, Date createDate, String status) {
		super();
		this.id = id;
		this.house = house;
		this.val = val;
		this.month = month;
		this.createDate = createDate;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public float getVal() {
		return val;
	}
	public void setVal(float val) {
		this.val = val;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PetFee [id=" + id + ", house=" + house + ", val=" + val + ", month=" + month + ", createDate="
				+ createDate + ", status=" + status + "]";
	}
	
}