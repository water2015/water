package com.water.mockito.powermockito;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(XxxService.class)
public class MockConstructionTest {

	@Test
	public void mockConstruction() throws Exception {
		// prepare
		XxxService service = new XxxService();
		XxxUtil util = new XxxUtil();
		String name = "hello";
		util.setName(name);
		PowerMockito.whenNew(XxxUtil.class).withNoArguments().thenReturn(util);

		// action
		XxxUtil res = service.getUtil();

		// assert
		assertEquals(name, res.getName());
	}

}
