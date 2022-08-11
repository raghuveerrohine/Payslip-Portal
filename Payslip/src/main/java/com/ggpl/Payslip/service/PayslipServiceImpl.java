package com.ggpl.Payslip.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggpl.Payslip.dto.Payslip;
import com.ggpl.Payslip.dto.UserDto;
import com.ggpl.Payslip.eXception.PayslipEXception;
import com.ggpl.Payslip.entity.PayslipEntity;
import com.ggpl.Payslip.entity.User;
import com.ggpl.Payslip.repo.PayslipRepo;
import com.ggpl.Payslip.repo.UserRepo;
@Service
@Transactional
public class PayslipServiceImpl implements PayslipService {

	@Autowired
	private PayslipRepo payslipRepo;
	@Autowired
	private UserRepo repo;
	@Override
	public List<UserDto> addUser(UserDto gg) throws PayslipEXception {
		System.out.println(gg.getRe_no());
		System.out.println(gg.getPayslip());
		Integer id=Integer.parseInt(gg.getRe_no());
		Optional<User> list=repo.findById(id);
		 
		
		if(list.isPresent()) {
			throw new PayslipEXception("Service.User.Exist");
		}
		
		User u=new User();
		List<PayslipEntity> userPayslipList=new ArrayList<PayslipEntity>();
		
		
		PayslipEntity p=new PayslipEntity();
		List<Payslip>  pay=gg.getPayslip();
		System.out.println(pay);
		for(Payslip g:pay) {
			p.setBasic(g.getBasic());
			p.setDate(g.getDate());
			p.setEmp_name(g.getEmp_name());
			 
			p.setHra(g.getHra());
			p.setSp_allon(g.getSp_allon());
			p.setRe_allon(g.getRe_allon());
			p.setConvenience(g.getConvenience());
			p.setTotal(g.getTotal());
			p.setPf(g.getPf());
			p.setPtax(g.getPtax());
			p.setLic(g.getLic());
			p.setCanteen(g.getCanteen());
			p.setTds(g.getTds());
			p.setEsic(g.getEsic());
			p.setCovid_adv(g.getCovid_adv());
			p.setTot_dud(g.getTot_dud());
			p.setNet(g.getNet());
			p.setPf_in_per(g.getPf_in_per());
			p.setEmail(g.getEmail());
			userPayslipList.add(p);
		}
		
		u.setRe_no(id);
		u.setEntity(userPayslipList);
		
		
		repo.save(u);
	 
	
		Iterable<User> clist=repo.findAll();
		 
		List<UserDto> dtos=new ArrayList<UserDto>();
		for(User um:clist) {
			String idd=um.getRe_no().toString();
			if(um.equals(null)) {
				throw new PayslipEXception("User.doesnot.exist");
			}
			UserDto user=new UserDto();
			user.setRe_no(idd);
			List<Payslip> dto=new ArrayList<Payslip>();
			for(PayslipEntity pm:um.getEntity()) {
				Payslip pg=new Payslip();
				pg.setBasic(pm.getBasic());
				pg.setDate(pm.getDate());
				pg.setEmp_name(pm.getEmp_name());
				 
				pg.setHra(pm.getHra());
				pg.setSp_allon(pm.getSp_allon());
				pg.setRe_allon(pm.getRe_allon());
				pg.setConvenience(pm.getConvenience());
				pg.setTotal(pm.getTotal());
				pg.setPf(pm.getPf());
				pg.setPtax(pm.getPtax());
				pg.setLic(pm.getLic());
				pg.setCanteen(pm.getCanteen());
				pg.setTds(pm.getTds());
				pg.setEsic(pm.getEsic());
				pg.setCovid_adv(pm.getCovid_adv());
				pg.setTot_dud(pm.getTot_dud());
				pg.setNet(pm.getNet());
				pg.setPf_in_per(pm.getPf_in_per());
				pg.setEmail(pm.getEmail());
				dto.add(pg);
				
			}
			user.setPayslip(dto);
			dtos.add(user);
		}
		
		
		
		
		return dtos;
	}
	
