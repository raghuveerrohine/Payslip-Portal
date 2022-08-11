package com.ggpl.Payslip.entity;
 

 

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="payslip_entity")
public class PayslipEntity {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer payslip_id;
	@Temporal(TemporalType.DATE)
	  private Date date;   ;
	  private String   emp_name    ;
	 
	  private String  basic     ;
	  private String    hra   ;
	  private String      sp_allon ;
	  private String     re_allon  ;
	  private String      convenience ;
	  private String     total  ;
	  private String   pf    ;
	  private String    ptax   ;
	  private String    lic   ;
	  private String      canteen ;
	  private String     tds  ;
	  private String     esic  ;
	  private String      covid_adv ;
	  private String      tot_dud ;
	  private String     net  ;
	  private String   pf_in_per    ;
	  
	  private String email;

	public Integer getPayslip_id() {
		return payslip_id;
	}

	public void setPayslip_id(Integer payslip_id) {
		this.payslip_id = payslip_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getBasic() {
		return basic;
	}

	public void setBasic(String basic) {
		this.basic = basic;
	}

	public String getHra() {
		return hra;
	}

	public void setHra(String hra) {
		this.hra = hra;
	}

	public String getSp_allon() {
		return sp_allon;
	}

	public void setSp_allon(String sp_allon) {
		this.sp_allon = sp_allon;
	}

	public String getRe_allon() {
		return re_allon;
	}

	public void setRe_allon(String re_allon) {
		this.re_allon = re_allon;
	}

	public String getConvenience() {
		return convenience;
	}

	public void setConvenience(String convenience) {
		this.convenience = convenience;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getPtax() {
		return ptax;
	}

	public void setPtax(String ptax) {
		this.ptax = ptax;
	}

	public String getLic() {
		return lic;
	}

	public void setLic(String lic) {
		this.lic = lic;
	}

	public String getCanteen() {
		return canteen;
	}

	public void setCanteen(String canteen) {
		this.canteen = canteen;
	}

	public String getTds() {
		return tds;
	}

	public void setTds(String tds) {
		this.tds = tds;
	}

	public String getEsic() {
		return esic;
	}

	public void setEsic(String esic) {
		this.esic = esic;
	}

	public String getCovid_adv() {
		return covid_adv;
	}

	public void setCovid_adv(String covid_adv) {
		this.covid_adv = covid_adv;
	}

	public String getTot_dud() {
		return tot_dud;
	}

	public void setTot_dud(String tot_dud) {
		this.tot_dud = tot_dud;
	}

	public String getNet() {
		return net;
	}

	public void setNet(String net) {
		this.net = net;
	}

	public String getPf_in_per() {
		return pf_in_per;
	}

	public void setPf_in_per(String pf_in_per) {
		this.pf_in_per = pf_in_per;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(basic, canteen, convenience, covid_adv, date, email, emp_name, esic, hra, lic, net,
				payslip_id, pf, pf_in_per, ptax, re_allon, sp_allon, tds, tot_dud, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PayslipEntity other = (PayslipEntity) obj;
		return Objects.equals(basic, other.basic) && Objects.equals(canteen, other.canteen)
				&& Objects.equals(convenience, other.convenience) && Objects.equals(covid_adv, other.covid_adv)
				&& Objects.equals(date, other.date) && Objects.equals(email, other.email)
				&& Objects.equals(emp_name, other.emp_name) && Objects.equals(esic, other.esic)
				&& Objects.equals(hra, other.hra) && Objects.equals(lic, other.lic) && Objects.equals(net, other.net)
				&& Objects.equals(payslip_id, other.payslip_id) && Objects.equals(pf, other.pf)
				&& Objects.equals(pf_in_per, other.pf_in_per) && Objects.equals(ptax, other.ptax)
				&& Objects.equals(re_allon, other.re_allon) && Objects.equals(sp_allon, other.sp_allon)
				&& Objects.equals(tds, other.tds) && Objects.equals(tot_dud, other.tot_dud)
				&& Objects.equals(total, other.total);
	}

	@Override
	public String toString() {
		return "PayslipEntity [payslip_id=" + payslip_id + ", date=" + date + ", emp_name=" + emp_name + ", basic="
				+ basic + ", hra=" + hra + ", sp_allon=" + sp_allon + ", re_allon=" + re_allon + ", convenience="
				+ convenience + ", total=" + total + ", pf=" + pf + ", ptax=" + ptax + ", lic=" + lic + ", canteen="
				+ canteen + ", tds=" + tds + ", esic=" + esic + ", covid_adv=" + covid_adv + ", tot_dud=" + tot_dud
				+ ", net=" + net + ", pf_in_per=" + pf_in_per + ", email=" + email + "]";
	}

	public PayslipEntity(Integer payslip_id, Date date, String emp_name, String basic, String hra, String sp_allon,
			String re_allon, String convenience, String total, String pf, String ptax, String lic, String canteen,
			String tds, String esic, String covid_adv, String tot_dud, String net, String pf_in_per, String email) {
		super();
		this.payslip_id = payslip_id;
		this.date = date;
		this.emp_name = emp_name;
		this.basic = basic;
		this.hra = hra;
		this.sp_allon = sp_allon;
		this.re_allon = re_allon;
		this.convenience = convenience;
		this.total = total;
		this.pf = pf;
		this.ptax = ptax;
		this.lic = lic;
		this.canteen = canteen;
		this.tds = tds;
		this.esic = esic;
		this.covid_adv = covid_adv;
		this.tot_dud = tot_dud;
		this.net = net;
		this.pf_in_per = pf_in_per;
		this.email = email;
	}

	public PayslipEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	
		
		
}
