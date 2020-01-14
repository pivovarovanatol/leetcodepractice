package com.leetcode.algors.BinaryTreePostOrderTraversal;
//https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	
	// Solved iteratively. 1ms (<51%) 35.6MB(<100%)
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        HashSet<TreeNode> set = new HashSet<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode node = root;
        st.push(root);
        node=root;
        
        while (!st.isEmpty()){
        	if (node.left!=null && !set.contains(node.left)) {
        		st.push(node);
        		node = node.left;
        		// continue;
        	} else if (node.right!=null && !set.contains(node.right)) {
        		st.push(node);
        		node = node.right;
        		// continue;
        	} else if (!set.contains(node)) {
        		set.add(node);
        		result.add(node.val);
                node = st.pop();
        	} else {
                node = st.pop();    
            }
        }
        return result;
    }

	// Solved iteratively. 1ms (<51%) 35.6MB(<100%)
    public List<Integer> postorderTraversal3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<TreeNode> set = new HashSet<>();
        if (root==null){
            return result;
        }
        
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode node = root;
        st.push(root);
        node=root;
        
        while (!st.isEmpty()){
        	
        	if (node.left!=null && !set.contains(node.left)) {
        		st.push(node);
        		node = node.left;
        		continue;
        	}
        	
        	if (node.right!=null && !set.contains(node.right)) {
        		st.push(node);
        		node = node.right;
        		continue;
        	}

        	if (!set.contains(node)) {
        		set.add(node);
        		result.add(node.val);
        	}
    		node = st.pop();
        }
        
        return result;
    }

    

	// First trivial solution with DFS. 0ms(<100%) 35.1MB(<100%)
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
    
    public void dfs(TreeNode root, List<Integer> result){
        if (root==null){
            return;
        } else {
           if (root.left!=null){
                dfs(root.left, result);   
           }
           if (root.right!=null){
                dfs(root.right, result);   
           }
           result.add(root.val);
        }
        return;
    }
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        if (root==null){
            return result;
        }
        
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode node = root;
        st.push(root);
        node=root;
        
        while (!st.isEmpty()){
        	if (node.left!=null) {
        		st.push(node.left);
        		node = node.left;
        		continue;
        	} 
        	
        	node = st.pop();
        	if (!set.contains(node)) {
        		result.add(node.val);
        		set.add(node);
        	}
        	
        	if (node.right!=null) {
        		st.push(node.right);
        		node = node.right;
        	}
        }
        return result;
    }

        
    
}

