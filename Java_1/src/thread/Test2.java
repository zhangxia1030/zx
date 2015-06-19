package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		for(int i=0; i < 3; i++)
		{
			es.execute(new Runnable1());
		}
		
		es.shutdown();
	}
	
}
