package com.leetcode.algors.UglyNumberII;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/ugly-number-ii/

class Solution {
	
	
	// from discussions: use the same thing but with static method. 2ms(<98%)
    static int[] ugly = new int[1691];
    static {
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < ugly.length; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min)
                factor2 = 2 * ugly[++index2];
            if (factor3 == min)
                factor3 = 3 * ugly[++index3];
            if (factor5 == min)
                factor5 = 5 * ugly[++index5];
        }
    }

    public int nthUglyNumber(int n) {
        return ugly[n - 1];
    }
	
	// from discussions: calculate the sequence of ugly numbers by having tree "pointers" for 2,3 and 5 and calculating smallest product of multiplication -> assigning that as an ugly number. 
	// from discussions: 3ms(<70%)
    public int nthUglyNumber1(int n) {
        int[] ugly = new int[n];
        int index2 = 0, index3 = 0, index5 = 0;
        int Sequence2 = 1, Sequence3 = 1, Sequence5 = 1;
        for(int i=0;i<n;i++){
            ugly[i] = Math.min(Math.min(Sequence2,Sequence3),Sequence5);//min of the 3 sequences is the ith UglyNumber 
            if(Sequence2 == ugly[i]) Sequence2 = 2*ugly[index2++];//the ith UglyNumber is in factor2 sequence, then update sequence2
            if(Sequence3 == ugly[i]) Sequence3 = 3*ugly[index3++];//the ith UglyNumber is in factor3 sequence, then update sequence3
            if(Sequence5 == ugly[i]) Sequence5 = 5*ugly[index5++];//the ith UglyNumber is in factor5 sequence, then update sequence5
        }
        return ugly[n-1];//return the nth UglyNumber
    }	
	
	// solved with brute force and recursion with memory -> still fail by time.    
    public int nthUglyNumber2(int n) {
        // 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 14, 15,16, 18,20,21,22,24,25,
        if (n==0) return 0;
        if (n==1) return 1;
        
        // brute force with recursion and Set. 
        int curNum=0;
        int count=1;
        int i=1;
        
        Set<Integer> uglyMap = new HashSet<>();
        uglyMap.add(1);
        uglyMap.add(2);
        uglyMap.add(3);
        uglyMap.add(4);
        uglyMap.add(5);
        
        while (count<=n){
            boolean isUgly = isUgly(i, uglyMap);
            if (isUgly){
            	System.out.println(i);
                count++;
            }
            i++;
        }
        
        return i-1;
    }
    
    boolean isUgly(int n, Set<Integer> uglyMap){
        if (uglyMap.contains(n)){
            return true;
        } 
        
        int tmp2 = n % 2;
        
        if (tmp2==0){
            // boolean isUgly = isUgly(n/2, uglyMap);
            if (uglyMap.contains(n/2)){
                uglyMap.add(n);
                return true;
            }
        } 
        
        int tmp3 = n % 3;
        if (tmp3==0){
            if (uglyMap.contains(n/3)){
                uglyMap.add(n);
                return true;
            }
        } 
        
        int tmp5 = n % 5;
        if (tmp5==0){
            if (uglyMap.contains(n/5)){
                uglyMap.add(n);
                return true;
            }
        } 
        return false;   
    }
    
    
}


