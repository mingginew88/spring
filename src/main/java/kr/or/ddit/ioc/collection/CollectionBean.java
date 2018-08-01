package kr.or.ddit.ioc.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	
	private List lists;
	private Set sets;
	private Map map;
	private Properties pros;
	
	public CollectionBean() {
		
	}
	
	public List getLists() {
		return lists;
	}
	public void setLists(List lists) {
		this.lists = lists;
	}
	public Set getSets() {
		return sets;
	}
	public void setSets(Set sets) {
		this.sets = sets;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getPros() {
		return pros;
	}
	public void setPros(Properties pros) {
		this.pros = pros;
	}
	
	//spring 설정 파일을 통해 주입받는 방법
	//1. constructor : 생성자를 통한 주입
	//2. setter : setter를 통한 주입
	
	
	
	
	
	

}
