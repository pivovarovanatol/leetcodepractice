package com.leetcode.algors.LongestCommonSubsequence;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String text2 = "a";
//		String text1 = "n";
		
//		String text2 = "oxcpqrsvwf";
//		String text1 = "shmtulqrypy";

		
//		String text2 = "mhunuzqrkzsnidwbun";
//		String text1 = "szulspmhwpazoxijwbq";
		
		String text1 = "parovarov";
		String text2 = "povar";

		Solution sl = new Solution();
		int result = sl.longestCommonSubsequence(text1, text2);
		System.out.println(result);
	}

}
