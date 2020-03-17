package com.leetcode.algors.CombinationSumIII;
import java.util.List;
// https://leetcode.com/problems/combination-sum-iii/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=3, n=7;
		
		Solution sl = new Solution();
		List<List<Integer>> actual = sl.combinationSum3(k, n);
		
		for (List<Integer> list : actual) {
			for (int element : list) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
		
	}
}
