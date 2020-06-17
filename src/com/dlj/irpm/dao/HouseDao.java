package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.HOUSETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.dlj.irpm.dao.provider.HouseDynaSqlProvider;
import com.dlj.irpm.domain.House;


public interface HouseDao {
	@Select("select * from "+HOUSETABLE+" where ID = #{id}")
	House selectById(int id);
	
	@Select("select * from "+HOUSETABLE+" ")
	List<House> selectAllHouse();

	// 动态查询
	@SelectProvider(type=HouseDynaSqlProvider.class,method="selectWhitParam")
	List<House> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=HouseDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@Delete(" delete from "+HOUSETABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	@SelectProvider(type=HouseDynaSqlProvider.class,method="insertHouse")
	void save(House house);
	
	@SelectProvider(type=HouseDynaSqlProvider.class,method="updateHouse")
	void update(House house);
}
