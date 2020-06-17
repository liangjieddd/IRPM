package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.PROPTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.Prop;

public class PropDynaSqlProvider {
	
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(PROPTABLE);
				if(params.get("prop") != null){
					Prop prop = (Prop)params.get("prop");
					if(prop.getHouse() != null && prop.getHouse().getId() != null && prop.getHouse().getId() != 0){
						WHERE(" HOUSE_ID = #{prop.house.id} ");
					}
					if(prop.getPrice()!= 0.0f){
						WHERE("  price LIKE CONCAT ('%',#{prop.price},'%') ");
					}
					if(prop.getValue()!= 0.0f){
						WHERE("  value LIKE CONCAT ('%',#{prop.value},'%') ");
					}
					if(prop.getMon()!= null && !prop.getMon().equals("")){
						WHERE("  mon LIKE CONCAT ('%',#{prop.mon},'%') ");
					}
					if(prop.getStatus()!= null && !prop.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{prop.status},'%') ");
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
				FROM(PROPTABLE);
				if(params.get("prop") != null){
					Prop prop = (Prop)params.get("prop");
					if(prop.getHouse()!= null && prop.getHouse().getId() != null && prop.getHouse().getId() != 0){
						WHERE(" HOUSE_ID = #{prop.house.id} ");
					}
					if(prop.getPrice()!= 0.0f){
						WHERE("  price LIKE CONCAT ('%',#{prop.price},'%') ");
					}
					if(prop.getValue()!= 0.0f){
						WHERE("  value LIKE CONCAT ('%',#{prop.value},'%') ");
					}
					if(prop.getMon()!= null && !prop.getMon().equals("")){
						WHERE("  mon LIKE CONCAT ('%',#{prop.mon},'%') ");
					}
					if(prop.getStatus()!= null && !prop.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{prop.status},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertProp(Prop prop){
		
		return new SQL(){
			{
				INSERT_INTO(PROPTABLE);
				if(prop.getPrice()!= 0.0f){
					VALUES("price", "#{price}");
				}
				if(prop.getValue()!= 0.0f){
					VALUES("value", "#{value}");
				}
				if(prop.getMon()!= null && !prop.getMon().equals("")){
					VALUES("mon", "#{mon}");
				}
				if(prop.getStatus()!= null && !prop.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(prop.getHouse()!= null && prop.getHouse().getId() != null){
					VALUES("house_id", "#{house.id}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updateProp(Prop prop){
		
		return new SQL(){
			{
				UPDATE(PROPTABLE);
				if(prop.getPrice() != 0.0f){
					SET(" price = #{price} ");
				}
				if(prop.getValue() != 0.0f){
					SET(" value = #{value} ");
				}
				if(prop.getMon()!= null && !prop.getMon().equals("")){
					SET(" mon = #{mon} ");
				}
				if(prop.getStatus()!= null && !prop.getStatus().equals("")){
					SET(" status = #{status} ");
				}
				if(prop.getHouse()!= null && prop.getHouse().getId() != null){
					SET(" house_id = #{house.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
