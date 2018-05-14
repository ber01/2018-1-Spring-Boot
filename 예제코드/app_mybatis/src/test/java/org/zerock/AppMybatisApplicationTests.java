package org.zerock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.persistence.TimeMapper;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppMybatisApplicationTests {
	
	@Autowired
	TimeMapper timeMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1(){
		
		log.info("---------------------------");
	
		log.info("TIME: " + timeMapper.getTime());
		
	}
	
	@Test
	public void test2(){
		
		log.info("---------------------------");
	
		log.info("TIME: " + timeMapper.getTimeXML());
		
	}
	
	
}
