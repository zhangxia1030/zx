package test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Test2 {
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue bq = new ArrayBlockingQueue<Integer>(10);
		BlockingQueue lb = new LinkedBlockingDeque<Integer>();
		BlockingQueue lb123 = new LinkedBlockingDeque<Integer>();
		for(int i=0; i < 10; i++)
		{
			lb.add(i);
			//bq.add(i);
		}
		
		lb123.addAll(Arrays.asList(lb.toArray()));
		
		lb.poll();
		System.out.println(lb.size());
		System.out.println(lb.toString());
		System.out.println(lb123.toString());
		
	}
}


