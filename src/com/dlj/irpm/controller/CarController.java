package com.dlj.irpm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dlj.irpm.domain.Car;
import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.tag.PageModel;

@Controller
public class CarController {

	@Autowired
	@Qualifier("hrmService")
	private IrpmService irpmService;
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/car/selectCar")
	 public String selectCar(Model model,Integer pageIndex,
			 @ModelAttribute Car car){
		System.out.println("selectCar -->>");
		System.out.println("pageIndex = " + pageIndex);
		System.out.println("car = " + car);
		PageModel pageModel = new PageModel();
		System.out.println("getPageIndex = " + pageModel.getPageIndex());
		System.out.println("getPageSize = " + pageModel.getPageSize());
		System.out.println("getRecordCount = " + pageModel.getRecordCount());
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<Car> cars = irpmService.findCar(car, pageModel);
		model.addAttribute("cars", cars);
		model.addAttribute("pageModel", pageModel);
		return "car/car";
		
	}
	
}
