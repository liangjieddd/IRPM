package com.dlj.irpm.domain;

import java.util.Date;

import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
import org.springframework.format.annotation.DateTimeFormat;

public class UserDetail implements java.io.Serializable {

	private Integer id; // id
	private String loginname; // 登陆名字
	private String username; // 用户姓名
	private String passwd;// 密码
	private Integer sex; // 性别
	/**
	 * 使用@ModelAttribute接收参数时 form表单中有日期,Spring不知道该如何转换,
	 * 要在实体类的日期属性上加@DateTimeFormat(pattern="yyyy-MM-dd")注解
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date birthday; // 生日

	private char phone; // 手机
	private String email; // 邮箱
	private String qqNum; // qq
	private String passwdQuess;// 密码提示问题
	private String passwdAns;// 密码提示答案
	private String provincecity;// 省份
	private String address; // 地址

	private House house;// 房间
	private Car car;// 车位
	private Complain complain;// 投诉
	private Repair repair;// 报修

	private java.util.Date createDate; // 建档日期

	public UserDetail() {
		super();
	}

	public UserDetail(String loginname, String username, String passwd, Integer sex, Date birthday, char phone, String email,
			String qqNum, String passwdQuess, String passwdAns, String provincecity, String address, House house,
			Car car, Complain complain, Repair repair, Date createDate) {
		super();
		this.loginname = loginname;
		this.username = username;
		this.passwd = passwd;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.qqNum = qqNum;
		this.passwdQuess = passwdQuess;
		this.passwdAns = passwdAns;
		this.provincecity = provincecity;
		this.address = address;
		this.house = house;
		this.car = car;
		this.complain = complain;
		this.repair = repair;
		this.createDate = createDate;
	}

	public UserDetail(Integer id, String loginname, String username, String passwd, Integer sex, Date birthday, char phone,
			String email, String qqNum, String passwdQuess, String passwdAns, String provincecity, String address,
			House house, Car car, Complain complain, Repair repair, Date createDate) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.username = username;
		this.passwd = passwd;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.qqNum = qqNum;
		this.passwdQuess = passwdQuess;
		this.passwdAns = passwdAns;
		this.provincecity = provincecity;
		this.address = address;
		this.house = house;
		this.car = car;
		this.complain = complain;
		this.repair = repair;
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public char getPhone() {
		return phone;
	}

	public void setPhone(char phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public String getPasswdQuess() {
		return passwdQuess;
	}

	public void setPasswdQuess(String passwdQuess) {
		this.passwdQuess = passwdQuess;
	}

	public String getPasswdAns() {
		return passwdAns;
	}

	public void setPasswdAns(String passwdAns) {
		this.passwdAns = passwdAns;
	}

	public String getProvincecity() {
		return provincecity;
	}

	public void setProvincecity(String provincecity) {
		this.provincecity = provincecity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Complain getComplain() {
		return complain;
	}

	public void setComplain(Complain complain) {
		this.complain = complain;
	}

	public Repair getRepair() {
		return repair;
	}

	public void setRepair(Repair repair) {
		this.repair = repair;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginname=" + loginname + ", username=" + username + ", passwd=" + passwd
				+ ", sex=" + sex + ", birthday=" + birthday + ", phone=" + phone + ", email=" + email + ", qqNum="
				+ qqNum + ", passwdQuess=" + passwdQuess + ", passwdAns=" + passwdAns + ", provincecity=" + provincecity
				+ ", address=" + address + ", house=" + house + ", car=" + car + ", complain=" + complain + ", repair="
				+ repair + ", createDate=" + createDate + "]";
	}

}