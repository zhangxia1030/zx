package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test3 {
	
	public static void main(String[] args) {
		ScheduledExecutorService es = Executors.newScheduledThreadPool(10);
		Runnable rn = new Runnable1();
		for(int i=0; i < 10; i++)
		{
			es.schedule(rn, 20, TimeUnit.SECONDS);
		}
		
		es.shutdown();
	}
	
}
