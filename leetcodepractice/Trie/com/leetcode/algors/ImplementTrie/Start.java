package com.leetcode.algors.ImplementTrie;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		
//		String word = "apple";
//		trie.insert(word);
//		System.out.println(trie.search(word));
//		word ="app";
//		System.out.println(trie.search(word));
//		System.out.println(trie.startsWith(word));
//		trie.insert(word);
//		System.out.println(trie.search(word));
		
		trie.insert("ab");
		System.out.println(trie.search("a"));
		System.out.println(trie.startsWith("a"));
		System.out.println(trie.startsWith("ab"));
		System.out.println(trie.search("ab"));
		
	}

}
