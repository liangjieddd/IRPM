package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.COMPLAINTABLE;
import static com.dlj.irpm.util.common.IrpmConstants.REPAIRTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import com.dlj.irpm.dao.provider.RepairDynaSqlProvider;
import com.dlj.irpm.domain.Complain;
import com.dlj.irpm.domain.Repair;

public interface RepairDao {

	// 动态查询
	@SelectProvider(type=RepairDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.dlj.irpm.dao.UserDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Repair> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=RepairDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	@Select("select * from "+REPAIRTABLE+" where ID = #{id}")
	Repair selectById(int id);
	
	@Select("select * from "+REPAIRTABLE+" where user_id = #{userid}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="USER_ID",property="user",
			one=@One(select="com.dlj.irpm.dao.UserDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Repair> selectByUserId(int userid);
	
	@Delete(" delete from "+REPAIRTABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	@SelectProvider(type=RepairDynaSqlProvider.class,method="insertRepair")
	void save(Repair repair);
		
	@SelectProvider(type=RepairDynaSqlProvider.class,method="updateRepair")
	void update(Repair repair);
	
}
