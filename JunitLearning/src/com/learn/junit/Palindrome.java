package com.learn.junit;

public class Palindrome {
	public static String palindromechaeck(String input) {
//		StringBuilder sb=new StringBuilder(input);
//		StringBuilder rev=sb.reverse();
		return (new StringBuilder(input).reverse().toString().equals(input)?"Palindrome":"Not Palindrome");
	}
}