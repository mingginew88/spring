package kr.or.ddit.mvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ValidJsr303Vo {
	//userId, name, password
	
	@NotNull
	private String userId;
	
	@NotNull
	private String name;
	
	@Size(min=4)
	@NotNull
	private String password;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
