package com.dlj.irpm.domain;

import java.io.Serializable;
import java.util.Date;

public class House implements Serializable {

	private Integer id; // id
	private Integer buildingnum; // 楼号
	private Integer unitnum; // 单元号
	private Integer housenum; // 房间号
	private float area; // 建筑面积
	private float value; // 总价值
	private String status; // 售出状态
	public House() {
		super();
	}
	public House(Integer buildingnum, Integer unitnum, Integer housenum, float area, float value, String status) {
		super();
		this.buildingnum = buildingnum;
		this.unitnum = unitnum;
		this.housenum = housenum;
		this.area = area;
		this.value = value;
		this.status = status;
	}
	public House(Integer id, Integer buildingnum, Integer unitnum, Integer housenum, float area, float value,
			String status) {
		super();
		this.id = id;
		this.buildingnum = buildingnum;
		this.unitnum = unitnum;
		this.housenum = housenum;
		this.area = area;
		this.value = value;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBuildingnum() {
		return buildingnum;
	}
	public void setBuildingnum(Integer buildingnum) {
		this.buildingnum = buildingnum;
	}
	public Integer getUnitnum() {
		return unitnum;
	}
	public void setUnitnum(Integer unitnum) {
		this.unitnum = unitnum;
	}
	public Integer getHousenum() {
		return housenum;
	}
	public void setHousenum(Integer housenum) {
		this.housenum = housenum;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
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
		return "House [id=" + id + ", buildingnum=" + buildingnum + ", unitnum=" + unitnum + ", housenum=" + housenum
				+ ", area=" + area + ", value=" + value + ", status=" + status + "]";
	}

	

}
