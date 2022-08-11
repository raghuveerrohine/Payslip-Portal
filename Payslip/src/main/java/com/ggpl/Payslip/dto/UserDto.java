package com.ggpl.Payslip.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;


public class UserDto  {
	private String re_no;
	 
	private List<Payslip> payslipData;
	public String getRe_no() {
		return re_no;
	}

	public void setRe_no(String re_no) {
		this.re_no = re_no;
	}

	public List<Payslip> getPayslip() {
		return payslipData;
	}

	public void setPayslip(List<Payslip> payslip) {
		this.payslipData = payslip;
	}

	 

	@Override
	public String toString() {
		return "UserDto [re_no=" + re_no + ", payslipData=" + payslipData + "]";
	}

	public UserDto(String re_no, List<Payslip> payslip) {
		super();
		this.re_no = re_no;
		this.payslipData = payslip;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
