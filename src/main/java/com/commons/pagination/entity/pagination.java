package com.commons.pagination.entity;

import java.util.List;

public class pagination {
	
	private int currentpageindex;
	
	private long totalrec;
	
	private int totalrecperpage;
	
	private long pageindex;
	
	private String search;
	
	private List data;
	
	private long totalpage;

	public int getCurrentpageindex() {
		return currentpageindex;
	}

	public void setCurrentpageindex(int currentpageindex) {
		this.currentpageindex = currentpageindex;
	}

	public long getTotalrec() {
		return totalrec;
	}

	public void setTotalrec(long totalrec) {
		this.totalrec = totalrec;
	}

	public int getTotalrecperpage() {
		return totalrecperpage;
	}

	public void setTotalrecperpage(int totalrecperpage) {
		this.totalrecperpage = totalrecperpage;
	}

	public long getPageindex() {
		return pageindex;
	}

	public void setPageindex(long pageindex) {
		this.pageindex = pageindex;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public long getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(long totalpage) {
		
		totalpage=totalrec/totalrecperpage;
	    if(totalrec%totalrecperpage!=0){
	    	totalpage++;
	    }
		this.totalpage = totalpage;
		
	}

	
}
