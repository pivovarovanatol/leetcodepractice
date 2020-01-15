package com.leetcode.algors.PathSum2;
//https://leetcode.com/problems/path-sum-ii/

import java.util.List;

public class Start {

	public static void main(String[] args) {
		// int[] arr = {5,4,8,11,-11111,13,4,7,2,-11111,-11111,-11111,1}; // 48
		
		int[] arr = {5,4,8,11,-11111,13,4,7,2,-11111,-11111,5,1-11111,-11111};
		Solution sl = new Solution();
		TreeNode root = new TreeNode(arr[0]);
		root = insertLevelOrder(root, arr, 0);
		
		List<List<Integer>> result = sl.pathSum(root, 22);
		
		for (List<Integer> l : result) {
			for (int i: l) {
				System.out.print(i+ " ");
			}
			System.out.println();
		}
		
	}
	
	public static TreeNode insertLevelOrder(TreeNode root, int[] arr, int i) {
        // Base case for recursion 
        if (i < arr.length) {
        	TreeNode temp = null;
        	
        	if (arr[i]!=-11111) {
            	temp = new TreeNode(arr[i]); 
        	} else {
        		return null;
        	}
            root = temp; 
            root.left = insertLevelOrder(root.left, arr, 2 * i + 1); 
            root.right = insertLevelOrder(root.right, arr,2 * i + 2); 
        } 
        return root; 
	}
	
}

