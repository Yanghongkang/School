package cn.sh.dto.common;

import java.io.Serializable;

public class PagerRetDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long page;
	private Long recTotal;
	private Long recPerPage;

	public PagerRetDto() {
		super();
	}

	public PagerRetDto(Long page, Long recTotal, Long recPerPage) {
		super();
		this.page = page;
		this.recTotal = recTotal;
		this.recPerPage = recPerPage;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getRecTotal() {
		return recTotal;
	}

	public void setRecTotal(Long recTotal) {
		this.recTotal = recTotal;
	}

	public Long getRecPerPage() {
		return recPerPage;
	}

	public void setRecPerPage(Long recPerPage) {
		this.recPerPage = recPerPage;
	}

}
