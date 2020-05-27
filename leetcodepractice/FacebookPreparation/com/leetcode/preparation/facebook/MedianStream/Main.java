package com.leetcode.preparation.facebook.MedianStream;
// https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=547645422524434


import java.util.*;
// Add any extra import statements you may need here


class Main {

	  // Add any helper functions you may need here
	  

	  int[] findMedian(int[] arr) {
	    // Write your code here
	    int n=arr.length;
	    int[] result = new int[n];
	    
	    if (arr==null || n==0) return result;
	    PriorityQueue<Integer> heap1 = new PriorityQueue<>();
	    PriorityQueue<Integer> heap2 = new PriorityQueue<>(Collections.reverseOrder());
	    
	    for (int i=0;i<n;i++){
	      heap2.offer(arr[i]);
	      
	      if (i > 1 && heap2.size() > (i+1)/2+1 ){
	        int t = heap2.poll(); 
	        heap1.offer(t);
	      }
	      // odd -> return 1 element
	      if ((i+1)%2==1){
	        result[i] = heap2.peek();
	      } 
	      // even - return avg of two highest elements
	      else {
	        int n1 = heap2.poll();
	        int n2 = heap2.peek();
	        //System.out.println("Even i=" + i + " n1=" + n1 + " n2="+n2);
	        heap2.offer(n1);
	        result[i] = (n1+n2)/2;
	      }
	    }
	    
	    return result;
	  }












	  // These are the tests we use to determine if the solution is correct.
	  // You can add your own at the bottom, but they are otherwise not editable!
	  int test_case_number = 1;
	  void check(int[] expected, int[] output) {
	    int expected_size = expected.length; 
	    int output_size = output.length; 
	    boolean result = true; 
	    if (expected_size != output_size) {
	      result = false;
	    }
	    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
	      result &= (output[i] == expected[i]);
	    }
	    String rightTick = "PASSED";
	    String wrongTick = "FAILED";
	    if (result) {
	      System.out.println(rightTick + " Test #" + test_case_number);  
	    }
	    else {
	      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
	      printIntegerArray(expected); 
	      System.out.print(" Your output: ");
	      printIntegerArray(output);
	      System.out.println();
	    }
	    test_case_number++;
	  }
	  void printIntegerArray(int[] arr) {
	    int len = arr.length; 
	    System.out.print("[");
	    for(int i = 0; i < len; i++) {
	      if (i != 0) {
	        System.out.print(", ");
	      }
	      System.out.print(arr[i]);
	    }
	    System.out.print("]");
	  }
	  public void run() {
	    int[] arr_1 = {5, 15, 1, 3};
	    int[] expected_1 = {5, 10, 5, 4};
	    int[] output_1 = findMedian(arr_1);
	    check(expected_1, output_1);

	    int[] arr_2 = {2, 4, 7, 1, 5, 3};
	    int[] expected_2 = {2, 3, 4, 3, 4, 3};
	    int[] output_2 = findMedian(arr_2);
	    check(expected_2, output_2);
	  
	    // Add your own test cases here
	    
	  }
	  public static void main(String[] args) {
	    new Main().run();
	  }
	}