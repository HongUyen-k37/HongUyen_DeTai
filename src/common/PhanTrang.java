package common;

import java.util.List;

public class PhanTrang {
	private int numItems;
	private int total;
	private int page;
	private List<?> lst;
	public int getNumItems() {
		return numItems;
	}
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<?> getLst() {
		int start=(page-1)*numItems;
		int end=page*numItems;
		if(end>lst.size()) end=lst.size();
		return lst.subList(start,end);
	}
	public void setLst(List<?> lst) {
		this.lst = lst;
	}
	public PhanTrang(int numItems, int page, List<?> lst) {
		super();
		this.numItems=numItems;
		this.total = (int) Math.ceil(lst.size()*1.0/numItems);
		if(page>=total) page=total;
		if(page<=0) page=1;
		this.page = page;
		this.lst = lst;
	}
}
