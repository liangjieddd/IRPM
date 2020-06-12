package com.dlj.irpm.dao;


import static com.dlj.irpm.util.common.HrmConstants.USERTABLE;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.dlj.irpm.dao.provider.UserDynaSqlProvider;
import com.dlj.irpm.domain.UserDetail;

/**   
 * @Description: UserMapper接口
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */
public interface UserDao {

	// 根据登录名和密码查询员工
	@Select("select * from "+USERTABLE+" where loginname = #{loginname} and password = #{password}")
	UserDetail selectByLoginnameAndPassword(
			@Param("loginname") String loginname,
			@Param("password") String password);
	
	// 根据id查询用户
	@Select("select * from "+USERTABLE+" where ID = #{id}")
	UserDetail selectById(Integer id);
	
	// 根据id删除用户
	@Delete(" delete from "+USERTABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	// 动态修改用户
	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	void update(UserDetail user);
		
	// 动态查询
	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWhitParam")
	List<UserDetail> selectByPage(Map<String, Object> params);
	
	// 根据参数查询用户总数
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	// 动态插入用户
	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void save(UserDetail user);
	
}
