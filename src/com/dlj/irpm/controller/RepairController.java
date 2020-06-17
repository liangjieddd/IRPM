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


import com.dlj.irpm.domain.Repair;
import com.dlj.irpm.domain.User;
import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.common.IrpmConstants;
import com.dlj.irpm.util.tag.PageModel;

@Controller
public class RepairController {


	@Autowired
	@Qualifier("hrmService")
	private IrpmService irpmService;
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/repair/selectRepair")
	 public String selectRepair(Model model,Integer pageIndex,
			 @ModelAttribute Repair repair){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		List<Repair> repairs = irpmService.findRepair(repair, pageModel);
		model.addAttribute("repairs", repairs);
		model.addAttribute("pageModel", pageModel);
		return "repair/repair";
		
	}
	

	@RequestMapping(value="/repair/selectMyRepair")
	 public String selectMyRepair(Model model,Integer pageIndex,
			 @ModelAttribute Repair repair, HttpSession session){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		User user = (com.dlj.irpm.domain.User) session.getAttribute(IrpmConstants.USER_SESSION);
		int userid=user.getId();
		List<Repair> repairs = irpmService.findRepairByUserId(userid);
		model.addAttribute("repairs", repairs);
		model.addAttribute("pageModel", pageModel);
		return "repair/repair";
		
	}
	
	
	@RequestMapping(value="/repair/previewRepair")
	 public String previewRepair(
			 Integer id,Model model){
		
		Repair repair = irpmService.findRepairById(id);
		
		model.addAttribute("repair", repair);
		// 返回
		return "repair/previewRepair";
	}
	
	
	@RequestMapping(value="/repair/removeRepair")
	 public ModelAndView removeRepair(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除公告
			irpmService.removeRepairById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/repair/selectRepair");
		// 返回ModelAndView
		return mv;
	}
	
	
	@RequestMapping(value="/repair/addRepair")
	 public ModelAndView addRepair(
			 String flag,
			 @ModelAttribute Repair repair,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("repair/showAddRepair");
		}else{
			User user = (User) session.getAttribute(IrpmConstants.USER_SESSION);
			repair.setUser(user);
			irpmService.addRepair(repair);
			mv.setViewName("redirect:/repair/selectRepair");
		}
		// 返回
		return mv;
	}
	
	
	@RequestMapping(value="/repair/updateRepair")
	 public ModelAndView updateRepair(
			 String flag,
			 @ModelAttribute Repair repair,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			Repair target = irpmService.findRepairById(repair.getId());
			mv.addObject("repair",target);
			mv.setViewName("repair/showUpdateRepair");
		}else{
			irpmService.modifyRepair(repair);
			mv.setViewName("redirect:/repair/selectRepair");
		}
		// 返回
		return mv;
	}
	
	
}
