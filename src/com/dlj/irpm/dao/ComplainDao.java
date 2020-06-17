package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.COMPLAINTABLE;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import com.dlj.irpm.dao.provider.ComplainDynaSqlProvider;

import com.dlj.irpm.domain.Complain;

public interface ComplainDao {
	// 动态查询
		@SelectProvider(type=ComplainDynaSqlProvider.class,method="selectWhitParam")
		@Results({
			@Result(id=true,column="id",property="id"),
			@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
			@Result(column="USER_ID",property="user",
				one=@One(select="com.dlj.irpm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER))
		})
		List<Complain> selectByPage(Map<String, Object> params);
		
		@SelectProvider(type=ComplainDynaSqlProvider.class,method="count")
		Integer count(Map<String, Object> params);
			
		@Select("select * from "+COMPLAINTABLE+" where id = #{id}")
		Complain selectById(int id);
		
		@Select("select * from "+COMPLAINTABLE+" where user_id = #{userid}")
		@Results({
			@Result(id=true,column="id",property="id"),
			@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
			@Result(column="USER_ID",property="user",
				one=@One(select="com.dlj.irpm.dao.UserDao.selectById",
			fetchType=FetchType.EAGER))
		})
		List<Complain> selectByUserId(int userid);
		
		@Delete(" delete from "+COMPLAINTABLE+" where id = #{id} ")
		void deleteById(Integer id);
			
		@SelectProvider(type=ComplainDynaSqlProvider.class,method="insertComplain")
		void save(Complain complain);
			
		@SelectProvider(type=ComplainDynaSqlProvider.class,method="updateComplain")
		void update(Complain complain);
		
	}
