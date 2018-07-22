package com.yongcheng.liuyang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yongcheng.liuyang.model.AccountInfo;
import com.yongcheng.liuyang.service.UserService;

/**
 * 主页访问的控制权限
 * 
 * @author Administrator
 *
 */
@Controller
public class IndexActionController
{
	@Autowired
	private UserService userService;
	
	
	/**
	 * 访问主页
	 * 
	 * @return
	 */
    @RequestMapping("/index.action")
    public String index()
    {
		return "index";
    }
    
    @RequestMapping("/register")
    public String register(AccountInfo user,HttpServletRequest req)
    {
    	try 
    	{
    		userService.registerUser(user);
    		//登录成后，将当前的用户名保存到session中
    		HttpSession session = req.getSession();
    		session.setAttribute("user_name", user.getUserId());
    		//跳转到注册成功页面
        	return "redirect/success.jsp";
		} 
    	catch (Exception e) 
    	{
    		System.out.println(e.getMessage());
		}
    	return null;
    }
    
    @RequestMapping("/validateName")
    @ResponseBody
    public boolean userNameIsLegal(@RequestParam(value="userName") String userName)
    {
    	return userService.validateUserIsLegal(userName);
    }
    
}
