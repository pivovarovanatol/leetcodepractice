package com.leetcode.algors.FlattenBinaryTreeToLinkedList;
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

import java.util.List;

public class Start {

	public static void main(String[] args) {
		// int[] arr = {5,4,8,11,-11111,13,4,7,2,-11111,-11111,-11111,1}; // 48
		int[] arr = {1,2,5,3,4,-11111,6};
		Solution sl = new Solution();
		TreeNode root = new TreeNode(arr[0]);
		root = insertLevelOrder(root, arr, 0);
		
		sl.flatten(root);
		
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

