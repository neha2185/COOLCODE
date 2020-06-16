package com.java.functional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

public class StringFunctional {

	public static void main(String[] args) {
		//case 1 : count Occurrences Of A Certain Character
		String str = "this is java";
		char charToFind = 'i';
		
		System.out.println("no. of occurance of " + charToFind + " is " + str.chars().filter(c -> c==charToFind).count());
		
		//case 2 : Count vowels and consonants
		final List<Character> vowelsSet = Arrays.asList('a','e','i','o','u');
		//Simple way
		//long vowels = str.chars().mapToObj(c -> (char)c).filter(c -> vowelsSet.contains(c)).count();
		//long consonants = str.chars().mapToObj(c -> (char)c).filter(c -> !vowelsSet.contains(c)).filter(ch -> (ch >='a' && ch <= 'z')).count();
		//System.out.println("Vowels : " + vowels + ", Consonants: "+ consonants);
		
		//Complex way
		Map<Boolean, Long> vowels = str.chars().mapToObj(c -> (char) c).filter(ch -> ch >= 'a' && ch <= 'z')
				.collect(Collectors.partitioningBy(ch1 -> vowelsSet.contains(ch1), Collectors.counting()));
		Pair<Long, Long> pair = Pair.of(vowels.get(true), vowels.get(false));
		System.out.println("Vowels : " + pair.getLeft() + ", Consonants: " + pair.getRight());
		
		//case 3 : Reverse of each word of a string
		final Pattern PATTERN = Pattern.compile(" +");
		String reverseWords = PATTERN.splitAsStream(str).map(w -> new StringBuilder(w).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println("Reverse of each word : " + reverseWords);
		
		//case 4 : check if string contains any digit
		String str1 = "This is string with digit 1";
		boolean isDigit = str1.chars().anyMatch(n -> Character.isDigit(n));
		System.out.println("String contains any digit " + isDigit);
		
		//case 5 : check if string contains only digits
		String str2 = "1234";
		boolean areAllDigits = str2.chars().allMatch(n -> Character.isDigit(n));
		System.out.println("String contains all digits " + areAllDigits);
		
		//Case 6 : join words by delimiter
		List<String> words = Arrays.asList("Hi","This","is","a","sentence");
		String sentence = words.stream().collect(Collectors.joining(" "));
		System.out.println("After joining words : " + sentence);
		
		
	}

}
