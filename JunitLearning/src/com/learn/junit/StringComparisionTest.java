package com.learn.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringComparisionTest {

	@Test
	void test() {
		StringComparision s=new StringComparision();
		boolean c=s.com("Akhilesh","Akhilesh");
		assertEquals(true,c);
	}

}
