package com.java.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PractiseStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Get all the string starting with a
		/*Stream.of("aaa", "aab", "xyz")
			.filter(s -> s.startsWith("a"))
			.forEach(System.out :: println);
		
		//count
		List<String> listStrings = Arrays.asList("aaa", "aab", "xyz");
		System.out.println(listStrings.stream()
			.filter(s -> s.startsWith("a"))
			.count());
		
		//Create a map with word and its count
		Map<String, Long> map = listStrings.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		map.forEach((key, value) -> System.out.println("Word: " + key +", Count: " + value)); */
		
		//Find each char count from sentence
		String str = "neha is nice girl";
		Map<Character, Long> mapChars = str.replaceAll(" ", "").toLowerCase().chars()
			.mapToObj(c -> (char) c)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		mapChars.forEach((k,v) -> System.out.println("char: " + k + " , count : " + v));
		
		//Sort in descending order based on map's value
		mapChars.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k,v) -> k, LinkedHashMap:: new))
			.forEach((k,v) -> System.out.println("Value:" + v));
	}

}
