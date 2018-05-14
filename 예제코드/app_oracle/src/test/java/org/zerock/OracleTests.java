package org.zerock;


import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class OracleTests {

	@Autowired
	DataSource ds;

	@Test
	public void testConnection(){
		
		try(Connection con = ds.getConnection()){
	
			log.info("CONNECTION: " + con);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
