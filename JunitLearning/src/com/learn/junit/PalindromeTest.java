package com.learn.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeTest {

	@Test
	void test() {
		Palindrome p=new Palindrome();
		String result=p.palindromechaeck("amma");
		assertEquals("Palindrome",result);
	}
	@Test
	void test1() {
		Palindrome p=new Palindrome();
		String result=p.palindromechaeck("Akhiulesh");
		assertEquals("Not Palindrome",result);
	}


}
