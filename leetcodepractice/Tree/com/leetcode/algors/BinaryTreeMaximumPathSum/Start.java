package com.leetcode.algors.BinaryTreeMaximumPathSum;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class Start {

	public static void main(String[] args) {
		// int[] arr = {5,4,8,11,-11111,13,4,7,2,-11111,-11111,-11111,1}; // 48
		
		int[] arr = {9,6,-3,-11111,-11111,-6,2,-11111,-11111,2,-11111,-6,-6,-6};
		Solution sl = new Solution();
		TreeNode root = new TreeNode(arr[0]);
		root = insertLevelOrder(root, arr, 0);
		
		int result = sl.maxPathSum(root);
		System.out.println(result);
		
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

