package com.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageUtils {
	
	public static String uploadImage(File filedata,String uploadPath,String fileName){
		
		try{
			//基于myFile创建一个文件输入流 
	        InputStream is = new FileInputStream(filedata);
	        
	        // 设置目标文件  
	        File toFile = new File(uploadPath, fileName);
	        
	        // 创建一个输出流  
	        OutputStream os = new FileOutputStream(toFile);
	  
	        //设置缓存  
	        byte[] buffer = new byte[1024];
	  
	        int length = 0;
	  
	        //读取myFile文件输出到toFile文件中  
	        while ((length = is.read(buffer)) > 0) { 
	            os.write(buffer, 0, length);
	        }
	        
	        //关闭输入流  
	        is.close();
	        
	        //关闭输出流  
	        os.close();
	        
	        return uploadPath+fileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void uploadImage(InputStream is,File toFile){
		
		try{
			
	        // 创建一个输出流  
	        OutputStream os = new FileOutputStream(toFile);
	  
	        //设置缓存  
	        byte[] buffer = new byte[1024];
	  
	        int length = 0;
	  
	        //读取myFile文件输出到toFile文件中  
	        while ((length = is.read(buffer)) > 0) { 
	            os.write(buffer, 0, length);
	        }
	        
	        //关闭输入流  
	        is.close();
	        
	        //关闭输出流  
	        os.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
