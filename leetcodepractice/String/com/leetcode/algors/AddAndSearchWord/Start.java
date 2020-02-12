package com.leetcode.algors.AddAndSearchWord;
//https://leetcode.com/problems/add-and-search-word-data-structure-design/

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] dict = {"ran","rune","runner","runs","add","adds","adder","addee"};
		WordDictionary dictionary = new WordDictionary();

		for (String str : dict) {
			dictionary.addWord(str);
		}
		
		System.out.println(dictionary.search("r.n"));
		System.out.println(dictionary.search("ru.n.e"));
		System.out.println(dictionary.search("add"));
		System.out.println(dictionary.search("add."));
		System.out.println(dictionary.search("adde."));
		System.out.println(dictionary.search(".an."));
		System.out.println(dictionary.search("...s"));
		
		System.out.println();

		
	}
}
