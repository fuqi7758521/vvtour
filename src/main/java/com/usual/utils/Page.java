package com.usual.utils;

import java.util.ArrayList;
import java.util.List;

public class Page {
    
    public static final int DEFAULT_PAGE_SIZE = 50;		//默认每页多少数据
    
    private long totalNum = 0;							//数据总数
    
    private int pageSize = DEFAULT_PAGE_SIZE;			//默认每页多少数据
    
    private int currentPage = 1;						//当前页数
    
    private int totalPage = 1;							//总页数
    
    private int start = 1;								//
    
    private int end = 1;
    
    
    /**
     * 
     * @param pageSize	默认每页显示数量
     * @param count	数据总数
     * @param pageIndex 当前页数
     */
    public Page(int pageSize, long totalCount, int currentPage) {

        this.pageSize = pageSize;
        
        this.totalNum = totalCount;
        
        turnPage(currentPage);
    }

    public void turnPage(int currentPage){
    	//计算总页数
    	long pageCount = 1;
    	if(totalNum % pageSize == 0){
    		
    		pageCount = totalNum / pageSize;
			
		}else{
			
			pageCount = totalNum / pageSize +1;
		}
    	
    	this.totalPage = Integer.parseInt(pageCount+"");
    	
    	//计算当前查询开始索引
    	long pageTemp = currentPage - 1;
    	
        if (totalNum > 0 ) {
             if (pageTemp > totalNum - 1) {
            	 
                 pageTemp = totalNum - 1;
             }
         }
         this.start = Integer.parseInt(pageTemp+"") * pageSize;
         
         if (this.start < 0) {
             start = 0;
         }
    }

	public long getTotalNum() {
		return totalNum;
	}


	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}
    
	public static void main(String[] args){
		Page page = new Page(50,49,1);
		System.out.println(page.getStart()+","+page.getTotalPage());
		
	}
    
}
