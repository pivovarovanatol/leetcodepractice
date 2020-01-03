package com.leetcode.algors.LCAofBinarySearchTree;
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/


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
	
	// Solved with DFS assuming conditions. 4ms (<100%) 39MB(<5%)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null){
            return null;
        }
        
        if (p.val == root.val || q.val == root.val) {
        	return root;
        }
        
        
        if (p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val) {
        	return root;
        } 
        
        if (p.val < root.val) 
        	return lowestCommonAncestor(root.left, p, q);
        else 
        	return lowestCommonAncestor(root.right, p, q);
    }
	
	
	
	// Solved with standard DFS with checking right/left subtrees. 7ms(<22%) 39MB(<5%)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Check where nodes are. If in different subtrees - then current node is the LCA. 
        // Otherwise do DFS on the subtree where the nodes are.
        
        if (root == null || p == null || q == null){
            return null;
        }
        
        TreeNode lca = findLCA(root, p, q);
        
        return lca;
    }
    
    TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }
                
        if (root == p || root==q){
            return root;
        }
        
        TreeNode leftP = dfs(root.left, p);
        TreeNode rightP = dfs(root.right, p);
        
        TreeNode leftQ = dfs(root.left, q);
        TreeNode rightQ = dfs(root.right, q);   
        
        if ((leftP != null && rightQ !=null) || (rightP !=null && leftQ != null)){
            return root;
        };
        if (leftP!=null && leftQ!=null){
            return findLCA(root.left,p,q);
        }
        if (rightP!=null && rightQ!=null){
            return findLCA(root.right,p,q);
        }
        
        return null;
    }
    
    
    TreeNode dfs(TreeNode root, TreeNode node){
        if (root == null){
            return null;
        }
        
        if (root == node){
            return node;
        }
        TreeNode left = dfs(root.left, node);
        TreeNode right = dfs(root.right, node);
        if (left!=null) return left;
        if (right!=null) return right;
        
        return null;
        
    }
    
    
}


