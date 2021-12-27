package com.tcs;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestRunner {

	@Parameters({"what"})
	@Test
	public void test(String a) {
		System.out.println("this is a "+ a + ".");
	}
}
