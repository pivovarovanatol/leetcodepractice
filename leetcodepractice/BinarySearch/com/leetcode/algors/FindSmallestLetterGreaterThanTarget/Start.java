package com.leetcode.algors.FindSmallestLetterGreaterThanTarget;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] letters = {'e','e','e','e','e','e','n','n','n','n'};
		char target = 'e';
		Solution sl = new Solution();
		char result = sl.nextGreatestLetter(letters, target);

		System.out.println(result);
	}
    
}

