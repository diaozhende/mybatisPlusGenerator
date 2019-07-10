package com.dzd.utils;

public class ResultData<T> {

	private String code;
	private T data;
	private T filedData;
	private String dataSize;
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDataSize() {
		return dataSize;
	}

	public void setDataSize(String dataSize) {
		this.dataSize = dataSize;
	}

	public T getFiledData() {
		return filedData;
	}

	public void setFiledData(T filedData) {
		this.filedData = filedData;
	}

	@Override
	public String toString() {
		return "ResultData{" +
				"code='" + code + '\'' +
				", data=" + data +
				", filedData=" + filedData +
				", dataSize='" + dataSize + '\'' +
				", message='" + message + '\'' +
				'}';
	}
}
