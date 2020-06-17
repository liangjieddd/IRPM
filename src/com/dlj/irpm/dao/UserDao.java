package com.dlj.irpm.dao;


import static com.dlj.irpm.util.common.IrpmConstants.USERTABLE;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.dlj.irpm.dao.provider.UserDynaSqlProvider;
import com.dlj.irpm.domain.User;


public interface UserDao {

	// 根据登录名和密码查询
	@Select("select * from "+USERTABLE+" where loginname = #{loginname} and password = #{password} and housename=#{housename}")
	User selectByLoginnameAndPassword(
			@Param("loginname") String loginname,
			@Param("password") String password,
			@Param("housename") String housename
			);
	
	@Select("select * from "+USERTABLE+" where ID = #{id}")
	User selectById(Integer id);
	
	@Delete(" delete from "+USERTABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	void update(User user);
		
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWhitParam")
	List<User> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void save(User user);
	
	
	
}
