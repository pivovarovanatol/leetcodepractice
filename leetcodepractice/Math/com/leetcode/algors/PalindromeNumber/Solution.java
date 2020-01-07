package com.leetcode.algors.PalindromeNumber;

class Solution {
	
	// from discussions. 6ms (<100%)
    public boolean isPalindrome(int x) {
        int rev = 0, y = x;
        while (y > 0) {
            rev = rev * 10 + y % 10;
            y /= 10;
        }
        return rev == x;
    }
	
	
	// reversing with the StringBuilder. 11ms(<11.6%)
    public boolean isPalindrome3(int x) {
        if (x<0){
            return false;
        }
        String str = new StringBuilder(Integer.toString(x)).reverse().toString();
        //System.out.println(str);
        return (str.equals(Integer.toString(x)));
    }
    
    
	// reverse integer by dividing by powers of 10 and reconstructing backwards. 19ms(<5%) 36MB(<5%)
    public boolean isPalindrome1(int x) {
        if (x<0){
            return false;
        }
        
        int n = reversedNumber(x);
        return (n == x);
    }
    
    
    int reversedNumber(int x){
        int count = 9;
        int result =0;
        int i=0;
        while (count >=0){
            int divisor = (int) Math.pow(10, count);
            int tmp = x/divisor;
            result += tmp * (int) Math.pow(10, i);
            if (result > 0) i++;
            //System.out.println(count + " " + divisor + " " + result + " " + x);
            count--;
            x = x % divisor;
            
        }
        
        return result;
    }
	
	// Solved by charArray. 8ms(<41%)
    public boolean isPalindrome2(int x) {
        
        String str = Integer.toString(x);
        char[] arr = str.toCharArray();
        
        int n = arr.length;
        
        for(int i=0;i<n/2;i++){
            if (arr[i]!=arr[n-i-1]){
                return false;
            }
        }
        return true;
    }
}