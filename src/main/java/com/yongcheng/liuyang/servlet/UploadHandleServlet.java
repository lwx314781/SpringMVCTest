package com.yongcheng.liuyang.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.yongcheng.liuyang.utils.CommonUtils;

/**
 * servlet2.5 模拟文件上传
 * 
 * 
 * @author Administrator
 *
 */
@WebServlet
public class UploadHandleServlet extends HttpServlet
{
    private static Logger logger = Logger.getLogger(UploadHandleServlet.class);
    
    /**
     * 序列号
     */
    private static final long serialVersionUID = -7962718045722318716L;
    
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        InputStream is = null;
        FileOutputStream fos = null;
        
        //上传文件的保存地址
        String savePath = req.getServletContext().getRealPath("WEB-INF/upload");
        File file = new File(savePath);
        //如果该位置不存在，则重新创建
        if (!file.exists() && !file.isDirectory())
        {
            logger.error("file is not exists or file is not a directory");
            //创建目录
            file.mkdirs();
        }
        
        //前台消息提示
        String msg = "";
        
        //使用apach文件上传组件处理文件上传的步骤
        //1. 创建一个DiskFileItemFactory的工厂
        DiskFileItemFactory factroy = new DiskFileItemFactory();
        //2.上传一个文件解析器
        ServletFileUpload fileUpload = new ServletFileUpload(factroy);
        //3.解决上传过程中的乱码问题
        fileUpload.setHeaderEncoding("utf-8");
        //判断上传上来的数据是否为表单提交的数据
        if (!ServletFileUpload.isMultipartContent(req))
        {
            //按照传统方式获取
            return;
        }
        //利用ServletFileUpload解析器解析的上传数据，解析的结果是一个list<FileItem>集合，
        //每一个FileItem对应一个form表单输入数据
        try
        {
            List<FileItem> fileItems = fileUpload.parseRequest(req);
            for (FileItem item : fileItems)
            {
               //如果fileItem中封装的是普通数据
               if (item.isFormField())
               {
                   //得到变量名称
                   String name = item.getFieldName();
                   //解决普通输入项中的乱码问题
                   String value = item.getString("utf-8");
                   value = new String(value.getBytes("iso8859-1"), "utf-8");
                   System.out.println(name + "=" + value);
               }
               //如果是上传文件
               else
               {
                   //得到文件名称
                   String fileName = item.getName();
                   System.out.println(fileName);
                   if (fileName == null || fileName.trim().equals(""))
                   {
                       logger.info("file is not exists");
                       continue;
                   }
                   //由于不同浏览器提交的文件名称有可能不同
                   fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                   //获取上传的文件输入流
                   is = item.getInputStream();
                   //创建一个标准的文件输出流
                   fos = new FileOutputStream(new File(savePath + file.separator + fileName));
                   //创建一个缓冲区
                   byte[] buffer = new byte[1024];
                   int len = 0;
                   while((len = is.read(buffer)) != -1)
                   {
                       fos.write(buffer, 0, len);
                   }
                   CommonUtils.closeIo(fos,is);
                   //删除临时文件
                   item.delete();
                   msg = "文件上传成功！";
               }
            }
        }
        catch (FileUploadException e)
        {
            logger.error(e.getMessage());
            msg = "上传失败";
        }
        req.setAttribute("message", msg);
        req.getRequestDispatcher("/jsp/message.jsp").forward(req, resp);
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }

}