	@Override
	public UserDto updateUser(Payslip g) throws PayslipEXception{
		System.out.println(g.getDate());
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		    String strDate= formatter.format(g.getDate());  
		    System.out.println(strDate);  
	 
		
		Integer id=Integer.parseInt(g.getRe_no());
		Optional<User> list=repo.findById(id);
		 User u=list.orElseThrow(()-> new PayslipEXception("Service.Please.AddUser"));
 
		if(list.isPresent()) {
 
			
			
			PayslipEntity p=new PayslipEntity();
			p.setBasic(g.getBasic());
			p.setDate(g.getDate());
			p.setEmp_name(g.getEmp_name());
			 
			p.setHra(g.getHra());
			p.setSp_allon(g.getSp_allon());
			p.setRe_allon(g.getRe_allon());
			p.setConvenience(g.getConvenience());
			p.setTotal(g.getTotal());
			p.setPf(g.getPf());
			p.setPtax(g.getPtax());
			p.setLic(g.getLic());
			p.setCanteen(g.getCanteen());
			p.setTds(g.getTds());
			p.setEsic(g.getEsic());
			p.setCovid_adv(g.getCovid_adv());
			p.setTot_dud(g.getTot_dud());
			p.setNet(g.getNet());
			p.setPf_in_per(g.getPf_in_per());
			p.setEmail(g.getEmail());
			 u.getEntity().add(p);
			 
		}
		
		
		List<Payslip> uList=new ArrayList<Payslip>();
		List<PayslipEntity> eList=u.getEntity();
		for(PayslipEntity gg :eList) {
			
			Payslip p=new Payslip();
			p.setBasic(gg.getBasic());
			p.setDate(gg.getDate());
			p.setEmp_name(gg.getEmp_name());
			 
			p.setHra(gg.getHra());
			p.setSp_allon(gg.getSp_allon());
			p.setRe_allon(gg.getRe_allon());
			p.setConvenience(gg.getConvenience());
			p.setTotal(gg.getTotal());
			p.setPf(gg.getPf());
			p.setPtax(gg.getPtax());
			p.setLic(gg.getLic());
			p.setCanteen(gg.getCanteen());
			p.setTds(gg.getTds());
			p.setEsic(gg.getEsic());
			p.setCovid_adv(gg.getCovid_adv());
			p.setTot_dud(gg.getTot_dud());
			p.setNet(gg.getNet());
			p.setPf_in_per(gg.getPf_in_per());
			p.setEmail(gg.getEmail());
			uList.add(p);
		}
		
		UserDto dto=new UserDto();
		dto.setRe_no(g.getRe_no());
		dto.setPayslip(uList);
		
		return dto;
		
	}
	public String deleteUser(String re_no) throws PayslipEXception{
		Integer id=Integer.parseInt(re_no);
		Optional<User> list=repo.findById(id);
		 User u=list.get();
		 repo.delete(u);
		 
		 return "User Deleted successfully!!!";
	}
public UserDto deleteMonthlyUserData(Date date,String re_no)throws PayslipEXception{
	Integer idd=Integer.parseInt(re_no);
	Optional<User> list=repo.findById(idd);
	 User ul=list.orElseThrow(()->new PayslipEXception("Service.Please.AddUser"));
	 List<PayslipEntity> opd=ul.getEntity();
	 
	 for(PayslipEntity pe:opd) {
		 if(pe.getDate().equals(date) ) {
			 opd.remove(pe);
			 payslipRepo.deleteById(pe.getPayslip_id());
			 break;
		 }
	 }
//	boolean value= ul.getEntity().remove(opd.orElse(null));
//	payslipRepo.deleteById(date);
	if(ul.getEntity().isEmpty()) {
		repo.deleteById(idd);
	}
//	System.out.println(value);
//	 for(PayslipEntity p:ul.getEntity()) {
//		 System.out.println(p.getDate());
//		 System.out.println(date);
//		 if(p.getDate().equals(date)) {
//			 System.out.println("matched");
//			boolean value= ul.getEntity().remove(del);
//			 System.out.println(value);
//			 break;
//		 }
//	 }
	 

	 Optional<User> list2=repo.findById(idd);
	 
	 User ul2=list2.orElseThrow(()->new PayslipEXception("Sorry.Deleted.All.Payslip"));
	 System.out.println(ul2);
	 List<Payslip> uList=new ArrayList<Payslip>();
		List<PayslipEntity> eList=ul2.getEntity();
		for(PayslipEntity gg :eList) {
			
			Payslip p=new Payslip();
			p.setBasic(gg.getBasic());
			p.setDate(gg.getDate());
			p.setEmp_name(gg.getEmp_name());
			 
			p.setHra(gg.getHra());
			p.setSp_allon(gg.getSp_allon());
			p.setRe_allon(gg.getRe_allon());
			p.setConvenience(gg.getConvenience());
			p.setTotal(gg.getTotal());
			p.setPf(gg.getPf());
			p.setPtax(gg.getPtax());
			p.setLic(gg.getLic());
			p.setCanteen(gg.getCanteen());
			p.setTds(gg.getTds());
			p.setEsic(gg.getEsic());
			p.setCovid_adv(gg.getCovid_adv());
			p.setTot_dud(gg.getTot_dud());
			p.setNet(gg.getNet());
			p.setPf_in_per(gg.getPf_in_per());
			p.setEmail(gg.getEmail());
			uList.add(p);
		}
		
		UserDto dto=new UserDto();
		dto.setRe_no(re_no);
		dto.setPayslip(uList);
		
		
		
		
		return dto;
}
	@Override
	public List<UserDto> getUsers() throws PayslipEXception {
		Iterable<User> clist=repo.findAll();
		 
		List<UserDto> dtos=new ArrayList<UserDto>();
		for(User u:clist) {
			String id=u.getRe_no().toString();
			if(u.equals(null)) {
				throw new PayslipEXception("User.doesnot.exist");
			}
			UserDto user=new UserDto();
			user.setRe_no(id);
			List<Payslip> dto=new ArrayList<Payslip>();
			for(PayslipEntity pm:u.getEntity()) {
				Payslip pg=new Payslip();
				pg.setBasic(pm.getBasic());
				pg.setDate(pm.getDate());
				pg.setEmp_name(pm.getEmp_name());
				 
				pg.setHra(pm.getHra());
				pg.setSp_allon(pm.getSp_allon());
				pg.setRe_allon(pm.getRe_allon());
				pg.setConvenience(pm.getConvenience());
				pg.setTotal(pm.getTotal());
				pg.setPf(pm.getPf());
				pg.setPtax(pm.getPtax());
				pg.setLic(pm.getLic());
				pg.setCanteen(pm.getCanteen());
				pg.setTds(pm.getTds());
				pg.setEsic(pm.getEsic());
				pg.setCovid_adv(pm.getCovid_adv());
				pg.setTot_dud(pm.getTot_dud());
				pg.setNet(pm.getNet());
				pg.setPf_in_per(pm.getPf_in_per());
				pg.setEmail(pm.getEmail());
				dto.add(pg);
				
			}
			user.setPayslip(dto);
			dtos.add(user);
		}
		
		
		
		
		return dtos;
	}
	 

	
public String updateAndSendMail(UserDto userdto)  throws PayslipEXception{
	
	Iterable<PayslipEntity> clist=payslipRepo.findAll();
	String name=null;
	String email=null;
	 
	
	String fileLocation="F:\\Payslip.xlsx";
	try {
		
		Workbook workbook=new XSSFWorkbook();
		
		Sheet sheet1=workbook.createSheet("payslip");
		String[] columnsHeadings= {
		"Date", "Name","Re.No","Basic","HRA","Spl.Allowance","Re.Allowance","Convenience","Total","PF","P Tax",
		"LIC","Canteen","TDS","ESIC","Covid Adv","Total Deduction","Net","PF in %"};
		
	Font headerFont=workbook.createFont();
	headerFont.setBold(true);
headerFont.setFontHeight((short)12);
headerFont.setColor(IndexedColors.YELLOW.index);

CellStyle headerStyle=workbook.createCellStyle();
headerStyle.setFont(headerFont);
headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
headerStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.index);


Row headerRow=sheet1.createRow(0);
for(int i=0;i<columnsHeadings.length;i++) {
	Cell cell=headerRow.createCell(i);
	cell.setCellValue(columnsHeadings[i]);
	cell.setCellStyle(headerStyle);
	}
//Fill data

 List<Payslip> a=createData(userdto);
CreationHelper ch=workbook.getCreationHelper();
CellStyle datastyle=workbook.createCellStyle();
datastyle.setDataFormat(ch.createDataFormat().getFormat("MM/dd/yyyy"));
Calendar cal = Calendar.getInstance();

 
int rowNum=1;

for(Payslip i:a) {
	name=i.getEmp_name();
	email=i.getEmail();
	
	break;
}

for(Payslip i:a) {
	Row row=sheet1.createRow(rowNum++);
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	
	row.createCell(0).setCellValue( formatter.format(i.getDate()) );
	row.createCell(1).setCellValue(i.getEmp_name());
	row.createCell(2).setCellValue(userdto.getRe_no());
	row.createCell(3).setCellValue(i.getBasic());
	row.createCell(4).setCellValue(i.getHra());
	row.createCell(5).setCellValue(i.getSp_allon());
	row.createCell(6).setCellValue(i.getRe_allon());
	row.createCell(7).setCellValue(i.getConvenience());
	row.createCell(8).setCellValue(i.getTotal());
	row.createCell(9).setCellValue(i.getPf());
	row.createCell(10).setCellValue(i.getPtax());
	row.createCell(11).setCellValue(i.getLic());
	row.createCell(12).setCellValue(i.getCanteen());
	row.createCell(13).setCellValue(i.getTds());
	row.createCell(14).setCellValue(i.getEsic());
	row.createCell(15).setCellValue(i.getCovid_adv());
	row.createCell(16).setCellValue(i.getTot_dud());
	row.createCell(17).setCellValue(i.getNet());
	row.createCell(18).setCellValue(i.getPf_in_per());
	
}
for(int i=0;i<columnsHeadings.length;i++) {
	
	sheet1.autoSizeColumn(i);
	Sheet sheet2=workbook.createSheet("second");
	FileOutputStream fileOut=new FileOutputStream(fileLocation);
	
	workbook.write(fileOut);
	fileOut.close();
	workbook.close();
	System.out.println("Completed");
	
}
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	String fromMail="raghuveerrohine@gmail.com";
	String toMail=email;
	Properties properties=new Properties();
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port",587);
	properties.put("mail.smtp.starttls.enable", true);
	properties.put("mail.transport.protocol","smtp");
	
	Session session=Session.getInstance(properties, new javax.mail.Authenticator(){
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("raghuveerrohine@gmail.com", "otparvqegqgxoyqv");
		}
	}
	
	);
	MimeMessage msg=new MimeMessage(session);
	try {
		
		msg.setFrom(fromMail);
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
		
		Calendar cal = Calendar.getInstance();
		String month=new SimpleDateFormat("MMMM").format(cal.getTime());
		 
		msg.setSubject("Payslip for the month of "+month);
		msg.setText("Hello "+name+", please find attached. Thank you");
		Multipart emailContent=new MimeMultipart();
		MimeBodyPart mimebodypart=new MimeBodyPart();
		mimebodypart.setText("Hello "+name+", please find attached. Thank you");
		
		MimeBodyPart excelAttachement=new MimeBodyPart();
		excelAttachement.attachFile(fileLocation);
		
		emailContent.addBodyPart(mimebodypart);
		emailContent.addBodyPart(excelAttachement);
		msg.setContent(emailContent);
		Transport.send(msg);
		
		System.out.println("mail sent successfully");
	} catch (MessagingException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return "Payslip sent successfully to the user!!!";
}
	
public static List<Payslip> 	createData(UserDto payslip) {
	List<Payslip> slip=payslip.getPayslip();
	
	return slip;
}

@Override
public String validateReNo(String re_no) throws PayslipEXception{
	// TODO Auto-generated method stub
	Integer id=Integer.parseInt(re_no);
	if(repo.existsById(id)) {
		throw new PayslipEXception("RE.NO.EXIST");
		 
	}
	return null;
}
}
