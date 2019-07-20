package com.leetcode.algors.RomanToInteger;

class Solution {
    public int romanToInt(String s) {
        
        int result = 0;
        
        char[] arr = s.toCharArray();
        int n= arr.length;
        
        
        for (int i=0;i<n;i++){
            char current = arr[i];

            if (current !='I' && current !='X' && current !='C'){
                // normal situation
                if (current == 'M') {
                    result+=1000;
                } else 
                if (current == 'D') {
                    result+=500;
                } else
                if (current == 'L') {
                    result+=50;
                } else
                if (current == 'V') {
                    result+=5;
                }
            }

            if (current == 'I'){
            	if (i<n-1) {
                    char next = arr[i+1];
                    if (next == 'V') {
                        result+=4;
                        i++;
                    } else
                    if (next == 'X') {
                        result+=9;
                        i++;
            	}
                else {
                	result +=1;
                } 
                    } else { 
                	result +=1;
                }
            }
            
            if (current == 'X'){
            	if (i<n-1) {
                    char next = arr[i+1];
                    if (next == 'L') {
                        result+=40;
                        i++;
                    } else
                    if (next == 'C') {
                        result+=90;
                        i++;
            	}
                else {
                	result +=10;
                } 
                    } else { 
                	result +=10;
                }
            }
            
            
            if (current == 'C'){
            	if (i<n-1) {
                    char next = arr[i+1];
                    if (next == 'D') {
                        result+=400;
                        i++;
                    } else
                    if (next == 'M') {
                        result+=900;
                        i++;
            	}
                else {
                	result +=100;
                } 
                    } else { 
                	result +=100;
                }
            }
            
        }
        
        //System.out.println(result);
        return result;
    }
}