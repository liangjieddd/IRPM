package com.dlj.irpm.domain;

import java.util.Date;

public class WaterFee implements java.io.Serializable{

	private Integer id; // id
	private House house; // 房间号
	private float consumption; // 使用量
	private float price;// 单价
	private float val;// 总费用
	private String month;// 水费月份
	private java.util.Date createDate; // 抄表日期
	private String status; // 缴纳状态
	public WaterFee() {
		super();
	}
	public WaterFee(House house, float consumption, float price, float val, String month, Date createDate,
			String status) {
		super();
		this.house = house;
		this.consumption = consumption;
		this.price = price;
		this.val = val;
		this.month = month;
		this.createDate = createDate;
		this.status = status;
	}
	public WaterFee(Integer id, House house, float consumption, float price, float val, String month, Date createDate,
			String status) {
		super();
		this.id = id;
		this.house = house;
		this.consumption = consumption;
		this.price = price;
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
	public float getConsumption() {
		return consumption;
	}
	public void setConsumption(float consumption) {
		this.consumption = consumption;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
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
		return "WaterFee [id=" + id + ", house=" + house + ", consumption=" + consumption + ", price=" + price
				+ ", val=" + val + ", month=" + month + ", createDate=" + createDate + ", status=" + status + "]";
	}
	

}