package cn.sh.dto.common;

import java.io.Serializable;
import java.util.List;

public class PageRetDto<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String result;

	private PagerRetDto pagerdto;
	private String message;
	private List<T> data;

	public PageRetDto() {
		super();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public PagerRetDto getPagerdto() {
		return pagerdto;
	}

	public void setPagerdto(PagerRetDto pagerdto) {
		this.pagerdto = pagerdto;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
