package com.leetcode.preparation.facebook.MinimizingPermutations;
// https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=292715105029046


import java.util.*;
// Add any extra import statements you may need here


class Main {

	// Add any helper functions you may need here
	// passed both test cases
  String reverseSubString(String str, int b, int e) {
	char[] chars = str.toCharArray();
    while (b < e){
      char ch = chars[b];
      chars[b] = chars[e];
      chars[e]=ch;
      b++;
      e--;
    }
    return new String(chars);
  }
  
  int bfs(String initial, String destination){
    if (initial.equals(destination)) return 0;
    
    HashSet<String> visited = new HashSet<>();
    Queue<String> bfsQ = new ArrayDeque<String>();
    bfsQ.offer(initial);
    int levelSize = 0;
    int level=0;
    int permSize = initial.length();
    String currPerm="", nextPerm="";
    
    while (bfsQ.size()>0){
      levelSize = bfsQ.size();
      level++;
      
      for (int q=0;q<levelSize; q++){
        currPerm = bfsQ.poll();
        
        for (int i=0;i<permSize;i++){
          for (int j=i+1;j<permSize;j++){
            nextPerm = currPerm;
            
            nextPerm = reverseSubString(nextPerm, i, j);
            //System.out.println(nextPerm);
            
            if (nextPerm.equals(destination)) return level;
            
            if (!visited.contains(nextPerm)){
              visited.add(nextPerm);
              bfsQ.offer(nextPerm);
            }
            
          }
        }
      }
    }
    
    return level;
  }
  
  
  

  int minOperations(int[] arr) {
    // int[] -> String
    int[] sorted = Arrays.copyOf(arr, arr.length);
    Arrays.sort(sorted);
    String initial = "";
    String destination = "";
    
    for (int i=0;i<arr.length;i++){
      initial += arr[i];
      destination += sorted[i];
    }
    
    int min = bfs(initial, destination);
    
    return min;
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
  public void run() {

    int n_1 = 5;
    int[] arr_1 = {1, 2, 5, 4, 3};
    int expected_1 = 1;
    int output_1 = minOperations(arr_1);
    check(expected_1, output_1);

    int n_2 = 3;
    int[] arr_2 = {3, 1, 2};
    int expected_2 = 2;
    int output_2 = minOperations(arr_2);
    check(expected_2, output_2);
    
    // Add your own test cases here
    
  }
  public static void main(String[] args) {
    new Main().run();
  }
}