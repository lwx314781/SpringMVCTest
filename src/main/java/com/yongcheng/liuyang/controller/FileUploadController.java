package com.yongcheng.liuyang.controller;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 上传文件的过滤器
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/index")
public class FileUploadController
{
    @RequestMapping(value="/fileUpload",method=RequestMethod.POST,produces="application/json; charset=utf-8")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile[] files,HttpServletRequest request)
    {
        String path = request.getServletContext().getRealPath("WEB-INF/upload");
        
        File savePath = new File(path);
        if (!savePath.exists() && !savePath.isDirectory())
        {
            savePath.mkdirs();
        }
        
        for (MultipartFile file : files) 
        {
            File tempFile=new File(path, file.getOriginalFilename());
            try
            {
                file.transferTo(tempFile);
            }
            catch (IllegalStateException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        
        return "上传成功";
    }
    
    @PostMapping("/form")
    public String handleFormUpload(HttpServletRequest request,
    		@RequestParam("name") String name,
            @RequestParam("file") Part file) {

    	String path = request.getServletContext().getRealPath("/upload");
    	InputStream is = null;
		OutputStream os = null;
    	try {
    		is = file.getInputStream();
    		os = new FileOutputStream(new File(path));
		
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = is.read(buffer)) != -1)
			{
				os.write(buffer, 0, len);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        finally
        {
        	closeStream(os,is);
        }

        return "uploadSuccess";
    }
    
    
    private void closeStream(Closeable...io)
    {
    	for (Closeable closeable : io) {
			if (closeable != null)
			{
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
}
