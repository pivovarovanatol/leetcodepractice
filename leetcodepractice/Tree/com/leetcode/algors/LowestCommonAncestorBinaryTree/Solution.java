package com.leetcode.algors.LowestCommonAncestorBinaryTree;
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


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
	// solved with DFS. 4ms(<100%) 42.5MB(<5%)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // idea: do dfs and check if both nodes exist. If one in left and another is in the right -> return that node as LCA
        if (root==null) return null;
        TreeNode lca = getLCA(root, p,q);
        return lca;        
    }
    
    public TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return null;
        if (root==p || root==q) return root;
        
        TreeNode leftTree = getLCA(root.left, p,q);        
        TreeNode rightTree = getLCA(root.right, p,q);        
        
        if (leftTree!= null && rightTree!= null) return root;
        if (leftTree!=null) return leftTree;
        if (rightTree!=null) return rightTree;
        return null;
    } 
    
}
