package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.HOUSETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.House;

public class HouseDynaSqlProvider {
	
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(HOUSETABLE);
				if(params.get("house") != null){
					House house = (House) params.get("house");
					if(house.getName() != null && !house.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{house.name},'%') ");
					}
					if(house.getArea()!= 0.0f){
						WHERE("  area = #{house.area} ");
					}
					if(house.getValue()!= 0.0f){
						WHERE("  value = #{house.value} ");
					}
					if(house.getStatus()!= null && !house.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{house.status},'%') ");
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
				FROM(HOUSETABLE);
				if(params.get("house") != null){
					House house = (House) params.get("house");
					if(house.getName() != null && !house.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{house.name},'%') ");
					}
					if(house.getArea() != 0.0f){
						WHERE("  area = #{house.area} ");
					}
					if(house.getValue()!= 0.0f){
						WHERE("  value = #{house.value} ");
					}
					if(house.getStatus()!= null && !house.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{house.status},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertHouse(House house){
		
		return new SQL(){
			{
				INSERT_INTO(HOUSETABLE);
				if(house.getName() != null && !house.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(house.getArea() != 0.0f){
					VALUES("area", "#{area}");
				}
				if(house.getValue()!=0.0f){
					VALUES("value", "#{value}");
				}
				if(house.getStatus()!= null && !house.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updateHouse(House house){
		
		return new SQL(){
			{
				UPDATE(HOUSETABLE);
				if(house.getName() != null){
					SET(" name = #{name} ");
				}
				if(house.getArea() != 0.0f){
					SET(" area = #{area} ");
				}
				if(house.getValue() != 0.0f){
					SET(" value = #{value} ");
				}
				
				if(house.getStatus() != null){
					SET(" status = #{status} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
	
}
