package com.leetcode.algors.GenerateParentheses;
// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Solution {
    List<String> res = new ArrayList<String>();

	// from discussions. Concise solution with recursion and backtracking. 1ms(<99%)
    public List<String> generateParenthesis(int n) {
        helper("",n,0);
        return res;
    }
    
    private void helper(String str, int left, int right){
        if(left == 0 && right == 0)
            res.add(str);
        if(left > 0){
            helper(str+"(", left-1,right+1);
        }
        if(right > 0){
            helper(str+")",left,right-1);
        }
    }
	
    // idea: create all the combinations and validate one by one, if valid -> add to result
	public List<String> generateParenthesis2(int n) {
	    List<String> result = new ArrayList<>();
	    if (n==0){
	        return result;
	    }
	    char[] chars = new char[n*2];
	    chars[0]='(';
	    permute2(chars,n*2,result,1,1);
	    
	    return result;
	}
	
	// solved recursively with tracking opened/closed parentheses adding both brackets. 0ms(<100%) 38.8MB(<32%)  
	public void permute2(char[] chars, int n, List<String> result, int index, int opened){
	    // get the needed length
	    if (index==n){
	        if (opened==0){
	            //System.out.println(prefix);
	            result.add(new String(chars));
	        }
	        return;
	    }
	    int newOpened=opened;
	    chars[index]='(';
	    if (opened>=0) newOpened++;
	    permute2(chars,n,result,index+1, newOpened);
	    
	    
	    chars[index]=')';
	    if (opened>=0) newOpened--;
	    permute2(chars,n,result,index+1, opened-1);
	    
	    return;
	}

	// solved with checking if the combination is a valid combination. 8ms (<~30%)
	public void permute3(char[] chars, int n, List<String> result, int index){
	    if (index==n){
	        if (isValid(chars)){
	            //System.out.println(prefix);
	            result.add(new String(chars));
	        }
	        return;
	    }
	    chars[index]='(';
	    permute3(chars,n,result,index+1);
	    chars[index]=')';
	    permute3(chars,n,result,index+1);
	    
	    return;
	}


	boolean isValid(char[] chars){
	    Stack<Character> stack = new Stack<>();
	    int index =0;
	    
	    while (index < chars.length){
	        char ch1 = chars[index];
	        if (ch1 == '(') stack.push(ch1);
	        else {
	            if (stack.size()==0) return false;
	            else {
	                char ch2 = stack.pop();
	                if (ch2!='(') return false;
	            }
	        }
	        index++;
	    }
	    
	    if (stack.size()!=0) return false;
	    else return true;
	}

}
