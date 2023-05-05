package com.chanyongyang.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JDBCTests {
	@Autowired
	private HikariConfig hikariConfig;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try(Connection conn = DriverManager.getConnection
				("jdbc:mariadb://np.chanyongyang.com:3306/semi", "SAMPLE", "1234")) {
			log.info(conn);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testDataSource() {
		assertNotNull(dataSource);
		
		try {
			log.info(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHikariConfig() {
		log.info(hikariConfig);
	}
}
