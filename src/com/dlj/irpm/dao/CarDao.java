package com.dlj.irpm.dao;

import static com.dlj.irpm.util.common.IrpmConstants.CARTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.dlj.irpm.dao.provider.CarDynaSqlProvider;
import com.dlj.irpm.domain.Car;

public interface CarDao {
	
	// 动态查询
		@SelectProvider(type=CarDynaSqlProvider.class,method="selectWhitParam")
		List<Car> selectByPage(Map<String, Object> params);
		
		@SelectProvider(type=CarDynaSqlProvider.class,method="count")
		Integer count(Map<String, Object> params);
		
		@Select("select * from "+CARTABLE+" ")
		List<Car> selectAllCar();
		
		@Select("select * from "+CARTABLE+" where ID = #{id}")
		Car selectById(int id);

		@Delete(" delete from "+CARTABLE+" where id = #{id} ")
		void deleteById(Integer id);
		
		@SelectProvider(type=CarDynaSqlProvider.class,method="insertCar")
		void save(Car car);
		
		@SelectProvider(type=CarDynaSqlProvider.class,method="updateCar")
		void update(Car car);

}
