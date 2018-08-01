package kr.or.ddit.ioc.service;

import kr.or.ddit.ioc.dao.IocDaoInf;

public interface IocServiceInf {
	
	String hello();
	
	//setter를 통한 주입
	IocDaoInf getIocDao();

	void setIocDao(IocDaoInf iocDao);
	
}
