package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test4 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		Callable c1 = null;
		Future f2 = null;
		for(int i=0; true; i++)
		{
			c1 = new PassworkFauther();
			f2 = pool.submit(c1);
			
			System.out.println(f2.get().toString());
			if(!f2.get().toString().equals("no"))break;
			c1 = null;
			f2 = null;
		}
		
	}
	
}
