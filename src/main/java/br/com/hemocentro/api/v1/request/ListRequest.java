package br.com.hemocentro.api.v1.request;

public class ListRequest {

	private static final int DEF_ACTUAL_PAGE = 0;
	private static final int DEF_PAGE_SIZE = 15;

	private String name;
	private String city;
	private String state;
	private long plat;
	private long plong;
	private int actualPage = DEF_ACTUAL_PAGE;
	private int pageSize = DEF_PAGE_SIZE;

	public boolean isEmptyFilters() {
		return name == null || city == null || state == null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPlat() {
		return plat;
	}

	public void setPlat(long plat) {
		this.plat = plat;
	}

	public long getPlong() {
		return plong;
	}

	public void setPlong(long plong) {
		this.plong = plong;
	}

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
