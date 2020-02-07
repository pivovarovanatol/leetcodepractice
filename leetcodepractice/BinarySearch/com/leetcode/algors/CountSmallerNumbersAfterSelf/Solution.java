package com.leetcode.algors.CountSmallerNumbersAfterSelf;
// https://leetcode.com/problems/count-of-smaller-numbers-after-self/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	// solved with some Tree structure (Fenwick tree?) 4ms (<97%) 41MB(<8%)
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[nums.length];
        if (nums==null || nums.length==0) return result;
        TreeNode root = new TreeNode(nums[nums.length-1]);
        
        for (int i=nums.length-2;i>=0;i--){
            add(root, nums[i], 0, result);
        }
        
        Collections.reverse(result);
        result.add(0);
        return result;
    }
    
    void add(TreeNode root, int val, int count, List<Integer> result){
        if (root==null) return;
        else if (val > root.val) {
        	count += root.countSame;
        	if (root.right!=null) {
        		add(root.right,val,count, result);
        	} else {
        		TreeNode node = new TreeNode(val);
        		node.countSmaller=count;
        		result.add(count);
        		root.right=node;
        	}
        } else {
        	root.countSame++;
        	if (root.left !=null) {
        		add(root.left,val,count,result);
        	} else {
        		TreeNode node = new TreeNode(val);
        		result.add(count);
        		node.countSmaller=count;
        		root.left=node;
        	}
        }
    }
    
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int countSmaller;
    int countSame;
    
    TreeNode(int val){
    	this.countSame=1;
        this.val = val;
    }
}

	
    // naive brute force solution. 
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums==null || nums.length==0) return result;
        
        for (int i=0;i<nums.length-1;i++){
            int count = 0;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]<nums[i]) count++;
            }
            result.add(count);
        }
        result.add(0);
        return result;
    }
}
