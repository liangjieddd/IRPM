package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.PETINFTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.PetInf;

public class PetInfDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(PETINFTABLE);
				if(params.get("petinf") != null){
					PetInf petinf = (PetInf) params.get("petinf");
					if(petinf.getName() != null && !petinf.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{petinf.name},'%') ");
					}
					if(petinf.getKind()!= null && !petinf.getKind().equals("")){
						WHERE("  kind LIKE CONCAT ('%',#{petinf.kind},'%') ");
					}
					if(petinf.getStatus() != null && !petinf.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{petinf.status},'%') ");
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
				FROM(PETINFTABLE);
				if(params.get("petinf") != null){
					PetInf petinf = (PetInf) params.get("petinf");
					if(petinf.getName()!= null && !petinf.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{petinf.name},'%') ");
					}
					if(petinf.getKind()!= null && !petinf.getKind().equals("")){
						WHERE("  kind LIKE CONCAT ('%',#{petinf.kind},'%') ");
					}
					if(petinf.getStatus()!= null && !petinf.getStatus().equals("")){
						WHERE("  status LIKE CONCAT ('%',#{petinf.status},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertPetInf(PetInf petinf){
		
		return new SQL(){
			{
				INSERT_INTO(PETINFTABLE);
				if(petinf.getName() != null && !petinf.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(petinf.getFileName() != null && !petinf.getFileName().equals("")){
					VALUES("filename", "#{fileName}");
				}
				if(petinf.getKind() != null && !petinf.getKind().equals("")){
					VALUES("kind", "#{kind}");
				}
				if(petinf.getStatus() != null && !petinf.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(petinf.getUser() != null && petinf.getUser().getId() != null){
					VALUES("user_id", "#{user.id}");
				}
			}
		}.toString();
	}
	
	// 动态更新
	public String updatePetInf(PetInf petinf){
		
		return new SQL(){
			{
				UPDATE(PETINFTABLE);
				if(petinf.getName() != null && !petinf.getName().equals("")){
					SET(" name = #{name} ");
				}
				if(petinf.getFileName() != null && !petinf.getFileName().equals("")){
					SET(" filename = #{fileName} ");
				}
				if(petinf.getKind() != null && !petinf.getKind().equals("")){
					SET("kind = #{kind}");
				}
				if(petinf.getStatus() != null && !petinf.getStatus().equals("")){
					SET("status = #{status}");
				}
				if(petinf.getUser() != null && petinf.getUser().getId() != null){
					SET("user_id = #{user.id}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	

}
