package com.yongcheng.liuyang.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

/**
 * 用户登录过滤器
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class UserLoginFilter implements Filter
{

	private static List<String> urls = Arrays.asList(new String[]{"js/","images/","jsp/","/doLogin","fonts/"});
	
    @Override
    public void destroy()
    {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, 
    					 FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse rep = (HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();
        
        //获取当前请求的uri
        String uri = req.getRequestURI();
        
        if (isIegalUrl(uri))
        {
        	chain.doFilter(servletRequest, servletResponse);
        }
        else
        {
        	//如果当前session中存储了用户信息则直接访问，否则跳转到登录页面
        	if (StringUtils.isEmpty(session.getAttribute("user")))
        	{
        		req.getRequestDispatcher("jsp/login.jsp").forward(servletRequest, servletResponse);
        	}
        	else
        	{
        		chain.doFilter(servletRequest, servletResponse);
        	}
        }
        
    }
        

    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
        
    }

    
    private boolean isIegalUrl(String uri)
    {
    	for (String string : urls) {
			//如果当前请求包括这些静态资源文件，则不处理，
    		if (uri.indexOf(string) > -1)
    		{
    			return true;
    		}
		}
    	
    	return false;
    }
    
}
