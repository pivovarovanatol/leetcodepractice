package com.leetcode.algors.BullsAndCows;
//https://leetcode.com/problems/bulls-and-cows/

class Solution {
	
	// solved with arrays as a hash tables. 1ms(<100%) 37.3MB(<97%)
    public String getHint(String secret, String guess) {
        // Count cows by array with counts. 
        // Array will contain the count of each symbol in guess.
        
        int[] guessNumbersCount = new int[10];
        int[] secretNumbersCount = new int[10];
        char[] guessArr = guess.toCharArray();
        char[] secretArr = secret.toCharArray();
        
        for (char ch : guessArr){
            guessNumbersCount[ch-'0']++;
        }
        
        for (char ch : secretArr){
            secretNumbersCount[ch-'0']++;
        }     
        
        // Count cows by comparing two arrays
        int countCows = 0;
        for(int i=0;i<10;i++){
            //System.out.println(i + " " + secretNumbersCount[i] + " " + guessNumbersCount[i] + " " + countCows);
            if (secretNumbersCount[i]>0){
                countCows += Math.min(secretNumbersCount[i], guessNumbersCount[i]);
            }
        }
        
        int countBulls=0;
        for (int i=0;i<guessArr.length;i++){
            if (secretArr[i]==guessArr[i]){
                countBulls++;
            }
        }
        countCows-=countBulls;
        
        return Integer.toString(countBulls) + "A" + Integer.toString(countCows)+"B";
    }
}