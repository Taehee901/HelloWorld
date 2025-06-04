package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;//에러

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*Dao역할 SqlSessionFactory
 * 경로만 바꿈,사용자접속정보,쿼리파일.xml*/
public class DataSource {
	public static SqlSessionFactory getInstance() {
		//데이터접속,sql이 어디있는지 정보를 넣는 경로 변경
		String resource = "config/mybatis-config.xml";//경로파일읽으려고
		InputStream inputStream = null;
		try {//예외처리 x 에러
			inputStream = Resources.getResourceAsStream(resource);//실제 파일읽음
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sqlsession여러개담고있음
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;//리턴반환없으면에러
	}
}
