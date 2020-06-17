package com.dlj.irpm.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dlj.irpm.domain.House;
import com.dlj.irpm.domain.User;
import com.dlj.irpm.domain.UserInfo;
import com.dlj.irpm.service.IrpmService;
import com.dlj.irpm.util.common.IrpmConstants;
import com.dlj.irpm.util.tag.PageModel;

/**
 * 处理用户请求控制器
 * */
@Controller
public class UserController {
	
	
	@Autowired
	@Qualifier("hrmService")
	private IrpmService irpmService;
	
	@RequestMapping(value="/login")
	 public ModelAndView login(@RequestParam("loginname") String loginname,
			
			 @RequestParam("password") String password,
			 @RequestParam("housename") String housename,
			 HttpSession session,
			 ModelAndView mv){
		// 调用业务逻辑组件判断用户是否可以登录
		User user = irpmService.login(loginname, password,housename);
		String username = user.getUsername();
		UserInfo userinfo = irpmService.findUserInfoByUserName(username);
		session.setAttribute(IrpmConstants.USER_SESSION, userinfo);
		if(user != null){
			// 将用户保存到HttpSession当中
			session.setAttribute(IrpmConstants.USER_SESSION, user);
			// 客户端跳转到main页面
			mv.setViewName("redirect:/main");
		}else{
			// 设置登录失败提示信息
			mv.addObject("message", "登录名或密码或房间号错误!请重新输入");
			// 服务器内部跳转到登录页面
			mv.setViewName("forward:/loginForm");
		}
		return mv;
		
	}
	
	
	@RequestMapping(value="/user/selectUser")
	 public String selectUser(Integer pageIndex,
			 @ModelAttribute User user,
			 Model model){
		System.out.println("user = " + user);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<User> users = irpmService.findUser(user, pageModel);
		model.addAttribute("users", users);
		model.addAttribute("pageModel", pageModel);
		return "user/user";
		
	}
	
	
	@RequestMapping(value="/user/removeUser")
	 public ModelAndView removeUser(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			irpmService.removeUserById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/user/selectUser");
		// 返回ModelAndView
		return mv;
	}
	

	@RequestMapping(value="/user/updateUser")
	 public ModelAndView updateUser(
			 String flag,
			 @ModelAttribute User user,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询用户
			User target = irpmService.findUserById(user.getId());
			// 设置Model数据
			mv.addObject("user", target);
			mv.setViewName("user/showUpdateUser");
		}else{
			// 执行修改操作
			irpmService.modifyUser(user);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/user/selectUser");
		}
		// 返回
		return mv;
	}
	
	
	@RequestMapping(value="/user/addUser")
	 public ModelAndView addUser(
			 String flag,
			 @ModelAttribute User user,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("user/showAddUser");
		}else{
			// 执行添加操作
			irpmService.addUser(user);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/user/selectUser");
		}
		// 返回
		return mv;
	}
	
}
