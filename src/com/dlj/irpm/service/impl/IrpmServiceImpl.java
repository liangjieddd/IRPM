package com.dlj.irpm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dlj.irpm.dao.CarDao;
import com.dlj.irpm.dao.ComplainDao;
import com.dlj.irpm.dao.ElecDao;
import com.dlj.irpm.dao.HouseDao;
import com.dlj.irpm.dao.PetDao;
import com.dlj.irpm.dao.PetInfDao;
import com.dlj.irpm.dao.PropDao;
import com.dlj.irpm.dao.RepairDao;
import com.dlj.irpm.dao.UserDao;
import com.dlj.irpm.dao.UserInfoDao;
import com.dlj.irpm.dao.WaterDao;
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

import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.tag.PageModel;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("hrmService")
public class IrpmServiceImpl implements IrpmService{

	/**
	 * 自动注入持久层Dao对象
	 * */
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private UserInfoDao userinfoDao;
	
	@Autowired
	private HouseDao houseDao;
	
	@Autowired
	private RepairDao repairDao;
	
	@Autowired
	private ComplainDao complainDao;
	
	@Autowired
	private WaterDao waterDao;
	
	@Autowired
	private PropDao propDao;
	
	@Autowired
	private PetDao petDao;
	
	@Autowired
	private ElecDao elecDao;
	
	@Autowired
	private PetInfDao petinfDao;
	
	
	
	/************************用户管理*************************/
	
	@Transactional(readOnly=true)
	@Override
	public User login(String loginname, String password,String housename) {
		return userDao.selectByLoginnameAndPassword(loginname, password,housename);
	}

	@Transactional(readOnly=true)
	@Override
	public List<User> findUser(User user,PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("user", user);
		int recordCount = userDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<User> users = userDao.selectByPage(params);
		 
		return users;
	}
	
	@Transactional(readOnly=true)
	@Override
	public User findUserById(Integer id) {
		return userDao.selectById(id);
	}
	
	@Override
	public void removeUserById(Integer id) {
		userDao.deleteById(id);
	}
	
	@Override
	public void modifyUser(User user) {
		userDao.update(user);
	}
	
	@Override
	public void addUser(User user) {
		userDao.save(user);
	}
	
	

