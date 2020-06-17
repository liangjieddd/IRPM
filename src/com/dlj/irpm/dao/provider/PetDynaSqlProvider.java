package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.PETTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.Pet;

public class PetDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(PETTABLE);
				if(params.get("pet") != null){
					Pet pet = (Pet)params.get("pet");
					if(pet.getHouse() != null && pet.getHouse().getId() != null && pet.getHouse().getId() != 0){
						WHERE(" HOUSE_ID = #{pet.house.id} ");
					}
					if(pet.getValue()!= 0.0f){
						WHERE("  value LIKE CONCAT ('%',#{pet.value},'%') ");
					}
					if(pet.getMon()!= null && !pet.getMon().equals("")){
						WHERE("  mon LIKE CONCAT ('%',#{pet.mon},'%') ");
					}
					if(pet.getStatus()!= null && !pet.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{pet.status},'%') ");
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
				FROM(PETTABLE);
				if(params.get("pet") != null){
					Pet pet = (Pet)params.get("pet");
					if(pet.getHouse()!= null && pet.getHouse().getId() != null && pet.getHouse().getId() != 0){
						WHERE(" HOUSE_ID = #{pet.house.id} ");
					}
					if(pet.getValue()!= 0.0f){
						WHERE("  value LIKE CONCAT ('%',#{pet.value},'%') ");
					}
					if(pet.getMon()!= null && !pet.getMon().equals("")){
						WHERE("  mon LIKE CONCAT ('%',#{pet.mon},'%') ");
					}
					if(pet.getStatus()!= null && !pet.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{pet.status},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertPet(Pet pet){
		
		return new SQL(){
			{
				INSERT_INTO(PETTABLE);
				if(pet.getValue()!= 0.0f){
					VALUES("value", "#{value}");
				}
				if(pet.getMon()!= null && !pet.getMon().equals("")){
					VALUES("mon", "#{mon}");
				}
				if(pet.getStatus()!= null && !pet.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(pet.getHouse()!= null && pet.getHouse().getId() != null){
					VALUES("house_id", "#{house.id}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updatePet(Pet pet){
		
		return new SQL(){
			{
				UPDATE(PETTABLE);
				if(pet.getValue() != 0.0f){
					SET(" value = #{value} ");
				}
				if(pet.getMon()!= null && !pet.getMon().equals("")){
					SET(" mon = #{mon} ");
				}
				if(pet.getStatus()!= null && !pet.getStatus().equals("")){
					SET(" status = #{status} ");
				}
				if(pet.getHouse()!= null && pet.getHouse().getId() != null){
					SET(" house_id = #{house.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
