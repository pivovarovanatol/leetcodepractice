package com.leetcode.algors.BinaryWatch;
//https://leetcode.com/problems/binary-watch/

import java.util.ArrayList;
import java.util.List;

class Solution {
	
	// Solved with shift and & operation. 1ms(<99%) 35.9MB(<100%)
    public List<String> readBinaryWatch(int num) {
       
        
        List<String> result = new ArrayList<>();
        
        for (int h=0;h<=11;h++){
            int hourBits = numberOfBits(h);

            for (int m=0;m<=59;m++){
                int minuteBits = numberOfBits(m);
                
                if (hourBits + minuteBits == num){
                    String tmp = "000000" + Integer.toString(m);
                    result.add(Integer.toString(h) + ":" +(tmp.substring(tmp.length()-2, tmp.length())));
                }
                
            }
            
        }
        
        return result;
    }
    
    int numberOfBits(int n){
        
        int count=0;
        
        for (int i=0;i<32;i++){
            int tmp = n &1;
            count +=tmp;
            n = n >>> 1;
        }
        return count;        
    }
    
    
}