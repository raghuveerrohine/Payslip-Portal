package com.ggpl.Payslip.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class User {

	@Id
	 
	private Integer re_no;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ref_no")
	private List<PayslipEntity> entity;
	public User(Integer re_no, List<PayslipEntity> entity) {
		super();
		this.re_no = re_no;
		this.entity = entity;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getRe_no() {
		return re_no;
	}
	public void setRe_no(Integer re_no) {
		this.re_no = re_no;
	}
	public List<PayslipEntity> getEntity() {
		return entity;
	}
	public void setEntity(List<PayslipEntity> entity) {
		this.entity = entity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(entity, re_no);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(entity, other.entity) && Objects.equals(re_no, other.re_no);
	}
	@Override
	public String toString() {
		return "User [re_no=" + re_no + ", entity=" + entity + "]";
	}
	
	
}
