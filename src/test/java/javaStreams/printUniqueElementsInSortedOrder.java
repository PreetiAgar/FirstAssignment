package javaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class printUniqueElementsInSortedOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a1 = {30,23,56,23,33,56,78}; 
		//List li2=Arrays.asList(a1);
		List<Integer> a2= Arrays.asList(30,23,56,23,33,56,78);
		List<Integer> li= a2.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li);
		}

}
