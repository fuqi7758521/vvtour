package com.vvtour.shop.criteria;

import java.util.List;

/**
 * 用于分页查询时计算 offset，minIndex， maxIndex 并用于记录查询结果：total，totalPage， resultList
 * @author fuqi
 * @date 2014-08-02
 */

public class SearchPagerModel<T> {

    // 总数
    private int total;

    //起始查询条目
    private int offset;
    
    // 页面大小,默认为20
    private int pageSize=20;


    // 查询出来的数据
    private List<T> resultList;
    
    public SearchPagerModel(){
        
    }

    public SearchPagerModel(int offset, int pageSize) {
    	this.offset=offset;
    	this.pageSize=pageSize;
    }

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
    
}
