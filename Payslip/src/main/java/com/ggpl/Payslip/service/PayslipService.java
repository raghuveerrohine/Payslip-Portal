package com.ggpl.Payslip.service;

import java.util.Date;
import java.util.List;

import com.ggpl.Payslip.dto.Payslip;
import com.ggpl.Payslip.dto.UserDto;
import com.ggpl.Payslip.eXception.PayslipEXception;
import com.ggpl.Payslip.entity.User;

public interface PayslipService {

	
	public List<UserDto> addUser(UserDto payslip) throws PayslipEXception;
	public List<UserDto> getUsers() throws PayslipEXception;
	public String updateAndSendMail(UserDto userdto ) throws PayslipEXception;
	 public UserDto updateUser(Payslip payslip) throws PayslipEXception;
	 public String deleteUser(String re_no) throws PayslipEXception;
	 public UserDto deleteMonthlyUserData(Date date,String re_no)throws PayslipEXception;
	 public String validateReNo(String re_no) throws PayslipEXception;
}
