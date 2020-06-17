package com.dlj.irpm.domain;

public class Complain {
	private Integer id;		// 编号
	private String title;   // 标题
	private String content; // 内容
	private java.util.Date createDate;  // 发布日期
	private String replay;//投诉反馈
	private User user;		// 发布人
	// 无参数构造器
	public Complain() {
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Complain [id=" + id + ", title=" + title + ", content=" + content + ", createDate=" + createDate
				+ ", replay=" + replay + ", user=" + user + "]";
	}

}
