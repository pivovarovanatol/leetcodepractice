package com.leetcode.algors.ImplementMagicDictionary;

//trying to solve with Trie. 10 ms (<40%) 
class MagicDictionary {
	 public Trie dictionary;
	 
	 /** Initialize your data structure here. */
	 public MagicDictionary() {
	     dictionary = new Trie();
	 }
	 
	 /** Build a dictionary through a list of words */
	 public void buildDict(String[] dict) {
	     if (dictionary==null){
	         dictionary = new Trie();
	     }
	     for (String str : dict){
	             dictionary.add(str.toCharArray());                
	     }
	 }
	 
	 /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	 public boolean search(String word) {
	     int len = word.length();
	     char[] wordAsChar = word.toCharArray();
	     for (int i=0;i<len;i++){
	         char orig = wordAsChar[i];
	         for (int j=0;j<26;j++){
	             if (orig-'a'!=j){
	                 wordAsChar[i]=(char)('a'+j);
	                 if (dictionary.search(wordAsChar)) return true;;
	             }
	         }
             wordAsChar[i]= orig;
	     }
	     return false;
	 }
	 
	class TrieNode {
	 private TrieNode[] children;
	 private char content;
	 private boolean isWord;
	
	 public TrieNode() {
	        setChildren(new TrieNode[26]);
	 }
	 
	 public TrieNode[] getChildren(){
	     return children;
	 }
	 
	 public void setChildren(TrieNode[] children){
	     this.children = children;
	 }

	 public void setContent(char ch){
	     this.content = ch;
	 }

	 public char getContent(){
	     return this.content;
	 }

	 public boolean isEndOfWord(){
	     return isWord;
	 }
	
	 public void setEndOfWord(boolean flag){
	     isWord=flag;
	 }
	
	}    
	 
	class Trie{
	    private TrieNode root;
	    
	    public Trie(){
	        root = new TrieNode();
	        
	    }
	    
	    public void add(char[] word) {
	        TrieNode current = root;

	        for (int i = 0; i < word.length; i++) {
	        	TrieNode[] children = current.getChildren();
	        	if (children[word[i]-'a'] !=  null) {
	        		current = children[word[i]-'a'];
	        	} else {
	        		current = new TrieNode();
	        		current.setContent(word[i]);
	        		children[word[i]-'a']=current;
	        	}	            //current = current.getChildren().computeIfAbsent(word[i], c -> new TrieNode());
	        }
	        current.setEndOfWord(true);
	    }
	    
	    public boolean search(char[] word) {
	        TrieNode current = root;
	        for (int i = 0; i < word.length; i++) {
	            char ch = word[i];
	            TrieNode[] children =current.getChildren(); 
	            TrieNode node = children[ch-'a'];
	            if (node == null) {
	                return false;
	            }
	            current = node;
	        }
	        return current.isEndOfWord();
	    }    
	}    
 
}

/**
* Your MagicDictionary object will be instantiated and called as such:
* MagicDictionary obj = new MagicDictionary();
* obj.buildDict(dict);
* boolean param_2 = obj.search(word);
*/

