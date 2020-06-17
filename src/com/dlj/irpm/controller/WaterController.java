package com.dlj.irpm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlj.irpm.domain.Water;

import com.dlj.irpm.domain.House;
import com.dlj.irpm.domain.User;
import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.common.IrpmConstants;
import com.dlj.irpm.util.tag.PageModel;

@Controller
public class WaterController {
	
	@Autowired
	@Qualifier("hrmService")
	private IrpmService irpmService;
			
	
	@RequestMapping(value="/water/selectWater")
	 public String selectWater(Integer pageIndex,
			 Integer house_id,
			 @ModelAttribute Water water,
			 Model model){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(house_id, water);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		List<House> houses = irpmService.findAllHouse();
		List<Water> waters = irpmService.findWater(water,pageModel);
		// 设置Model数据
		model.addAttribute("waters", waters);
		model.addAttribute("houses", houses);
		model.addAttribute("pageModel", pageModel);
		return "water/water";
		
	}
		
	
	@RequestMapping(value="/water/selectMyWater")
	 public String selectMyWater(Integer pageIndex,
			 Integer house_id,
			 @ModelAttribute Water water,
			 Model model,HttpSession session){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(house_id, water);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		List<House> houses = irpmService.findAllHouse();
		User user = (com.dlj.irpm.domain.User) session.getAttribute(IrpmConstants.USER_SESSION);
		String housename=user.getHousename();
		List<Water> waters = irpmService.findWaterByHouse(housename);
		// 设置Model数据
		model.addAttribute("waters", waters);
		model.addAttribute("houses", houses);
		model.addAttribute("pageModel", pageModel);
		return "water/water";
		
	}
	
	
	@RequestMapping(value="/water/addWater")
	 public ModelAndView addWater(
			 String flag,
			 Integer house_id,
			 @ModelAttribute Water water,
			 ModelAndView mv){
		if(flag.equals("1")){
			List<House> houses = irpmService.findAllHouse();
			// 设置Model数据
			mv.addObject("houses", houses);
			mv.setViewName("water/showAddWater");
		}else{
			// 判断是否有关联对象传递，如果有，创建关联对象
			this.genericAssociation(house_id, water);
			// 添加操作
			irpmService.addWater(water);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/water/selectWater");
		}
		// 返回
		return mv;
		
	}
	

	@RequestMapping(value="/water/removeWater")
	 public ModelAndView removeWater(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			irpmService.removeWaterById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/water/selectWater");
		// 返回ModelAndView
		return mv;
	}
	
	
	@RequestMapping(value="/water/updateWater")
	 public ModelAndView updateWater(
			 String flag,
			 Integer house_id,
			 @ModelAttribute Water water,
			 ModelAndView mv){
		if(flag.equals("1")){
			Water target = irpmService.findWaterById(water.getId());
			List<House> houses = irpmService.findAllHouse();
			// 设置Model数据
			mv.addObject("houses", houses);
			mv.addObject("water", target);
			mv.setViewName("water/showUpdateWater");
		}else{
			// 创建并封装关联对象
			this.genericAssociation(house_id, water);
			System.out.println("updateWater -->> " + water);
			// 执行修改操作
			irpmService.modifyWater(water);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/water/selectWater");
		}
		// 返回
		return mv;
	}
	
	
	private void genericAssociation(Integer house_id,
			Water water){
		if(house_id != null){
			House house = new House();
			house.setId(house_id);
			water.setHouse(house);
		}
	}
	
}
