package com.ggpl.Payslip.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ggpl.Payslip.dto.Payslip;
import com.ggpl.Payslip.dto.UserDto;
import com.ggpl.Payslip.eXception.PayslipEXception;
import com.ggpl.Payslip.service.PayslipService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
@RestController
@RequestMapping(value = "/payslip")
@CrossOrigin 
public class PayslipApi {

	@Autowired
	private PayslipService payslipService;

	@GetMapping("/test")
	public String test() {
		return "Working";
	}
	@GetMapping("/maventest")
	public String test2() {
		return "Added maven test for poll scm";
	}
	@PostMapping(value = "/add" ,  consumes="application/json")
	 public ResponseEntity<List<UserDto>> addUser(@RequestBody UserDto dto) throws PayslipEXception {
 
		 System.out.println(dto);
		 List<UserDto> p= payslipService.addUser(dto);
		return new ResponseEntity<List<UserDto>>(p, HttpStatus.CREATED);
	}
	 
	@GetMapping(value = "/getusers")
	public ResponseEntity<List<UserDto>> getUsers() throws PayslipEXception {
		 System.out.println("*************************Calleedd**************");
		List<UserDto> p=payslipService.getUsers();
		return new ResponseEntity<List<UserDto>>(p, HttpStatus.OK);
	}
	 
	@PutMapping(value="/sendmail")
	public ResponseEntity<String> updateAndSend(@RequestBody UserDto payslip) throws PayslipEXception {
		 System.out.println("Send mail called");
		String p=payslipService.updateAndSendMail(payslip);
		return new ResponseEntity<String>(p, HttpStatus.CREATED);
	}
	  
	 
	@PutMapping(value="/update")
	public ResponseEntity<UserDto> updateUser(@RequestBody Payslip payslip) throws PayslipEXception {
		 System.out.println("update called");
		 System.out.println(payslip);
		UserDto p=payslipService.updateUser(payslip);
		return new ResponseEntity<UserDto>(p, HttpStatus.CREATED);
	}	
	 
	@DeleteMapping(value="/delete/{data}")
	public ResponseEntity<String> deleteUser(@PathVariable("data") String re_no) throws PayslipEXception {
		
		System.out.println("delete user called");
		String p=payslipService.deleteUser(re_no);
		return new ResponseEntity<String>(p, HttpStatus.CREATED);
	}	
	 
	@DeleteMapping(value="/deleteMonthly/{value}/{date}")
	public ResponseEntity<UserDto> deleteMonthlyUserData(
			@PathVariable("value")String re_no, @PathVariable("date") String date) throws PayslipEXception, ParseException {
		System.out.println("delete single data called");
		System.out.println(re_no+"   "+date);
		  Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);  
		  System.out.println(date1);
		UserDto p=payslipService.deleteMonthlyUserData(date1, re_no);
		return new ResponseEntity<UserDto>(p, HttpStatus.CREATED);
	}	
	@GetMapping(value="/validateReNo/{reNo}")
	public ResponseEntity<String> validateReNo(@PathVariable("reNo") String re_no) throws PayslipEXception {
		 System.out.println("*************************Calleedd**************");
		 String p=payslipService.validateReNo(re_no);
		return new ResponseEntity<String>(p, HttpStatus.OK);
	}
	
}
