package com.leetcode.algors.WordSearch;
// https://leetcode.com/problems/word-search/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//char[][] arr1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		//String word = "ABCCED";
		
		//char[][] arr1 = {{'A','B'}};
		//String word = "AB";

		// Should be true
		//char[][] arr1 = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
		//String word = "ABCESEEEFS";
		
		//char[][] arr1 = {{'A','A'}};
		//String word = "AAA";
		
		// Should be true
		char[][] arr1 = {{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
		String word = "AAAAAAAAAAAV";

		
		Solution sl = new Solution();
		boolean result = sl.exist(arr1, word);

		System.out.println(result);
		System.out.print(" ");
	}
    
}

