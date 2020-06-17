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

import com.dlj.irpm.domain.Elec;

import com.dlj.irpm.domain.House;
import com.dlj.irpm.domain.User;
import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.common.IrpmConstants;
import com.dlj.irpm.util.tag.PageModel;

@Controller
public class ElecController {

	@Autowired
	@Qualifier("hrmService")
	private IrpmService irpmService;
			
	
	@RequestMapping(value="/elec/selectElec")
	 public String selectElec(Integer pageIndex,
			 Integer house_id,
			 @ModelAttribute Elec elec,
			 Model model){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(house_id, elec);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		List<House> houses = irpmService.findAllHouse();
		List<Elec> elecs = irpmService.findElec(elec,pageModel);
		// 设置Model数据
		model.addAttribute("elecs", elecs);
		model.addAttribute("houses", houses);
		model.addAttribute("pageModel", pageModel);
		return "elec/elec";
		
	}
	
	
	@RequestMapping(value="/elec/selectMyElec")
	 public String selectMyElec(Integer pageIndex,
			 Integer house_id,
			 @ModelAttribute Elec elec,
			 Model model,HttpSession session){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(house_id, elec);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		List<House> houses = irpmService.findAllHouse();
		User user = (com.dlj.irpm.domain.User) session.getAttribute(IrpmConstants.USER_SESSION);
		String housename=user.getHousename();
		List<Elec> elecs = irpmService.findElecByHouse(housename);
		// 设置Model数据
		model.addAttribute("elecs", elecs);
		model.addAttribute("houses", houses);
		model.addAttribute("pageModel", pageModel);
		return "elec/elec";
		
	}
	
	
	private void genericAssociation(Integer house_id,
			Elec elec){
		if(house_id != null){
			House house = new House();
			house.setId(house_id);
			elec.setHouse(house);
		}
	}
	
}
