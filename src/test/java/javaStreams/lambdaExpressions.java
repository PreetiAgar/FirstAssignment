package javaStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import junit.framework.Assert;

public class lambdaExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//java streams allows to process collection of objects in more efficient way
		//It is a sequence of objects
		ArrayList<String> names= new ArrayList<String>();
		names.add("Adam");
		names.add("Eve");
		names.add("Alekhya");
		names.add("Don");
		names.add("Aahil");
		names.add("Abhijeet");
		
		long d=names.stream().filter(s->s.startsWith("A")).count(); //prints the count of names starting with A
		System.out.println(d);

		//there is no life of intermediate op if there is no terminal op
		//terminal op will exec only if inter op(filter) returns true
		//we can directly create stream of names(see below) instead of creating a list and changing it to stream.
		
		long e=Stream.of("Adam","Eve","Alekhya","Don","Abhijeet","Aahil").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(e);
		names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println(s));
		
		//Using Stream Map
		//print names having length greater than 4 and then convert to uppercase and print it
		names.stream().filter(s->s.length()>4).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names which starts with A and sorted
		names.stream().filter(a->a.startsWith("A")).sorted().map(a->a.toUpperCase()).forEach(a->System.out.println(a));
		
		//collect method in stream to convert result back into list from stream
				List<String> as=names.stream().filter(a->a.startsWith("A")).sorted().collect(Collectors.toList());
				System.out.println(as.get(0));
		
		//MERGE 2 lists-use concat method of Stream class-takes 2 input streams. then sort the merged list
		Stream<String> newstream=Stream.concat(names.stream(), as.stream());
		//newstream.sorted().forEach(s->System.out.println(s));
		
		//anyMatch method of stream class returns boolean value
		boolean flag= newstream.anyMatch(s->s.equalsIgnoreCase("A99am"));
		Assert.assertTrue(flag);
		
		
	}
}
