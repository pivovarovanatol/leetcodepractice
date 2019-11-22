package com.leetcode.algors.SimplifyStack;


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sl = new Solution();
		//String tmp ="/home//etc///sap//"; // 
		//String tmp ="/a//b////c/d//././/.."; // 
		//String tmp ="////..//"; // 
		String tmp ="/..";
		String path = sl.simplifyPath(tmp);
		System.out.println(path);
		
	}

}
