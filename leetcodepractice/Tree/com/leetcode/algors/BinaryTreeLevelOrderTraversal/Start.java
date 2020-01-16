package com.leetcode.algors.BinaryTreeLevelOrderTraversal;
// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.List;

public class Start {

	public static void main(String[] args) {
		int[] arr = {1,-11111,2,-11111,-11111,3,-11111,-11111};
		Solution sl = new Solution();
		TreeNode root = new TreeNode(arr[0]);
		root = insertLevelOrder(root, arr, 0);
		int  k=1;
		List<List<Integer>> result = sl.levelOrder(root);
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

