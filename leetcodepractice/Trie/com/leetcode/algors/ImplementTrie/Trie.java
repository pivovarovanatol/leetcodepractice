package com.leetcode.algors.ImplementTrie;


// solved (HashMap with String and Trie + recursive calls for search). 56ms(<18%) 56MB(<27%). With char/int instead of String - 45ms(<34%). With charArray and helper methods - 39ms(<51%) 53MB(<32%)
// Further optimizations - use Trie[] instead of HashMap -> 30ms (<98%)  
class Trie {
    boolean isWord;
    Trie[] children;
    
    /** Initialize your data structure here. */
    public Trie() {
        isWord = false;
        children = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	char[] charWord = word.toCharArray();
        insertHelper(charWord, 0, charWord.length-1);
    }
    
    void insertHelper(char[] word, int lo, int hi) {
        if (lo>hi) {
        	isWord = true;
        	return;
        }
        int ch =  word[lo]-'a';
        Trie nextNode;
        if (children[ch]!=null){
            nextNode = children[ch];
        } else {
            nextNode = new Trie();
        	children[ch]= nextNode;
        }
        nextNode.insertHelper(word,lo+1,hi);
    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	char[] charWord = word.toCharArray();
    	return searchHelper(charWord, 0, charWord.length-1);
    }
    
    boolean searchHelper(char[] word, int lo, int hi) {
        if (lo > hi) return isWord;
        int ch =  word[lo]-'a';
        Trie nextNode; 
        
        if (children[ch]==null){
            return false;
        } else {
            nextNode = children[ch];
            return nextNode.searchHelper(word, lo+1,hi);
        }
    }
    
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
    	char[] charWord = word.toCharArray();
    	return startsWithHelper(charWord, 0, charWord.length-1);
    }

    public boolean startsWithHelper(char[] prefix, int lo, int hi) {
        if (lo>hi) return false;
        int ch =  prefix[lo]-'a'; 
        Trie nextNode; 
        
        if (children[ch]==null){
            return false;
        } else {
            if (lo==hi){
                // return searchWord();
                return true;
            } else {
                nextNode = children[ch];
                return nextNode.startsWithHelper(prefix,lo+1,hi);
            }
        }
        //return false;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
