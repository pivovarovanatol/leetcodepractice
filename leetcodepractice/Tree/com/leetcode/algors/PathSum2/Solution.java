package com.leetcode.algors.PathSum2;
// https://leetcode.com/problems/path-sum-ii/

import java.util.ArrayList;
import java.util.List;

class Solution {
	
	// solved recursively. 1ms(<100%) 46.7MB(<6%)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // trying to solve with DFS
        List<List<Integer>> result = new ArrayList<>();
        
        if (root==null){
            return result;
        }
        
        List<Integer> list = new ArrayList<>();
        //list.add(root.val);
        dfs(list, root, sum, result);
        
        return result;
    }
    
    void dfs(List<Integer> list, TreeNode root, int sum, List<List<Integer>> result){
        // base case for recursion
        if (root == null){
            return;
        }
        // leaf node -> check the running sum. if matches the remainder - add to the list and result
        if (root.left == null && root.right == null){
            list.add(root.val);
            if (root.val == sum){
            	List<Integer> l = new ArrayList<>(list);
                result.add(l);
            }
            list.remove(list.size()-1);
            return;
        } else {
            list.add(root.val);
            dfs(list, root.left, sum - root.val, result);
            dfs(list, root.right, sum - root.val, result);
            list.remove(list.size()-1);
        }
        
        return;
    }
    
    
}


