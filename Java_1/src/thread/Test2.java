package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		Runnable1 r1 = new Runnable1();
		for(int i=0; i < 3; i++)
		{
			es.execute(r1);
		}
		
		es.shutdown();
	}
	
}
