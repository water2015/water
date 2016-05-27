package com.water.spring.aopaspect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/water/spring/aopaspect/aop.xml")
@Component
public class AOPClient {

	@Autowired
	@Qualifier("serviceProxy")
	private OrderService service;

	@Test
	public void client() {
		service.save();
		service.delete(88);
	}
}
