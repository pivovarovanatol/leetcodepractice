package com.leetcode.algors.DeleteNodesAndReturnForest;
// https://leetcode.com/problems/delete-nodes-and-return-forest/

import java.util.ArrayList;
import java.util.List;


class Solution {
	
	// solved with DFS. 0ms(<100%) 40,7MB(<100%)
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        int[] valsToDelete = new int[1001];
        if (root==null){
            return null;
        }
        
        if (to_delete==null || to_delete.length==0) return null;
        
        for (int e: to_delete){
            valsToDelete[e]=1;
        }
        
        if (valsToDelete[root.val]!=1){
            result.add(root);
        }
        dfs(root, valsToDelete, result);
        
        return result;
    }
    
    TreeNode dfs(TreeNode root, int[] valsToDelete, List<TreeNode> result){
        
        if (root==null){
            return null;
        }
        //need to delete this node
        if (valsToDelete[root.val]==1){
            
            TreeNode left = dfs(root.left, valsToDelete, result);
            TreeNode right = dfs(root.right, valsToDelete, result);
            
            if (left!=null) result.add(left);
            if (right!=null) result.add(right);
            
            return null;
            
        } else {
        // no need to delete this node -> checking children
            TreeNode left = dfs(root.left, valsToDelete, result);
            TreeNode right = dfs(root.right, valsToDelete, result);
            
            root.left = left;
            root.right = right;
            return root;
        }
    }
    
}