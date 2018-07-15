package com.yongcheng.liuyang.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 一个公共工具类
 * 
 * @author Administrator
 *
 */
public class CommonUtils implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 3399725957655432026L;

    private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);
    
    public static void closeIo(Closeable... closeables)
    {
        for (Closeable closeable : closeables)
        {
            if (closeable != null)
            {
                try
                {
                    closeable.close();
                }
                catch (IOException e)
                {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
