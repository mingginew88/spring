package kr.or.ddit.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapSessionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	//프로그램이 로딩이될때 static부분이 ...
	static {
		try {
						//kr/or/ddit/config/spring/root-context.xml
						//kr/or/ddit/config/spring/servlet-context.xml
						//kr/or/ddit/config/spring/mybatis-config.xml
			String resource = "kr/or/ddit/config/mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	
	
	

}
