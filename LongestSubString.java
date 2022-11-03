package com.epam.learning;

public class LongestSubString {

	public static void main(String[] args) {
		String str = "abcdefajhibjklmcnopqr";
		String tempString = "";
		String longestString = "";
		for (char x : str.toCharArray()) {
			if (tempString.contains(String.valueOf(x))) {
				tempString = tempString.substring(tempString.indexOf(x) + 1);
			}
			tempString += String.valueOf(x);
			if (longestString.length() < tempString.length()) {
				longestString = tempString;
			}
		}
		System.out.println(longestString.length());
		
	}

}
