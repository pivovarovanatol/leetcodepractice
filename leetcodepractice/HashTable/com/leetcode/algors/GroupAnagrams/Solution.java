package com.leetcode.algors.GroupAnagrams;
//https://leetcode.com/problems/group-anagrams/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<List<String>> groupAnagrams2(String[] strs) {
       
        // Idea is to go over array of Strings. For every string -> sort the corresponding CharArray and get the key by that.
        // Then insert in the HashMap with the key the list of corresponding strings
        // After that go over the HashMap and create the List
        // Improvement1: use int array instead of string as a key, since only lower-case are provided -> 26 letters -> do not need to sort. Not worth it -> runtime is worse. 
        
        if (strs.length <= 0){
            return null;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs){
            
            String key = strToKey(str);
            
            //System.out.println(key);
            
            if (map.containsKey(key)){
                //System.out.println("Already contains: " + key);
                List<String> list = map.get(key);
                list.add(str);
            } else {
                //System.out.println("Creating new: " + key);
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for (List<String> list : map.values()){
            //System.out.println(list);
            result.add(list);
        }
        
        return result;
    }
    
    String strToKey(String str){
        int[] arr = new int[28];
        
        for (char ch : str.toCharArray()){
            arr[ch-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i : arr){
            sb.append(i);
            sb.append('|');
        }
        
        return sb.toString();
    }
    
    
    
    public List<List<String>> groupAnagrams(String[] strs) {
       
        // Idea is to go over array of Strings. For every string -> sort the corresponding CharArray and get the key by that.
        // Then insert in the HashMap with the key the list of corresponding strings
        // After that go over the HashMap and create the List
        
        if (strs.length <= 0){
            return null;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            //System.out.println(key);
            
            if (map.containsKey(key)){
                //System.out.println("Already contains: " + key);
                List<String> list = map.get(key);
                list.add(str);
            } else {
                //System.out.println("Creating new: " + key);
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for (List<String> list : map.values()){
            //System.out.println(list);
            result.add(list);
        }
        
        return result;
    }
}
