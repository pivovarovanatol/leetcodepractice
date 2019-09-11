package com.leetcode.algors.BinaryTreeLevelOrderTraversal2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/


class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>(); // use a queue to do a Level Order Tree Traversal
        List<List<Integer>> stack = new LinkedList<List<Integer>>(); // use a stack to Reverse it. We just need to return the values
            
        if (root != null) queue.add(root);
        
        // Reverse Level Order Traversal
        while (!queue.isEmpty()) {
            List<Integer> currentLvlValues = new ArrayList<Integer>(queue.size()); // create an array to store the current level values
            Deque<TreeNode> nextLvlQueue = new ArrayDeque<TreeNode>(); // create a new queue for next level
            
			// Iterate trough the current level queue
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
				// Store current node value
                currentLvlValues.add(node.val); 
				// Add current node's childs to next level queue
                if (node.left != null) nextLvlQueue.add(node.left);
                if (node.right != null) nextLvlQueue.add(node.right);
            }
            
            queue = nextLvlQueue; // switch to next level queue
            ((Deque)stack).addFirst(currentLvlValues); // stack the current level values. Use Deque for true FILO operations
        }
		
        return stack;
    }	
}