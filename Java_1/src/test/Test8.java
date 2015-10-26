package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test8 {
	
	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.valueOf("20150925141423"));
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		T1 t1 = new T1();
		T2 t2 = new T2();
		for(int i=0; i < 5; i++)
		{
			es.execute(t1);
			//es.execute(t2);
		}
	}
	
}

class T1 implements Runnable
{
	
	private int room = 10;
	
	@Override
	public void run() {
		while(room > 0)
		{
			System.out.println(Thread.currentThread()+":"+room);
			room--;
		}
	}
	
}

class T2 implements Runnable
{
	
	private int room = 10;
	
	@Override
	public void run() {
		while(room > 0)
		{
			System.out.println(Thread.currentThread()+"="+room);
			room--;
		}
	}
	
}
