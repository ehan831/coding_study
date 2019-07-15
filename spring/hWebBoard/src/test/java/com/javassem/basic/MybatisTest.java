package com.javassem.basic;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MybatisTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void timeTest() {
		try {
		
			SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection();
			log.info(session);
			log.info(con);
			log.info("[결과]"+session.selectOne("org.javassem.TestMapper.getTime"));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
