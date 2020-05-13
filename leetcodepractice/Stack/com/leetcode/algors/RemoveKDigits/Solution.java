package com.leetcode.algors.RemoveKDigits;
//https://leetcode.com/problems/remove-k-digits/

import java.util.Stack;

class Solution {
	
	// from discussions: just iteration with extra array for results. 2ms (<98%) O(n)
    public String removeKdigits(String num, int k) {
        int remain = num.length() - k;
        char[] numArray = num.toCharArray(), res = new char[remain];
        int index = 0;
        for(int i = 0; i < numArray.length; i++) {
            // (1)  (n - i > remain - index): have enough remaining digits to be compared
            // (2)  (res[index - 1] > nums[i]): at this time, the (index-1) is the newest added digit,
            //      compare this digit with the current num, if the res is greater and you have enough 
            //      remaining digits to be compared, decrease the index(it ensures that the future added digit is 
            //      always smaller than before and the size is remain) until get the right and 'safe' position
            while((numArray.length - i > remain - index) && (index > 0 && numArray[i] < res[index - 1])) index--;
            if(index < remain) res[index++] = numArray[i];
        }
        
        // check leading zeroes
        index = -1;
        while(++index < remain) {
            if(res[index] != '0') break;
        }
        String s = new String(res).substring(index);
        
        return s.length() == 0 ? "0" : s;
    }
	
	// from discussions using Stack and StringBuilder 9ms(<31%) O(n*k)
    public String removeKdigits2(String num, int k) {
        if(k==0)return num;
        if(num.length()==k)return "0";
        Stack<Character>stack=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            if(stack.size()==0||k==0){
                if(stack.size()==0&&c=='0')continue;
                stack.push(c);continue;
            }
            while(stack.size()!=0&&k>0&&c<stack.peek()){
                k--;stack.pop();
            }
            if(stack.size()==0&&c=='0')continue;
            stack.push(c);
        }
        
        while(stack.size()>0&&k>0){
            stack.pop();k--;
        }
        if(stack.size()==0)return "0";
        while(stack.size()!=0)res.append(""+stack.pop());
        return res.reverse().toString();
    }
	
	// solved in O(k*n)  25ms (<11%)
	// using loop over k and for every iteration checking start of the string and removing char if it's greater than following char 
    public String removeKdigits2(String num, int k) {
        String t = num;
        if (k == num.length()) return "0";
        int start = 0;
        
        while (k>=1){
            boolean found = false;
            for (int i=0;i<t.length()-1;i++){
                if (t.charAt(i)>t.charAt(i+1)){
                    //System.out.println("Found char to remove: " + t.charAt(i));
                    //System.out.println("Before remove: " + t);
                    String part1 = t.substring(0,i);
                    String part2 = t.substring(i+1);
                    t = part1+ part2;
                    //System.out.println("After remove : " + t);
                    //System.out.println();
                    found = true;
                    break;
                } 
            }
            if (!found) {
                t = t.substring(0,t.length()-1);
                //System.out.println("Nothing found -> removed last char: " + t);
            }
            k--;
        }
        //System.out.println("End string is= " + t);
        // int res = Integer.parseInt(t);
        while (!t.equals("") && t.charAt(0)=='0'){
            t = t.substring(1);
        }
        return t.equals("") ? "0" : t;
    }
    

    
}