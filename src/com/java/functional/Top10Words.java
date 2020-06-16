package com.java.functional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Top10Words {

	private static Stream<String> stream;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		stream = Files.lines(Paths.get("E:\\eclipseWS\\TestProject\\resources\\WordsFile.txt"));
		//Print contents of file
		//stream.forEach(System.out::println);
		
		//collect the words of all lines in a list
		List<String> listWords = stream.flatMap(l -> Arrays.stream(l.trim().split(" "))).collect(Collectors.toList());
		Map<String, Long> mapWordsCount = listWords.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		LinkedHashMap<String, Long> wordsSorted = mapWordsCount.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));
		
		//Print first 10 occuring words
		wordsSorted.forEach((k,v) -> System.out.println(String.format("%s --> %d", k, v)));
		
	}

}
