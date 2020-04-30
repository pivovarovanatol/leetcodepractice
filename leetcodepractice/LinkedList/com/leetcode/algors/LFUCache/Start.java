package com.leetcode.algors.LFUCache;
// https://leetcode.com/problems/lfu-cache/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Start {
    
	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\leetcodepractice\\leetcodepractice\\LinkedList\\com\\leetcode\\algors\\LFUCache\\input2.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // number of cases
        String commands = input.next();
        String operands = input.next();
        
        String[] coms = commands.split("A");
        String[] ops = operands.split("A");
		
        int capacity = Integer.parseInt(ops[0]);
        LFUCache cache = new LFUCache(capacity);
        
        
        for (int i=1;i<coms.length;i++) {
        	if (coms[i].equals("put")) {
        		String[] keyVal = ops[i].split(",");
        		int key = Integer.parseInt(keyVal[0]);
        		int value = Integer.parseInt(keyVal[1]);
        		cache.put(key, value);
        	} else {
        		int key = Integer.parseInt(ops[i]);
        		System.out.print(cache.get(key)+" ");
        	}
        }
        
        
    }
}
