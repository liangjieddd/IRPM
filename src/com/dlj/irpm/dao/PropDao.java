package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.PROPTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.dlj.irpm.dao.provider.PropDynaSqlProvider;
import com.dlj.irpm.domain.Prop;

public interface PropDao {

	@SelectProvider(type=PropDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@SelectProvider(type=PropDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="PRICE",property="price"),
		@Result(column="VALUE",property="value"),
		@Result(column="MON",property="mon"),
		@Result(column="STATUS",property="status"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Prop> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=PropDynaSqlProvider.class,method="insertProp")
	void save(Prop prop);

	@Delete(" delete from "+PROPTABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	@Select("select * from "+PROPTABLE+" where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="PRICE",property="price"),
		@Result(column="VALUE",property="value"),
		@Result(column="MON",property="mon"),
		@Result(column="STATUS",property="status"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	Prop selectById(Integer id);
	
	
	@Select("select propfee.* from propfee,houseinfo where houseinfo.name = #{housename} and houseinfo.id=propfee.house_id")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="PRICE",property="price"),
		@Result(column="VALUE",property="value"),
		@Result(column="MON",property="mon"),
		@Result(column="STATUS",property="status"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Prop> selectByHouse(String housename);
	
	@SelectProvider(type=PropDynaSqlProvider.class,method="updateProp")
	void update(Prop prop);

}
