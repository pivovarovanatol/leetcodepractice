package com.leetcode.algors.ReplaceWords;
//https://leetcode.com/problems/replace-words/

import java.util.Arrays;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] dict = {"a", "b", "c"};
		String sentence = "aadsfasf absbs bbab cadsfafs";
		Solution sl = new Solution();
		String result = sl.replaceWords(Arrays.asList(dict), sentence);
		System.out.println("!" +  result + "!");
		
	}
}
