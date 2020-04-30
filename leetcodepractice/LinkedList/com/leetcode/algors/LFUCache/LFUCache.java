package com.leetcode.algors.LFUCache;
// https://leetcode.com/problems/lfu-cache/

import java.util.HashMap;

// solved with HashMap and DoublyLinked list. 130ms (<8%)
class LFUCache {
    HashMap<Integer, Node> map;
    Node begin;
    Node end;
    int CACHE_SIZE;
    public LFUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        CACHE_SIZE = capacity;
        begin = null;
        end = null;
    }
    
    public int get(int key) {
    	//System.out.println("obj.get("+key+");");
    	if (CACHE_SIZE<=0) return -1;
    	
        if (map.containsKey(key)){
            Node node = map.get(key);
            placeNode(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
    	//System.out.println("obj.put("+key+", "+value+");");
    	if (CACHE_SIZE<=0) return;
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            placeNode(node);
        } else {
            if (map.size() >= CACHE_SIZE) {
            	if (end == null) 
            		System.out.println("!!!");
                int k = end.key;
                end = end.left;
                if (end != null) end.right = null;
                map.remove(k);
            } 
            Node node = new Node();
            node.val = value;
            node.key = key;
            map.put(key, node);
            node.right = begin;
            if (begin != null ) begin.left = node;
            begin = node;
            placeNode(node);
            

        }
    }
    // place from the beginning
    void placeNode(Node node){
        node.count++;
        // move right if needed
        while (node.right!=null && node.right.count > node.count) {
        	Node child = node.right.right;
        	Node parent = node.left;
        	Node next = node.right;
        	//swap node and node.right
        	node.left = next;
        	node.right = child;
        	if (child != null) child.left = node;
        	next.left = parent;
        	next.right = node;
        	if (parent != null) parent.right = next;
        	else begin = next;
        }
        // move left if needed
        while (node.left!=null && node.left.count <= node.count) {
        	Node parent = node.left.left;
        	Node child = node.right;
        	Node prev = node.left;
        	//swap to node and node.left
        	node.right = prev;
        	node.left = parent;
        	if (parent != null) parent.right = node;
        	prev.right = child;
        	prev.left = node;
        	if (child != null) child.left = prev;
        	else end = prev;
        }
        if (node.right == null) end = node;
        if (node.left == null) begin = node;
        
     }
    
    
    // place from the end
     void placeNode2(Node node){
        node.count++;
        while (node.left!=null && node.left.count <= node.count) {
        	Node parent = node.left.left;
        	Node child = node.right;
        	//swap to node and node.left
        	node.right = node.left;
        	node.left = parent;
        	if (parent != null) parent.right = node;
        	node.right.right = child;
        	if (child != null) child.left = node.right;
        	else end = node.right;
        	node.right.left = node;
        }
        
        if (node.left == null) begin = node;
        if (node.right == null) end = node;
        
     }
    
    
class Node {
    int val;
    int key;
    int count;
    Node left;
    Node right;
    }
}