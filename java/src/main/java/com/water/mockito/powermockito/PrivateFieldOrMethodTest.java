package com.water.mockito.powermockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class PrivateFieldOrMethodTest {

	private XxxService target;

	@Before
	public void setUp() {
		target = new XxxService();
	}

	@Test
	public void modifyPrivateField() throws Exception {
		// prepare
		Field f = PowerMockito.field(XxxService.class, "threshold");
		f.set(null, 10);

		// action
		int result = target.sum();

		// assert
		assertEquals(10, result);
	}

	@Test
	public void testPrivateMethod() throws Exception {
		// preapre
		Method m = PowerMockito.method(XxxService.class, "isPositiveNumber", new Class[] { int.class });

		// action
		boolean res = (Boolean) m.invoke(target, 2);

		// assert
		assertTrue(res);
	}

	@Test
	public void verifyPrivateMethodInvoke() throws Exception {
		// prepare

		// action
		target.foreach(2);

		// assert
		PowerMockito.verifyPrivate(target, times(2)).invoke("isPositiveNumber", anyInt());
	}

}
