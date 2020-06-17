package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.PETTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.dlj.irpm.dao.provider.PetDynaSqlProvider;
import com.dlj.irpm.domain.Pet;

public interface PetDao {

	@SelectProvider(type=PetDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@SelectProvider(type=PetDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="VALUE",property="value"),
		@Result(column="MON",property="mon"),
		@Result(column="STATUS",property="status"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Pet> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=PetDynaSqlProvider.class,method="insertPet")
	void save(Pet pet);

	@Delete(" delete from "+PETTABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	@Select("select * from "+PETTABLE+" where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="VALUE",property="value"),
		@Result(column="MON",property="mon"),
		@Result(column="STATUS",property="status"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	Pet selectById(Integer id);
	
	
	@Select("select petfee.* from petfee,houseinfo where houseinfo.name = #{housename} and houseinfo.id=petfee.house_id")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="VALUE",property="value"),
		@Result(column="MON",property="mon"),
		@Result(column="STATUS",property="status"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Pet> selectByHouse(String housename);
	
	@SelectProvider(type=PetDynaSqlProvider.class,method="updatePet")
	void update(Pet pet);

}
