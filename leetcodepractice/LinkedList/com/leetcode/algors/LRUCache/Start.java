package com.leetcode.algors.LRUCache;

public class Start {
    
	public static void main(String[] args) {
		int capacity = 2;
		int key = 0, value = 0;
		
		LRUCache obj = new LRUCache(2);
		obj.put(1,1);
		obj.put(2,2);
		System.out.println(obj.get(1));
		obj.put(3,3);
		System.out.println(obj.get(2));
		obj.put(4,4);
		System.out.println(obj.get(1));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
    }
}
