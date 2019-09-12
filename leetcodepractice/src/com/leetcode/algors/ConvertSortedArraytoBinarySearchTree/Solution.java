package com.leetcode.algors.ConvertSortedArraytoBinarySearchTree;
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/


class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
    	return arrToBST(nums,0,nums.length-1);
    }
    
    public TreeNode arrToBST(int[] arr, int start, int end) {
    	int mid = start + (end - start+1) / 2; 
    	//System.out.println(start + " - " + end + ": mid = " + mid + " value = " + arr[mid]);
    	
    	if (start>end) {
    		return null;
    	}
    	TreeNode root = new TreeNode(arr[mid]);
    	root.left = arrToBST(arr,start,mid-1);
    	root.right = arrToBST(arr,mid+1,end);
    	return root;
    }
}