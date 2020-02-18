package com.leetcode.algors.CombinationSum;
import java.util.List;
// https://leetcode.com/problems/combination-sum/


public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] candidates = {2,3,5};
		int target = 8;
		Solution sl = new Solution();
		List<List<Integer>> actual = sl.combinationSum(candidates, target);
		
		for (List<Integer> list : actual) {
			for (int element : list) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
		
	}
}
