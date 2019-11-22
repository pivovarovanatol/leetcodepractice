package com.leetcode.algors.MinimumDistanceBetweenBstNodes;
//https://leetcode.com/problems/minimum-distance-between-bst-nodes/

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	
	// From discussions - 0ms(<100%) 34.6MB(<100%)
	int min = Integer.MAX_VALUE;
	Integer prev = null;

	public int minDiffInBST(TreeNode root) {
		if(root==null) return -1;
		minDiffInBST(root.left);
		if (prev!=null)
			min = Math.min(min, root.val - prev);
		prev = root.val;
		minDiffInBST(root.right);

		return min; 
	}
	
	
	// solved with in-order traversal and scan of the array. 1ms(<32%) 34.4MB(<100%)
    public int minDiffInBST2(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>(); 

        inOrder(root, list);
        
        int start = Integer.MAX_VALUE;
        
        for (int tmp : list){
            int diff = Math.abs(tmp - start);
            if (diff < minDiff){
                minDiff = diff;
            }
            start = tmp;
        }

        return minDiff;    
    }

    void inOrder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        
        if (root.left != null){
            inOrder(root.left, list);
        }
        list.add(root.val);
        if (root.right != null){
            inOrder(root.right, list);
        }
    }

    
}