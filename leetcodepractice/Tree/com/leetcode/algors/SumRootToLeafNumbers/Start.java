package com.leetcode.algors.SumRootToLeafNumbers;
//https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class Start {

	public static void main(String[] args) {
		int[] arr = {4,9,0,5,1};
		Solution sl = new Solution();
		TreeNode root = new TreeNode(arr[0]);
		root = insertLevelOrder(root, arr, 0);
		
		
		//printByLevel(root);
		//System.out.println();
		int result = sl.sumNumbers(root);
		System.out.println(result);
		
	}
	
	public static TreeNode insertLevelOrder(TreeNode root, int[] arr, int i) {
        // Base case for recursion 
        if (i < arr.length) {
        	TreeNode temp = null;
        	
        	if (arr[i]!=-1) {
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

