package test;

import entity.StudentCode;

public class TestCode {
	public static void main(String[] args) {
		StudentCode s1 = new StudentCode();
		StudentCode s2 = new StudentCode();
		StudentCode s3 = new StudentCode();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1==s2);
	}
}
