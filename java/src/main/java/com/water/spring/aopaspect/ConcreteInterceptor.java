package com.water.spring.aopaspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class ConcreteInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("before....");
		Object result = invocation.proceed();
		System.out.println("after....");
		return result;
	}
}
