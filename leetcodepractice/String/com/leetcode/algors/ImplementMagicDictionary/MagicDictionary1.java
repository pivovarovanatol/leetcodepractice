package com.leetcode.algors.ImplementMagicDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//brute force with HashMap<Integer,String>, where the key is the length of the word -> should be easier to search later, but is suboptimal, especially in case of all words have the same length. 9ms (<51%) 38MB(<6.67%)
public class MagicDictionary1 {
	HashMap<Integer,List<char[]>> dictionary;
 
	 /** Initialize your data structure here. */
	 public MagicDictionary1() {
	     dictionary = new  HashMap<Integer,List<char[]>>();
	 }
	 
	 /** Build a dictionary through a list of words */
	 public void buildDict(String[] dict) {
	     for (String str : dict){
	         int len = str.length();
	         if (dictionary.containsKey(len)){
	             List<char[]> list = dictionary.get(len);
	             list.add(str.toCharArray());
	         } else {
	             List<char[]> list = new ArrayList<>();
	             list.add(str.toCharArray());
	             dictionary.put(len,list);                
	         }
	     }
	 }
	 
	 /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	 public boolean search(String word) {
	     int len = word.length();
	     char[] wordAsChar = word.toCharArray();
	     if (!dictionary.containsKey(len)){
	         return false;
	     } else {
	         List<char[]> list = dictionary.get(len);
	         for (char[] str : list){
	             if (canMutate(wordAsChar, str)){
	                 return true;
	             } else {
	             }
	         }
	     }
	     return false;
	 }
	 
	 boolean canMutate(char[] wordAsChar, char[] str){
	     int diff = 0;
	     for (int i=0;i<wordAsChar.length;i++){
	         if (wordAsChar[i]!=str[i]){
	             diff++;
	             if (diff>1) return false;
	         }
	     }
	     if (diff==0) return false;
	     return true;
	 }
}

