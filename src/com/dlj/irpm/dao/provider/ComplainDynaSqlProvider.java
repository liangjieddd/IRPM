package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.COMPLAINTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.Complain;

public class ComplainDynaSqlProvider {
	// 分页动态查询
		public String selectWhitParam(Map<String, Object> params){
			String sql =  new SQL(){
				{
					SELECT("*");
					FROM(COMPLAINTABLE);
					if(params.get("complain") != null){
						Complain complain = (Complain)params.get("complain");
						if(complain.getTitle() != null && !complain.getTitle().equals("")){
							WHERE("  title LIKE CONCAT ('%',#{complain.title},'%') ");
						}
						if(complain.getContent() != null && !complain.getContent().equals("")){
							WHERE("  content LIKE CONCAT ('%',#{complain.content},'%') ");
						}
						if(complain.getReplay() != null && !complain.getReplay().equals("")){
							WHERE("  replay LIKE CONCAT ('%',#{complain.replay},'%') ");
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
					FROM(COMPLAINTABLE);
					if(params.get("complain") != null){
						Complain complain = (Complain)params.get("complain");
						if(complain.getTitle() != null && !complain.getTitle().equals("")){
							WHERE("  title LIKE CONCAT ('%',#{complain.title},'%') ");
						}
						if(complain.getContent() != null && !complain.getContent().equals("")){
							WHERE("  content LIKE CONCAT ('%',#{complain.content},'%') ");
						}
						if(complain.getReplay()!= null && !complain.getReplay().equals("")){
							WHERE("  replay LIKE CONCAT ('%',#{complain.replay},'%') ");
						}
					}
				}
			}.toString();
		}	
		// 动态插入
		public String insertComplain(Complain complain){
			
			return new SQL(){
				{
					INSERT_INTO(COMPLAINTABLE);
					if(complain.getTitle() != null && !complain.getTitle().equals("")){
						VALUES("title", "#{title}");
					}
					if(complain.getContent() != null && !complain.getContent().equals("")){
						VALUES("content", "#{content}");
					}
					if(complain.getReplay()!= null && !complain.getReplay().equals("")){
						VALUES("replay", "#{replay}");
					}
					if(complain.getUser() != null && complain.getUser().getId() != null){
						VALUES("user_id", "#{user.id}");
					}
				}
			}.toString();
		}
		// 动态更新
		public String updateComplain(Complain complain){
			
			return new SQL(){
				{
					UPDATE(COMPLAINTABLE);
					if(complain.getTitle() != null && !complain.getTitle().equals("")){
						SET(" title = #{title} ");
					}
					if(complain.getContent() != null && !complain.getContent().equals("")){
						SET(" content = #{content} ");
					}
					if(complain.getReplay()!= null && !complain.getReplay().equals("")){
						SET(" replay = #{replay} ");
					}
					if(complain.getUser() != null && complain.getUser().getId() != null){
						SET(" user_id = #{user.id} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
		
	}
