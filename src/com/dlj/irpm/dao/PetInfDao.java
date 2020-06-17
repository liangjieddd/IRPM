package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.PETINFTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import com.dlj.irpm.dao.provider.PetInfDynaSqlProvider;
import com.dlj.irpm.domain.PetInf;

public interface PetInfDao {

	// 动态查询
	@SelectProvider(type=PetInfDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.dlj.irpm.dao.UserDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<PetInf> selectByPage(Map<String, Object> params);
		
	@SelectProvider(type=PetInfDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	@SelectProvider(type=PetInfDynaSqlProvider.class,method="insertPetInf")
	void save(PetInf petinf);
	
	@Select("select * from "+PETINFTABLE+" where ID = #{id}")
	PetInf selectById(int id);
	
	@Select("select * from "+PETINFTABLE+" where user_id = #{userid}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.dlj.irpm.dao.UserDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<PetInf> selectByUserId(int userid);
	
	@Delete(" delete from "+PETINFTABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	@SelectProvider(type=PetInfDynaSqlProvider.class,method="updatePetInf")
	void update(PetInf petinf);
		
}
