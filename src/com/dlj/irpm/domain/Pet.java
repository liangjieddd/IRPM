package com.dlj.irpm.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class Pet implements java.io.Serializable{

	private int id;					// 编号
	private String name;			// 宠物名字
	private House house;				// 所属房间号
	private String kind;			// 种类
	private String fileName;		// 文件名
	private MultipartFile file;		// 文件
	private String healthstatus; // 健康状态
	private String feestatus; // 费用缴纳状态
	private java.util.Date createDate;	// 创建时间
	public Pet() {
		super();
	}
	public Pet(String name, House house, String kind, String fileName, MultipartFile file, String healthstatus,
			String feestatus, Date createDate) {
		super();
		this.name = name;
		this.house = house;
		this.kind = kind;
		this.fileName = fileName;
		this.file = file;
		this.healthstatus = healthstatus;
		this.feestatus = feestatus;
		this.createDate = createDate;
	}
	public Pet(int id, String name, House house, String kind, String fileName, MultipartFile file, String healthstatus,
			String feestatus, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.house = house;
		this.kind = kind;
		this.fileName = fileName;
		this.file = file;
		this.healthstatus = healthstatus;
		this.feestatus = feestatus;
		this.createDate = createDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getHealthstatus() {
		return healthstatus;
	}
	public void setHealthstatus(String healthstatus) {
		this.healthstatus = healthstatus;
	}
	public String getFeestatus() {
		return feestatus;
	}
	public void setFeestatus(String feestatus) {
		this.feestatus = feestatus;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", house=" + house + ", kind=" + kind + ", fileName=" + fileName
				+ ", file=" + file + ", healthstatus=" + healthstatus + ", feestatus=" + feestatus + ", createDate="
				+ createDate + "]";
	}
	

}