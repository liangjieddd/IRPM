package com.dlj.irpm.domain;

import java.util.Date;

public class Complain implements java.io.Serializable {

	private Integer id; // 编号
	private UserDetail user; // 投诉人
	private String title;// 标题
	private String detail; // 内容
	private java.util.Date createDate; // 发布日期
	private String replay;// 投诉反馈
	public Complain() {
		super();
	}
	public Complain(UserDetail user, String title, String detail, Date createDate, String replay) {
		super();
		this.user = user;
		this.title = title;
		this.detail = detail;
		this.createDate = createDate;
		this.replay = replay;
	}
	public Complain(Integer id, UserDetail user, String title, String detail, Date createDate, String replay) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.detail = detail;
		this.createDate = createDate;
		this.replay = replay;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getReplay() {
		return replay;
	}
	public void setReplay(String replay) {
		this.replay = replay;
	}
	@Override
	public String toString() {
		return "Complain [id=" + id + ", user=" + user + ", title=" + title + ", detail=" + detail + ", createDate="
				+ createDate + ", replay=" + replay + "]";
	}
	
	

}