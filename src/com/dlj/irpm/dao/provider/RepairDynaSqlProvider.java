package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.REPAIRTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.Repair;

public class RepairDynaSqlProvider {
	
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(REPAIRTABLE);
				if(params.get("repair") != null){
					Repair repair = (Repair)params.get("repair");
					if(repair.getTitle() != null && !repair.getTitle().equals("")){
						WHERE("  title LIKE CONCAT ('%',#{repair.title},'%') ");
					}
					if(repair.getContent() != null && !repair.getContent().equals("")){
						WHERE("  content LIKE CONCAT ('%',#{repair.content},'%') ");
					}
					if(repair.getUserphone()!= null && !repair.getUserphone().equals("")){
						WHERE("  userphone LIKE CONCAT ('%',#{repair.userphone},'%') ");
					}
					if(repair.getRepairername() != null && !repair.getRepairername().equals("")){
						WHERE("  repairername LIKE CONCAT ('%',#{repair.repairername},'%') ");
					}
					if(repair.getRepairerphone()!= null && !repair.getRepairerphone().equals("")){
						WHERE("  repairerphone LIKE CONCAT ('%',#{repair.repairerphone},'%') ");
					}
					if(repair.getReply()!= null && !repair.getReply().equals("")){
						WHERE("  reply LIKE CONCAT ('%',#{repair.reply},'%') ");
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
				FROM(REPAIRTABLE);
				if(params.get("repair") != null){
					Repair repair = (Repair)params.get("repair");
					if(repair.getTitle() != null && !repair.getTitle().equals("")){
						WHERE("  title LIKE CONCAT ('%',#{repair.title},'%') ");
					}
					if(repair.getContent() != null && !repair.getContent().equals("")){
						WHERE("  content LIKE CONCAT ('%',#{repair.content},'%') ");
					}
					if(repair.getUserphone()!= null && !repair.getUserphone().equals("")){
						WHERE("  userphone LIKE CONCAT ('%',#{repair.userphone},'%') ");
					}
					if(repair.getRepairername() != null && !repair.getRepairername().equals("")){
						WHERE("  repairername LIKE CONCAT ('%',#{repair.repairername},'%') ");
					}
					if(repair.getRepairerphone()!= null && !repair.getRepairerphone().equals("")){
						WHERE("  repairerphone LIKE CONCAT ('%',#{repair.repairerphone},'%') ");
					}
					if(repair.getReply()!= null && !repair.getReply().equals("")){
						WHERE("  reply LIKE CONCAT ('%',#{repair.reply},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertRepair(Repair repair){
		
		return new SQL(){
			{
				INSERT_INTO(REPAIRTABLE);
				if(repair.getTitle() != null && !repair.getTitle().equals("")){
					VALUES("title", "#{title}");
				}
				if(repair.getContent() != null && !repair.getContent().equals("")){
					VALUES("content", "#{content}");
				}
				if(repair.getUserphone()!= null && !repair.getUserphone().equals("")){
					VALUES("userphone", "#{userphone}");
				}
				if(repair.getRepairername() != null && !repair.getRepairername().equals("")){
					VALUES("repairername", "#{repairername}");
				}
				if(repair.getRepairerphone() != null && !repair.getRepairerphone().equals("")){
					VALUES("repairerphone", "#{repairerphone}");
				}
				if(repair.getReply() != null && !repair.getReply().equals("")){
					VALUES("reply", "#{reply}");
				}
				if(repair.getUser() != null && repair.getUser().getId() != null){
					VALUES("user_id", "#{user.id}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updateRepair(Repair repair){
		
		return new SQL(){
			{
				UPDATE(REPAIRTABLE);
				if(repair.getTitle() != null && !repair.getTitle().equals("")){
					SET(" title = #{title} ");
				}
				if(repair.getContent() != null && !repair.getContent().equals("")){
					SET(" content = #{content} ");
				}
				if(repair.getUserphone()!= null && !repair.getUserphone().equals("")){
					SET(" userphone = #{userphone} ");
				}
				if(repair.getRepairername() != null && !repair.getRepairername().equals("")){
					SET(" repairername = #{repairername} ");
				}
				if(repair.getRepairerphone() != null && !repair.getRepairerphone().equals("")){
					SET(" repairerphone = #{repairerphone} ");
				}
				if(repair.getReply() != null && !repair.getReply().equals("")){
					SET(" reply = #{reply} ");
				}
				if(repair.getUser() != null && repair.getUser().getId() != null){
					SET(" user_id = #{user.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
	
}
