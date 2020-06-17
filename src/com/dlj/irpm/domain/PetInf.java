package com.dlj.irpm.domain;

import org.springframework.web.multipart.MultipartFile;

public class PetInf implements java.io.Serializable{

	private int id;					// 编号
	private String name;			// 名字
	private String fileName;		// 文件名
	private MultipartFile file;		// 文件
	private String kind;			// 种类
	private String status;			// 状态
	private java.util.Date createDate;	// 创建时间
	private User user;				// 主人
	public PetInf() {
		super();
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PetInf [id=" + id + ", name=" + name + ", fileName=" + fileName + ", file=" + file + ", kind=" + kind
				+ ", status=" + status + ", createDate=" + createDate + ", user=" + user + "]";
	}
	
	
}
