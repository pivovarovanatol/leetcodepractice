package com.leetcode.preparation.facebook.MinimumLengthSubstrings;
// https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=2237975393164055


import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here


class Main {

  // Add any helper functions you may need here
  int[] charCount(char[] arr, int start, int end){
    int[] count = new int[26];
    for (int i=start;i<end;i++){
      count[arr[i]-'a']++;
    }
    return count;    
  }
  
  boolean isEmpty(int[] a){
    if (a==null) return false;
    for(int i=0;i<a.length;i++)
      if (a[i]>0) return false;
    return true;
  }
  

  int minLengthSubstring(String s, String t) {
    // Write your code here
    int min = 10000000;
    char[] str = s.toCharArray();
    char[] tst = t.toCharArray();
    int n = tst.length;
    int N = str.length;
    int[] hash = charCount(tst, 0, n);
    HashSet<Character> set = new HashSet<>();
    for (char ch : tst) 
      set.add(ch);
    
    
    int pointer1 = 0;
    int pointer2 = 0;
    while (!set.contains(str[pointer1]))
      pointer1++;  
    pointer2 = pointer1;
    
    while (pointer1 < N - n && pointer2<N){
      if (set.contains(str[pointer2])){
        hash[str[pointer2]-'a']--;
        if (isEmpty(hash)){
          System.out.println("Found match at: " + pointer1 + " - " + pointer2 + " len = " +(pointer2-pointer1+1));
          min = Math.min(min, pointer2-pointer1+1);
          hash[str[pointer1]-'a']++;
          pointer1++;
          while (pointer1 < N && !set.contains(str[pointer1]))
            pointer1++;  
          
          if(pointer1>pointer2) pointer2=pointer1;
          hash[str[pointer2]-'a']++;
        } else {
          pointer2++;
        }   
      } else {
        pointer2++;
      }
    }
    
    return min == 10000000 ? -1 : min;
  }











  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int expected, int output) {
    boolean result = (expected == output);
    String rightTick = "PASSED";
    String wrongTick = "FAILED";
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected); 
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }
  public void run() throws IOException {
    String s_1 = "dcbefebce";
    String t_1 = "fd";
    int expected_1 = 5;
    int output_1 = minLengthSubstring(s_1, t_1);
    check(expected_1, output_1);

    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t_2 = "cbccfafebccdccebdd";
    int expected_2 = -1;
    int output_2 = minLengthSubstring(s_2, t_2);
    check(expected_2, output_2);

    // Add your own test cases here
    String s_3 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t_3 = "cccaadd";
    int expected_3 = 10;
    int output_3 = minLengthSubstring(s_3, t_3);
    check(expected_3, output_3);
    
  }
  public static void main(String[] args) throws IOException {
    new Main().run();
  }
}