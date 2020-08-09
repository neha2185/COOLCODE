import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr1
     *  2. INTEGER_ARRAY arr2
     */

    public static int minimumMoves(List<Integer> arr1, List<Integer> arr2) {
        int noOfMoves = 0;
        
        for(int position=0;position < arr1.size(); position++) {
            int[] arr1Elemarray = convertIntToArray(arr1.get(position));
            int[] arr2Elemarray = convertIntToArray(arr2.get(position));
            
            for(int i=0; i<arr1Elemarray.length ; i++) 
                for(int j=0; j<arr2Elemarray.length ; j++) {
                    noOfMoves += Math.abs(arr1Elemarray[i]-arr2Elemarray[j]);
            }                        
        }

        return noOfMoves;
    }

    private static int[] convertIntToArray(int num) {
        if(num==0) return new int[] {0};
        
        List<Integer> digits = new ArrayList<>();

        for(; num !=0; num/=10) 
            digits.add(num%10);
        
        Collections.reverse(digits);
        return digits.stream().mapToInt(Integer::intValue).toArray();
                
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arr1Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr1 = IntStream.range(0, arr1Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int arr2Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr2 = IntStream.range(0, arr2Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());*/
    	/*Integer[] arr1 = new Integer[] {123,543};
    	Integer[] arr2 = new Integer[] {321,279};
        int result = Result.minimumMoves(Arrays.asList(123, 543), Arrays.asList(321, 279));
        System.out.println(result);*/

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    	
    	List<Integer> teamAGoals = Arrays.asList(2,4,7);
    	List<Integer> teamBGoals = Arrays.asList(3,8);
    	System.out.println(numberOfGoals(teamAGoals, teamBGoals));
    	
    	Map<String, Integer> items = new HashMap<>();
    	items.put("A", 10);
    	items.put("B", 20);
    	items.put("C", 30);
    	items.put("D", 40);
    	items.put("E", 50);
    	items.put("F", 60);
    	
    	items.forEach((k,v)->System.out.println("key:" + k +", value:" + v));
    	
    	System.out.println("item with key as B");
    	items.forEach((k,v) -> {
    		if("B".equals(k)) {
    			System.out.println("key:" + k +", value:" + v);
    		}
    	});
    }
    
    //return no of B element
    private static int numberOfGoals(List<Integer> teamA, List<Integer> teamB) {
    	AtomicInteger noOfCount = new AtomicInteger(0);
    	
    	teamB.forEach(b->{
    		teamA.forEach(a-> {
    			if(b>=a) noOfCount.incrementAndGet();
    		});
    	});
    	
    	/*for(int b: teamB) {
    		for(int a: teamA) {
    			if(b>=a) noOfCount++;
    		}
    	}*/
    	return noOfCount.intValue();
    }
 }
