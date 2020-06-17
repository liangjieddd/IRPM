package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.ELECTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.dlj.irpm.dao.provider.ElecDynaSqlProvider;
import com.dlj.irpm.domain.Elec;

public interface ElecDao {

	@SelectProvider(type=ElecDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@SelectProvider(type=ElecDynaSqlProvider.class,method="selectWhitParam")
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
	List<Elec> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=ElecDynaSqlProvider.class,method="insertElec")
	void save(Elec elec);

	@Delete(" delete from "+ELECTABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	@Select("select * from "+ELECTABLE+" where ID = #{id}")
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
	Elec selectById(Integer id);
	
	@Select("select elecfee.* from elecfee,houseinfo where houseinfo.name = #{housename} and houseinfo.id=elecfee.house_id")
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
	List<Elec> selectByHouse(String housename);
	
	@SelectProvider(type=ElecDynaSqlProvider.class,method="updateElec")
	void update(Elec elec);

}
