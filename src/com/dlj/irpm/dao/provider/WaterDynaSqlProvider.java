package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.WATERTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.Water;

public class WaterDynaSqlProvider {
	
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(WATERTABLE);
				if(params.get("water") != null){
					Water water = (Water)params.get("water");
					if(water.getHouse() != null && water.getHouse().getId() != null && water.getHouse().getId() != 0){
						WHERE(" HOUSE_ID = #{water.house.id} ");
					}
					if(water.getConsumption()!= 0.0f){
						WHERE("  consumption LIKE CONCAT ('%',#{water.consumption},'%') ");
					}
					if(water.getPrice()!= 0.0f){
						WHERE("  price LIKE CONCAT ('%',#{water.price},'%') ");
					}
					if(water.getValue()!= 0.0f){
						WHERE("  value LIKE CONCAT ('%',#{water.value},'%') ");
					}
					if(water.getMon()!= null && !water.getMon().equals("")){
						WHERE("  mon LIKE CONCAT ('%',#{water.mon},'%') ");
					}
					if(water.getStatus()!= null && !water.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{water.status},'%') ");
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
				FROM(WATERTABLE);
				if(params.get("water") != null){
					Water water = (Water)params.get("water");
					if(water.getHouse()!= null && water.getHouse().getId() != null && water.getHouse().getId() != 0){
						WHERE(" HOUSE_ID = #{water.house.id} ");
					}
					if(water.getConsumption()!= 0.0f){
						WHERE("  consumption LIKE CONCAT ('%',#{water.consumption},'%') ");
					}
					if(water.getPrice()!= 0.0f){
						WHERE("  price LIKE CONCAT ('%',#{water.price},'%') ");
					}
					if(water.getValue()!= 0.0f){
						WHERE("  value LIKE CONCAT ('%',#{water.value},'%') ");
					}
					if(water.getMon()!= null && !water.getMon().equals("")){
						WHERE("  mon LIKE CONCAT ('%',#{water.mon},'%') ");
					}
					if(water.getStatus()!= null && !water.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{water.status},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertWater(Water water){
		
		return new SQL(){
			{
				INSERT_INTO(WATERTABLE);
				if(water.getConsumption()!= 0.0f){
					VALUES("consumption", "#{consumption}");
				}
				if(water.getPrice()!= 0.0f){
					VALUES("price", "#{price}");
				}
				if(water.getValue()!= 0.0f){
					VALUES("value", "#{value}");
				}
				if(water.getMon()!= null && !water.getMon().equals("")){
					VALUES("mon", "#{mon}");
				}
				if(water.getStatus()!= null && !water.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(water.getHouse()!= null && water.getHouse().getId() != null){
					VALUES("house_id", "#{house.id}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updateWater(Water water){
		
		return new SQL(){
			{
				UPDATE(WATERTABLE);
				if(water.getConsumption() != 0.0f){
					SET(" consumption = #{consumption} ");
				}
				if(water.getPrice() != 0.0f){
					SET(" price = #{price} ");
				}
				if(water.getValue() != 0.0f){
					SET(" value = #{value} ");
				}
				if(water.getMon()!= null && !water.getMon().equals("")){
					SET(" mon = #{mon} ");
				}
				if(water.getStatus()!= null && !water.getStatus().equals("")){
					SET(" status = #{status} ");
				}
				if(water.getHouse()!= null && water.getHouse().getId() != null){
					SET(" house_id = #{house.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
