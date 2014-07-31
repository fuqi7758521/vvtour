package com.usual.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncapsulateUtil {

	/**
	 * 去重
	 * */
	public static String[] getDistinct(String[] str){
		String[] temp = {""};
		if(str==null||str.length==0){
			return temp;
		}
		List<String> list = new ArrayList<String>();
		for(int i=0;i<str.length;i++){
			if(!list.contains(str[i])){
				list.add(str[i]);
			}
		}
		
		String[] strArray = listToString(list).split(",");
		return strArray;
		
	}
	
	/**
	 * 将带有,号的字符串转化封装为数组
	 * */
	public static String[] encaStrings(String str){
		
		if(str.indexOf(",")<0){
			String[] enstr = {str};
			return enstr;
		}
		String[] enstr = str.split(",");
		return enstr;
	}
	
	/**
	 * 将带有,号的字符串转化封装为list列表
	 * */
	public static List<String> encaList(String str){
		List<String> list = new ArrayList<String>();
		
		if(str.indexOf(",")<0){
			list.add(str);
			return list;
		}
		for(String t : str.split(",")){
			list.add(t);
		}
		return list;
	}
	
	
	/**
	 * 
	 * 将List<String> 转化为以逗号为分割的字符串
	 * */ 
	public static String listToString(List<String> stringList){
		if (stringList==null) {
			return null;
		}
		StringBuilder result=new StringBuilder();
		boolean flag=false;
		for (String string : stringList) {
			if (flag) {
				result.append(",");
			}else {
				flag=true;
			}
			result.append(string);
		}
		return result.toString();
	}
	
	/**
	 * 
	 * 数组 转化为以逗号为分割的字符串
	 * */ 
	public static String arrayToString(String[] strs){
		if (strs==null) {
			return null;
		}
		if(strs.length==1){
			return strs[0];
		}
		StringBuilder result=new StringBuilder();
		boolean flag=false;
		for (String string : strs) {
			if (flag) {
				result.append(",");
			}else {
				flag=true;
			}
			result.append(string);
		}
		return result.toString();
	}
	
	public static void main(String args[]) {
		String str = "http://127.0.0.1/upload,http://127.0.0.1/upload,http://127.0.0.1/upload,http://127.0.0.1/upload";
		
		if(str!=null){
			String img = str;
			if(img.indexOf("http://127.0.0.1")>-1){
				img = img.replace("http://127.0.0.1", "");
			}
			System.out.println(img);
		}
	}
}
