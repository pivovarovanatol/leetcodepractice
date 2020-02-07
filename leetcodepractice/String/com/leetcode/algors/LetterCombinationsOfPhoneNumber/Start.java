package com.leetcode.algors.LetterCombinationsOfPhoneNumber;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.List;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Tst");
		Solution sl = new Solution();
		List<String> actual = sl.letterCombinations("23456");
		
		for (String str : actual) {
			System.out.println(str);
		}
		
		
	}

}
