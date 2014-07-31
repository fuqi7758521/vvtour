package com.usual.utils;

import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.OutputStreamWriter; 
import java.io.Writer; 
import java.net.HttpURLConnection; 
import java.net.URL; 
import java.util.Date; 
import java.util.List; 

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class MakeHtml {
	private static long star = 0; 
	private static long end = 0; 
	private static long ttime = 0; 

	private static final Logger logger = Logger.getLogger(MakeHtml.class.getName()); 
	/** 
	* 根据动态url 生成对应的 html代码 
	* 
	* @param httpUrl 
	* @return 
	*/ 
	public static String getHtmlCode(String httpUrl) { 
	//httpUrl = StringUtil.nvl(httpUrl); 
		if(httpUrl.equals("")){ 
			return ""; 
		} 
		Date before = new Date(); 
		star = before.getTime(); 
		String htmlCode = ""; 
		try {
			//1.创建引用外部URL的对象
			//2.通过在 URL 上调用 openConnection 方法创建连接对象
			//3.通过setRequestProperty(key,value)方法修改一般请求属性："User-Agent", "Mozilla/4.0"
			//4.connect()，打开引用URL的通信连接
			//5.获取从字符输入流中读取文本，对输入流进行缓冲，BufferedReader的建立，可高效读取
			InputStream in;
			URL url = new java.net.URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0");
			connection.connect();
			in = connection.getInputStream();
			java.io.BufferedReader breader = new BufferedReader(new InputStreamReader(in, "utf-8"));
			
			String currentLine;
			while ((currentLine = breader.readLine()) != null) { 
				htmlCode += currentLine + "\n"; 
			} 
			breader.close();
		} catch (Exception e) { 
			logger.error(e.getCause()); 
			e.printStackTrace(); 
		} finally {
			Date after = new Date(); 
			end = after.getTime(); 
			ttime = end - star; 
			logger.debug("执行时间:" + ttime + "秒"); 
		} 
		return htmlCode; 
	} 

	/** 
	* 根据给的的url List 生成给定名称路径的html文件列表 
	* 
	* @param urlLst 
	*            url列表 
	* @param fileLst 
	*            要生成的文件的全路径列表 
	* @param isDel 
	*            true 表示 要删除存在的文件 
	*/ 
	public static synchronized void writeHtml(List<String> urlLst, List<String> fileLst, 
	boolean isDel) { 
	if(urlLst == null || fileLst == null ||(urlLst.size() != fileLst.size())){ 
	return; 
	} 
	for (int i = 0,count = urlLst.size();i < count; i++) { 
	writeHtml(urlLst.get(i), fileLst.get(i),isDel); 
	} 

	} 

	/** 
	* 根据给的的url 生成给定名称路径的html文件 
	* 
	* @param url 动态页面的路径
	* @param filePath 要生成静态文件的路径+html文件
	* @param isDel 是否删除已存在的文件
	*            true 表示 要删除存在的文件 
	*/ 
	public static synchronized void writeHtml(String url,String filePath,boolean isDel) {
		Writer ow = null; 
		try {
			//1.生成静态文件的文件对象，判断该文件是否存在，如果存在根据变量isDel决定是否删除，
			//2.判断该静态文件的上一级文件夹是否存在，如果不存在，创建相应文件夹
			//3.创建该静态文件，此时只是空文件
			File writeFile = new File(filePath); 
			boolean isExit = writeFile.exists(); 
			File folder = writeFile.getParentFile(); 
			if(folder.exists() == false){ 
				folder.mkdirs(); 
			}
			if (isExit != true) { 
				writeFile.createNewFile(); 
			} else {
				if (isDel) {
					writeFile.delete(); 
					writeFile.createNewFile(); 
				}
			}
			
			//根据静态文件，创建输出流，可以写入该输出流
			ow = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
			ow.write(getHtmlCode(url));
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		} finally {
			try {
				ow.close(); 
			} catch (Exception ex) {
				logger.debug(ex.getMessage()); 
			}
			logger.debug(url + "\n" + filePath + "\n is make html ok.................."); 
		} 
	}
	
	/** 
	* 根据给的的list,批量生成给定名称路径的html文件 
	* 
	* @param url 动态页面的路径
	* @param filePath 要生成静态文件的路径+html文件
	* @param isDel 是否删除已存在的文件
	*            true 表示 要删除存在的文件 
	* @param times 中间间隔 毫秒为单位 times=1000=1秒
	*/ 
	public static synchronized void writeHtmlBatch(List<String> list,String filePath,boolean isDel,int times) {
		try {
			
		} catch (Exception ex) {
			logger.debug(ex.getMessage());
		} 
	}
	
	
	//删除文件
	public static Boolean deleteFile(String filePath){
		File targetFile = new File(filePath);
	    if (targetFile.isDirectory()) { //如果是 文件夹
	        try {
	              FileUtils.deleteDirectory(targetFile);
	           } catch (IOException e) {
	              e.printStackTrace();
	              return false;
	           }
	    } else if (targetFile.isFile()) {//如果是文件  
	         targetFile.delete();  
	    }
	    return true;
	}
	
	/**去除Html代码，根据length截取字符串*/
	public static String splitAndFilterString(String input, int length) {      
        if (input == null || input.trim().equals("")) {      
            return "";      
        }      
        // 去掉所有html元素,      
        String str = input.replaceAll("//&[a-zA-Z]{1,10};", "").replaceAll(      
                "<[^>]*>", "");      
        str = str.replaceAll("[(/>)<]", "");      
        int len = str.length();      
        if (len <= length) {      
            return str;      
        } else {      
            str = str.substring(0, length);      
            str += "......";      
        }      
        return str;      
    }

	/**测试main函数 
	* @param args 
	* @throws Exception 
	*/ 
	public static void main(String[] args) throws Exception { 
	//String httpUrl = "http://127.0.0.1/blog/blog_viewBlog.action?blogId=10005"; 
	String httpUrl = "http://www.baidu.com"; 
	String targetPath="d:/10001.html";
	File targetFile = new File(targetPath);  
    if (targetFile.isDirectory()) { //如果是 文件夹
        try {
              FileUtils.deleteDirectory(targetFile);
           } catch (IOException e) {
              e.printStackTrace();
           }  
     } else if (targetFile.isFile()) {//如果是文件  
         targetFile.delete();  
     } 
	//writeHtml(httpUrl, "d:/test.jsp", true); 
//	URL url = new java.net.URL(httpUrl); 
//	HttpURLConnection connection = (HttpURLConnection) url 
//	.openConnection(); 
//	connection = (HttpURLConnection) url.openConnection(); 
//	System.out.println(connection.getResponseCode()); 
	} 
}
