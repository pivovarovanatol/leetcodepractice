package com.leetcode.algors.BinaryWatch;

import java.util.List;

//https://leetcode.com/problems/binary-watch/

public class Start {

	public static void main(String[] args) {
		
		Solution sl = new Solution(); 
		List<String> actual = sl.readBinaryWatch(5);
		
		for (String s : actual) {
			System.out.println(s);
		}
		

	}
	
}

