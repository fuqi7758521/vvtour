package com.usual.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.common.utils.UnicodeUtils;
import com.vvtour.shop.entity.ProductType;

public class FileToolkit {
	
	/**
	 * 从文件里读取内容
	 * */
	public static String readFileContent(String realPath){
		File file = new File(realPath);
		StringBuffer sp = new StringBuffer();
		
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(file));
		    String line;
		    while((line = reader.readLine())!=null){
		    	sp = sp.append(line+"\n");
		    }
		    reader.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return sp.toString();
	}
	
	/**
	 * 对具体文件写入指定内容
	 * */
	public static boolean writeContentInFile(String con,String realPath,boolean isAppend){
		
		try {
			if(isAppend){
				appendMethod(realPath,con);
				return true;
			}
			File file = new File(realPath);
			BufferedWriter writer  = new BufferedWriter(new FileWriter(file));
			
		    writer.write(con);  
		    writer.flush(); 
		    writer.close();   

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		    return false;
		} catch (IOException e) {
		    e.printStackTrace();
		    return false;
		}
		return true;
	}
	
	public static void appendMethod(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args){
		/*String str = FileToolkit.readFileContent("e:/school.js");
		str = UnicodeUtils.fromEncodedUnicode(str.toCharArray(), 0, str.length());
		String un = "var schoolList = ";
		if(str.indexOf(un)>0){
			str = str.replace(un, "");
		}
		//System.out.println(str);
		List<ViewSpotTag> list = new ArrayList<ViewSpotTag>();
		list = (List<ViewSpotTag>)JSONArray.parseArray(str, ViewSpotTag.class);
		
		for(ViewSpotTag vs : list){
    		System.out.println("id:"+vs.getViews_id());
    		System.out.println("name:"+vs.getViews_name());
    		List<VisitTag> vl = (List<VisitTag>)vs.getVisitList();
    		for(VisitTag vt: vl){
    			System.out.println("visitObject:");
    			System.out.println("\t vid:"+vt.getVisit_id());
    			System.out.println("\t vname:"+vt.getVisit_name());
    		}
    		
    	}*/
		
		//System.out.println(readFileContent("e:/a.txt"));
		//System.out.println(writeContentInFile("57ikehnr","e:/a.txt",false));
		
		String str = FileToolkit.readFileContent("e:/proType.js");
		str = UnicodeUtils.fromEncodedUnicode(str.toCharArray(), 0, str.length());
		String un = "var proType = ";
		
		if(str.indexOf(un)>-1){
			str = str.replace(un, "");
		}
		List<ProductType> list = new ArrayList<ProductType>();
		list = (List<ProductType>)JSONArray.parseArray(str, ProductType.class);
		
		for(ProductType vs : list){
			//添加名称，删除，修改
    		System.out.println("ptype_id:"+vs.getPtype_id());
    		System.out.println("ptype_name:"+vs.getPtype_name());
    	}
		
	}

}