	/*****************部门服务接口实现*************************************/
	@Transactional(readOnly=true)
	@Override
	public List<Car> findAllCar() {
		return carDao.selectAllCar();
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Car> findCar(Car car,PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("car", car);
		int recordCount = carDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Car> cars = carDao.selectByPage(params);
		return cars;
	}
	
	@Override
	public void removeCarById(Integer id) {
		carDao.deleteById(id);
	}

	@Override
	public void addCar(Car car) {
		carDao.save(car);
	}
	
	@Override
	public Car findCarById(Integer id) {		
		return carDao.selectById(id);
	}
	
	@Override
	public void modifyCar(Car car) {
		carDao.update(car);
	}
	
	
	/************************用户信息管理*************************/

	@Transactional(readOnly=true)
	@Override
	public List<UserInfo> findUserInfo(UserInfo userinfo,PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("userinfo", userinfo);
		int recordCount = userinfoDao.count(params);
	    pageModel.setRecordCount(recordCount);
	    if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
	    List<UserInfo> userinfos = userinfoDao.selectByPage(params);
	    return userinfos;
	}

	
	@Override
	public void removeUserInfoById(Integer id) {
		userinfoDao.deleteById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public UserInfo findUserInfoById(Integer id) {
		return userinfoDao.selectById(id);
	}
		
	@Transactional(readOnly=true)
	@Override
	public UserInfo findUserInfoByUserName(String username) {
		return userinfoDao.selectByUserName(username);
	}
	
	
	@Override
	public void addUserInfo(UserInfo userinfo) {
		userinfoDao.save(userinfo);
	}
	
	@Override
	public void modifyUserInfo(UserInfo userinfo) {
		userinfoDao.update(userinfo);
	}
	
	
	/************************房产管理*************************/
	
	@Transactional(readOnly=true)
	@Override
	public List<House> findAllHouse() {
		return houseDao.selectAllHouse();
	}

	@Transactional(readOnly=true)
	@Override
	public List<House> findHouse(House house, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("house", house);
		int recordCount = houseDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<House> houses = houseDao.selectByPage(params);
		return houses;
	}
	
	@Override
	public void removeHouseById(Integer id) {
		houseDao.deleteById(id);
	}
	
	@Override
	public void addHouse(House house) {
		houseDao.save(house);
	}
	
	@Transactional(readOnly=true)
	@Override
	public House findHouseById(Integer id) {
		return houseDao.selectById(id);
	}
	
	@Override
	public void modifyHouse(House house) {
		houseDao.update(house);
	}
	
	
	/************************报修管理*************************/

	@Transactional(readOnly=true)
	@Override
	public List<Repair> findRepair(Repair repair, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("repair", repair);
		int recordCount = repairDao.count(params);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Repair> repairs = repairDao.selectByPage(params);
		 
		return repairs;
	}


	@Transactional(readOnly=true)
	@Override
	public Repair findRepairById(Integer id) {
		return repairDao.selectById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Repair> findRepairByUserId(Integer userid) {
		return repairDao.selectByUserId(userid);
	}

	@Override
	public void removeRepairById(Integer id) {
		repairDao.deleteById(id);
	}
	
	@Override
	public void addRepair(Repair repair) {
		repairDao.save(repair);
	}
	
	@Override
	public void modifyRepair(Repair repair) {
		repairDao.update(repair);
	}

	
	/************************投诉管理*************************/
	
	@Transactional(readOnly=true)
	@Override
	public List<Complain> findComplain(Complain complain, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("complain", complain);
		int recordCount = complainDao.count(params);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Complain> complains = complainDao.selectByPage(params);
		 
		return complains;
	}

	@Transactional(readOnly=true)
	@Override
	public Complain findComplainById(Integer id) {
		return complainDao.selectById(id);
	}

	
	@Transactional(readOnly=true)
	@Override
	public List<Complain> findComplainByUserId(Integer userid) {
		return complainDao.selectByUserId(userid);
	}
	@Override
	public void removeComplainById(Integer id) {
		complainDao.deleteById(id);
	}
	
	@Override
	public void addComplain(Complain complain) {
		complainDao.save(complain);
	}
	
	@Override
	public void modifyComplain(Complain complain) {
		complainDao.update(complain);
	}
	

	/************************水费管理*************************/

	@Transactional(readOnly=true)
	@Override
	public List<Water> findWater(Water water, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("water", water);
		int recordCount = waterDao.count(params);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Water> waters = waterDao.selectByPage(params);
		 
		return waters;
	}

	@Transactional(readOnly=true)
	@Override
	public Water findWaterById(Integer id) {
		return waterDao.selectById(id);
	}
	
	
	@Transactional(readOnly=true)
	@Override
	public List<Water> findWaterByHouse(String housename) {
		return waterDao.selectByHouse(housename);
	}

	@Override
	public void removeWaterById(Integer id) {
		waterDao.deleteById(id);
	}
	
	@Override
	public void addWater(Water water) {
		waterDao.save(water);
	}
	
	@Override
	public void modifyWater(Water water) {
		waterDao.update(water);
	}
	
	
	/************************物业费管理*************************/
	
	@Transactional(readOnly=true)
	@Override
	public List<Prop> findProp(Prop prop, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("prop", prop);
		int recordCount = propDao.count(params);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Prop> props = propDao.selectByPage(params);
		 
		return props;
	}

	@Transactional(readOnly=true)
	@Override
	public Prop findPropById(Integer id) {
		return propDao.selectById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Prop> findPropByHouse(String housename) {
		return propDao.selectByHouse(housename);
	}

	@Override
	public void removePropById(Integer id) {
		propDao.deleteById(id);
	}
	
	@Override
	public void addProp(Prop prop) {
		propDao.save(prop);
	}
	
	@Override
	public void modifyProp(Prop prop) {
		propDao.update(prop);
	}
	
	
	/************************宠物费管理*************************/
	
	@Transactional(readOnly=true)
	@Override
	public List<Pet> findPet(Pet pet, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("pet", pet);
		int recordCount = petDao.count(params);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Pet> pets = petDao.selectByPage(params);
		 
		return pets;
	}

	@Transactional(readOnly=true)
	@Override
	public Pet findPetById(Integer id) {
		return petDao.selectById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Pet> findPetByHouse(String housename) {
		return petDao.selectByHouse(housename);
	}

	@Override
	public void removePetById(Integer id) {
		petDao.deleteById(id);
	}
	
	@Override
	public void addPet(Pet pet) {
		petDao.save(pet);
	}
	
	@Override
	public void modifyPet(Pet pet) {
		petDao.update(pet);
	}
	
	
	/************************电费管理*************************/
	
	@Transactional(readOnly=true)
	@Override
	public List<Elec> findElec(Elec elec, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("elec", elec);
		int recordCount = elecDao.count(params);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<Elec> elecs = elecDao.selectByPage(params);
		 
		return elecs;
	}

	@Transactional(readOnly=true)
	@Override
	public Elec findElecById(Integer id) {
		return elecDao.selectById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Elec> findElecByHouse(String housename) {
		return elecDao.selectByHouse(housename);
	}
	@Override
	public void removeElecById(Integer id) {
		elecDao.deleteById(id);
	}
	
	@Override
	public void addElec(Elec elec) {
		elecDao.save(elec);
	}
	
	@Override
	public void modifyElec(Elec elec) {
		elecDao.update(elec);
	}
	

	/************************宠物信息管理*************************/

	@Transactional(readOnly=true)
	@Override
	public List<PetInf> findPetInf(PetInf petinf, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("petinf", petinf);
		int recordCount = petinfDao.count(params);
		pageModel.setRecordCount(recordCount);
		
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		
		List<PetInf> petinfs = petinfDao.selectByPage(params);
		 
		return petinfs;
	}

	@Override
	public void addPetInf(PetInf petinf) {
		petinfDao.save(petinf);
	}

	
	@Override
	public void removePetInfById(Integer id) {
		petinfDao.deleteById(id);
	}

	@Override
	public void modifyPetInf(PetInf petinf) {
		petinfDao.update(petinf);
	}

	@Transactional(readOnly=true)
	@Override
	public PetInf findPetInfById(Integer id) {
		return petinfDao.selectById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<PetInf> findPetInfByUserId(Integer userid) {
		return petinfDao.selectByUserId(userid);
	}
	
}
