package com.leetcode.algors.AmazonTest;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM

import java.util.Arrays;

//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
class GCD
{
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 public int generalizedGCD(int num, int[] arr)
 {
     
     Arrays.sort(arr);
     int max = arr[num-1];
     int gcd = 1;

     for (int i=max;i>=1;i--){
         
         boolean passed=false;
         
         for (int j=0;j<num;j++){
             if (arr[j] % i != 0){
                 passed = false;
                 break;
             }
             passed = true;
         }
         
         if (passed && gcd < i) {
             gcd=i;
         }
         
     }

     return gcd;
     
 }
 // METHOD SIGNATURE ENDS
}