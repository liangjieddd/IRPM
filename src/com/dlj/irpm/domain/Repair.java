package com.dlj.irpm.domain;

import java.util.Date;

public class Repair implements java.io.Serializable{

	private Integer id; // 编号
	private House house;//房间号
	private UserDetail user; // 报修人
	private String title;// 标题
	private String detail; // 内容
	private java.util.Date createDate; // 报修日期
	private String status;//处理状态
	private String repairmanname;// 维修人员
	private String repairmantel;//维修人员联系方式
	public Repair() {
		super();
	}
	public Repair(House house, UserDetail user, String title, String detail, Date createDate, String status,
			String repairmanname, String repairmantel) {
		super();
		this.house = house;
		this.user = user;
		this.title = title;
		this.detail = detail;
		this.createDate = createDate;
		this.status = status;
		this.repairmanname = repairmanname;
		this.repairmantel = repairmantel;
	}
	public Repair(Integer id, House house, UserDetail user, String title, String detail, Date createDate, String status,
			String repairmanname, String repairmantel) {
		super();
		this.id = id;
		this.house = house;
		this.user = user;
		this.title = title;
		this.detail = detail;
		this.createDate = createDate;
		this.status = status;
		this.repairmanname = repairmanname;
		this.repairmantel = repairmantel;
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
	public UserDetail getUser() {
		return user;
	}
	public void setUser(UserDetail user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
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
	public String getRepairmanname() {
		return repairmanname;
	}
	public void setRepairmanname(String repairmanname) {
		this.repairmanname = repairmanname;
	}
	public String getRepairmantel() {
		return repairmantel;
	}
	public void setRepairmantel(String repairmantel) {
		this.repairmantel = repairmantel;
	}
	@Override
	public String toString() {
		return "Repair [id=" + id + ", house=" + house + ", user=" + user + ", title=" + title + ", detail=" + detail
				+ ", createDate=" + createDate + ", status=" + status + ", repairmanname=" + repairmanname
				+ ", repairmantel=" + repairmantel + "]";
	}
	
	

}