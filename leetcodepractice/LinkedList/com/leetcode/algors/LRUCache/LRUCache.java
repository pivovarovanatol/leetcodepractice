package com.leetcode.algors.LRUCache;
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3309/

import java.util.HashMap;

// Solved with HashMap<Integer, Node> and Doubly-linked List of Node. 
// Node represents the queue holds the key-value pairs and left/right neighbors.
// HashMap holds keys and corresponding Node objects. 
public class LRUCache {
    class Node {
		int value;
		int key;
		Node left;
		Node right;
	}

    HashMap<Integer, Node> hashmap;
	Node start, end;
	int LRU_SIZE = 4;

    public LRUCache(int capacity) {
        LRU_SIZE = capacity;
        hashmap = new HashMap<Integer, Node>();
        
    }
    
    public int get(int key) {
        if (hashmap.containsKey(key)) {
			Node node = hashmap.get(key);
			removeNode(node);
			addAtTop(node);
			return node.value;
		}
		return -1;
    }
    
    public void put(int key, int value) {
		if (hashmap.containsKey(key)) {
			Node node = hashmap.get(key);
			node.value = value;
			removeNode(node);
			addAtTop(node);
		} else {
			Node newnode = new Node();
			newnode.left = null;
			newnode.right = null;
			newnode.value = value;
			newnode.key = key;
			if (hashmap.size() >= LRU_SIZE) {
				hashmap.remove(end.key);
				removeNode(end);				
				addAtTop(newnode);
			} else {
				addAtTop(newnode);
			}
			hashmap.put(key, newnode);
		}
    }

    public void addAtTop(Node node) {
		node.right = start;
		node.left = null;
		if (start != null)
			start.left = node;
		start = node;
		if (end == null)
			end = start;
	}

	public void removeNode(Node node) {
		if (node.left != null) {
			node.left.right = node.right;
		} else {
			start = node.right;
		}

		if (node.right != null) {
			node.right.left = node.left;
		} else {
			end = node.left;
		}
	}

}
