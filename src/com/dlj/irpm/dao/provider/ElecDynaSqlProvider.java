package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.ELECTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.Elec;

public class ElecDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(ELECTABLE);
				if(params.get("elec") != null){
					Elec elec = (Elec)params.get("elec");
					if(elec.getHouse() != null && elec.getHouse().getId() != null && elec.getHouse().getId() != 0){
						WHERE(" HOUSE_ID = #{elec.house.id} ");
					}
					if(elec.getConsumption()!= 0.0f){
						WHERE("  consumption LIKE CONCAT ('%',#{elec.consumption},'%') ");
					}
					if(elec.getPrice()!= 0.0f){
						WHERE("  price LIKE CONCAT ('%',#{elec.price},'%') ");
					}
					if(elec.getValue()!= 0.0f){
						WHERE("  value LIKE CONCAT ('%',#{elec.value},'%') ");
					}
					if(elec.getMon()!= null && !elec.getMon().equals("")){
						WHERE("  mon LIKE CONCAT ('%',#{elec.mon},'%') ");
					}
					if(elec.getStatus()!= null && !elec.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{elec.status},'%') ");
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
				FROM(ELECTABLE);
				if(params.get("elec") != null){
					Elec elec = (Elec)params.get("elec");
					if(elec.getHouse()!= null && elec.getHouse().getId() != null && elec.getHouse().getId() != 0){
						WHERE(" HOUSE_ID = #{elec.house.id} ");
					}
					if(elec.getConsumption()!= 0.0f){
						WHERE("  consumption LIKE CONCAT ('%',#{elec.consumption},'%') ");
					}
					if(elec.getPrice()!= 0.0f){
						WHERE("  price LIKE CONCAT ('%',#{elec.price},'%') ");
					}
					if(elec.getValue()!= 0.0f){
						WHERE("  value LIKE CONCAT ('%',#{elec.value},'%') ");
					}
					if(elec.getMon()!= null && !elec.getMon().equals("")){
						WHERE("  mon LIKE CONCAT ('%',#{elec.mon},'%') ");
					}
					if(elec.getStatus()!= null && !elec.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{elec.status},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertElec(Elec elec){
		
		return new SQL(){
			{
				INSERT_INTO(ELECTABLE);
				if(elec.getConsumption()!= 0.0f){
					VALUES("consumption", "#{consumption}");
				}
				if(elec.getPrice()!= 0.0f){
					VALUES("price", "#{price}");
				}
				if(elec.getValue()!= 0.0f){
					VALUES("value", "#{value}");
				}
				if(elec.getMon()!= null && !elec.getMon().equals("")){
					VALUES("mon", "#{mon}");
				}
				if(elec.getStatus()!= null && !elec.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(elec.getHouse()!= null && elec.getHouse().getId() != null){
					VALUES("house_id", "#{house.id}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updateElec(Elec elec){
		
		return new SQL(){
			{
				UPDATE(ELECTABLE);
				if(elec.getConsumption() != 0.0f){
					SET(" consumption = #{consumption} ");
				}
				if(elec.getPrice() != 0.0f){
					SET(" price = #{price} ");
				}
				if(elec.getValue() != 0.0f){
					SET(" value = #{value} ");
				}
				if(elec.getMon()!= null && !elec.getMon().equals("")){
					SET(" mon = #{mon} ");
				}
				if(elec.getStatus()!= null && !elec.getStatus().equals("")){
					SET(" status = #{status} ");
				}
				if(elec.getHouse()!= null && elec.getHouse().getId() != null){
					SET(" house_id = #{house.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
