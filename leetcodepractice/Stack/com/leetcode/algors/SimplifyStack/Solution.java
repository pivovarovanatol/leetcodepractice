package com.leetcode.algors.SimplifyStack;

class Solution {
    public String simplifyPath(String path) {
        
        int n = path.length();
        char[] arr = path.toCharArray();
        
        // 2. remove multiple '/' - keep just one
        String tmp="";
        String tmp1=path;
        while (1==1){
            tmp = path.replace("//","/");
            if (tmp1 == tmp){
                break;
            }
            tmp1 = tmp;
        }

        path = tmp;
        System.out.println(path);
        
        // 1. remove trailing '/'
        for (int i=n-1;i>=0;i--){
            if (arr[i] == '/') {
                arr[i] = ' ';
            }
        }
        
        
        
        
        // 3. Using stack: 
        // '.' - do nothing
        // '..' - pop
        // anything else - push
        
        
        // 4. Construct from the stack working backwards
        
        
        return path;
    }
}