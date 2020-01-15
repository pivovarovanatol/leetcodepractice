package com.leetcode.algors.BinaryTreeMaximumPathSum;
// https://leetcode.com/problems/binary-tree-maximum-path-sum/

import java.util.HashMap;

class Solution {
	
	// From discussions. 1ms(<99%) 51.5MB(<6%)
    int max = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        if (root==null) {
        	return 0;
        }
        traverse(root);
        return max;
    }
    
    public int traverse(TreeNode root){
        if(root == null) return -1;
        if(root.left == null && root.right == null){
            max = Math.max(max,root.val);
            return root.val;
        }
        int maxLeft = traverse(root.left);
        int maxRight = traverse(root.right);
        int combined = Math.max(root.val,Math.max(maxLeft + root.val,maxRight + root.val));
        int total = Math.max(combined,root.val+maxLeft+maxRight);
        max = Math.max(max,total);
        return combined;
    }
	
	// solved recursively. 10ms(<5%) 51MB(<6%)
    public int maxPathSum(TreeNode root) {
        // create a structure to store path sum for left and right subtree.
        // iterate over and sum left + rigth + val - and check max
        HashMap<TreeNode,int[]> paths = new HashMap<>();
        if (root==null) {
        	return 0;
        }
        // Fill the structure with DFS
        dfs(root, paths);
        
        // Iterate over HashMap and calculate paths
        int maxSum = Integer.MIN_VALUE;
        
        for (TreeNode n : paths.keySet()){
            int[] list = paths.get(n);
            int left = list[0];
            int right = list[1];
            int currVal = n.val;
            
            if (currVal > maxSum) {
                maxSum = currVal;
            }
            if (currVal + left > maxSum){
                maxSum = currVal + left;
            }
            
            if (currVal + right > maxSum){
                maxSum = currVal + right;
            }
            
            if (currVal + right + left > maxSum){
                maxSum = currVal + right + left;
            }
        }
        
        return maxSum;
    }
    
    
    int dfs(TreeNode root, HashMap<TreeNode, int[]> paths){
        if (root==null){
            return 0;
        }
        //System.out.println(root.val);
        
        int left = root.left == null ? 0 : dfs(root.left, paths);
        left = left < 0 ? 0 : left;
        int right = root.right == null ? 0 : dfs(root.right, paths);
        right = right < 0 ? 0 : right;
        int[] l = new int[2];
        l[0] = left;
        l[1] = right;
        paths.put(root, l);
        return root.val + (left > right ? left : right);
    }

}
