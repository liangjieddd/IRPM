package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.CARTABLE;


import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.Car;

public class CarDynaSqlProvider {
	// 分页动态查询
		public String selectWhitParam(Map<String, Object> params){
			String sql =  new SQL(){
				{
					SELECT("*");
					FROM(CARTABLE);
					if(params.get("car") != null){
						Car car = (Car) params.get("car");
						if(car.getName() != null && !car.getName().equals("")){
							WHERE("  name LIKE CONCAT ('%',#{car.name},'%') ");
						}
						if(car.getStatus() != null && !car.getStatus().equals("")){
							WHERE("  status LIKE CONCAT ('%',#{car.status},'%') ");
						}
					}
				}
			}.toString();
			
			if(params.get("pageModel") != null){
				sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
			}
			
			return sql;
		}	
		// 动态查询总数量
		public String count(Map<String, Object> params){
			return new SQL(){
				{
					SELECT("count(*)");
					FROM(CARTABLE);
					if(params.get("car") != null){
						Car car = (Car) params.get("car");
						if(car.getName() != null && !car.getName().equals("")){
							WHERE("  name LIKE CONCAT ('%',#{car.name},'%') ");
						}
						if(car.getStatus() != null && !car.getStatus().equals("")){
							WHERE("  status LIKE CONCAT ('%',#{car.status},'%') ");
						}
					}
				}
			}.toString();
		}	
		// 动态插入
		public String insertCar(Car car){
			
			return new SQL(){
				{
					INSERT_INTO(CARTABLE);
					if(car.getName() != null && !car.getName().equals("")){
						VALUES("name", "#{name}");
					}
					if(car.getValue()!= 0.0f){
						VALUES("value", "#{value}");
					}
					if(car.getStatus() != null && !car.getStatus().equals("")){
						VALUES("status", "#{status}");
					}
					
				}
			}.toString();
		}
		// 动态更新
		public String updateCar(Car car){
			
			return new SQL(){
				{
					UPDATE(CARTABLE);
					if(car.getName() != null){
						SET(" name = #{name} ");
					}
					if(car.getValue()!= 0.0f){
						SET(" value = #{value} ");
					}
					if(car.getStatus() != null){
						SET(" status = #{status} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}


	}
