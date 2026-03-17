package testNGPractice;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TestNGPrac {
	
	@Test
	public void Demo(){
		System.out.println("Hello");
	}
	@Test
	public void day1() {
		
		System.out.println("Day1");
	}
	@Test
	public void day2() {
		System.out.println("Day2");
		Assert.assertTrue(true);
	}

}
