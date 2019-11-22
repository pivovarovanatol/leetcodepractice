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
	
	// solved with in-order traversal and scan of the array. 1ms(<32%) 34.4MB(<100%)
    public int minDiffInBST(TreeNode root) {
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