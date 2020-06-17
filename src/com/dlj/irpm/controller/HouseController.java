package com.dlj.irpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlj.irpm.domain.House;
import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.tag.PageModel;

@Controller
public class HouseController {


	@Autowired
	@Qualifier("hrmService")
	private IrpmService irpmService;
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/house/selectHouse")
	 public String selectHouse(Model model,Integer pageIndex,
			 @ModelAttribute House house){
		System.out.println("selectHouse -->> " + house);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		List<House> houses = irpmService.findHouse(house, pageModel);
		model.addAttribute("houses", houses);
		model.addAttribute("pageModel", pageModel);
		return "house/house";
		
	}
	
}
