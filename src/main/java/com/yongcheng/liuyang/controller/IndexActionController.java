package com.yongcheng.liuyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页访问的控制权限
 * 
 * @author Administrator
 *
 */
@Controller
public class IndexActionController
{
	/**
	 * 访问主页
	 * 
	 * @return
	 */
    @RequestMapping("/index")
    public String index()
    {
		return "index";
    }
    
}
