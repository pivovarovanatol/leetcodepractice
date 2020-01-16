package com.leetcode.algors.FlattenBinaryTreeToLinkedList;
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

import java.util.LinkedList;

class Solution {
	
	// From discussions. 0ms(<100%) 41.5MB(<5%)
    public void flatten(TreeNode root) {
        helper(root);
     }
    
    
     public TreeNode helper(TreeNode root)
     {
          if(root!=null&&root.left==null&&root.right==null)
             return root;
         else if(root!=null){
             TreeNode temp = root.right;
             root.right = helper(root.left);
             TreeNode temp2=root;
             while(temp2.right!=null)
                 temp2=temp2.right;
             temp2.right=temp;
             root.right = helper(root.right);
             root.left=null;
         }
         return root;
     }

	//solved recursively with DFS + LinkedList. 1ms(<25%) 41.8MB(<5%)
    public void flatten2(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        
        dfs(root, list);
        TreeNode prev = root;
        for(TreeNode node : list){
            if (node != root){
                prev.left = null;
                prev.right = node;
                prev = node;
            }
        }
        
    }
    
    public void dfs(TreeNode root, LinkedList<TreeNode> list){
        
        if (root==null){
            return;
        }
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
        return;
    }
    
}
