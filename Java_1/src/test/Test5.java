package test;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class Test5 {
	public static void main(String[] args) throws ParseException {
		int n = 40;
		System.out.println(n/100);
		System.out.println(n%100);
		
		String st = "123";
		Set<String> set = new HashSet<String>();
		set.add(st);
		set.add("123");
		set.add(new String("123"));
		System.out.println(set.size());
	}
}
