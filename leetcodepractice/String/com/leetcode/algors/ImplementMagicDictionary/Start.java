package com.leetcode.algors.ImplementMagicDictionary;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] dict = {"hello","leetcode"};
		MagicDictionary dictionary = new MagicDictionary();
		dictionary.buildDict(dict);
		System.out.println(dictionary.search("hello"));
		System.out.println(dictionary.search("hhllo"));
		System.out.println(dictionary.search("hell"));
		System.out.println(dictionary.search("leetcoded"));
		
		System.out.println();

		MagicDictionary1 dictionary1 = new MagicDictionary1();
		dictionary1.buildDict(dict);
		System.out.println(dictionary1.search("hello"));
		System.out.println(dictionary1.search("hhllo"));
		System.out.println(dictionary1.search("hell"));
		System.out.println(dictionary1.search("leetcoded"));
		
		
		//System.out.println(dictionary.search("abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjzoawj"));
		
	}
}
