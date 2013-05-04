package com.web.front.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport
{

    /**
     * 
     */
    private static final long serialVersionUID = 2854105381965508552L;

    private static final int BUFFER_SIZE = 20 * 1024; // 20K

    private File uploadify;

    private String uploadifyFileName;
    private String uploadifyContentType;

    private Map result = new HashMap();

    public String uploadify()
    {
        String newFileName = new Date().getTime() + getExtention(uploadifyFileName);

        File imageFile = new File(ServletActionContext.getServletContext().getRealPath("/upload") + "/" + newFileName);

        upload(uploadify, imageFile);
        
        result.put("fileName", newFileName);

        return SUCCESS;
    }

    private static void upload(File src, File dst)
    {
        try
        {
            InputStream in = null;
            OutputStream out = null;
            try
            {
                in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
                out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
                byte[] buffer = new byte[BUFFER_SIZE];
                while (in.read(buffer) > 0)
                {
                    out.write(buffer);
                }
            }
            finally
            {
                if (null != in)
                {
                    in.close();
                }
                if (null != out)
                {
                    out.close();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static String getExtention(String fileName)
    {
        int pos = fileName.lastIndexOf(".");

        return fileName.substring(pos);
    }

    /**
     * @return the uploadify
     */
    public File getUploadify()
    {
        return uploadify;
    }

    /**
     * @param uploadify the uploadify to set
     */
    public void setUploadify(File uploadify)
    {
        this.uploadify = uploadify;
    }

    /**
     * @return the uploadifyFileName
     */
    public String getUploadifyFileName()
    {
        return uploadifyFileName;
    }

    /**
     * @param uploadifyFileName the uploadifyFileName to set
     */
    public void setUploadifyFileName(String uploadifyFileName)
    {
        this.uploadifyFileName = uploadifyFileName;
    }

    /**
     * @return the uploadifyContentType
     */
    public String getUploadifyContentType()
    {
        return uploadifyContentType;
    }

    /**
     * @param uploadifyContentType the uploadifyContentType to set
     */
    public void setUploadifyContentType(String uploadifyContentType)
    {
        this.uploadifyContentType = uploadifyContentType;
    }

    /**
     * @return the result
     */
    public Map getResult()
    {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Map result)
    {
        this.result = result;
    }

}
