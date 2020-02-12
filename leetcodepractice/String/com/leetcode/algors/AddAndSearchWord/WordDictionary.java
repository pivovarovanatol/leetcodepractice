package com.leetcode.algors.AddAndSearchWord;
// https://leetcode.com/problems/add-and-search-word-data-structure-design/


class WordDictionary {
	// solved with Trie. 34ms(<90%) 55.2MB(<82%)
    TrieNode dict;
    /** Initialize your data structure here. */
    public WordDictionary() {
        dict = new TrieNode();    
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word== null) {
            return;
        }
        char[] arr = word.toCharArray();
        int len = word.length();
        if (len == 0) {
            return;
        }
        TrieNode current = dict;
        
        for (int i=0;i<len;i++){
            if (current.children[arr[i]-'a']!=null){
                current = current.children[arr[i]-'a'];
            } else {
                current.children[arr[i]-'a'] = new TrieNode();
                current = current.children[arr[i]-'a'];
                //current.value = arr[i];
            }
        }
        current.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word== null) {
            return false;
        }
        if (dict.children == null) {
            return false;
        }
        int len = word.length();
        if (len == 0) {
            return false;
        }
        char[] arr = word.toCharArray();
        return searchWord(dict, arr, 0, len);
    }
    
    boolean searchWord(TrieNode root, char[] arr, int index, int n){
        // 
        //System.out.println("Called for " + root.value + " and index="+index);
        if (root==null){
            return false;
        }
        if (index >=n){
            return false;
        }
        // not the end of the word, but have no children -> false
        if (root.children==null){
            return false;
        }
        
        if (arr[index]=='.'){
            boolean result = false;
            for (int i=0;i<26;i++){
                if (root.children[i]!=null){
                    //System.out.println("Searching the word for " + arr[index] + " at " + index);
                    if (index==n-1 && root.children[i].isWord){
                        return root.children[i].isWord;
                    } else result = searchWord(root.children[i], arr, index+1, n);
                    if (result) return result;
                }
            }
            return result;
        } else {
            if (root.children[arr[index]-'a']==null) return false;
            //System.out.println("Searching the word for " + arr[index] + " at " + index);
            if (index==n-1){
                return root.children[arr[index]-'a'].isWord;
            } else return searchWord(root.children[arr[index]-'a'], arr, index+1, n);
        }
    }
    
class TrieNode{
    //char value;
    TrieNode[] children;
    boolean isWord;
    
    public TrieNode(){
        children = new TrieNode[26];
    }
}
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */