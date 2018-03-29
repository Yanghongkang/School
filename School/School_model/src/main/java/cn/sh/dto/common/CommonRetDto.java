package cn.sh.dto.common;

import java.io.Serializable;

public class CommonRetDto implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public static String SUCCESS = "000";
	public static String FAIL = "111";
	private String errCode;
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public CommonRetDto(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public CommonRetDto() {
		super();
	}

}
