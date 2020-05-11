package com.leetcode.algors.DFS.NumberOfWaysCuttingPizza;
//https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] pizza = {"A...","AA.A","..A.",".A.A"};
//		int k=3;
//		int expected = 19;
		
		String[] pizza = {".A","AA","A."};
		int k=3;
		int expected = 2;

//		String[] pizza = {"A..", "AAA", "..."};
//		int k=3;
//		int expected = 3;
		
		
		Solution sl = new Solution();
		int result = sl.ways(pizza, k);
		System.out.println(result);
	}
}
