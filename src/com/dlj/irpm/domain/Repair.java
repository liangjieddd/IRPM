package com.dlj.irpm.domain;

public class Repair {

	private Integer id;		// 编号
	private String title;   // 标题
	private String content; // 内容
	private String userphone;//联系方式
	private String repairername;//维修人员
	private String repairerphone;//维修人员联系电话
	private String reply;//反馈
	private java.util.Date createDate;  // 发布日期
	private User user;		// 发布人
	public Repair() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getRepairername() {
		return repairername;
	}
	public void setRepairername(String repairername) {
		this.repairername = repairername;
	}
	public String getRepairerphone() {
		return repairerphone;
	}
	public void setRepairerphone(String repairerphone) {
		this.repairerphone = repairerphone;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
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
		return "Repair [id=" + id + ", title=" + title + ", content=" + content + ", userphone=" + userphone
				+ ", repairername=" + repairername + ", repairerphone=" + repairerphone + ", reply=" + reply
				+ ", createDate=" + createDate + ", user=" + user + "]";
	}
	
	
}
