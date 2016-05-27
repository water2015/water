package com.water.spring.aopaspect;

public class OrderServiceImpl implements OrderService {

	@Override
	public void save() {
		System.out.println("add...");
	}

	@Override
	public Integer delete(Integer param) {
		System.out.println("delete..." + param);
		return param;
	}

}
