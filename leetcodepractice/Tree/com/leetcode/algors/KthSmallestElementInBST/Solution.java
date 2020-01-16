package com.leetcode.algors.KthSmallestElementInBST;
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list;
    
    //solved with DFS and in-order traversal. 1ms(<58%) 45.5MB(<6%)
    public int kthSmallest(TreeNode root, int k) {
        
        list =  new ArrayList<Integer>();
        if (root==null){
            return -1;    
        }
        
        dfs(root);
        
        return list.get(k-1);
    }
    
    void dfs(TreeNode root){
        if (root==null){
            return;
        }
        
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    
    
    
    
}