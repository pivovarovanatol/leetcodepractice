package com.leetcode.algors.PathSum;
// https://leetcode.com/problems/path-sum/submissions/


class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        
//    	if (sum < 0) {
//    		return false;
//    	}
    	
    	if (root == null) {
    		return false;
    	}
    	
    	if (root.left == null && root.right == null) {
    		if (root.val == sum) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	
    	boolean leftHasPathSum = false;
    	if (root.left != null) {
    		leftHasPathSum = hasPathSum(root.left, sum - root.val);
    		if (leftHasPathSum) return leftHasPathSum;
    	}
    	
    	boolean rightHasPathSum = false;
    	if (root.right != null) {
    		rightHasPathSum = hasPathSum(root.right, sum - root.val);
    		if (rightHasPathSum) return rightHasPathSum;
    	}
    	
    	
    	return leftHasPathSum || rightHasPathSum;
    }
    
    
}