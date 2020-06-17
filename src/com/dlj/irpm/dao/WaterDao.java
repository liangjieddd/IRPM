package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.WATERTABLE;
import static com.dlj.irpm.util.common.IrpmConstants.HOUSETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.dlj.irpm.dao.provider.WaterDynaSqlProvider;
import com.dlj.irpm.domain.Water;

public interface WaterDao {

	@SelectProvider(type=WaterDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@SelectProvider(type=WaterDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CONSUMPTION",property="consumption"),
		@Result(column="PRICE",property="price"),
		@Result(column="VALUE",property="value"),
		@Result(column="MON",property="mon"),
		@Result(column="STATUS",property="status"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Water> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=WaterDynaSqlProvider.class,method="insertWater")
	void save(Water water);

	@Delete(" delete from "+WATERTABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	@Select("select * from "+WATERTABLE+" where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CONSUMPTION",property="consumption"),
		@Result(column="PRICE",property="price"),
		@Result(column="VALUE",property="value"),
		@Result(column="MON",property="mon"),
		@Result(column="STATUS",property="status"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	Water selectById(Integer id);
	
	
		@Select("select waterfee.* from waterfee,houseinfo where houseinfo.name = #{housename} and houseinfo.id=waterfee.house_id")
		@Results({
			@Result(id=true,column="id",property="id"),
			@Result(column="CONSUMPTION",property="consumption"),
			@Result(column="PRICE",property="price"),
			@Result(column="VALUE",property="value"),
			@Result(column="MON",property="mon"),
			@Result(column="STATUS",property="status"),
			@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
			@Result(column="HOUSE_ID",property="house",
				one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
			fetchType=FetchType.EAGER))
		})
		List<Water> selectByHouse(String housename);
	
	@SelectProvider(type=WaterDynaSqlProvider.class,method="updateWater")
	void update(Water water);

}
