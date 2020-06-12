package com.dlj.irpm.domain;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {

	private Integer id;			// id
	private String dist;	// 区号
	private String num;	// 车位号
	private float value;	// 价格
	private String status;		// 售出状态
	public Car() {
		super();
	}
	public Car(String dist, String num, float value, String status) {
		super();
		this.dist = dist;
		this.num = num;
		this.value = value;
		this.status = status;
	}
	public Car(Integer id, String dist, String num, float value, String status) {
		super();
		this.id = id;
		this.dist = dist;
		this.num = num;
		this.value = value;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", dist=" + dist + ", num=" + num + ", value=" + value + ", status=" + status + "]";
	}
	
	
}
