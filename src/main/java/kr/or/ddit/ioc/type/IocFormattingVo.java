package kr.or.ddit.ioc.type;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class IocFormattingVo {
	
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regDt;
	
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date modDt;
	
	@NumberFormat(pattern="#,###")
	private int amount;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public Date getModDt() {
		return modDt;
	}
	public void setModDt(Date modDt) {
		this.modDt = modDt;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
