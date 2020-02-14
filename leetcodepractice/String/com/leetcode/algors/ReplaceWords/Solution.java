package com.leetcode.algors.ReplaceWords;
// https://leetcode.com/problems/replace-words/


import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	// from discussions: create a Trie. Split sentence into array of strings(words). For each word search for a shortest root in the Trie. Add if found or add word if not. 6ms (<99%) 51MB(<92%) 
    TrieNode root;
    
    public Solution() {
        root = new TrieNode();
    }
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || sentence == null)
            return sentence;
        
        //build trie
        for (String word : dict) {
            addWord(word);
        }
        
        //split sentence, find shortest roots and build sentence
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            String root = findRoot(word);
            sb.append(root == null ? word : root);
            sb.append(' ');
        }
        String s = sb.toString();
        return s.substring(0, s.length()-1); //remove space after sentence
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.get(c) == null) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.isRoot = true;
    }
    
    public String findRoot(String word) {
        TrieNode node = root;
        
        char[] wordArr = word.toCharArray();
        for (int i = 0; i < wordArr.length; i++) {
            TrieNode n = node.get(wordArr[i]);
            if (n == null) 
                return null; //no root
            if (n.isRoot)
                return word.substring(0, i+1); //shortest root
            node = n;
        }
        return null;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isRoot;
    
    public TrieNode get(char c) {
        return children[c - 'a'];
    }
    
    public void put(char c, TrieNode node) {
        children[c - 'a'] = node;
    }

	
	
    // solved with Trie. 11ms(<75%) 51MB(<92%)
    // 1. create the Trie out of roots. 
    // 2. Go over the sentence and for every word go over the letters check if there is a matching word
    public String replaceWords(List<String> roots, String sentence) {
        // creating a dictionary
        Trie dict = new Trie();
        for (String root : roots){
            dict.add(root.toCharArray());
        }
        
        // Going over a sentence and replacing the word
        StringBuilder sb = new StringBuilder();
        char[] tmp = new char[sentence.length()];
        int index=0;
        boolean skip=false;
        for (char ch : sentence.toCharArray()){
            if (ch != ' '){
                if (skip) continue;
                	tmp[index] = ch;
                if (dict.search(tmp, index)){
                    index++;
                    skip=true;
                    continue;
                }
                index++;
            } else {
                sb.append(tmp, 0, index);
                sb.append(' ');
                index=0;
                skip=false;
                continue;
            } 
        }
        sb.append(tmp, 0, index);
        return sb.toString();
    }
    
    
    class Trie{
        char value;
        Trie[] children;
        boolean isWord;
        
        
        public Trie(){
            children = new Trie[26];
            isWord = false;
        }
        
        public void add(char[] word){
            
            Trie current = this;
            
            for (char ch: word){
                if (current.children[ch-'a']!=null){
                    current = current.children[ch-'a'];
                } else {
                    Trie node = new Trie();
                    current.children[ch-'a'] = node;
                    current = current.children[ch-'a'];
                }
            }
            current.isWord=true;
        }
        
        public boolean search(char[] word, int max){
            if (word==null || word.length==0) return false;
            
//            System.out.print("Looking for a word: " );
//            for (int i=0;i<=max;i++){
//                System.out.print(word[i]);
//            }
//            System.out.println();
            
            Trie current = this;
            for (int i=0;i<=max;i++){
                if (current.children[word[i] - 'a'] != null){
                    current=current.children[word[i] - 'a'];
                } else {
                    return false;
                }
            }
            return current.isWord;
        }
    }

	
	// same idea from Solution. 183ms(<10%) 46MB(<100%)
	    public String replaceWords1(List<String> roots, String sentence) {
	        Set<String> rootset = new HashSet<>();
	        for (String root: roots) rootset.add(root);

	        StringBuilder ans = new StringBuilder();
	        for (String word: sentence.split("\\s+")) {
	            String prefix = "";
	            for (int i = 1; i <= word.length(); ++i) {
	                prefix = word.substring(0, i);
	                if (rootset.contains(prefix)) break;
	            }
	            if (ans.length() > 0) ans.append(" ");
	            ans.append(prefix);
	        }
	        return ans.toString();
	    }
	
    // solved with brute force: use Set for the dictionary, then for every word in the sentence go and traverse thru the word letter by letter 
    // and look for corresponding word in the dictionary. If found -> add to the result string, if not - add the original word.
    // 226 ms (<7%) 45.7MB(<100%)
    public String replaceWords2(List<String> dict, String sentence) {
        if (dict==null || dict.size()==0) return sentence;
        if (sentence==null || sentence.length()==0) return "";
        
        Set<String> roots = new HashSet<>();
        for (String word : dict){
            roots.add(word);
        }
        
        //StringBuilder sb = new StringBuilder();
        String result = "";
        char[] arr = sentence.toCharArray();
        boolean skip = false;
        String tmp = "";

        for (char ch : arr){
            if (ch==' ') {
                if (!skip){
                    result+=tmp;
                }
                tmp = "";
                result += " ";
                skip = false;
            } else {
                if (roots.contains(tmp) && !skip){
                    result += tmp;
                    skip=true;
                } else {
                    tmp+=ch;
                }
            }
        }
        if (!skip) result +=tmp;
        return result;
    }
}