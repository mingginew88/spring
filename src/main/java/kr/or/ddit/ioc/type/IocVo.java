package kr.or.ddit.ioc.type;

import java.util.Date;

public class IocVo {
	private String name;
	private Date regDt;
	
	public IocVo(){
		
	}
	
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

	@Override
	public String toString() {
		return "IocVo [name=" + name + ", regDt=" + regDt + "]";
	}

}
