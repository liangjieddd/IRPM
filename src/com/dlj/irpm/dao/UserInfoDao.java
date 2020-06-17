package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.USERINFOTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import com.dlj.irpm.dao.provider.UserInfoDynaSqlProvider;
import com.dlj.irpm.domain.UserInfo;;

public interface UserInfoDao {

	@SelectProvider(type=UserInfoDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@SelectProvider(type=UserInfoDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CARD_ID",property="cardId"),
		@Result(column="POST_CODE",property="postCode"),
		@Result(column="QQ_NUM",property="qqNum"),
		@Result(column="BIRTHDAY",property="birthday",javaType=java.util.Date.class),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="CAR_ID",property="car",
			one=@One(select="com.dlj.irpm.dao.CarDao.selectById",
		fetchType=FetchType.EAGER)),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	List<UserInfo> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=UserInfoDynaSqlProvider.class,method="insertUserInfo")
	void save(UserInfo userinfo);

	@Delete(" delete from "+USERINFOTABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	@Select("select * from "+USERINFOTABLE+" where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="CARD_ID",property="cardId"),
		@Result(column="POST_CODE",property="postCode"),
		@Result(column="QQ_NUM",property="qqNum"),
		@Result(column="BIRTHDAY",property="birthday",javaType=java.util.Date.class),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="CAR_ID",property="car",
			one=@One(select="com.dlj.irpm.dao.CarDao.selectById",
		fetchType=FetchType.EAGER)),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	UserInfo selectById(Integer id);
	
	
	
	@Select("select * from "+USERINFOTABLE+" where name = #{username}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="NAME",property="name"),
		@Result(column="CARD_ID",property="cardId"),
		@Result(column="ADDRESS",property="address"),
		@Result(column="POST_CODE",property="postCode"),
		@Result(column="TEL",property="tel"),
		@Result(column="PHONE",property="phone"),
		@Result(column="QQ_NUM",property="qqNum"),
		@Result(column="EMAIL",property="email"),
		@Result(column="SEX",property="sex"),
		@Result(column="PARTY",property="party"),
		@Result(column="RACE",property="race"),
		@Result(column="EDUCATION",property="education"),
		@Result(column="SPECIALITY",property="speciality"),
		@Result(column="HOBBY",property="hobby"),
		@Result(column="REMARK",property="remark"),
		@Result(column="BIRTHDAY",property="birthday",javaType=java.util.Date.class),
		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
		@Result(column="CAR_ID",property="car",
			one=@One(select="com.dlj.irpm.dao.CarDao.selectById",
		fetchType=FetchType.EAGER)),
		@Result(column="HOUSE_ID",property="house",
			one=@One(select="com.dlj.irpm.dao.HouseDao.selectById",
		fetchType=FetchType.EAGER))
	})
	UserInfo selectByUserName(String username);
	
	@SelectProvider(type=UserInfoDynaSqlProvider.class,method="updateUserInfo")
	void update(UserInfo userinfo);

}
