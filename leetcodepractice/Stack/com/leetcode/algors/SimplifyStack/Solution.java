package com.leetcode.algors.SimplifyStack;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	
	
	// Solved with 1 stack. 4ms(<90%) 36.5MB(<100%)
    public String simplifyPath(String path) {
        
        String tmp="";

        int n = path.length();
        char[] arr = path.toCharArray();

        Deque<String> stack = new ArrayDeque<String>();
        tmp = "";
        
        // 1. Put everyting in the stack: 
        // Execute once for every character in the String -> O(n)
        for (int i=1;i<n;i++){
        	char ch = arr[i]; 
        	if (ch == '/') {
                //System.out.println(" Symbol is " + tmp);
            	if (tmp.length() > 0) {
            		if (tmp.equals(".")) {
                    // do nothing
                    } else if (tmp.equals("..") ) {
                    	if (stack.size() > 0) {
                    		stack.pop();
                    	} 
                    } else {
                    	stack.push(tmp);	
                    }
            	}
                tmp = "";                    
            } else {
                tmp = tmp + arr[i];
            	if (tmp.length() > 0 && i == n-1) {
            		if (tmp.equals(".")) {
                    // do nothing
                    } else if (tmp.equals("..")  && stack.size() > 0) {
                    	stack.pop();
                    } else {
                    	stack.push(tmp);	
                    }
            	}
            }
        }
        
        
        // 2. Construct path from the stack
        // Execute once for word in the stack -> O(n) worse case
        tmp="";
        path = "";
        while (stack.size()>0){
            tmp = stack.pop();
            if (!tmp.equals("..")) {
            	path = "/" + tmp + path;
            }
           		
                         
        }    
        //path = path + "/";
                
        
        path = path.length() > 0 ? path.trim() : "/";
        
        return path;
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	// solved with Queue + Stack in 5 steps - too slow, need to optimize. 14ms (<6.5%) 37.6MB(<87%)
    public String simplifyPath2(String path) {
        
        // 1. remove multiple '/' - keep just one
        String tmp="";
        String tmp1=path;
        while (1==1){
            tmp = tmp1.replaceAll("//","/");
            if (tmp1.equals(tmp)){
                break;
            }
            tmp1 = tmp;
        }
        path = tmp;
        int n = path.length();
        char[] arr = path.toCharArray();

        // 2. remove trailing '/'
        for (int i=n-1;i>=0;i--){
            if (arr[i] == '/') {
                arr[i] = ' ';
            } else {
                break;
            }
        }
        
        // 3. Put everyting in the queue: 
        Deque<String> queue = new ArrayDeque<String>();

        tmp = "";
        for (int i=1;i<n;i++){
            if (i==n-1 && arr[i] != '/'){
                tmp = tmp + arr[i];
                queue.addLast(tmp);
            }
            if (arr[i] == '/') {
                queue.addLast(tmp);
                tmp = "";                    
            } else {
                tmp = tmp + arr[i];
            }
            
            
        }
        
        // 4. Construct stack from the queue 
        // '.' - do nothing
        // '..' - pop
        // anything else - push
        Deque<String> stack = new ArrayDeque<String>();
        tmp = "";
        while (queue.size() > 0){
            tmp = queue.removeFirst().trim();
            //System.out.println("To analyze: " + tmp);
            if (tmp.equals(".")) {
                //System.out.println("Tmp is '.' - do nothing...");
            } else if (tmp.equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();   
                }
            } else {
                stack.push(tmp);
            }
        }
        
        // 5. Construct path from the stack
        tmp="";
        path = "";
        while (stack.size()>0){
            tmp = stack.pop();
            path = "/" + tmp + path;             
            //System.out.println(path + " <- " + tmp);
        }    
        //path = path + "/";
                
        
        path = path.length() > 0 ? path.trim() : "/";
        
        return path;
    }
}

