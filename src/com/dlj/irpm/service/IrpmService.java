package com.dlj.irpm.service;

import java.util.List;

import com.dlj.irpm.domain.Car;
import com.dlj.irpm.domain.Complain;
import com.dlj.irpm.domain.Elec;
import com.dlj.irpm.domain.House;
import com.dlj.irpm.domain.Pet;
import com.dlj.irpm.domain.PetInf;
import com.dlj.irpm.domain.Prop;
import com.dlj.irpm.domain.Repair;
import com.dlj.irpm.domain.User;
import com.dlj.irpm.domain.UserInfo;
import com.dlj.irpm.domain.Water;
import com.dlj.irpm.util.tag.PageModel;

public interface IrpmService {


	/************************ 用户管理 *************************/

	User login(String loginname, String password,String housename);

	User findUserById(Integer id);

	List<User> findUser(User user, PageModel pageModel);

	void removeUserById(Integer id);

	void modifyUser(User user);

	void addUser(User user);

	
	/************************ 用户信息管理 *************************/

	List<UserInfo> findUserInfo(UserInfo userinfo, PageModel pageModel);

	void removeUserInfoById(Integer id);

	UserInfo findUserInfoById(Integer id);

	UserInfo findUserInfoByUserName(String username);
	
	void addUserInfo(UserInfo userinfo);

	void modifyUserInfo(UserInfo userinfo);
	
	/************************车位管理*************************/

	List<Car> findCar(Car car, PageModel pageModel);

	List<Car> findAllCar();

	public void removeCarById(Integer id);

	void addCar(Car car);

	Car findCarById(Integer id);

	void modifyCar(Car car);

	/************************房产管理*************************/

	List<House> findAllHouse();

	List<House> findHouse(House house, PageModel pageModel);

	public void removeHouseById(Integer id);

	void addHouse(House house);

	House findHouseById(Integer id);

	void modifyHouse(House house);

	/************************报修管理*************************/
	List<Repair> findRepair(Repair repair, PageModel pageModel);

	Repair findRepairById(Integer id);

	List<Repair> findRepairByUserId(Integer userid);
	public void removeRepairById(Integer id);

	void addRepair(Repair repair);

	void modifyRepair(Repair repair);

	/************************投诉管理*************************/
	
	List<Complain> findComplain(Complain complain, PageModel pageModel);

	Complain findComplainById(Integer id);

	List<Complain> findComplainByUserId(Integer userid);
	public void removeComplainById(Integer id);

	void addComplain(Complain complain);

	void modifyComplain(Complain complain);

	/************************水费管理*************************/
	
	List<Water> findWater(Water water,PageModel pageModel);
	
	Water findWaterById(Integer id);
	
	List<Water> findWaterByHouse(String housename);

	public void removeWaterById(Integer id);

	void addWater(Water water);

	void modifyWater(Water water);


	/************************物业费管理*************************/
	
	List<Prop> findProp(Prop prop,PageModel pageModel);
	
	Prop findPropById(Integer id);
	
	List<Prop> findPropByHouse(String housename);
	
	public void removePropById(Integer id);

	void addProp(Prop prop);

	void modifyProp(Prop prop);


	/************************宠物费管理*************************/
	
	List<Pet> findPet(Pet pet,PageModel pageModel);
	
	Pet findPetById(Integer id);
	
	List<Pet> findPetByHouse(String housename);
	
	public void removePetById(Integer id);

	void addPet(Pet pet);

	void modifyPet(Pet pet);

	/************************电费管理*************************/
	
	List<Elec> findElec(Elec elec,PageModel pageModel);
	
	Elec findElecById(Integer id);
	
	List<Elec> findElecByHouse(String housename);
	
	public void removeElecById(Integer id);

	void addElec(Elec elec);

	void modifyElec(Elec elec);

	/************************宠物信息管理*************************/
	
	List<PetInf> findPetInf(PetInf petinf,PageModel pageModel);
	
	void addPetInf(PetInf petinf);
	
	PetInf findPetInfById(Integer id);
	
	List<PetInf> findPetInfByUserId(Integer userid);
	
	public void removePetInfById(Integer id);

	void modifyPetInf(PetInf petinf);
}
