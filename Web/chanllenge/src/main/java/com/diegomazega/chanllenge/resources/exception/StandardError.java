package com.diegomazega.chanllenge.resources.exception;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private String date;
	
	public StandardError(Integer status, String msg) {
		super();
		this.status = status;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.date = formatter.format(new Date());
		this.msg = msg;
	}
		
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
