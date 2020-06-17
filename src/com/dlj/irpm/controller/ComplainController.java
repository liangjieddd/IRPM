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

import com.dlj.irpm.domain.Complain;
import com.dlj.irpm.domain.User;
import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.common.IrpmConstants;
import com.dlj.irpm.util.tag.PageModel;

@Controller
public class ComplainController {
	
	@Autowired
	@Qualifier("hrmService")
	private IrpmService irpmService;
	
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping(value="/complain/selectComplain")
	 public String selectComplain(Model model,Integer pageIndex,
			 @ModelAttribute Complain complain){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<Complain> complains = irpmService.findComplain(complain, pageModel);
		model.addAttribute("complains", complains);
		model.addAttribute("pageModel", pageModel);
		return "complain/complain";
		
	}
	
	
	
	@RequestMapping(value="/complain/selectMyComplain")
	 public String selectMyComplain(Model model,Integer pageIndex,
			 @ModelAttribute Complain complain, HttpSession session){
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		User user = (com.dlj.irpm.domain.User) session.getAttribute(IrpmConstants.USER_SESSION);
		int userid=user.getId();
		List<Complain> complains = irpmService.findComplainByUserId(userid);
		model.addAttribute("complains", complains);
		model.addAttribute("pageModel", pageModel);
		return "complain/showMyComplain";
		
	}
	
	
	@RequestMapping(value="/complain/previewComplain")
	 public String previewComplain(
			 Integer id,Model model){
		
		Complain complain = irpmService.findComplainById(id);
		
		model.addAttribute("complain", complain);
		// 返回
		return "complain/previewComplain";
	}
	

	@RequestMapping(value="/complain/removeComplain")
	 public ModelAndView removeComplain(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除公告
			irpmService.removeComplainById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/complain/selectComplain");
		// 返回ModelAndView
		return mv;
	}
	
	
	@RequestMapping(value="/complain/addComplain")
	 public ModelAndView addComplain(
			 String flag,
			 @ModelAttribute Complain complain,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			mv.setViewName("complain/showAddComplain");
		}else{
			User user = (User) session.getAttribute(IrpmConstants.USER_SESSION);
			complain.setUser(user);
			irpmService.addComplain(complain);
			mv.setViewName("redirect:/complain/selectComplain");
		}
		// 返回
		return mv;
	}
	
	
	@RequestMapping(value="/complain/updateComplain")
	 public ModelAndView updateComplain(
			 String flag,
			 @ModelAttribute Complain complain,
			 ModelAndView mv,
			 HttpSession session){
		if(flag.equals("1")){
			Complain target = irpmService.findComplainById(complain.getId());
			mv.addObject("complain",target);
			mv.setViewName("complain/showUpdateComplain");
		}else{
			irpmService.modifyComplain(complain);
			mv.setViewName("redirect:/complain/selectComplain");
		}
		// 返回
		return mv;
	}
	
	
}
