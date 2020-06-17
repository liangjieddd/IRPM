package com.dlj.irpm.dao.provider;

import static com.dlj.irpm.util.common.IrpmConstants.USERINFOTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.dlj.irpm.domain.UserInfo;;

public class UserInfoDynaSqlProvider {
	
	// 分页动态查询
		public String selectWhitParam(Map<String, Object> params){
			String sql =  new SQL(){
				{
					SELECT("*");
					FROM(USERINFOTABLE);
					if(params.get("userinfo") != null){
						UserInfo userinfo = (UserInfo)params.get("userinfo");
						if(userinfo.getCar() != null && userinfo.getCar().getId() != null && userinfo.getCar().getId() != 0){
							WHERE(" CAR_ID = #{userinfo.car.id} ");
						}
						if(userinfo.getHouse()!= null && userinfo.getHouse().getId() != null && userinfo.getHouse().getId() != 0){
							WHERE(" HOUSE_ID = #{userinfo.house.id} ");
						}
						if(userinfo.getName() != null && !userinfo.getName().equals("")){
							WHERE("  NAME LIKE CONCAT ('%',#{userinfo.name},'%') ");
						}
						if(userinfo.getPhone() != null && !userinfo.getPhone().equals("")){
							WHERE(" phone LIKE CONCAT ('%',#{userinfo.phone},'%') ");
						}
						if(userinfo.getCardId() != null && !userinfo.getCardId().equals("") ){
							WHERE(" card_id LIKE CONCAT ('%',#{userinfo.cardId},'%') ");
						}
						if(userinfo.getSex()!= null && userinfo.getSex() != 0){
							WHERE("sex = #{userinfo.sex}");
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
					FROM(USERINFOTABLE);
					if(params.get("userinfo") != null){
						UserInfo userinfo = (UserInfo)params.get("userinfo");
						if(userinfo.getCar()!= null && userinfo.getCar().getId() != null && userinfo.getCar().getId() != 0){
							WHERE(" CAR_ID = #{userinfo.car.id} ");
						}
						if(userinfo.getHouse()!= null && userinfo.getHouse().getId() != null && userinfo.getHouse().getId() != 0){
							WHERE(" HOUSE_ID = #{userinfo.house.id} ");
						}
						if(userinfo.getName() != null && !userinfo.getName().equals("")){
							WHERE("  NAME LIKE CONCAT ('%',#{userinfo.name},'%') ");
						}
						if(userinfo.getPhone() != null && !userinfo.getPhone().equals("")){
							WHERE(" phone LIKE CONCAT ('%',#{userinfo.phone},'%') ");
						}
						if(userinfo.getCardId() != null && !userinfo.getCardId().equals("") ){
							WHERE(" card_id LIKE CONCAT ('%',#{userinfo.cardId},'%') ");
						}
						if(userinfo.getSex()!= null && userinfo.getSex() != 0){
							WHERE("sex = #{userinfo.sex}");
						}
					}
				}
			}.toString();
		}	
		
		// 动态插入
		public String insertUserInfo(UserInfo userinfo){
			
			return new SQL(){
				{
					INSERT_INTO(USERINFOTABLE);
					if(userinfo.getName() != null){
						VALUES("name", "#{name}");
					}
					if(userinfo.getCardId() != null){
						VALUES("card_id", "#{cardId}");
					}
					if(userinfo.getAddress()!= null){
						VALUES("address", "#{address}");
					}
					if(userinfo.getPostCode()!= null){
						VALUES("post_code", "#{postCode}");
					}
					if(userinfo.getTel()!= null){
						VALUES("tel", "#{tel}");
					}
					if(userinfo.getPhone()!= null){
						VALUES("phone", "#{phone}");
					}
					if(userinfo.getQqNum()!= null){
						VALUES("qq_num", "#{qqNum}");
					}
					if(userinfo.getEmail()!= null){
						VALUES("email", "#{email}");
					}
					if(userinfo.getSex()!= null){
						VALUES("sex", "#{sex}");
					}
					if(userinfo.getParty()!= null){
						VALUES("party", "#{party}");
					}
					if(userinfo.getBirthday()!= null){
						VALUES("birthday", "#{birthday}");
					}
					if(userinfo.getRace()!= null){
						VALUES("race", "#{race}");
					}
					if(userinfo.getEducation()!= null){
						VALUES("education", "#{education}");
					}
					if(userinfo.getSpeciality()!= null){
						VALUES("speciality", "#{speciality}");
					}
					if(userinfo.getHobby()!= null){
						VALUES("hobby", "#{hobby}");
					}
					if(userinfo.getRemark()!= null){
						VALUES("remark", "#{remark}");
					}
					if(userinfo.getCreateDate()!= null){
						VALUES("create_Date", "#{createDate}");
					}
					if(userinfo.getCar()!= null){
						VALUES("car_id", "#{car.id}");
					}
					if(userinfo.getHouse()!= null){
						VALUES("house_id", "#{house.id}");
					}
				}
			}.toString();
		}
		// 动态更新
		public String updateUserInfo(UserInfo userinfo){
			
			return new SQL(){
				{
					UPDATE(USERINFOTABLE);
					if(userinfo.getName() != null){
						SET(" name = #{name} ");
					}
					if(userinfo.getCardId() != null){
						SET(" card_id = #{cardId} ");
					}
					if(userinfo.getAddress()!= null){
						SET(" address = #{address} ");
					}
					if(userinfo.getPostCode()!= null){
						SET(" post_code = #{postCode} ");
					}
					if(userinfo.getTel()!= null){
						SET(" tel = #{tel} ");
					}
					if(userinfo.getPhone()!= null){
						SET(" phone = #{phone} ");
					}
					if(userinfo.getQqNum()!= null){
						SET(" qq_num = #{qqNum} ");
					}
					if(userinfo.getEmail()!= null){
						SET(" email = #{email} ");
					}
					if(userinfo.getSex()!= null){
						SET(" sex = #{sex} ");
					}
					if(userinfo.getParty()!= null){
						SET(" party = #{party} ");
					}
					if(userinfo.getBirthday()!= null){
						SET(" birthday = #{birthday} ");
					}
					if(userinfo.getRace()!= null){
						SET(" race = #{race} ");
					}
					if(userinfo.getEducation()!= null){
						SET(" education = #{education} ");
					}
					if(userinfo.getSpeciality()!= null){
						SET(" speciality = #{speciality} ");
					}
					if(userinfo.getHobby()!= null){
						SET(" hobby = #{hobby} ");
					}
					if(userinfo.getRemark()!= null){
						SET(" remark = #{remark} ");
					}
					if(userinfo.getCreateDate()!= null){
						SET(" create_Date = #{createDate} ");
					}
					if(userinfo.getCar()!= null){
						SET(" car_id = #{car.id} ");
					}
					if(userinfo.getHouse()!= null){
						SET(" house_id = #{house.id} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}


	}
