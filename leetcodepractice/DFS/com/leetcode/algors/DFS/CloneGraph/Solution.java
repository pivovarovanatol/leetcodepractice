package com.leetcode.algors.DFS.CloneGraph;
//https://leetcode.com/problems/clone-graph/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
	
	
	// Solved with DFS in 1ms(<100%) and 32.4MB(<98%)
    public Node cloneGraph(Node node) {
        
    	if (node==null) {
    		return node;
    	}
    	
    	
        //boolean[] visited = new boolean[100];
        HashMap<Node, Node> map = new HashMap<>();
        
        // try DFS approach
        Node newHead = dfs(node, map);
        
        return newHead;
        
    }
    
    
    Node dfs(Node source, HashMap<Node, Node> map){
        if (source == null){
            return null;
        }
        
        if (map.containsKey(source)){
            return map.get(source);
        }
        
        List<Node> children = new ArrayList<Node>();
        Node target = new Node(source.val, children);
        map.put(source, target);
        for (Node n : source.neighbors){
            Node child = dfs(n, map);
            target.neighbors.add(child);    
        }
        
        return target;
    }
    
}

