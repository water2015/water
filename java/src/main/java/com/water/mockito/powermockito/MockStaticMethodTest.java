package com.water.mockito.powermockito;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(XxxUtil.class)
public class MockStaticMethodTest {

	@Test
	public void mockStaticMethodAndVerifyStaticMethod() {
		// prepare
		XxxService service = new XxxService();
		PowerMockito.mockStatic(XxxUtil.class);
		when(XxxUtil.isSafe(anyInt())).thenReturn(false);

		// action
		boolean res = service.isAllowBuy(2);

		// assert
		assertFalse(res);

		/*
		 * 
		 * // Different from Mockito, always use PowerMockito.verifyStatic()
		 * first PowerMockito.verifyStatic(Mockito.times(2)); // Use
		 * EasyMock-like verification semantic per static method invocation
		 * Static.firstStaticMethod(param);
		 * 
		 * // Remember to call verifyStatic() again
		 * PowerMockito.verifyStatic(Mockito.never());
		 * Static.secondStaticMethod();
		 */
		PowerMockito.verifyStatic(times(1));
		XxxUtil.isSafe(anyInt());
	}

	@Test(expected = RuntimeException.class)
	public void mockStaticMethodThrowException() {
		// prepare
		XxxService service = new XxxService();
		PowerMockito.mockStatic(XxxUtil.class);
		PowerMockito.doThrow(new RuntimeException()).when(XxxUtil.isSafe(anyInt()));

		// action
		service.isAllowBuy(2);
	}

}
