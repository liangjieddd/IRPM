package com.dlj.irpm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlj.irpm.domain.Pet;
import com.dlj.irpm.domain.User;
import com.dlj.irpm.domain.House;
import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.common.IrpmConstants;
import com.dlj.irpm.util.tag.PageModel;

@Controller
public class PetController {

	@Autowired
	@Qualifier("hrmService")
	private IrpmService irpmService;
			
	
	@RequestMapping(value="/pet/selectPet")
	 public String selectPet(Integer pageIndex,
			 Integer house_id,
			 @ModelAttribute Pet pet,
			 Model model){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(house_id, pet);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		List<House> houses = irpmService.findAllHouse();
		List<Pet> pets = irpmService.findPet(pet,pageModel);
		// 设置Model数据
		model.addAttribute("pets", pets);
		model.addAttribute("houses", houses);
		model.addAttribute("pageModel", pageModel);
		return "pet/pet";
		
	}
	
	@RequestMapping(value="/pet/selectMyPet")
	 public String selectMyPet(Integer pageIndex,
			 Integer house_id,
			 @ModelAttribute Pet pet,
			 Model model,HttpSession session){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(house_id, pet);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		List<House> houses = irpmService.findAllHouse();
		User user = (com.dlj.irpm.domain.User) session.getAttribute(IrpmConstants.USER_SESSION);
		String housename=user.getHousename();
		List<Pet> pets = irpmService.findPetByHouse(housename);
		// 设置Model数据
		model.addAttribute("pets", pets);
		model.addAttribute("houses", houses);
		model.addAttribute("pageModel", pageModel);
		return "pet/pet";
		
	}
	
	
	private void genericAssociation(Integer house_id,
			Pet pet){
		if(house_id != null){
			House house = new House();
			house.setId(house_id);
			pet.setHouse(house);
		}
	}
	
}
