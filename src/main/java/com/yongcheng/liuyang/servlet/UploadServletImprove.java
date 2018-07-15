package com.yongcheng.liuyang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件上传性能提升
 * 1.为保证服务器安全，上传文件应该放在外界无法直接访问的目录下，比如放于WEB-INF目录下
 * 2.为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名。
 * 3.为防止一个目录下面出现太多文件，要使用hash算法打散存储。
 * 4.要限制上传文件的最大值。
 * 5.要限制上传文件的类型，在收到上传文件名时，判断后缀名是否合法。
 * @author Administrator
 *
 */
public class UploadServletImprove extends HttpServlet
{

    /**
     * 
     */
    private static final long serialVersionUID = -4558765804084351502L;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
        
        doPost(req, resp);
    }
    
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }
}
