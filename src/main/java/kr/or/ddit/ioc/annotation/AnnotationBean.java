package kr.or.ddit.ioc.annotation;

import org.springframework.stereotype.Component;

@Component("annotationBean")
public class AnnotationBean {
	
	private String name;

	public AnnotationBean() {
		name = "brown";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	  
	
	
	
	
}
