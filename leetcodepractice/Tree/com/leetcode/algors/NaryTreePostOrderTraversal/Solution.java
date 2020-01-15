package com.leetcode.algors.NaryTreePostOrderTraversal;
// https://leetcode.com/problems/n-ary-tree-postorder-traversal/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class Solution {

	// from discussions with linked list. Same time.
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> output_list = new LinkedList<Integer>();
        if(root == null)
            return output_list;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.empty()) {
            Node currNode = s.pop();
            output_list.addFirst(currNode.val);
            for(int i = 0; i < currNode.children.size(); i++) {
                if(currNode.children.get(i) != null) {
                    s.push(currNode.children.get(i));
                }
            }
        }
        
        return output_list;
    }
	
	// solved iteratively. 3ms(<36%) 39.8MB(<100%)
    public List<Integer> postorder3(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Deque<Node> st = new ArrayDeque<>();
        
        st.push(root);
        Node node = root;
        
        while (!st.isEmpty()) {
        	if (node.children != null && !node.children.isEmpty()) {
   				st.push(node);
   				Node tmp = node.children.get(0);
   				node.children.remove(0);
   				node = tmp;
   				continue;
        	} else {
        		result.add(node.val);
        		node = st.pop();        	
        	}
        }
        
        return (result);
    }
    
    
	
	
	// solved iteratively. 6ms(<8.77%) 39.8MB(<100%)
    public List<Integer> postorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Deque<Node> st = new ArrayDeque<>();
        HashSet<Node> set = new HashSet<>();
        
        st.push(root);
        Node node = root;
        boolean foundChild = false;
        
        while (!st.isEmpty()) {
        	
        	if (node.children != null && !node.children.isEmpty()) {
        		for (Node n : node.children) {
        			if (!set.contains(n)) {
        				st.push(node);
        				node.children.remove(0);
        				node = n;
        				foundChild = true;
        				set.add(node);
        				break;
        			}
        		}
        		if (foundChild) {
        			foundChild=false;
        			continue;
        		} else {
            		result.add(node.val);
            		node = st.pop();        	
        		} 
        	} else {
        		result.add(node.val);
        		node = st.pop();        	
        	}
        }
        
        return (result);
    }
    
    

	
	// solved recursively. 1ms(<90%) 40.3MB(<100%)
    public List<Integer> postorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }
        dfs(root, result);
        return (result);
    }
    
    
    void dfs(Node root, List<Integer> result){
        if (root == null){
            return;
        }

        if (root.children == null){
            result.add(root.val);
        } else {
            for (Node child : root.children){
                dfs(child, result);
            }
            result.add(root.val);
        }
        return;        
    }
        
    
}

