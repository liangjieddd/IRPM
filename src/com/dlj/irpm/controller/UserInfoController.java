package com.dlj.irpm.controller;

import java.util.List;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlj.irpm.domain.Car;


import com.dlj.irpm.domain.UserInfo;
import com.dlj.irpm.domain.House;

import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.tag.PageModel;

@Controller
public class UserInfoController {
	
	@Autowired
	@Qualifier("hrmService")
	private IrpmService irpmService;
			
	    
	@RequestMapping(value="/userinfo/selectUserInfo")
	 public String selectUserInfo(Integer pageIndex,
			 Integer house_id,Integer car_id,
			 @ModelAttribute UserInfo userinfo,
			 Model model){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(house_id, car_id, userinfo);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		List<House> houses = irpmService.findAllHouse();
		List<Car> cars = irpmService.findAllCar();
		List<UserInfo> userinfos = irpmService.findUserInfo(userinfo,pageModel);
		// 设置Model数据
		model.addAttribute("userinfos", userinfos);
		model.addAttribute("houses", houses);
		model.addAttribute("cars", cars);
		model.addAttribute("pageModel", pageModel);
		return "userinfo/userinfo";
		
	}
	
	
	@RequestMapping(value="/userinfo/addUserInfo")
	 public ModelAndView addUserInfo(
			 String flag,
			 Integer house_id,Integer car_id,
			 @ModelAttribute UserInfo userinfo,
			 ModelAndView mv){
		if(flag.equals("1")){
			List<House> houses = irpmService.findAllHouse();
			List<Car> cars = irpmService.findAllCar();
			// 设置Model数据
			mv.addObject("houses", houses);
			mv.addObject("cars", cars);
			mv.setViewName("userinfo/showAddUserInfo");
		}else{
			// 判断是否有关联对象传递，如果有，创建关联对象
			this.genericAssociation(house_id, car_id, userinfo);
			// 添加操作
			irpmService.addUserInfo(userinfo);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/userinfo/selectUserInfo");
		}
		// 返回
		return mv;
		
	}
	
	
	@RequestMapping(value="/userinfo/removeUserInfo")
	 public ModelAndView removeUserInfo(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			irpmService.removeUserInfoById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/userinfo/selectUserInfo");
		// 返回ModelAndView
		return mv;
	}
	
	
	@RequestMapping(value="/userinfo/updateUserInfo")
	 public ModelAndView updateUserInfo(
			 String flag,
			 Integer house_id,Integer car_id,
			 @ModelAttribute UserInfo userinfo,
			 ModelAndView mv){
		if(flag.equals("1")){
			UserInfo target = irpmService.findUserInfoByUserName(userinfo.getName());
			List<House> houses = irpmService.findAllHouse();
			List<Car> cars = irpmService.findAllCar();
			// 设置Model数据
			mv.addObject("houses", houses);
			mv.addObject("cars", cars);
			mv.addObject("userinfo", target);
			mv.setViewName("userinfo/showUpdateUserInfo");
		}else{
			// 创建并封装关联对象
			this.genericAssociation(house_id, car_id, userinfo);
			System.out.println("updateUserInfo -->> " + userinfo);
			// 执行修改操作
			irpmService.modifyUserInfo(userinfo);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/userinfo/selectUserInfo");
		}
		// 返回
		return mv;
	}
	
	
	@RequestMapping(value="/userinfo/showUserInfo")
	 public ModelAndView showUserInfo(
			 String flag,
			 Integer house_id,Integer car_id,
			 @ModelAttribute UserInfo userinfo,
			 ModelAndView mv){
		if(flag.equals("1")){
			UserInfo target = irpmService.findUserInfoByUserName(userinfo.getName());
			List<House> houses = irpmService.findAllHouse();
			List<Car> cars = irpmService.findAllCar();
			// 设置Model数据
			mv.addObject("houses", houses);
			mv.addObject("cars", cars);
			mv.addObject("userinfo", target);
			mv.setViewName("userinfo/showUserInfo");
		}else{
			// 创建并封装关联对象
			this.genericAssociation(house_id, car_id, userinfo);
			System.out.println("updateUserInfo -->> " + userinfo);
			// 执行修改操作
			irpmService.modifyUserInfo(userinfo);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/userinfo/selectUserInfo");
		}
		// 返回
		return mv;
	}
	

	private void genericAssociation(Integer house_id,
			Integer car_id,UserInfo userinfo){
		if(house_id != null){
			House house = new House();
			house.setId(house_id);
			userinfo.setHouse(house);
		}
		if(car_id != null){
			Car car = new Car();
			car.setId(car_id);
			userinfo.setCar(car);
		}
	}
	
}
