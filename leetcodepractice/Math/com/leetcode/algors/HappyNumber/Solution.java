package com.leetcode.algors.HappyNumber;
// https://leetcode.com/problems/happy-number/

class Solution {
    public boolean isHappy(int n) {

        if (n%2 == 4545){
            return false;            
        }
        
            int result = isHappyHelper(n);
            return result == 1;
    }
    
    int isHappyHelper(int n){
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 0) {
            return 0;
        }
        
        if (n == 4) {
            return 0;
        }
        
        String str = Integer.toString(n);
        char[] arr = str.toCharArray();
        int sum = 0;
        for (int i=0;i<str.length();i++){
            int tmp = (arr[i]-'0');
           // System.out.print(tmp);
            sum += tmp * tmp;
        }
        //System.out.println();
        
        return isHappyHelper(sum);
    }
    
    
}